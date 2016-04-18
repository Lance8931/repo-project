package com.siping.hrip.portal.user.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.stroma.framework.core.platform.web.StromaController;

import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.UserLoginRequest;
import com.siping.hrip.portal.user.service.LoginService;

@Controller
public class LoginController extends StromaController {
    @Autowired
    private LoginService userService;
    

    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    @ResponseBody
    public void login() {
        System.out.println("get ...");
    }
    
    /**
     * 用户登录
     * @param userLoginRequest
     * @param request
     * @return
     */
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg login(UserLoginRequest userLoginRequest,HttpServletRequest request){
        ResultMsg resultMsg = null;
        try {
            resultMsg = userService.login(userLoginRequest, request);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg = new ResultMsg(false, e.getMessage());
            return resultMsg;         
        }
        return resultMsg;
    }
    
    /**
     * 重置密码
     * @param oldPwd
     * @param pwd
     * @param request
     * @return
     */
    @RequestMapping(value = "/user/resetpwd", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg resetPwd(String oldPwd, String pwd, HttpServletRequest request){
        ResultMsg resultMsg = null;
        try{
            resultMsg = userService.resetPwd(oldPwd, pwd, request); 
        }catch(Exception e){
            e.printStackTrace();
            resultMsg = new ResultMsg(false, e.getMessage());
            return resultMsg;
        }                 
        return resultMsg;
    } 
}
