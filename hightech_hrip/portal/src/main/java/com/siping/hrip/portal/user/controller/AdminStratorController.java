package com.siping.hrip.portal.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.stroma.framework.core.platform.web.StromaController;

import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.HrEmployee;
import com.siping.domain.portal.entity.PageRequest;
import com.siping.domain.portal.entity.PageResponse;
import com.siping.domain.portal.entity.User;
import com.siping.domain.portal.entity.UserOrgInfo;
import com.siping.domain.portal.entity.UserPersonalInfo;
import com.siping.hrip.portal.user.service.AdminStratorService;

@Controller
@RequestMapping(value = "/adminstrator")
public class AdminStratorController extends StromaController {
    @Autowired
    private AdminStratorService adminservice;
    User user = new User();
    HrEmployee he = new HrEmployee();
    UserPersonalInfo personal = new UserPersonalInfo();
    UserOrgInfo org = new UserOrgInfo();

    /**
     * 添加单位用户
     * @return
     */
    @RequestMapping(value = "/addUserHr", method = RequestMethod.GET)
    @ResponseBody
    public ResultMsg addUserHr() {
        ResultMsg msg = new ResultMsg();
        try {
            msg.setMsg(adminservice.addUser(user, he));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    /**
     * 修改单位用户
     * @return
     */
    @RequestMapping(value = "/updateUserHrEmployee", method = RequestMethod.GET)
    @ResponseBody
    public ResultMsg updateUserHrEmployee() {
        ResultMsg msg = new ResultMsg();
        try {
            msg.setMsg(adminservice.updateUserHrEmployee(user, he));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    /**
     * 查询所有单位用户
     */
    @RequestMapping(value = "/getAllEmployee", method = RequestMethod.GET)
    @ResponseBody
    public PageResponse<HrEmployee> getAllEmployee() {
        PageRequest pageRequest = new PageRequest();
        pageRequest.setPageNo(1);
        pageRequest.setPageSize(10);
        try {
            return adminservice.getAllEmployee(pageRequest, he);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询所有个人用户
     */
    @RequestMapping(value = "/getAllPersonal", method = RequestMethod.GET)
    @ResponseBody
    public PageResponse<UserPersonalInfo> getAllPersonal() {
        PageRequest pageRequest = new PageRequest();
        pageRequest.setPageNo(1);
        pageRequest.setPageSize(10);
        try {
            return adminservice.getAllPersonal(pageRequest, personal);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询所企业人用户
     */
    @RequestMapping(value = "/getAllOrg", method = RequestMethod.GET)
    @ResponseBody
    public PageResponse<UserOrgInfo> getAllOrg() {
        PageRequest pageRequest = new PageRequest();
        pageRequest.setPageNo(1);
        pageRequest.setPageSize(10);
        try {
            return adminservice.getAllOrg(pageRequest, org);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 删除单位用户
     * @return
     */
    @RequestMapping(value = "/deleteUserHrEmployee", method = RequestMethod.GET)
    @ResponseBody
    public ResultMsg deleteUserHrEmployee() {
        ResultMsg msg = new ResultMsg();
        try {
            msg.setMsg(adminservice.deleteUserHrEmlpoyee(he));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }
}
