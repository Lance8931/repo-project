package com.siping.hrip.portal.user.service;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;

import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.User;

/**
 * 用户登录service
 * @author yangxu
 *
 */
public interface LoginService {

    public User get(BigInteger id) ;
    /**
     * 用户登录
     * @param userLoginRequest 
     * @param request
     * @return
     * @throws Exception
     */
    public ResultMsg login(String username, String password, HttpServletRequest request) throws Exception; 
    
    /**
     * 重置密码
     * @param oldPwd 旧密码
     * @param pwd 要修改的新密码
     * @param request 请求对象
     * @return
     * @throws Exception
     */
    public ResultMsg resetPwd(String oldPwd, String pwd, HttpServletRequest request) throws Exception;
   
}
