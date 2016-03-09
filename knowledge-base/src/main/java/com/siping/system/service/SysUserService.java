package com.siping.system.service;


import com.siping.system.bean.SysUser;

public interface SysUserService {
    /**
     * 用户登录验证
     * @return
     */
    SysUser userLogin(SysUser user) throws Exception;
}
