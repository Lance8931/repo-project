package com.siping.system.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siping.system.bean.SysUser;
import com.siping.system.mapper.SysUserMapper;
import com.siping.system.service.SysUserService;
import com.siping.util.MD5Util;
import com.siping.web.bean.PageRequest;
import com.siping.web.bean.PageResponse;

@Service
public class SysUserServiceImpl implements SysUserService{
    @Autowired
    private SysUserMapper sm;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    MD5Util add = new MD5Util();
    @Override
    public SysUser userLogin(SysUser user) throws Exception{
        Map<String, Object> userMap = new HashMap<String, Object>();
        String pass = add.MD5Add(user.getUserPass());//MD5加密密码
        userMap.put("userPass", pass);
        userMap.put("userName", user.getUserName());
        List<SysUser> userList = sm.get(userMap);
        if(userList.size()==1){
            return userList.get(0);
        }
        return null;
    }
    @Override
    public PageResponse<SysUser> getUserByPage(PageRequest pageRequest,int userType) throws Exception {
        PageResponse<SysUser> pageResponse = new PageResponse<SysUser>();
        Map<String, Object> userMap = new HashMap<String, Object>();
        userMap.put("userType", userType);//设置查询用户的状态 
        userMap.put("pageRequest", pageRequest);
        List<SysUser> pros = sm.getByPage(userMap);//待审用户
        Integer total = sm.getTotalUsers(userType);//待审用户总量 
        pageResponse.setRecords(pros);
        pageResponse.setTotal(total);
        return pageResponse;
    }
    @Override
    public SysUser getUser(String id) throws Exception {
        return sm.selectByPrimaryKey(Integer.valueOf(id));
    }
    @Override
    public String resetPass(SysUser su) throws Exception {
        String pass = add.MD5Add("123456");//重置密码为123456 MD5加密
        su.setUserPass(pass);
        su.setUpdateTime(sdf.format(new Date()));//赋值操作（修改）时间
        Integer k = sm.updateByPrimaryKeySelective(su);
        if(k==1)
            return "成功！";
        else
            return "失败！";
    }
    @Override
    public String deleteUser(String id) throws Exception {
        Integer k = sm.deleteByPrimaryKey(Integer.valueOf(id));
        if(k==1)
            return "成功！";
        else
            return "失败！";
    }
    @Override
    public String examineUser(SysUser su) throws Exception {
        su.setUpdateTime(sdf.format(new Date()));//赋值操作（修改）时间
        Integer k = sm.updateByPrimaryKeySelective(su);
        if(k==1)
            return "成功！";
        else
            return "失败！";
    }
    @Override
    public String selectNewName(SysUser su) throws Exception {
        Integer k = sm.selectNewName(su);
        if(k==0)
            return "恭喜！账号可以使用！";
        else
            return "账号已被注册，请重新输入！";
    }
}
