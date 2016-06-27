package com.siping.hrip.portal.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.siping.domain.common.PagePath;

/**
 * @author siping-L.J.H
 * @date 2016年6月3日下午4:34:28
 * @version 1.0
 */
@Controller
@RequestMapping("/report")
public class ReportController {

    @RequestMapping("/employment")
    public String redirectReport() {
        return PagePath.REPORT_EMPLOYMENT;
    }
}
