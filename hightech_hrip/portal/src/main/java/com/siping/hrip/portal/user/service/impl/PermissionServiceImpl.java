package com.siping.hrip.portal.user.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.stroma.framework.core.platform.web.filter.RequestUtils;

import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.Groups;
import com.siping.domain.portal.entity.HrEmployee;
import com.siping.domain.portal.entity.PageRequest;
import com.siping.domain.portal.entity.PageResponse;
import com.siping.domain.portal.entity.Permission;
import com.siping.domain.portal.entity.UserGroup;
import com.siping.hrip.portal.user.mapper.AdminMapper;
import com.siping.hrip.portal.user.mapper.PermissionMapper;
import com.siping.hrip.portal.user.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private AdminMapper adminMapper;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public ResultMsg addGroup(Groups group) throws Exception {
        try {
            permissionMapper.addGroup(group);
        } catch (Exception e) {
            new Exception("添加错误，请稍后再试");
        }
        return new ResultMsg(true, "添加成功！");
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public ResultMsg updateGroup(Groups group) throws Exception {
        if (permissionMapper.updateGroup(group) == 1) {
            return new ResultMsg(true, "修改成功！");
        } else {
            return new ResultMsg(false, "修改失败！");
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public ResultMsg deleteGroup(List<Integer> roleId) throws Exception {
        /* 判断权限组是否被引用 */
        if (permissionMapper.selectUserGroup(roleId) > 0) {
            return new ResultMsg(false, "角色组已经被引用，不能删除！");
        }
        /* 删除角色菜单权限 */
        permissionMapper.deletePermission(roleId);
        /* 删除角色组 */
        permissionMapper.deleteGroup(roleId);
        return new ResultMsg(true, "删除成功！");

    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Groups selectGroup(String groupId) throws Exception {
        return permissionMapper.selectGroups(Integer.valueOf(groupId));
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public ResultMsg addUpdateMenu(List<Permission> pmss) throws Exception {
        List<Integer> groupIds = new ArrayList<Integer>();
        groupIds.add(pmss.get(0).getGroupId());
        permissionMapper.deletePermission(groupIds); // 删除之前角色菜单的权限
        permissionMapper.addUpdateMenu(pmss); // 保存角色菜单权限
        return new ResultMsg(true, "保存成功！");
    }

    @Override
    public String addUpdateUserGroup(List<UserGroup> listUserGroup) throws Exception {
        permissionMapper.deleteUserGroup(listUserGroup.get(0).getUsername());
        UserGroup ug = null;
        for (int i = 0; i < listUserGroup.size(); i++) {
            ug = new UserGroup();
            ug = listUserGroup.get(i);
            permissionMapper.addUpdateUserGroup(ug);
        }
        return "授权成功！";
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public PageResponse<Groups> listRole(HttpServletRequest request) throws Exception {
        Map<String, Object> pageMap = RequestUtils.getRequestParams(request);
        PageRequest pageRequest = new PageRequest();
        PageResponse<Groups> pageresponse = new PageResponse<Groups>();

        pageRequest.setPageNo(Integer.valueOf(pageMap.get("pageSize").toString())); // 当前页数
        pageRequest.setPageSize(Integer.valueOf(pageMap.get("limit").toString())); // 每页显示页数
        List<Groups> listRole = permissionMapper.listRole(pageRequest);
        Integer total = permissionMapper.totalRole();
        pageresponse.setRecords(listRole);
        pageresponse.setTotal(total);
        return pageresponse;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Permission> listPermission(String groupId) throws Exception {
        List<Permission> list = permissionMapper.listPermission(Integer.valueOf(groupId));
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public PageResponse<HrEmployee> listHrEmployee(HttpServletRequest request) throws Exception {
        PageResponse<HrEmployee> hrList = new PageResponse<HrEmployee>();
        hrList.setRecords(adminMapper.getEmployeeAll());
        hrList.setTotal(adminMapper.getEmployeeTotal());
        return hrList;
    }

    @Override
    public List<UserGroup> listRoleHr() throws Exception {
        return permissionMapper.listRoleHr();
    }

}
