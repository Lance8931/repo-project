package com.siping.hrip.portal.user.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.stroma.framework.core.platform.web.filter.RequestUtils;
import org.stroma.framework.core.util.DigestUtils;

import com.siping.domain.common.DataValidation;
import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.HrEmployee;
import com.siping.domain.portal.entity.PageRequest;
import com.siping.domain.portal.entity.PageResponse;
import com.siping.domain.portal.entity.User;
import com.siping.domain.portal.entity.UserOrgInfo;
import com.siping.domain.portal.entity.UserPersonalInfo;
import com.siping.hrip.portal.user.mapper.AdminMapper;
import com.siping.hrip.portal.user.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminStratorMapper;

    /**
     * 添加单位用户
     * @param user
     * @return
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public ResultMsg addEmp(HrEmployee he) throws Exception {
        User user = new User();
        try {
            user.setUsername(he.getUserName().replaceAll(" ", ""));// 去除所有空格
            /* 验证用户名和员工编号是否存在 */
            Integer isSucceed = adminStratorMapper.selectUserName(user);
            if (isSucceed > 0) {
                return new ResultMsg(false, "账号已存在！");
            } else {
                isSucceed = adminStratorMapper.selectHrEmployee(he);
                if (isSucceed > 0) {
                    return new ResultMsg(false, "员工编号已存在！");
                }
            }
            user.setEnabled(1); // 启用标识
            user.setUserType(1); // 用户类别
            /* 密码加密 */
            user.setPwdIterator(RandomUtils.nextInt(10) + 1);
            user.setPwdSalt(RandomStringUtils.randomAlphanumeric(6));
            user.setPwdHash(DigestUtils.calculatePasswordHashWithSha512("123456", user.getPwdSalt(), user.getPwdIterator()));
            user.setIsVerified(1); // 审核标识
            user.setEmail(he.getEmail());
            he.setIsDelete(0);
            /* 添加单位用户 */
            Integer isSuccess = adminStratorMapper.addUser(user);// 添加user
            if (isSuccess == 1) {
                Integer isHe = adminStratorMapper.addHrEmployee(he);// 添加hremployee
                if (isHe == 1) {
                    return new ResultMsg(true, "添加成功！");
                }
            }
        } catch (Exception e) {
            throw new Exception("添加错误，请稍后再试。");
        }
        return new ResultMsg(false, "添加失败！");
    }

    /**
     * 修改单位用户
     * @param user
     * @param he
     * @return
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public ResultMsg updateUserHrEmployee(HrEmployee he) throws Exception {
        try {
            Integer isSuccess = adminStratorMapper.updateHrEmployee(he);// 修改hr
            if (isSuccess == 1) {
                /* 修改USER邮箱 */
                User user = adminStratorMapper.getUser(he.getUserName());
                user.setEmail(he.getEmail());
                isSuccess = adminStratorMapper.updateUser(user);
                if (isSuccess == 1) {
                    return new ResultMsg(true, "修改成功！");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("修改错误，请稍后再试");
        }
        return new ResultMsg(false, "修改失败");
    }

    /**
     * 查询单位用户S
     * @param map
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public PageResponse<HrEmployee> getAllEmployee(HttpServletRequest request) throws Exception {
        HrEmployee hrEmployee = new HrEmployee();
        Map<String, Object> pageMap = RequestUtils.getRequestParams(request);
        PageRequest pageRequest = new PageRequest();
        PageResponse<HrEmployee> pageresponse = new PageResponse<HrEmployee>();
        Map<String, Object> map = new HashMap<String, Object>();

        pageRequest.setPageNo(Integer.valueOf(pageMap.get("pageSize").toString())); // 当前页数
        pageRequest.setPageSize(Integer.valueOf(pageMap.get("limit").toString())); // 每页显示页数
        /* 获取页面查询条件 */
        String querys = pageMap.get("querys").toString();
        if (!querys.equals("") && querys != null) {
            hrEmployee.setUserName(pageMap.get("querys").toString());
            hrEmployee.setEmpName(pageMap.get("querys").toString());
            /* 用户编号为integer型，判断查询条件是否全是数字 */
            if (querys.matches("[0-9]+")) {
                hrEmployee.setEmpNo(Integer.valueOf(pageMap.get("querys").toString()));
            }
        }
        map.put("enabled", Integer.valueOf(pageMap.get("enabled").toString()));
        map.put("hrEmployee", hrEmployee);
        map.put("pageRequest", pageRequest);
        List<HrEmployee> listHr = adminStratorMapper.getAllEmployee(map);
        Integer total = adminStratorMapper.getTotalEmployee(map);
        pageresponse.setRecords(listHr);
        pageresponse.setTotal(total);
        return pageresponse;
    }

    /**
     * 删除单位用户
     * @param hrEmployee
     * @return
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public ResultMsg deleteUserHrEmlpoyee(String[] userNames) throws Exception {
        List<String> nameList = new ArrayList<>();
        for (String userName : userNames) {
            nameList.add(userName);
        }
        try {
            adminStratorMapper.deleteUserHrEmployee(nameList);
            return new ResultMsg(true, "删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("删除错误，请稍后再试");
        }
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public HrEmployee getHrEmployee(String username, HttpServletRequest request) throws Exception {
        HrEmployee hrEmployee;
        try {
            if (username == null) {
                User user = (User) request.getSession().getAttribute("user"); // 获取登录用户信息
                if (user == null) {
                    return null;
                } else {
                    username = user.getUsername();
                }
            }
            hrEmployee = adminStratorMapper.getHrEmployee(username);
        } catch (Exception e) {
            throw new Exception("信息获取失败，请稍后再试。");
        }
        return hrEmployee;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public ResultMsg updatePassword(HttpServletRequest request, String passWord, String oldPassWord) throws Exception {
        try {
            User user = (User) request.getSession().getAttribute("user"); // 获取登录用户信息
            if (user == null) {
                return new ResultMsg(false, "请登录账户");
            }
            user.setPwdHash(DigestUtils.calculatePasswordHashWithSha512(oldPassWord, user.getPwdSalt(), user.getPwdIterator()));
            if (adminStratorMapper.selectUserName(user) != 1) {
                return new ResultMsg(false, "旧密码输入错误。");
            } else if (!passWord.equals("") && passWord != null) {
                user.setPwdHash(DigestUtils.calculatePasswordHashWithSha512(passWord, user.getPwdSalt(), user.getPwdIterator())); // 密码加密
                Integer isSuccess = adminStratorMapper.updateUser(user);
                if (isSuccess == 1) {
                    return new ResultMsg(true, "更改成功！");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("密码修改错误，请稍后再试。");
        }
        return new ResultMsg(false, "更改失败！");
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Map<String, Object> getUserInfo(String userName, Map<String, Object> map) throws Exception {

        /*
         * try { User user = adminStratorMapper.getUser(userName); if
         * (user.getUserType() != null) { map.put("userType",
         * user.getUserType().toString()); // 用户类型 switch (user.getUserType()) {
         * case 1: // 单位用户 map.put("success", "false"); map.put("psdQuestion",
         * "单位用户请联系系统管理员。"); return map; case 2: // 企业用户 UserOrgInfo org = new
         * UserOrgInfo(); org.setOrgCode(userName); map.put("psdQuestion",
         * adminStratorMapper.getOrg(org).getPsdQuestion()); return map; case 3:
         * // 个人用户 UserPersonalInfo personal = new UserPersonalInfo();
         * personal.setIdCode(userName); map.put("psdQuestion",
         * adminStratorMapper.getPersonal(personal).getPsdQuestion()); return
         * map; } } else { map.put("success", "false"); map.put("psdQuestion",
         * "没有该账户。"); } } catch (Exception e) { e.printStackTrace(); throw new
         * Exception("验证账号时发生错误，请稍后再试。"); }
         */
        return map;
    }

    @Override
    public ResultMsg seekPassWord(String userType, String userName, String pwdHash, String psdAnswer) throws Exception {
        User user = new User();
        UserOrgInfo org = new UserOrgInfo();
        UserPersonalInfo personal = new UserPersonalInfo();
        /* 验证答案是否正确 */
        if (Integer.valueOf(userType) == 2) { // 企业用户
            org.setOrgCode(userName);
            org = adminStratorMapper.getOrg(org);

        } else { // 个人用户
            personal = adminStratorMapper.getPersonal(personal);
        }
        /* 修改密码 */
        if (org != null && Integer.valueOf(userType) == 2 || personal != null && Integer.valueOf(userType) == 3) {
            user.setUsername(userName);
            user.setPwdIterator(RandomUtils.nextInt(10) + 1);
            user.setPwdSalt(RandomStringUtils.randomAlphanumeric(6));
            user.setPwdHash(DigestUtils.calculatePasswordHashWithSha512(pwdHash, user.getPwdSalt(), user.getPwdIterator()));
            adminStratorMapper.updateUser(user);
        } else {
            return new ResultMsg(false, "密保答案错误，请查证后再修改。");
        }
        return new ResultMsg(true, "修改成功，可以用新密码登录啦！");
    }

    @Override
    public ResultMsg addUser(User user) throws Exception {
        try {
            /* 如果是个人用户验证身份证号 */
            if (user.getUserType() == 3) {
                DataValidation dv = new DataValidation();
                String idCode = dv.idCardValidate(user.getUsername().replace(" ", ""));
                if (!idCode.equals("")) {
                    return new ResultMsg(false, idCode);
                }
            }
            /* 验证用户名和员工编号是否存在 */
            Integer isSucceed = adminStratorMapper.selectUserName(user);
            if (isSucceed > 0) {
                return new ResultMsg(false, "账号已存在！");
            }
            user.setUsername(user.getUsername().replaceAll(" ", ""));// 去除所有空格
            user.setEnabled(1); // 启用标识
            /* 密码加密 */
            user.setPwdIterator(RandomUtils.nextInt(10) + 1);
            user.setPwdSalt(RandomStringUtils.randomAlphanumeric(6));
            user.setPwdHash(DigestUtils.calculatePasswordHashWithSha512(user.getUsername(), user.getPwdSalt(), user.getPwdIterator()));
            user.setIsVerified(0); // 审核标识
            adminStratorMapper.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("注册错误，请稍后再试");
        }
        return new ResultMsg(true, "注册成功！");
    }

    @Override
    public ResultMsg resetPassWord(String userName) throws Exception {
        if (userName.equals("") || userName == null) {
            return new ResultMsg(false, "用户账号获取失败。");
        }
        try {
            User user = new User();
            user.setUsername(userName);
            user.setPwdHash(DigestUtils.calculatePasswordHashWithSha512("123456", RandomStringUtils.randomAlphanumeric(6), RandomUtils.nextInt(10) + 1));
            adminStratorMapper.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("重置密码发生错误，请稍后在试。");
        }
        return new ResultMsg(true, "该用户的密码已重置为123456");
    }
}
