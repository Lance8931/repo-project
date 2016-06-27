package com.siping.hrip.portal.user.service;

import org.stroma.framework.core.exception.BusinessProcessException;

import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.PageRequest;
import com.siping.domain.portal.entity.PageResponse;
import com.siping.domain.portal.entity.User;
import com.siping.domain.portal.entity.UserPersonalInfo;

public interface UserPersonalService {
    /**
     * 添加个人用户
     * @param personal
     * @throws BusinessProcessException
     * @date 2016年5月5日下午5:32:31
     * @author siping-L.J.H
     */
    public ResultMsg addPersonal(UserPersonalInfo personal) throws BusinessProcessException;

    /**
     * 修改个人用户
     * @param personal
     * @throws BusinessProcessException
     * @date 2016年5月5日下午5:32:39
     * @author siping-L.J.H
     */
    public ResultMsg updatePersonal(UserPersonalInfo personal) throws BusinessProcessException;

    /**
     * 获取个人详情
     * @param username
     * @return
     * @throws BusinessProcessException
     * @date 2016年5月5日下午5:32:44
     * @author siping-L.J.H
     */
    public UserPersonalInfo getUserPersonal(String username) throws BusinessProcessException;

    /**
     * 分页查询个人用户
     * @param pageRequest
     * @param personal
     * @return
     * @throws BusinessProcessException
     * @date 2016年5月5日下午5:32:52
     * @author siping-L.J.H
     */
    public PageResponse<User> getListByPage(PageRequest pageRequest, UserPersonalInfo personal) throws BusinessProcessException;
}
