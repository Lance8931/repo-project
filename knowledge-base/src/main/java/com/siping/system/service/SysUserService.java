package com.siping.system.service;


import com.siping.system.bean.SysUser;
import com.siping.web.bean.PageRequest;
import com.siping.web.bean.PageResponse;

public interface SysUserService {
    /**
     * 用户登录验证
     * @return
     */
    SysUser userLogin(SysUser user) throws Exception;
    /**
     *  获取各个状态的用户并分页显示
     * @param pageRequest
     * @param userType 用户状态0、管理员1、普通用户2、待审核用户3为通过的用户
     * @return
     * @throws Exception
     */
    PageResponse<SysUser> getUserByPage(PageRequest pageRequest,int userType) throws Exception;
    /**
     * 根据ID获取用户详情
     * @param id
     * @return
     * @throws Exception
     */
    SysUser getUser(String id) throws Exception;
    /**
     * 重置用户密码
     * @param id
     * @return
     * @throws Exception
     */
    String resetPass(SysUser su) throws Exception;
    /**
     * 根据ID删除用户信息
     * @param id
     * @return
     * @throws Exception
     */
    String deleteUser(String id)throws Exception;
    /**
     * 审核新建用户
     * @param id
     * @param result 审核结果1通过 2不通过
     * @return
     * @throws Exception
     */
    String examineUser(SysUser su)throws Exception;
    /**
     * 验证新建用户账号是否使用
     * @param su
     * @return
     * @throws Exception
     */
    String selectNewName(SysUser su)throws Exception;
}
