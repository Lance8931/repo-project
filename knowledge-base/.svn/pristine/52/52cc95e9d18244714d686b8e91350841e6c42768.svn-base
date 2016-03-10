package com.siping.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siping.system.bean.SysUser;
import com.siping.system.mapper.SysUserMapper;
import com.siping.system.service.SysUserService;
import com.siping.util.MD5Util;

@Service
public class SysUserServiceImpl implements SysUserService{
    @Autowired
    private SysUserMapper sm;
    
    @Override
    public SysUser userLogin(SysUser user) throws Exception{
        MD5Util add = new MD5Util();
        Map<String, Object> userMap = new HashMap<String, Object>();
        String pass = add.MD5Add(user.getUserPass());//加密密码
        userMap.put("userPass", pass);
        userMap.put("userName", user.getUserName());
        List<SysUser> userList = sm.get(userMap);
        if(userList.size()==1){
            return userList.get(0);
        }
        return null;
    }

}
