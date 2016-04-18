package com.siping.hrip.portal.user.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.stroma.framework.core.platform.web.StromaController;

import com.siping.domain.common.PagePath;

@Controller
public class AdminController extends StromaController {

    @RequestMapping(value = "/admin/index", method = RequestMethod.GET)
    public String adminIndex(){
        
        return PagePath.ADMIN_INDEX;
    }
}
