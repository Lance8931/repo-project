package com.siping.hrip.portal.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.stroma.framework.core.platform.web.StromaController;

import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.User;
import com.siping.domain.portal.entity.UserOrgInfo;
import com.siping.hrip.portal.user.service.UserOrgService;

@Controller
@RequestMapping(value = "/userOrg")
public class UserOrgController extends StromaController {
    @Autowired
    private UserOrgService orgService;
    UserOrgInfo org = new UserOrgInfo();
    User user = new User();
    ResultMsg msg;

    /**
     * 添加企业用户
     * @return
     */
    @RequestMapping(value = "/addOrg", method = RequestMethod.GET)
    @ResponseBody
    public ResultMsg addOrg() {
        msg = new ResultMsg();
        try {
            msg.setMsg(orgService.addOrg(user, org));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    /**
     * 修改企业信息
     * @return
     */
    @RequestMapping(value = "/updateOrg", method = RequestMethod.GET)
    @ResponseBody
    public ResultMsg updateOrg() {
        msg = new ResultMsg();
        try {
            msg.setMsg(orgService.updateOrg(user, org));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    /**
     * 获取企业详情信息（找回秘密----返回用户问题）
     * @return
     */
    @RequestMapping(value = "/getUserOrg", method = RequestMethod.GET)
    @ResponseBody
    public UserOrgInfo getUserOrg() {
        try {
            return orgService.getUserOrg(org);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 修改密码
     * @return
     */
    @RequestMapping(value = "/updatePwd", method = RequestMethod.GET)
    @ResponseBody
    public ResultMsg updatePwd() {
        msg = new ResultMsg();
        try {
            msg.setMsg(orgService.updatePwd(user, org));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }
}
