package com.siping.hrip.portal.user.mapper;

import java.math.BigInteger;

import com.siping.domain.portal.entity.User;

/**
 * 用户登录sql映射文件
 * @author yangxu
 *
 */
public interface LoginMapper {
    User get(BigInteger id);
    /**
     * 根据用户名（username）查询账号相关信息
     * @param username 用户名
     * @return
     */
    User login(String username) throws Exception ;
    /**
     * 修改密码
     * @param id 
     * @param username
     * @param pwdHash
     * @return
     */
    Integer resetPwd(User user) throws Exception;
}
