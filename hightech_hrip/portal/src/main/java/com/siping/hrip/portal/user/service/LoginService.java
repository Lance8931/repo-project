package com.siping.hrip.portal.user.service;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;

import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.User;
import com.siping.domain.portal.entity.UserLoginRequest;

public interface LoginService {

    public User get(BigInteger id) ;
    /**
     * 用户登录
     * @param userLoginRequest
     * @param request
     * @return
     * @throws Exception
     */
    public ResultMsg login(UserLoginRequest userLoginRequest,HttpServletRequest request) throws Exception; 
    
    /**
     * 重置密码
     * @param oldPwd
     * @param pwd
     * @param request
     * @return
     * @throws Exception
     */
    public ResultMsg resetPwd(String oldPwd, String pwd, HttpServletRequest request) throws Exception;
   
}
