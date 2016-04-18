package com.siping.hrip.portal.user.mapper;

import com.siping.domain.portal.entity.User;
import com.siping.domain.portal.entity.UserPersonalInfo;

public interface UserPersonalMapper {
    /**
     * 添加个人用户（user基础资料）
     * @param user
     * @return
     */
    Integer addUser(User user) throws Exception;

    /**
     * 添加个人用户（personal资料）
     * @param record
     * @return
     * @throws Exception
     */
    Integer addUserPersonalInfo(UserPersonalInfo personal) throws Exception;

    /**
     * 验证用户账号是否存在username
     * @param user
     * @return
     */
    Integer selectUserName(User user) throws Exception;

    /**
     * 验证ID_code是否存在
     * @param he
     * @return
     */
    Integer selectIdcode(UserPersonalInfo personal) throws Exception;

    /**
     * 修改User
     * @param user
     * @return
     */
    Integer updateUser(User user) throws Exception;

    /**
     * 修改personal
     * @param he
     * @return
     */
    Integer updatePersonal(UserPersonalInfo personal) throws Exception;

    /**
     * 验证账号与问题答案
     * @param personal
     * @return
     * @throws Exception
     */
    Integer verifyAnswer(UserPersonalInfo personal) throws Exception;

    /**
     * 获取个人用户详情
     * @param id
     * @return
     * @throws Exception
     */
    UserPersonalInfo getUserpersonal(String username) throws Exception;

}
