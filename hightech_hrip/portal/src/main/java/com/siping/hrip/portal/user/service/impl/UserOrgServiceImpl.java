package com.siping.hrip.portal.user.service.impl;

import java.io.File;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.stroma.framework.core.exception.BusinessProcessException;

import com.siping.domain.common.DataValidation;
import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.OrgType;
import com.siping.domain.portal.entity.PageRequest;
import com.siping.domain.portal.entity.PageResponse;
import com.siping.domain.portal.entity.UserOrgInfo;
import com.siping.hrip.portal.user.mapper.UserOrgInfoMapper;
import com.siping.hrip.portal.user.service.UserOrgService;

/**
 * 招聘企业业务处理层
 * @author yangxu
 *
 */
@Service
public class UserOrgServiceImpl implements UserOrgService {
    @Autowired
    private UserOrgInfoMapper orgmapper;
    @Value("${site.imgs.path}")
    private String filePath;

    DataValidation dataValidation;// 数据验证工具类

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 添加招聘企业用户信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultMsg addOrg(UserOrgInfo org, MultipartFile licenseImage, MultipartFile logoImage) throws Exception{
        if(org.getUsername() == null)
            return new ResultMsg(false, "没有提交用户名" );
        /*保存数据*/
        if(licenseImage != null)
            org.setLicensePic(saveImage(licenseImage));
        if(logoImage != null)
            org.setLogoPic(saveImage(logoImage));
        orgmapper.addOrg(org); 
        return new ResultMsg(true, "保存成功" );
    }
    
    /**
     * 删除企业用户
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultMsg deleteUserOrg(String[] userNames) throws Exception {
        if(userNames == null)
            return new ResultMsg(false, "没有要删除的用户");
        List<String> nameList = new ArrayList<>();
        for (String userName : userNames) {
            nameList.add(userName);
        }
        List<UserOrgInfo> userOrg = orgmapper.getOrgList(nameList);
        Integer isSucceed = orgmapper.deleteUserOrg(nameList);
        for(UserOrgInfo u : userOrg){
            if(u.getLicensePic() != null)
                deleteImage(u.getLicensePic());
            if(u.getLogoPic() != null)
                deleteImage(u.getLogoPic());
        }
        return new ResultMsg(true, isSucceed + "条数据删除完毕");    
    }
    
    /**
     * 修改招聘企业用户信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultMsg updateOrg(UserOrgInfo org, MultipartFile licenseImage, MultipartFile logoImage) throws Exception {
        UserOrgInfo userOrg = orgmapper.selectOrg(org);
        if(licenseImage != null){
            String liencePic = userOrg.getLicensePic();
            deleteImage(liencePic);
            org.setLicensePic(saveImage(licenseImage));
        }
            
        if(logoImage != null){
            deleteImage(userOrg.getLogoPic());
            org.setLogoPic(saveImage(logoImage));
        }
        Integer n = orgmapper.updateOrg(org);
        if(n < 1){
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true, "修改成功");    
       
    }

    /**
     * 查询招聘企业信息
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public UserOrgInfo getUserOrg(UserOrgInfo org) throws Exception {
        UserOrgInfo orgInfo = orgmapper.selectOrg(org);
        return orgInfo;    
    }
    
    /**
     * 查询所有招聘企业用户
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public PageResponse<UserOrgInfo> getAllOrg(HttpServletRequest request, UserOrgInfo org, PageRequest pageRequest) throws Exception {
        PageResponse<UserOrgInfo> pageresponse = new PageResponse<UserOrgInfo>();
        Map<String, Object> map = new HashMap<String, Object>();
        // 模糊查询
        String querys = request.getParameter("querys");
        if(!"".equals(querys) && querys !=null){
            org.setOrgCode(querys);
            org.setOrgName(querys);
            org.setRegisteredNo(querys);
        }
        String enabled = request.getParameter("enabled");
        if(enabled != null && ! "".equals(enabled)){
            map.put("enabled", Integer.valueOf(enabled));
        }
        map.put("org", org);
        map.put("pageRequest", pageRequest);
        List<UserOrgInfo> list = orgmapper.getAllOrg(map);
        Integer total = orgmapper.getTotalOrg(map);
        pageresponse.setRecords(list);
        pageresponse.setTotal(total);	
        return pageresponse;
    }
    
    @Override
    public Map<BigInteger, String> getOrgType() throws Exception {
        Map<BigInteger, String> map  = new HashMap<BigInteger, String>();
        List<OrgType> orgTypes = orgmapper.getOrgType();
        for(OrgType t : orgTypes){
            map.put(t.getId(), t.getTypeName());
        }
        return map;    
    }

    /**
     * 保存文件
     * @param file
     * @return 保存的文件名
     * @throws Exception
     */
    private String saveImage(MultipartFile file) throws Exception{
        if(file == null){
            throw new BusinessProcessException("文件为空");
        }
        if(file.getSize()>2*1024*1024){
            throw new BusinessProcessException("请选择小于2M的文件");
        }
        String fileName = String.valueOf(System.currentTimeMillis());
        String imgName = file.getOriginalFilename();
        String fileSuffix = imgName.substring(imgName.lastIndexOf(".")).toLowerCase();
        String imgFilePath = filePath + fileName + fileSuffix;
        file.transferTo(new File(imgFilePath));
        return fileName + fileSuffix;
    }
    
    /**
     * 删除文件
     * @param picName
     * @return
     * @throws Exception
     */
    private Boolean deleteImage(String picName) throws Exception{
        File picPath = new File(filePath + picName);
        if(picPath.exists()){
            picPath.delete();
        }
        return true;
    }

}
