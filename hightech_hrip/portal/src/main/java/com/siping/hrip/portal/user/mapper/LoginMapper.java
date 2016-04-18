package com.siping.hrip.portal.user.mapper;

import java.math.BigInteger;

import org.apache.ibatis.annotations.Param;

import com.siping.domain.portal.entity.User;
import com.siping.domain.portal.entity.UserLoginRequest;

public interface LoginMapper {
    User get(BigInteger id);
    /**
     * 登录
     * @param userLoginRequest
     * @return
     */
    User login(UserLoginRequest userLoginRequest);
    /**
     * 修改密码
     * @param id
     * @param username
     * @param pwdHash
     * @return
     */
    Integer resetPwd(@Param("id")BigInteger id, @Param("username")String username, @Param("pwdHash")String pwdHash);
}
