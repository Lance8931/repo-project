package com.siping.hrip.portal.user.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.stroma.framework.core.platform.web.StromaController;

import com.siping.domain.common.PagePath;

@Controller
@RequestMapping(value="/view")
public class ViewController extends StromaController {

    /**
     * 后台首页
     * @return
     */
    @RequestMapping(value = "/admin/index", method = RequestMethod.GET)
    public String adminIndex(){
        
        return PagePath.ADMIN_INDEX;
    }

    /**
     * 企业用户列表页
     * @return
     */
    @RequestMapping(value = "/user/org/list", method = RequestMethod.GET)
    public String userOrgList(){
        
        return PagePath.LIST_ORG_USER;
    }

    /**
     * 个人用户列表页
     * @return
     */
    @RequestMapping(value = "/user/personal/list", method = RequestMethod.GET)
    public String userPersonalList(){
        
        return PagePath.LIST_PERSONAL_USER;
    }

    /**
     * 单位用户列表页
     * @return
     */
    @RequestMapping(value = "/user/emp/list", method = RequestMethod.GET)
    public String userEmpList(){
        
        return PagePath.LIST_EMP_USER;
    }
}
