package com.siping.hrip.portal.user.service;

import com.siping.domain.portal.entity.User;
import com.siping.domain.portal.entity.UserPersonalInfo;

public interface UserPersonalService {
    /**
     * 添加个人用户
     * @param user
     * @param personal
     * @return
     * @throws Exception
     */
    public String addPersonal(User user, UserPersonalInfo personal) throws Exception;

    /**
     * 修改个人用户
     * @param user
     * @param personal
     * @return
     * @throws Exception
     */
    public String updatePersonal(User user, UserPersonalInfo personal) throws Exception;

    /**
     * 修改密码
     * @param user
     * @return
     * @throws Exception
     */
    public String updatePwd(User user, UserPersonalInfo personal) throws Exception;

    /**
     * 找回密码--验证账号
     * @param personal
     * @return
     * @throws Exception
     */
    public UserPersonalInfo verifyAnswer(UserPersonalInfo personal) throws Exception;

    /**
     * 获取个人详情
     * @param personal
     * @return
     * @throws Exception
     */
    public UserPersonalInfo getUserPersonal(User user) throws Exception;
}
