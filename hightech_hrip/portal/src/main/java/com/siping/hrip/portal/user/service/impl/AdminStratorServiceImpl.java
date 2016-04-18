package com.siping.hrip.portal.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.stroma.framework.core.util.DigestUtils;

import com.siping.domain.portal.entity.HrEmployee;
import com.siping.domain.portal.entity.PageRequest;
import com.siping.domain.portal.entity.PageResponse;
import com.siping.domain.portal.entity.User;
import com.siping.domain.portal.entity.UserOrgInfo;
import com.siping.domain.portal.entity.UserPersonalInfo;
import com.siping.hrip.portal.user.mapper.AdminStratorMapper;
import com.siping.hrip.portal.user.service.AdminStratorService;

@Service
public class AdminStratorServiceImpl implements AdminStratorService {
    @Autowired
    private AdminStratorMapper adminStratorMapper;

    /**
     * 添加单位用户
     * @param user
     * @return
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public String addUser(User user, HrEmployee he) throws Exception {
        user.setUsername("sipingsoft");
        user.setEnabled(1);
        user.setPwdIterator(RandomUtils.nextInt(10) + 1);
        user.setPwdSalt(RandomStringUtils.randomAlphanumeric(6));
        user.setPwdHash(DigestUtils.calculatePasswordHashWithSha512("12345678", user.getPwdSalt(), user.getPwdIterator()));
        user.setCreateDate("2015-04-11 11:11:11");

        he.setUserName("sipingsoft");
        he.setEmpNo(11111);
        he.setPosition("hehe");
        he.setCreateDate("2015-04-11 11:11:11");

        user.setUsername(user.getUsername().replaceAll(" ", ""));// 去除所有空格
        /* 验证用户名和员工编号是否存在 */
        Integer isSucceed = adminStratorMapper.selectUserName(user);
        if (isSucceed > 0) {
            return "账号已存在！";
        } else {
            isSucceed = adminStratorMapper.selectHrEmployee(he);
            if (isSucceed > 0) {
                return "员工编号已存在！";
            }
        }
        /* 添加单位用户 */
        adminStratorMapper.addUser(user);// 添加user
        adminStratorMapper.addHrEmployee(he);// 添加hremployee
        return "添加成功！";
    }

    /**
     * 修改单位用户
     * @param user
     * @param he
     * @return
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public String updateUserHrEmployee(User user, HrEmployee he) throws Exception {
        user.setUsername("sipingsoft");
        user.setPwdHash("sipingsoft");
        user.setUpdateDate("2016-01-01 12:12:12");

        he.setUserName("sipingsoft");
        he.setEmpNo(123456);
        he.setUpdateDate("2016-01-01 12:12:12");
        adminStratorMapper.updateUser(user);// 修改user
        adminStratorMapper.updateHrEmployee(he);// 修改hr
        return "修改成功！";
    }

    /**
     * 查询单位用户S
     * @param map
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public PageResponse<HrEmployee> getAllEmployee(PageRequest pageRequest, HrEmployee hrEmployee) throws Exception {
        PageResponse<HrEmployee> pageresponse = new PageResponse<HrEmployee>();
        Map<String, Object> map = new HashMap<String, Object>();
        hrEmployee.setUserName("si");
        map.put("hrEmployee", hrEmployee);
        map.put("pageRequest", pageRequest);
        List<HrEmployee> listHr = adminStratorMapper.getAllEmployee(map);
        Integer total = adminStratorMapper.getTotalEmployee(hrEmployee);
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
    public String deleteUserHrEmlpoyee(HrEmployee hrEmployee) throws Exception {
        hrEmployee.setUserName("sipingsoft");
        Integer isSucceed = adminStratorMapper.deleteUserHrEmployee(hrEmployee);
        if (isSucceed > 1) {
            return "删除成功！";
        }
        return "删除失败！";
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public PageResponse<UserPersonalInfo> getAllPersonal(PageRequest pageRequest, UserPersonalInfo personal) throws Exception {
        PageResponse<UserPersonalInfo> pageresponse = new PageResponse<UserPersonalInfo>();
        Map<String, Object> map = new HashMap<String, Object>();
        personal.setNickname("我");
        map.put("personal", personal);
        map.put("pageRequest", pageRequest);
        List<UserPersonalInfo> listPersonal = adminStratorMapper.getAllPersonal(map);
        Integer total = adminStratorMapper.getTotalPersonal(personal);
        pageresponse.setRecords(listPersonal);
        pageresponse.setTotal(total);
        return pageresponse;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public PageResponse<UserOrgInfo> getAllOrg(PageRequest pageRequest, UserOrgInfo org) throws Exception {
        PageResponse<UserOrgInfo> pageresponse = new PageResponse<UserOrgInfo>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("org", org);
        map.put("pageRequest", pageRequest);
        List<UserOrgInfo> listOrg = adminStratorMapper.getAllOrg(map);
        Integer total = adminStratorMapper.getTotalOrg(org);
        pageresponse.setRecords(listOrg);
        pageresponse.setTotal(total);
        return pageresponse;
    }

}
