package com.siping.hrip.portal.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.stroma.framework.core.platform.web.StromaController;

import com.siping.domain.common.PagePath;
import com.siping.domain.portal.entity.User;

@Controller
@RequestMapping(value = "/view")
public class ViewController extends StromaController {

    /**
     * 后台首页
     * @return
     */
    @RequestMapping(value = "/admin/index", method = RequestMethod.GET)
    public String adminIndex(HttpServletRequest request, ModelMap map) {
        User user = (User) request.getSession().getAttribute("loggeduser");
        map.put("loguser", user);
        return PagePath.ADMIN_INDEX;
    }

    /**
     * 企业用户列表页
     * @return
     */
    @RequestMapping(value = "/user/org/list", method = RequestMethod.GET)
    public String userOrgList() {

        return PagePath.LIST_ORG_USER;
    }

    /**
     * 入住企业用户列表页
     * @return
     */
    @RequestMapping(value = "/user/enterprise/list", method = RequestMethod.GET)
    public String userEnterpriseList() {

        return PagePath.LIST_ENTERPRISE_USER;
    }

    @RequestMapping(value = "/user/org/add", method = RequestMethod.GET)
    public String addOrg() {
        return PagePath.ADD_ORG_USER;
    }

    /**
     * 个人用户列表页
     * @return
     */
    @RequestMapping(value = "/user/personal/list", method = RequestMethod.GET)
    public String userPersonalList() {

        return PagePath.LIST_PERSONAL_USER;
    }

    /**
     * 单位用户列表页
     * @return
     */
    @RequestMapping(value = "/user/emp/list", method = RequestMethod.GET)
    public String userEmpList() {

        return PagePath.LIST_EMP_USER;
    }

    /**
     * 添加单位用户
     * @return
     */
    @RequestMapping(value = "/user/emp/add", method = RequestMethod.GET)
    public String addEmpList() {
        return PagePath.ADD_EMP_USER;
    }

    /**
     * 修改单位用户
     * @return
     */
    @RequestMapping(value = "/user/emp/edit", method = RequestMethod.GET)
    public String editEmpList() {
        return PagePath.EDIT_EMP_USER;
    }

    /**
     * 修改密码
     * @return
     */
    @RequestMapping(value = "/user/updatePassWord", method = RequestMethod.GET)
    public String updatePassword() {
        return PagePath.UPDATEPASSWORD_USER;
    }

    /**
     * 找回密码
     * @return
     */
    @RequestMapping(value = "/user/seekPassWord", method = RequestMethod.GET)
    public String seekPassWrod() {
        return PagePath.SEEKPASSWORD_USER;
    }

    /**
     * 注册用户
     * @return
     */
    @RequestMapping(value = "/user/registered", method = RequestMethod.GET)
    public String registered() {
        return PagePath.REGISTERED_USER;
    }

    /**
     * 方法描述:跳转角色页面
     * @author:pingrong
     * @date:2016年5月31日
     * @return
     */
    @RequestMapping(value = "/user/role", method = RequestMethod.GET)
    public String role() {
        return PagePath.ADMIN_ROLE;
    }

    /**
     * 方法描述:跳转权限页面
     * @author:pingrong
     * @date:2016年5月31日
     * @return
     */
    @RequestMapping(value = "/user/permission", method = RequestMethod.GET)
    public String permission() {
        return PagePath.ADMIN_PERMISSION;
    }
}
