package com.siping.hrip.portal.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.stroma.framework.core.platform.web.StromaController;

import com.siping.domain.common.PagePath;
import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.HrEmployee;
import com.siping.domain.portal.entity.PageResponse;
import com.siping.domain.portal.entity.User;
import com.siping.domain.portal.entity.UserOrgInfo;
import com.siping.domain.portal.entity.UserPersonalInfo;
import com.siping.hrip.portal.user.service.AdminService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController extends StromaController {
    @Autowired
    private AdminService adminservice;
    UserPersonalInfo personal = new UserPersonalInfo();
    UserOrgInfo org = new UserOrgInfo();

    /**
     * 添加单位用户
     * @return
     */
    @RequestMapping(value = "/hrEmployee/add", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg addUserHr(HrEmployee hr) {
        ResultMsg msg = new ResultMsg();
        try {
            msg = adminservice.addEmp(hr);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setMsg(e.getMessage());
        }
        return msg;
    }

    /**
     * 添加user
     * @return
     */
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg addUser(User user) {
        ResultMsg msg = new ResultMsg();
        try {
            msg = adminservice.addUser(user);
            msg.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setMsg(e.getMessage());
        }
        return msg;
    }

    /**
     * 修改单位用户
     * @return
     */
    @RequestMapping(value = "/hrEmployee/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg updateUserHrEmployee(HrEmployee he) {
        ResultMsg msg = new ResultMsg();
        try {
            msg = adminservice.updateUserHrEmployee(he);
            msg.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setMsg(e.getMessage());
        }
        return msg;
    }

    /**
     * 查询所有单位用户
     */
    @RequestMapping(value = "/hrEmployee/list", method = RequestMethod.GET)
    @ResponseBody
    public PageResponse<HrEmployee> getAllEmployee(HttpServletRequest request) {
        try {
            return adminservice.getAllEmployee(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 删除单位用户
     * @return
     */
    @RequestMapping(value = "/hrEmployee/delete", method = RequestMethod.GET)
    @ResponseBody
    public ResultMsg deleteUserHrEmployee(String[] userNames) {
        ResultMsg msg = new ResultMsg();
        try {
            msg = adminservice.deleteUserHrEmlpoyee(userNames);
            msg.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setMsg(e.getMessage());
        }
        return msg;
    }

    /**
     * 查询单位用户详情
     * @param username
     * @return
     */
    @RequestMapping(value = "/hrEmployee/view", method = RequestMethod.GET)
    public String getHrEmployee(String username, ModelMap mmap, HttpServletRequest request, HttpServletResponse response) {
        try {
            /* 判断是个人查询还是管理员查询 ,1为个人, 0管理员 */
            if (username == null || username.equals("")) {
                mmap.put("types", 1);
            } else {
                mmap.put("types", 0);
            }
            HrEmployee hEmployee = adminservice.getHrEmployee(username, request);
            if (hEmployee != null) {
                mmap.put("he", hEmployee);
                mmap.put("msg", new ResultMsg(true, ""));
            } else {
                return PagePath.ADMIN_LOGIN;
            }
        } catch (Exception e) {
            e.printStackTrace();
            mmap.put("msg", new ResultMsg(false, e.getMessage()));
        }
        return PagePath.EDIT_EMP_USER;
    }

    /**
     * 修改密码
     * @return
     */
    @RequestMapping(value = "/user/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg updatePassword(HttpServletRequest reqeust, String passWord, String oldPassWord) {
        ResultMsg msg = new ResultMsg();
        try {
            msg = adminservice.updatePassword(reqeust, passWord, oldPassWord);
            msg.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setMsg(e.getMessage());
        }
        return msg;
    }

    /**
     * 找回密码，验证用户名,获取密保问题
     * @param reqeust
     * @param passWord
     * @return
     */
    @RequestMapping(value = "/user/getPsdQuestion", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getPsdQuestion(String userName) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            return adminservice.getUserInfo(userName, map);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", "false");
            map.put("psdQuestion", e.getMessage());
        }
        return map;
    }

    /**
     * 找回密码--验证答案保存新密码
     * @return
     */
    @RequestMapping(value = "/user/seekPassWord", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg seekPassWord(String userType, String userName, String pwdHash, String psdAnswer) {
        ResultMsg msg = new ResultMsg();
        try {
            msg = adminservice.seekPassWord(userType, userName, pwdHash, psdAnswer);
            msg.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setMsg(e.getMessage());
        }
        return msg;
    }

    /**
     * 重置单位用户密码为123456
     * @param userName
     * @return
     */
    @RequestMapping(value = "/user/resetPassWord", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg resetPassWord(String userName) {
        ResultMsg msg = new ResultMsg();
        try {
            msg = adminservice.resetPassWord(userName);
            msg.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setMsg(e.getMessage());
        }
        return msg;
    }
}
