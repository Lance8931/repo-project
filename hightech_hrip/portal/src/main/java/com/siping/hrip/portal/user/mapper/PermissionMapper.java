package com.siping.hrip.portal.user.mapper;

import com.siping.domain.portal.entity.Groups;

public interface PermissionMapper {
    /**
     * 删除用户组
     * @param id
     * @return
     */
    Integer deleteGroup(Integer id) throws Exception;

    /**
     * 添加用户组
     * @param record
     * @return
     */
    Integer addGroup(Groups record) throws Exception;

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
     * 检验用户组是否被引用
     * @param groupId
     * @return
     * @throws Exception
     */
    Integer selectUserGroup(Integer groupId) throws Exception;

}
