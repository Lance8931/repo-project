package com.siping.hrip.portal.user.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.HrEmployee;
import com.siping.domain.portal.entity.PageResponse;
import com.siping.domain.portal.entity.User;

public interface AdminService {
    /**
     * 添加单位用户
     * @param user
     * @return
     */
    public ResultMsg addEmp(HrEmployee he) throws Exception;

    /**
     * 修改单位用户
     * @param user
     * @param he
     * @return
     */
    public ResultMsg updateUserHrEmployee(HrEmployee he) throws Exception;

    /**
     * 查询单位用户S
     * @param map
     * @return
     */
    public PageResponse<HrEmployee> getAllEmployee(HttpServletRequest request) throws Exception;

    /**
     * 删除单位用户
     * @param hrEmployee
     * @return
     */
    public ResultMsg deleteUserHrEmlpoyee(String[] userNames) throws Exception;

    /**
     * 获取单位用户详情
     * @param username
     * @return
     * @throws Exception
     */
    public HrEmployee getHrEmployee(String username, HttpServletRequest request) throws Exception;

    /**
     * 修改密码
     * @param reqeust
     * @return
     * @throws Exception
     */
    public ResultMsg updatePassword(HttpServletRequest request, String passWord, String oldPassWord) throws Exception;

    /**
     * 找回密码---验证账号是否存在
     * @param request
     * @param passWord
     * @return
     * @throws Exception
     */
    public Map<String, Object> getUserInfo(String userName, Map<String, Object> map) throws Exception;

    /**
     * 找回密码---验证答案修改密码
     * @param userType
     * @param userName
     * @param pwdHash
     * @param psdAnswer
     * @return
     */
    public ResultMsg seekPassWord(String userType, String userName, String pwdHash, String psdAnswer) throws Exception;

    /**
     * 添加用户
     * @param user
     * @return
     */
    public ResultMsg addUser(User user) throws Exception;

    /**
     * 重置单位用户密码
     * @param userName
     * @return
     * @throws Exception
     */
    public ResultMsg resetPassWord(String userName) throws Exception;

}
