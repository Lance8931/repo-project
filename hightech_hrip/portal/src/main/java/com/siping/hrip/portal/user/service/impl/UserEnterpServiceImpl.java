package com.siping.hrip.portal.user.service.impl;

import java.io.File;
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

import com.siping.domain.common.DataValidation;
import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.PageRequest;
import com.siping.domain.portal.entity.PageResponse;
import com.siping.domain.portal.entity.UserEnterprise;
import com.siping.hrip.portal.user.mapper.UserEnterpMapper;
import com.siping.hrip.portal.user.service.UserEnterpService;

/**
 * 入住企业
 * @author yangxu
 *
 */
@Service
public class UserEnterpServiceImpl implements UserEnterpService {
    @Autowired
    private UserEnterpMapper userEnterpMapper;
    @Value("${site.imgs.path}")
    private String filePath;

    DataValidation dataValidation;// 数据验证工具类

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 添加入住企业信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultMsg addEnterprise(UserEnterprise enterprise, MultipartFile licenseImage) throws Exception{
        if(enterprise.getUsername() == null)
            return new ResultMsg(false, "没有提交用户名");
        String fileName = String.valueOf(System.currentTimeMillis());
        if(!licenseImage.isEmpty()){
            String imgName = licenseImage.getOriginalFilename();
            String fileSuffix = imgName.substring(imgName.lastIndexOf(".")).toLowerCase();
            String imgFilePath = filePath + fileName + fileSuffix;
            licenseImage.transferTo(new File(imgFilePath));
            userEnterpMapper.addEnterprise(enterprise);
        }    
        return new ResultMsg(true, "添加成功");
    }

    /**
     * 修改入住企业信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultMsg updateEnterprise(UserEnterprise enterprise, MultipartFile file) throws Exception {
            if(!file.isEmpty()){
                String liencePic = userEnterpMapper.getEnterpByName(enterprise).getLicensePic();
                File picPath = new File(filePath + liencePic);
                if(picPath.exists())
                    picPath.delete();
                if(file.getSize() > 2*1024*1024)
                    return new ResultMsg(false, "添加失败，请选择小于2M的图片");
                
                String fileName = String.valueOf(System.currentTimeMillis());
                String imgName = file.getOriginalFilename();
                String fileSuffix = imgName.substring(imgName.lastIndexOf(".")).toLowerCase();
                String imgFilePath = filePath + fileName + fileSuffix;
                file.transferTo(new File(imgFilePath));
                enterprise.setLicensePic(fileName + fileSuffix);
                Integer n = userEnterpMapper.updateEnterprise(enterprise);
                if(n < 1){
                    return new ResultMsg(false, "删除失败");
                }
            }
            return new ResultMsg(true, "修改成功");
    }
    
    /**
     * 删除入住企业用户
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultMsg deleteEnterprise(String[] userNames) throws Exception {
        if(userNames == null)
            return new ResultMsg(false, "没有要删除的用户");
        List<String> nameList = new ArrayList<>();
        for (String userName : userNames) {
            nameList.add(userName);
        }
        List<UserEnterprise> enterprise = userEnterpMapper.getEnterpList(nameList);
        Integer isSucceed = userEnterpMapper.deleteEnterprise(nameList);
        for(UserEnterprise u : enterprise){
            if(u.getLicensePic() != null){
                File file = new File(filePath + u.getLicensePic());
                if(file.exists()){
                    file.delete();
                }
            }
        }
        return new ResultMsg(true, isSucceed + "条数据删除成功");
}    

    /**
     * 查询所有入住企业用户
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public PageResponse<UserEnterprise> getAllEnterprise(HttpServletRequest request, UserEnterprise enterprise, PageRequest pageRequest) throws Exception {
        PageResponse<UserEnterprise> pageresponse = new PageResponse<UserEnterprise>();
        Map<String, Object> map = new HashMap<String, Object>();
        // 模糊查询
        String querys = request.getParameter("querys");
        if(!"".equals(querys) && querys !=null){
            enterprise.setUsername(querys);
            enterprise.setOrgName(querys);
            enterprise.setRegisteredNo(querys);
        }
        String enabled = request.getParameter("enabled");
        if(enabled != null && ! "".equals(enabled)){
            map.put("enabled", Integer.valueOf(enabled));
        }
        map.put("enterprise", enterprise);
        map.put("pageRequest", pageRequest);
        Integer total = userEnterpMapper.countEnterprise(map);
        List<UserEnterprise> list = userEnterpMapper.getAllEnterprise(map);
        pageresponse.setRecords(list);
        pageresponse.setTotal(total);    
        return pageresponse;
    }

    /**
     * 获取入住企业详情
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public UserEnterprise getUserEnterprise(UserEnterprise enterprise) throws Exception {
        return userEnterpMapper.getEnterpByName(enterprise);
    }
}
