package com.siping.hrip.portal.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.stroma.framework.core.platform.web.StromaController;

import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.Groups;
import com.siping.hrip.portal.user.service.PermissionService;

@Controller
@RequestMapping(value = "/group")
public class PermissionContorller extends StromaController {
    @Autowired
    private PermissionService groupService;
    private Groups group = new Groups();
    ResultMsg msg = null;

    /**
     * 添加组
     * @return
     */
    @RequestMapping(value = "/addGroup", method = RequestMethod.GET)
    @ResponseBody
    public ResultMsg addGroup() {
        msg = new ResultMsg();
        try {
            msg.setMsg(groupService.addGroup(group));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    /**
     * 修改组
     * @return
     */
    @RequestMapping(value = "/updateGroup", method = RequestMethod.GET)
    @ResponseBody
    public ResultMsg updateGroup() {
        msg = new ResultMsg();
        try {
            msg.setMsg(groupService.updateGroup(group));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    /**
     * 删除组
     * @return
     */
    @RequestMapping(value = "/deleteGroup", method = RequestMethod.GET)
    @ResponseBody
    public ResultMsg deleteGroup() {
        msg = new ResultMsg();
        try {
            msg.setMsg(groupService.deleteGroup(group));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    /**
     * 查询组
     * @return
     */
    @RequestMapping(value = "/selectGroup", method = RequestMethod.GET)
    @ResponseBody
    public Groups selectGroup() {
        msg = new ResultMsg();
        try {
            return groupService.selectGroup(group);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
