package com.siping.hrip.portal.user.mapper;

import java.util.List;
import java.util.Map;

import com.siping.domain.portal.entity.HrEmployee;
import com.siping.domain.portal.entity.User;
import com.siping.domain.portal.entity.UserOrgInfo;
import com.siping.domain.portal.entity.UserPersonalInfo;

public interface AdminStratorMapper {
    /**
     * 添加单位用户（user基础资料）
     * @param user
     * @return
     */
    Integer addUser(User user) throws Exception;

    /**
     * 添加单位用户（Hr详细资料）
     * @param he
     * @return
     */
    Integer addHrEmployee(HrEmployee he) throws Exception;

    /**
     * 验证用户账号是否存在username
     * @param user
     * @return
     */
    Integer selectUserName(User user) throws Exception;

    /**
     * 验证员工编号是否存在emp_no
     * @param he
     * @return
     */
    Integer selectHrEmployee(HrEmployee he) throws Exception;

    /**
     * 修改User
     * @param user
     * @return
     */
    Integer updateUser(User user) throws Exception;

    /**
     * 修改hr
     * @param he
     * @return
     */
    Integer updateHrEmployee(HrEmployee he) throws Exception;

    /**
     * 分页获取单位用户S
     * @return
     */
    List<HrEmployee> getAllEmployee(Map<String, Object> map) throws Exception;

    /**
     * 分页获取个人用户S
     * @return
     */
    List<UserPersonalInfo> getAllPersonal(Map<String, Object> map) throws Exception;

    /**
     * 分页获取企业用户S
     * @return
     */
    List<UserOrgInfo> getAllOrg(Map<String, Object> map) throws Exception;

    /**
     * 删除单位用户
     * @param userName
     * @return
     */
    Integer deleteUserHrEmployee(HrEmployee he) throws Exception;

    /**
     * 获取单位用户详情
     * @param username
     * @return
     * @throws Exception
     */
    HrEmployee getUserpersonal(String username) throws Exception;

    /**
     * 获取个体用户数据总条数
     * @return
     * @throws Exception
     */
    Integer getTotalPersonal(UserPersonalInfo personal) throws Exception;

    /**
     * 获取单位用户数据总条数
     * @return
     * @throws Exception
     */
    Integer getTotalEmployee(HrEmployee he) throws Exception;

    /**
     * 获取单位用户数据总条数
     * @return
     * @throws Exception
     */
    Integer getTotalOrg(UserOrgInfo org) throws Exception;
}
