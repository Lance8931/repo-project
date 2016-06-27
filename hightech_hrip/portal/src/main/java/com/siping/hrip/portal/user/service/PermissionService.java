package com.siping.hrip.portal.user.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.Groups;
import com.siping.domain.portal.entity.HrEmployee;
import com.siping.domain.portal.entity.PageResponse;
import com.siping.domain.portal.entity.Permission;
import com.siping.domain.portal.entity.UserGroup;

public interface PermissionService {
    /**
     * 添加用户组
     * @param group
     * @return
     */
    public ResultMsg addGroup(Groups group) throws Exception;

    /**
     * 修改用户组
     * @param group
     * @return
     */
    public ResultMsg updateGroup(Groups group) throws Exception;

    /**
     * list角色
     * @param group
     * @return
     */
    public PageResponse<Groups> listRole(HttpServletRequest request) throws Exception;

    /**
     * ilst 单位用户 角色组
     * @author:pingrong
     * @date:2016年6月2日
     * @param request
     * @return
     * @throws Exception
     */
    public List<UserGroup> listRoleHr() throws Exception;

    /**
     * 获取单位用户
     * @author:pingrong
     * @date:2016年6月2日
     * @param request
     * @return
     * @throws Exception
     */
    public PageResponse<HrEmployee> listHrEmployee(HttpServletRequest request) throws Exception;

    /**
     * 获取角色菜单操作权限
     * @author:pingrong
     * @date:2016年6月2日
     * @param groupId
     * @return
     * @throws Exception
     */
    public List<Permission> listPermission(String groupId) throws Exception;

    /**
     * 删除角色组
     * @param group
     * @return
     */
    public ResultMsg deleteGroup(List<Integer> roleId) throws Exception;

    /**
     * 查询用户组详情
     * @param group
     * @return
     */
    public Groups selectGroup(String groupId) throws Exception;

    /**
     * 添加修改角色菜单
     * @author:pingrong
     * @date:2016年6月1日
     * @param groupId 角色ID
     * @param permissions 操作权限
     * @return
     * @throws Exception
     */
    public ResultMsg addUpdateMenu(List<Permission> pmss) throws Exception;

    /**
     * 添加修改用户权限
     * @param listUserGroup
     * @return
     * @throws Exception
     */
    public String addUpdateUserGroup(List<UserGroup> listUserGroup) throws Exception;
}
