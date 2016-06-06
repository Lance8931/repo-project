package com.siping.hrip.portal.user.mapper;

import java.util.List;
import java.util.Map;

import com.siping.domain.portal.entity.OrgType;
import com.siping.domain.portal.entity.UserOrgInfo;

public interface UserOrgInfoMapper {
    
    /**
     * 删除企业用户信息
     * @param userName
     * @return
     */
    Integer deleteUserOrg(List<String> nameList) throws Exception;
    
    /**
     * 获取企业用户数据总条数
     * @return
     * @throws Exception
     */
    Integer getTotalOrg(Map<String, Object> map) throws Exception;
    
    
    /**
     * 分页获取企业用户S
     * @return
     */
    List<UserOrgInfo> getAllOrg(Map<String, Object> map) throws Exception;
    

    /**
     * 添加企业用户
     * @param org
     * @return
     */
    Integer addOrg(UserOrgInfo org) throws Exception;

    /**
     * 验证用户账号是否存在username
     * @param user
     * @return
     */
    Integer selectUserName(String username) throws Exception;
    
    /**
     * 根据用户名获取企业信息列表
     * @param usernames
     * @return
     */
    List<UserOrgInfo> getOrgList(List<String> usernames) throws Exception;

    /**
     * 查询企业用户信息详情
     * @param org
     * @return
     */
    UserOrgInfo selectOrg(UserOrgInfo org) throws Exception;

    /**
     * 修改企业用户信息
     * @param org
     * @return
     */
    Integer updateOrg(UserOrgInfo org) throws Exception;

    /**
     * 获取企业信息类型
     * @return
     * @throws Exception
     */
    List<OrgType> getOrgType() throws Exception;
}
