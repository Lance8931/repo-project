package com.siping.hrip.portal.user.mapper;

import com.siping.domain.portal.entity.User;
import com.siping.domain.portal.entity.UserOrgInfo;

public interface UserOrgInfoMapper {
    /**
     * 添加个人用户（user基础资料）
     * @param user
     * @return
     */
    Integer addUser(User user) throws Exception;

    /**
     * 添加企业用户
     * @param org
     * @return
     */
    Integer addOrg(UserOrgInfo org);

    /**
     * 验证用户账号是否存在username
     * @param user
     * @return
     */
    Integer selectUserName(User user) throws Exception;

    /**
     * 查询企业用户信息详情
     * @param org
     * @return
     */
    UserOrgInfo selectOrg(UserOrgInfo org);

    /**
     * 修改企业用户信息
     * @param org
     * @return
     */
    Integer updateOrg(UserOrgInfo org);

    /**
     * 修改User（密码）
     * @param user
     * @return
     */
    Integer updateUser(User user) throws Exception;

    /**
     * 验证账号与问题答案
     * @param org
     * @return
     * @throws Exception
     */
    Integer verifyAnswer(UserOrgInfo org) throws Exception;

}
