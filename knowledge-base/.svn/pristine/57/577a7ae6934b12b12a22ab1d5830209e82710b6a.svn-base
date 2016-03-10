package com.siping.system.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.siping.system.bean.SysUser;
import com.siping.system.service.SysUserService;
import com.siping.web.bean.PagePath;

@Controller
public class SysUserAction {
    @Autowired
    private SysUserService ss;
    /**
     * 验证用户账号密码-成功：获取用户信息
     * @param name
     * @param pass
     * @return
     */
    @RequestMapping(value="/answer/userLogin",method=RequestMethod.POST)
    public String userLogin(SysUser su,HttpSession hs){
        try {
            su = ss.userLogin(su);
            hs.setAttribute("loginUser",su);
            return PagePath.ALL_PRODUCTS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "hehe";
    }
}
