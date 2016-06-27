package com.siping.hrip.portal.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.stroma.framework.core.platform.web.StromaController;

import com.siping.domain.common.PagePath;
import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.Groups;
import com.siping.domain.portal.entity.HrEmployee;
import com.siping.domain.portal.entity.PageResponse;
import com.siping.domain.portal.entity.Permission;
import com.siping.domain.portal.entity.UserGroup;
import com.siping.hrip.portal.user.service.PermissionService;

@Controller
@RequestMapping(value = "/permission")
public class PermissionContorller extends StromaController {
    @Autowired
    private PermissionService groupService;
    ResultMsg msg = null;

    /**
     * 添加角色组
     * @return
     */
    @RequestMapping(value = "/role/add", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg addGroup(Groups group) {
        try {
            return groupService.addGroup(group);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(false, e.getMessage());
        }
    }

    /**
     * 角色---添加页面
     * @author:pingrong
     * @date:2016年5月31日
     * @return
     */
    @RequestMapping(value = "/role/addPage", method = RequestMethod.GET)
    public String addRolePage() {
        return PagePath.ADMIN_ROLE_ADD;
    }

    /**
     * 菜单页面
     * @author:pingrong
     * @date:2016年6月1日
     * @return
     */
    @RequestMapping(value = "/role/menuPage", method = RequestMethod.GET)
    public String menuPage(String groupId, ModelMap map) {
        try {
            map.put("groupId", groupId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return PagePath.ADMIN_MENU;
    }

    /**
     * 获取角色下面的权限
     * @author:pingrong
     * @date:2016年6月2日
     * @param groupId
     * @return
     */
    @RequestMapping(value = "/permission/listPermission", method = RequestMethod.POST)
    @ResponseBody
    public List<Permission> listPermission(String groupId) {
        try {
            return groupService.listPermission(groupId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 单位用户--角色组 关联数据
     * @author:pingrong
     * @date:2016年6月2日
     * @return
     */
    @RequestMapping(value = "/RoleHr/listRoleHr", method = RequestMethod.POST)
    @ResponseBody
    public List<UserGroup> listRoleHr() {
        try {
            return groupService.listRoleHr();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 角色---修改页面
     * @author:pingrong
     * @date:2016年5月31日
     * @return
     */
    @RequestMapping(value = "/role/editPage", method = RequestMethod.GET)
    public String editRolePage(String groupId, ModelMap map) {
        try {
            map.put("role", groupService.selectGroup(groupId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return PagePath.ADMIN_ROLE_EDIT;
    }

    /**
     * 角色组页面--权限组跳转
     * @author:pingrong
     * @date:2016年6月2日
     * @param groupId
     * @param map
     * @return
     */
    @RequestMapping(value = "/userGroup/listRolePage", method = RequestMethod.GET)
    public String listRolePage(String hrId, ModelMap map) {
        try {
            map.put("hrId", groupService.selectGroup(hrId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return PagePath.ADMIN_ROLE_LIST;
    }

    /**
     * 获取list角色
     * @author:pingrong
     * @date:2016年5月31日
     * @param group
     * @return
     */
    @RequestMapping(value = "/role/list", method = RequestMethod.GET)
    @ResponseBody
    public PageResponse<Groups> listRole(HttpServletRequest request) {
        try {
            return groupService.listRole(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/permission/listHrEmployee", method = RequestMethod.GET)
    @ResponseBody
    public PageResponse<HrEmployee> listHrEmployee(HttpServletRequest request) {
        try {
            return groupService.listHrEmployee(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 修改角色组
     * @return
     */
    @RequestMapping(value = "/role/updateRole", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg updateGroup(Groups group) {
        try {
            return groupService.updateGroup(group);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(false, "修改失败，请稍后再试！");
        }
    }

    /**
     * 删除角色组
     * @return
     */
    @RequestMapping(value = "/role/deleteRole", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg deleteGroup(@RequestBody List<Integer> roles) {
        try {
            return groupService.deleteGroup(roles);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(false, "删除失败，请稍后再试");
        }
    }

    /**
     * 添加修改角色菜单
     * @return
     */
    @RequestMapping(value = "/role/addUpdateMenu", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg addUpdateMenu(@RequestBody List<Permission> pmss, HttpServletRequest request) {
        try {
            return groupService.addUpdateMenu(pmss);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(false, "操作失败，请稍后再试");
        }
    }

    /**
     * 添加修改用户权限
     * @return
     */
    @RequestMapping(value = "/addUpdateUserGroup", method = RequestMethod.GET)
    @ResponseBody
    public ResultMsg addUpdateUserGroup() {
        msg = new ResultMsg();
        UserGroup ug = new UserGroup();
        List<UserGroup> listUg = new ArrayList<UserGroup>();
        ug.setUserId("");
        ug.setGroupId(1);
        listUg.add(ug);
        try {
            msg.setMsg(groupService.addUpdateUserGroup(listUg));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

}
