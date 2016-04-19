package com.siping.hrip.portal.user.service.impl;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siping.domain.portal.entity.Groups;
import com.siping.hrip.portal.user.mapper.PermissionMapper;
import com.siping.hrip.portal.user.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper groupmaaper;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public String addGroup(Groups group) throws Exception {
        group.setGroupName("我是酱油");
        group.setDescription("我是打酱油的！！！");
        group.setCreateDate(sdf.format(new Date()));
        if (groupmaaper.addGroup(group) == 1) {
            return "添加成功！";
        } else {
            return "添加失败！";
        }
    }

    @Override
    public String updateGroup(Groups group) throws Exception {
        group.setId(new BigInteger("1"));
        group.setUpdateDate(sdf.format(new Date()));
        if (groupmaaper.updateGroup(group) == 1) {
            return "修改成功！";
        } else {
            return "修改失败！";
        }
    }

    @Override
    public String deleteGroup(Groups group) throws Exception {
        group.setId(new BigInteger("1"));
        Integer x = groupmaaper.selectUserGroup(1);
        if (x > 0) {
            return "用户组已经被引用，不能删除！";
        }
        if (groupmaaper.deleteGroup(1) == 1) {
            return "删除成功！";
        } else {
            return "删除失败！";
        }

    }

    @Override
    public Groups selectGroup(Groups group) throws Exception {
        return groupmaaper.selectGroups(1);
    }

}
