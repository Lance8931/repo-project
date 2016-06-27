package com.siping.hrip.portal.user.mapper;

import java.util.List;
import java.util.Map;

import com.siping.domain.portal.entity.HrEmployee;
import com.siping.domain.portal.entity.User;
import com.siping.domain.portal.entity.UserOrgInfo;
import com.siping.domain.portal.entity.UserPersonalInfo;

public interface AdminMapper {
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
     * 获取所有单位用户不区分是否启用
     * @author:pingrong
     * @date:2016年6月2日
     * @param map
     * @return
     * @throws Exception
     */
    List<HrEmployee> getEmployeeAll() throws Exception;

    /**
     * 删除单位用户
     * @param userName
     * @return
     */
    Integer deleteUserHrEmployee(List<String> nameList) throws Exception;

    /**
     * 获取单位用户详情
     * @param username
     * @return
     * @throws Exception
     */
    HrEmployee getHrEmployee(String username) throws Exception;

    /**
     * 获取单位用户数据总条数
     * @return
     * @throws Exception
     */
    Integer getTotalEmployee(Map<String, Object> map) throws Exception;

    /**
     * 获取所有单位用户条数 不区分是否启用
     * @author:pingrong
     * @date:2016年6月2日
     * @param map
     * @return
     * @throws Exception
     */
    Integer getEmployeeTotal() throws Exception;

    /**
     * 获取用户信息
     * @param userName
     * @return
     * @throws Exception
     */
    User getUser(String userName) throws Exception;

    /**
     * 获取企业用户信息
     * @param userName
     * @return
     * @throws Exception
     */
    UserOrgInfo getOrg(UserOrgInfo org) throws Exception;

    /**
     * 获取个人用户信息
     * @param personal
     * @return
     * @throws Exception
     */
    UserPersonalInfo getPersonal(UserPersonalInfo personal) throws Exception;

}
