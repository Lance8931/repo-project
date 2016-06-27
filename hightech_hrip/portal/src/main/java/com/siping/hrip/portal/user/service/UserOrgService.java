package com.siping.hrip.portal.user.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.OrgType;
import com.siping.domain.portal.entity.PageRequest;
import com.siping.domain.portal.entity.PageResponse;
import com.siping.domain.portal.entity.UserOrgInfo;

/**
 * 招聘企业业务层接口
 * @author xjkms
 *
 */
public interface UserOrgService {
    
    /**
     * 查询所有招聘企业信息
     * @param request
     * @param UserOrgInfo 招聘企业信息对象
     * @return PageResponse<UserOrgInfo> 招聘企业信息分页对象
     * @throws Exception
     */
    public PageResponse<UserOrgInfo> getAllOrg(HttpServletRequest request, UserOrgInfo org, PageRequest pageRequest) throws Exception;
    
    /**
     * 根据用户名删除招聘企业信息
     * @param userNames
     * @return ResultMsg
     * @throws Exception
     */
    public ResultMsg deleteUserOrg(String[] userNames) throws Exception;
    
    /**
     * 添加招聘企业信息
     * @param UserOrgInfo 招聘企业信息对象
     * @param licenseImage 营业执照图片
     * @param logoImage 公司logo图片
     * @return ResultMsg
     * @throws Exception
     */
    public ResultMsg addOrg(UserOrgInfo org, MultipartFile licenseImage, MultipartFile logoImage) throws Exception;

    /**
     * 修改招聘企业信息
     * @param UserOrgInfo 招聘企业信息对象
     * @param file 营业执照图片
     * @param logoImage 公司logo图片
     * @return
     * @throws Exception
     */
    public ResultMsg updateOrg(UserOrgInfo org, MultipartFile file, MultipartFile logoImage) throws Exception;

    /**
     * 获取企业详情(找回密码---根据账号获取问题)
     * @param personal
     * @return UserOrgInfo
     * @throws Exception
     */
    public UserOrgInfo getUserOrg(UserOrgInfo org) throws Exception;
    
    public Map<BigInteger, String> getOrgType() throws Exception;

}
