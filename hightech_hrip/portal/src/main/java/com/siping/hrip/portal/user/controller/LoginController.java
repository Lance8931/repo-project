package com.siping.hrip.portal.user.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.stroma.framework.core.platform.web.StromaController;

import com.siping.domain.common.PagePath;
import com.siping.domain.common.ResultMsg;
import com.siping.hrip.portal.user.service.LoginService;

/**
 * 用户登录action
 * @author yangxu
 *
 */
@Controller
@RequestMapping("/user")
public class LoginController extends StromaController {
    @Autowired
    private LoginService userService;
    

    /**
     * 后台用户登录界面
     * @return
     */
    @RequestMapping(value = "/admin/login", method = RequestMethod.GET)
    public String adminLogin() {
        return PagePath.ADMIN_LOGIN;
    }

    /**
     * 前台登录界面
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return PagePath.FRONT_LOGIN;
    }

    /**
     * 前台注册界面
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return PagePath.REGISTERED_USER;
    }

    /**
     * 用户登录
     * @param userLoginRequest
     * @param request
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg login(String username, String password, HttpServletRequest request){
        try {
            return userService.login(username, password, request);
        } catch(CannotGetJdbcConnectionException ex){
            ex.printStackTrace();
            return new ResultMsg(false, "数据库连接失败");  
        } catch(SQLException ex){
            ex.printStackTrace();
            return new ResultMsg(false, "登录失败，请检查输入参数");  
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(false, "登录失败，请稍后再试");         
        }
    }
    
    /**
     * 重置密码
     * @param oldPwd
     * @param pwd
     * @param request
     * @return
     */
    @RequestMapping(value = "/pwd/reset", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg resetPwd(String oldPwd, String pwd, HttpServletRequest request){
        try{
            return userService.resetPwd(oldPwd, pwd, request);
        } catch(CannotGetJdbcConnectionException ex){
            ex.printStackTrace();
            return new ResultMsg(false, "数据库连接失败");  
        } catch(SQLException ex){
            ex.printStackTrace();
            return new ResultMsg(false, "修改失败，请检查输入参数");  
        } catch(Exception e){
            e.printStackTrace();
            return new ResultMsg(false, "修改失败，请稍后再试");  
        }
    }

    /**
     * 后台用户退出登录
     * @return
     */
    @RequestMapping(value = "/admin/logout", method = RequestMethod.GET)
    public String adminLogout(HttpServletRequest request) {
        request.getSession().removeAttribute("loggeduser");
        return "redirect:/user/admin/login";
    }
}
