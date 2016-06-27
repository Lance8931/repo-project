package com.siping.hrip.portal.user.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.PageRequest;
import com.siping.domain.portal.entity.PageResponse;
import com.siping.domain.portal.entity.UserEnterprise;

/**
 * 入驻企业
 * @author yangxu
 *
 */
public interface UserEnterpService {
    
    /**
     * 查询所有入住企业信息
     * @param request
     * @param enterprise 入住企业对象信息
     * @return PageResponse<UserEnterprise>
     * @throws Exception
     */
    public PageResponse<UserEnterprise> getAllEnterprise(HttpServletRequest request, UserEnterprise enterprise, PageRequest pageRequest) throws Exception;
    
    /**
     * 删除入住企业信息
     * @param userNames 用户名数组
     * @return ResultMsg
     * @throws Exception
     */
    public ResultMsg deleteEnterprise(String[] userNames) throws Exception;
    
    /**
     * 添加入住企业信息
     * @param enterprise
     * @param licenseImage
     * @return ResultMsg
     * @throws Exception
     */
    public ResultMsg addEnterprise(UserEnterprise enterprise, MultipartFile licenseImage) throws Exception;

    /**
     * 修改入住企业信息
     * @param enterprise
     * @param file 营业执照图片
     * @return
     * @throws Exception
     */
    public ResultMsg updateEnterprise(UserEnterprise enterprise, MultipartFile file) throws Exception;

    /**
     * 获取入住企业详情
     * @param enterprise
     * @return
     * @throws Exception
     */
    public UserEnterprise getUserEnterprise(UserEnterprise enterprise) throws Exception;
}
