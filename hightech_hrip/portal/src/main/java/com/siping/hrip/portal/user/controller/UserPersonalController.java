package com.siping.hrip.portal.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.User;
import com.siping.domain.portal.entity.UserPersonalInfo;
import com.siping.hrip.portal.user.service.UserPersonalService;

@Controller
@RequestMapping(value = "/userPsersonal")
public class UserPersonalController {
    @Autowired
    UserPersonalService personalService;
    User user = new User();
    UserPersonalInfo personal = new UserPersonalInfo();

    /**
     * 添加个人用户
     * @return
     */
    @RequestMapping(value = "/addPersonal", method = RequestMethod.GET)
    @ResponseBody
    public ResultMsg addPersonal() {
        ResultMsg msg = new ResultMsg();
        try {
            msg.setMsg(personalService.addPersonal(user, personal));
        } catch (Exception e) {
            e.printStackTrace();
        }
        msg.setSuccess(true);
        return msg;
    }

    /**
     * 修改个人用户
     * @return
     */
    @RequestMapping(value = "/updatePersonal", method = RequestMethod.GET)
    @ResponseBody
    public ResultMsg updatePersonal() {
        ResultMsg msg = new ResultMsg();
        try {
            msg.setMsg(personalService.updatePersonal(user, personal));
        } catch (Exception e) {
            e.printStackTrace();
        }
        msg.setSuccess(true);
        return msg;
    }

    /**
     * 找回 密码--验证账号
     * @return
     */
    @RequestMapping(value = "/verifyAnswer", method = RequestMethod.GET)
    @ResponseBody
    public UserPersonalInfo verifyAnswer() {
        try {
            return personalService.verifyAnswer(personal);
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
        ResultMsg msg = new ResultMsg();
        try {
            msg.setMsg(personalService.updatePwd(user, personal));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    /**
     * 获取个人详情
     * @return
     */
    @RequestMapping(value = "/getUserPersonal", method = RequestMethod.GET)
    @ResponseBody
    public UserPersonalInfo getUserPersonal() {
        try {
            return personalService.getUserPersonal(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
