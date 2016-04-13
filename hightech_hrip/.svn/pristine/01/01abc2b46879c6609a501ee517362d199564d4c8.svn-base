package com.siping.hrip.portal.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.stroma.framework.core.platform.web.StromaController;

import com.siping.domain.portal.entity.User;
import com.siping.domain.portal.entity.UserLoginRequest;
import com.siping.hrip.portal.user.service.LoginService;

@Controller
public class LoginController extends StromaController {
    @Autowired
    private LoginService userService;

//    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
//    @ResponseBody
//    public void login() {
//        
//    }
    
    @RequestMapping(value = "/user/login")
    @ResponseBody
    public User login(UserLoginRequest userLoginRequest){
        User user = userService.login(userLoginRequest);
        return user;
    }
}
