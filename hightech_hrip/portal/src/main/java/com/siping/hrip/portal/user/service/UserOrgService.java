package com.siping.hrip.portal.user.service;

import com.siping.domain.portal.entity.User;
import com.siping.domain.portal.entity.UserOrgInfo;

public interface UserOrgService {
    /**
     * 添加企业用户
     * @param user
     * @param personal
     * @return
     * @throws Exception
     */
    public String addOrg(User user, UserOrgInfo org) throws Exception;

    /**
     * 修改企业用户
     * @param user
     * @param personal
     * @return
     * @throws Exception
     */
    public String updateOrg(User user, UserOrgInfo org) throws Exception;

    /**
     * 修改密码
     * @param user
     * @return
     * @throws Exception
     */
    public String updatePwd(User user, UserOrgInfo org) throws Exception;

    /**
     * 获取企业详情(找回密码---根据账号获取问题)
     * @param personal
     * @return
     * @throws Exception
     */
    public UserOrgInfo getUserOrg(UserOrgInfo org) throws Exception;
}
