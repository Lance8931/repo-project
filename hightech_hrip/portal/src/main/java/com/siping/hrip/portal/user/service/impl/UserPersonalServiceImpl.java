package com.siping.hrip.portal.user.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.stroma.framework.core.util.DigestUtils;

import com.siping.domain.common.DataValidation;
import com.siping.domain.portal.entity.User;
import com.siping.domain.portal.entity.UserPersonalInfo;
import com.siping.hrip.portal.user.mapper.UserPersonalMapper;
import com.siping.hrip.portal.user.service.UserPersonalService;

@Service
public class UserPersonalServiceImpl implements UserPersonalService {
    @Autowired
    private UserPersonalMapper personalMapper;
    DataValidation dataValidation;// 数据验证工具类

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = null;

    /**
     * 添加个人用户
     * @param user
     * @param personal
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public String addPersonal(User user, UserPersonalInfo personal) throws Exception {
        date = new Date();
        dataValidation = new DataValidation();// 数据验证工具类
        user.setUsername("510922199107203210".replaceAll(" ", ""));
        /* 校验身份证号 */
        String msg = dataValidation.idCardValidate(user.getUsername());
        if (!msg.equals("")) {
            return msg;
        }
        user.setEnabled(1);
        user.setPwdIterator(RandomUtils.nextInt(10) + 1);
        user.setPwdSalt(RandomStringUtils.randomAlphanumeric(6));
        user.setPwdHash(DigestUtils.calculatePasswordHashWithSha512("12345678", user.getPwdSalt(), user.getPwdIterator()));
        user.setCreateDate(sdf.format(date));

        /* 从身份证号获取出生日期，并存储 */
        if (user.getUsername().length() == 18) {
            String idDate = user.getUsername().substring(6, 14);
            Date b = new SimpleDateFormat("yyyyMMdd").parse(idDate);
            personal.setBirthday(new SimpleDateFormat().format(b));
        } else {
            String idDate = "19" + user.getUsername().substring(6, 12);
            Date b = new SimpleDateFormat("yyyyMMdd").parse(idDate);
            personal.setBirthday(new SimpleDateFormat().format(b));
        }
        personal.setIdCode("510922199107203210".replaceAll(" ", ""));
        personal.setCreateDate(sdf.format(date));
        personal.setNickname("我喂自己袋盐");

        /* 验证账号否存在 */
        Integer isSucceed = personalMapper.selectUserName(user);
        if (isSucceed > 0) {
            return "账号已存在！";
        }

        personalMapper.addUser(user);
        personalMapper.addUserPersonalInfo(personal);
        return "添加成功！";
    }

    /**
     * 修改个人用户
     * @param user
     * @param personal
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public String updatePersonal(User user, UserPersonalInfo personal) throws Exception {
        date = new Date();
        user.setUsername("510922199107203210".replaceAll(" ", ""));
        user.setPwdHash("000000");
        user.setUpdateDate(sdf.format(date));

        personal.setIdCode("510922199107203210".replaceAll(" ", ""));
        personal.setNickname("我喂自己袋盐!");
        personal.setUpdateDate(sdf.format(date));

        personalMapper.updateUser(user);
        personalMapper.updatePersonal(personal);
        return "修改成功！";
    }

    /**
     * 修改密码
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public String updatePwd(User user, UserPersonalInfo personal) throws Exception {
        date = new Date();
        user.setPwdHash("zxcv");
        user.setUsername("510922199107203210".replaceAll(" ", ""));
        user.setPwdIterator(RandomUtils.nextInt(10) + 1);
        user.setPwdSalt(RandomStringUtils.randomAlphanumeric(6));
        user.setPwdHash(DigestUtils.calculatePasswordHashWithSha512(user.getPwdHash(), user.getPwdSalt(), user.getPwdIterator()));
        user.setUpdateDate(sdf.format(date));

        personal.setIdCode("510922199107203210".replaceAll(" ", ""));
        personal.setPsdAnswer("1");
        if (personalMapper.verifyAnswer(personal) == 0) {
            return "问题答案错误！";
        }
        personalMapper.updateUser(user);
        return "修改成功！";
    }

    /**
     * 找回密码---验证账号
     * @param personal
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public UserPersonalInfo verifyAnswer(UserPersonalInfo personal) throws Exception {
        personal.setIdCode("510922199107203210".replaceAll(" ", ""));
        return personalMapper.getUserpersonal(personal.getIdCode());

    }

    /**
     * 获取个人详情
     * @param personal
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public UserPersonalInfo getUserPersonal(User user) throws Exception {
        UserPersonalInfo x = personalMapper.getUserpersonal("510922199107203210");
        return x;
    }

}
