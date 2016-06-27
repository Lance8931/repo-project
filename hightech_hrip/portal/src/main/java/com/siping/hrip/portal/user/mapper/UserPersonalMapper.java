package com.siping.hrip.portal.user.mapper;

import java.util.List;
import java.util.Map;

import com.siping.domain.portal.entity.User;
import com.siping.domain.portal.entity.UserPersonalInfo;

public interface UserPersonalMapper {

    /**
     * 添加个人用户（personal资料）
     * @param record
     * @return
     * @throws Exception
     */
    Integer addUserPersonalInfo(UserPersonalInfo personal) throws Exception;

    /**
     * 修改personal
     * @param he
     * @return
     */
    Integer updatePersonal(UserPersonalInfo personal) throws Exception;

    /**
     * 获取个人用户详情
     * @param id
     * @return
     * @throws Exception
     */
    UserPersonalInfo getUserpersonal(String username) throws Exception;

    /**
     * 分页获取个人用户
     * @return
     */
    List<User> getListByPage(Map<?, ?> map) throws Exception;

    /**
     * 根据条件获取个人用户总数
     * @return
     * @throws Exception
     */
    Integer getCount(Map<?, ?> map) throws Exception;

}
