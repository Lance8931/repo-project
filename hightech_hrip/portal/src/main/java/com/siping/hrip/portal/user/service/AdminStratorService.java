package com.siping.hrip.portal.user.service;

import com.siping.domain.portal.entity.HrEmployee;
import com.siping.domain.portal.entity.PageRequest;
import com.siping.domain.portal.entity.PageResponse;
import com.siping.domain.portal.entity.User;
import com.siping.domain.portal.entity.UserOrgInfo;
import com.siping.domain.portal.entity.UserPersonalInfo;

public interface AdminStratorService {
    /**
     * 添加单位用户
     * @param user
     * @return
     */
    public String addUser(User user, HrEmployee he) throws Exception;

    /**
     * 修改单位用户
     * @param user
     * @param he
     * @return
     */
    public String updateUserHrEmployee(User user, HrEmployee he) throws Exception;

    /**
     * 查询单位用户S
     * @param map
     * @return
     */
    public PageResponse<HrEmployee> getAllEmployee(PageRequest pageRequest, HrEmployee hrEmployee) throws Exception;

    /**
     * 删除单位用户
     * @param hrEmployee
     * @return
     */
    public String deleteUserHrEmlpoyee(HrEmployee hrEmployee) throws Exception;

    /**
     * 查询所有个体用户S
     * @param map
     * @return
     */
    public PageResponse<UserPersonalInfo> getAllPersonal(PageRequest pageRequest, UserPersonalInfo personal) throws Exception;

    /**
     * 查询所有企业用户S
     * @param map
     * @return
     */
    public PageResponse<UserOrgInfo> getAllOrg(PageRequest pageRequest, UserOrgInfo org) throws Exception;
}
