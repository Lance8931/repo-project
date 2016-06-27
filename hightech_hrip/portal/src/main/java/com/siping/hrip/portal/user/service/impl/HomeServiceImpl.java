package com.siping.hrip.portal.user.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.stroma.framework.core.exception.RuntimeIOException;

import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.Menu;
import com.siping.domain.portal.entity.PageRequest;
import com.siping.domain.portal.entity.PageResponse;
import com.siping.domain.portal.entity.SlidePic;
import com.siping.hrip.portal.user.mapper.HomeMapper;
import com.siping.hrip.portal.user.service.HomeService;

/**
 * 菜单列表和幻灯片
 * @author siping-Y.X
 *
 */
@Service
public class HomeServiceImpl implements HomeService {
    
   @Autowired
   private HomeMapper homeMapper;
   @Value("${site.slide.path}")
   private String filePath;
   
    /**
     * 获取菜单列表
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public PageResponse<Menu> getMenuList() throws Exception{
        PageResponse<Menu> pageResponse = new PageResponse<Menu>();
        List<Menu> menuList = homeMapper.getMenuList();
        pageResponse.setTotal(menuList.size());
        pageResponse.setRecords(menuList);
        return pageResponse;
    }
    
    /**
     * 获取幻灯片图片列表
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public PageResponse<SlidePic> getSlidePicList(HttpServletRequest request, PageRequest pageRequest) throws Exception{
        PageResponse<SlidePic> pageresponse = new PageResponse<SlidePic>();
        Map<String, Object> map = new HashMap<String, Object>();
        String enabled = request.getParameter("enabled");
        if(enabled != null && ! "".equals(enabled)){
            map.put("enabled", Integer.valueOf(enabled));
       }
        if(pageRequest.getPageNo() != null){
            map.put("startNo", pageRequest.getStartNo());
            map.put("pageSize", pageRequest.getPageSize());
        }
        pageresponse.setTotal(homeMapper.countAllSlidePic(map));
        pageresponse.setRecords(homeMapper.getSlidePicList(map));
        return pageresponse;
    }
    
    
    /**
     * 上传幻灯片图片，并将图片相关信息保存到数据库
     * @param request
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class) 
    public ResultMsg uploadImage(List<MultipartFile> files, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        Map<String, MultipartFile> fileMap = new HashMap<String, MultipartFile>();
//        User user = (User) session.getAttribute("user");//从session中取用户信息
//        if(null == user)
//            return new ResultMsg(false, "请重新登录");
        List<SlidePic> list = new ArrayList<SlidePic>();
        if(files == null){
            return new ResultMsg(false, "没有要上传的文件");
        }
        for (int i=0; i<files.size(); i++){
            SlidePic slidePic = new SlidePic();
            MultipartFile file = files.get(i);
            if(file.getSize() > 1024*1024*2)
                return new ResultMsg(false, "上传失败，请选择小于2M的图片");
            
            String imgName = file.getOriginalFilename();
            String imageUrl = request.getParameter(imgName + "_imageUrl");//前端input的name为图片名+_imageUrl
            String hoverTips = request.getParameter(imgName + "_hoverTips");
            if("".equals(imgName) || "".equals(hoverTips) || imageUrl == null || hoverTips == null)
                return new ResultMsg(false, "上传失败，链接和悬停提示不能为空");
            if(imageUrl.length() <= 4 || !"http".equals(imageUrl.substring(0, 4))){
                imageUrl = "http://" + imageUrl;
            }
            String fileName = String.valueOf(System.currentTimeMillis()) + i;
            String fileSuffix = imgName.substring(imgName.lastIndexOf(".")).toLowerCase();
            String imgFilePath = filePath + fileName + fileSuffix;
            fileMap.put(imgFilePath, file);
            
            slidePic.setPicPath(fileName + fileSuffix);
            slidePic.setUrl(imageUrl);
            slidePic.setHoverTips(hoverTips);
            //slidePic.setCreateBy(user.getId());
            list.add(slidePic);
        }
        if(list.size() > 0){
            homeMapper.saveSlidePicInfo(list);
        }
        saveMultiFile(fileMap); 
        return new ResultMsg(true, "保存成功");
    }

    /**
     * 修改幻灯片
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultMsg updateSlidePic(List<SlidePic> slidePics) throws Exception{
        homeMapper.updateSlidePic(slidePics);
        return new ResultMsg(true, "修改成功");
    }
    
    /**
     * 通过id删除幻灯片
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class) 
    public ResultMsg deleteSlidePic(String[] ids) throws Exception{
        if(ids == null)
            return new ResultMsg(false, "没有要删除的图片");
        List<String> picIds = new ArrayList<String>();
        for(String id : ids){
            picIds.add(id);
        }
        List<SlidePic> slidePic = homeMapper.getSlidePics(picIds);
        homeMapper.deleteSlidePics(picIds);
        for(SlidePic s : slidePic){
            if(s.getPicPath() != null){
                File file = new File(filePath + s.getPicPath());
                if(file.exists()){
                    file.delete();
                }
            }
        }
        return new ResultMsg(true, "删除成功");
    }
    
    /**
     * 批量保存文件
     * @param fileMap 文件名和文件的map
     * @throws Exception
     */
    private void saveMultiFile(Map<String, MultipartFile> fileMap) throws Exception {
        for (String s : fileMap.keySet()) {//保存文件
            File imageFile = new File(s);
            try{
                fileMap.get(s).transferTo(imageFile);
            }catch(Exception e){//发生错误则回滚
                for (String str : fileMap.keySet()){
                    File f = new File(str);
                    if(f.exists()){
                        f.delete();
                    }
                }
                throw new RuntimeIOException(e);
            }
        }
    }
}

