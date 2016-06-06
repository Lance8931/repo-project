package com.siping.hrip.portal.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.stroma.framework.core.platform.intercept.LoginRequired;
import org.stroma.framework.core.platform.web.StromaController;

import com.siping.domain.common.PagePath;

@Controller
@LoginRequired
public class IndexController extends StromaController {

    /**
     * 首页
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String adminIndex() {
        return PagePath.WELCOME;
    }

    /**
     * 关于我们
     */
    @RequestMapping(value = "/aboutus", method = RequestMethod.GET)
    public String aboutUs() {
        return PagePath.ABOUT_US;
    }

    /**
     * 园区概况
     */
    @RequestMapping(value = "/about-park", method = RequestMethod.GET)
    public String aboutPark() {
        return PagePath.ABOUT_PARK;
    }

    /**
     * 企业入区
     */
    @RequestMapping(value = "/get-in-park", method = RequestMethod.GET)
    public String getInPark() {
        return PagePath.GET_IN_PARK;
    }

    /**
     * 创新创业
     */
    @RequestMapping(value = "/innovate", method = RequestMethod.GET)
    public String innovate() {
        return PagePath.INNOVATE;
    }

    /**
     * 最新资讯
     */
    @RequestMapping(value = "/latest-news", method = RequestMethod.GET)
    public String latestNews() {
        return PagePath.LATEST_NEWS;
    }

    /**
     * 通知公告
     */
    @RequestMapping(value = "/notification", method = RequestMethod.GET)
    public String notification() {
        return PagePath.NOTIFICATION;
    }
}
