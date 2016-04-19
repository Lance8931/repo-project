package com.siping.hrip.portal.user.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.Menu;
import com.siping.domain.portal.entity.SlidePic;
import com.siping.hrip.portal.user.mapper.HomeMapper;
import com.siping.hrip.portal.user.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService {
    
   @Autowired
   private HomeMapper homeMapper;
   @Value("${site.imgs.path}")
   private String filePath;
    
    /**
     * 获取菜单列表
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public String getMenuList() throws Exception{
        List<Menu> menuList = homeMapper.getMenuList();
        Gson gson = new Gson();
        String json = gson.toJson(menuList);
        return json;
    }
    
    /**
     * 获取幻灯片图片列表
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public String getSlidePicList() throws Exception{
        List<SlidePic> slidePicList = homeMapper.getSlidePicList();
        Gson gson = new Gson();
        String json = gson.toJson(slidePicList);
        return json;
    }
    
    
    /**
     * 上传幻灯片图片，并将图片相关信息保存到数据库
     * @param request
     * @return
     */
    @Transactional(rollbackFor=Exception.class) 
    public ResultMsg uploadImage(List<MultipartFile> files, HttpServletRequest request) throws Exception {
        ResultMsg resultMsg = null;
        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("user");//从session中取用户信息
//        if(null == user)
//            return new ResultMsg(false, "请重新登录");
        
        List<SlidePic> list = new ArrayList<SlidePic>();
        for (int i = 0; i < files.size(); i++) {
            SlidePic slidePic = new SlidePic();
            MultipartFile file = files.get(i);
            String fileName = String.valueOf(System.currentTimeMillis()) + i;
            String imgName = file.getOriginalFilename();
            String fileSuffix = imgName.substring(imgName.lastIndexOf(".")).toLowerCase();
            String imgFilePath = filePath + fileName + fileSuffix;
            file.transferTo(new File(imgFilePath));
          
            slidePic.setPicPath(fileName + fileSuffix);
            slidePic.setUrl("test");
            //slidePic.setCreateBy(user.getId());
            list.add(slidePic);
        }
        
        homeMapper.saveSlidePicInfo(list);
        resultMsg = new ResultMsg(true, "上传成功");
        return resultMsg;
    }

    /**
     * 修改幻灯片
     */
    public ResultMsg updateSlidePic(List<SlidePic> slidePics) throws Exception{
        Integer isUpdate = homeMapper.updateSlidePic(slidePics);
        return new ResultMsg(true, isUpdate + "张图片修改成功");
    }
    
    /**
     * 通过id删除幻灯片
     * @param id
     * @return
     */
    @Transactional(rollbackFor=Exception.class) 
    public ResultMsg deleteSlidePic(String id, String picPath) throws Exception{
        File file = new File(filePath + picPath);
        if(!file.exists())
            return new ResultMsg(false, "文件不存在");
        if(file.delete()){
            homeMapper.deleteSlidePic(id);
        }else{
            return new ResultMsg(false, "删除失败");
        }
        
        return new ResultMsg(true, "删除成功");
    }


}

