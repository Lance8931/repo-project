package com.siping.hrip.portal.user.service;

import com.siping.domain.portal.entity.Groups;

public interface PermissionService {
    /**
     * 添加用户组
     * @param group
     * @return
     */
    public String addGroup(Groups group) throws Exception;

    /**
     * 修改用户组
     * @param group
     * @return
     */
    public String updateGroup(Groups group) throws Exception;

    /**
     * 删除用户组
     * @param group
     * @return
     */
    public String deleteGroup(Groups group) throws Exception;

    /**
     * 查询用户组详情
     * @param group
     * @return
     */
    public Groups selectGroup(Groups group) throws Exception;
}
