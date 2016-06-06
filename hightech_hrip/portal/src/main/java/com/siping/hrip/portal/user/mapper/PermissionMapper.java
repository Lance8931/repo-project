package com.siping.hrip.portal.user.mapper;

import java.util.List;

import com.siping.domain.portal.entity.Groups;
import com.siping.domain.portal.entity.PageRequest;
import com.siping.domain.portal.entity.Permission;
import com.siping.domain.portal.entity.UserGroup;

public interface PermissionMapper {
    /**
     * 删除用户组
     * @param id
     * @return
     */
    Integer deleteGroup(List<Integer> roleId) throws Exception;

    /**
     * 添加用户组
     * @param record
     * @return
     */
    Integer addGroup(Groups record) throws Exception;

    /**
     * list角色
     * @author:pingrong
     * @date:2016年5月31日
     * @param request
     * @return
     * @throws Exception
     */
    List<Groups> listRole(PageRequest request) throws Exception;

    /**
     * list 单位用户 角色组
     * @author:pingrong
     * @date:2016年6月2日
     * @return
     * @throws Exception
     */
    List<UserGroup> listRoleHr() throws Exception;

    /**
     * 获取角色菜单操作权限
     * @author:pingrong
     * @date:2016年6月2日
     * @param roleId
     * @return
     * @throws Exception
     */
    List<Permission> listPermission(Integer roleId) throws Exception;

    /**
     * Role数量
     * @author:pingrong
     * @date:2016年5月31日
     * @param request
     * @return
     * @throws Exception
     */
    Integer totalRole() throws Exception;

    /**
     * 查询用户组
     * @param id
     * @return
     */
    Groups selectGroups(Integer id) throws Exception;

    /**
     * 修改用户组
     * @param record
     * @return
     */
    Integer updateGroup(Groups record) throws Exception;

    /**
     * 检验角色组是否被引用
     * @param groupId
     * @return
     * @throws Exception
     */
    Integer selectUserGroup(List<Integer> roleId) throws Exception;

    /**
     * 添加、修改组权限
     * @param permission
     * @return
     * @throws Exception
     */
    Integer addUpdateMenu(List<Permission> pmss) throws Exception;

    /**
     * 删除角色组菜单权限
     * @param groupId
     * @return
     * @throws Exception
     */
    Integer deletePermission(List<Integer> roleId) throws Exception;

    /**
     * 添加用户权限
     * @param userGroup
     * @return
     * @throws Exception
     */
    Integer addUpdateUserGroup(UserGroup userGroup) throws Exception;

    /**
     * 删除用户权限
     * @param userId
     * @return
     * @throws Exception
     */
    Integer deleteUserGroup(String userId) throws Exception;

}
