package com.siping.hrip.portal.user.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.stroma.framework.core.util.DigestUtils;

import com.siping.domain.common.DataValidation;
import com.siping.domain.portal.entity.User;
import com.siping.domain.portal.entity.UserOrgInfo;
import com.siping.hrip.portal.user.mapper.UserOrgInfoMapper;
import com.siping.hrip.portal.user.service.UserOrgService;

@Service
public class UserOrgServiceImpl implements UserOrgService {
    @Autowired
    private UserOrgInfoMapper orgmapper;
    @Value("${site.imgs.path}")
    private String filePath;

    DataValidation dataValidation;// 数据验证工具类

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = null;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public String addOrg(User user, UserOrgInfo org, HttpServletRequest request, @RequestParam("uploadImage") List<MultipartFile> files) throws Exception {

        date = new Date();
        user.setPwdHash("zxcv");
        user.setEnabled(1);
        user.setUsername("11111111".replaceAll(" ", ""));
        user.setPwdIterator(RandomUtils.nextInt(10) + 1);
        user.setPwdSalt(RandomStringUtils.randomAlphanumeric(6));
        user.setPwdHash(DigestUtils.calculatePasswordHashWithSha512(user.getPwdHash(), user.getPwdSalt(), user.getPwdIterator()));
        user.setCreateDate(sdf.format(date));

        if (orgmapper.selectUserName(user) > 0) {
            return "对不起，该企业已经注册，请直接登录！";
        }

        org.setOrgCode(user.getUsername());
        org.setPsdAnswer("haha");
        org.setCreateDate(sdf.format(date));
        /* 存营业执照 */
        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);
            String fileName = String.valueOf(System.currentTimeMillis()) + i;
            String imgName = file.getOriginalFilename();
            String fileSuffix = imgName.substring(imgName.lastIndexOf(".")).toLowerCase();
            String imgFilePath = filePath + fileName + fileSuffix;
            file.transferTo(new File(imgFilePath));

            org.setLicensePic(fileName + fileSuffix);
        }

        orgmapper.addUser(user);
        orgmapper.addOrg(org);
        return "注册成功！";
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public String updateOrg(User user, UserOrgInfo org) throws Exception {
        date = new Date();

        org.setUpdateDate(sdf.format(date));
        org.setOrgCode("0000000000");

        orgmapper.updateOrg(org);
        return "修改成功！";
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public String updatePwd(User user, UserOrgInfo org) throws Exception {
        date = new Date();
        user.setUsername("0000000000");
        user.setPwdHash("000000");
        user.setPwdIterator(RandomUtils.nextInt(10) + 1);
        user.setPwdSalt(RandomStringUtils.randomAlphanumeric(6));
        user.setPwdHash(DigestUtils.calculatePasswordHashWithSha512(user.getPwdHash(), user.getPwdSalt(), user.getPwdIterator()));
        user.setUpdateDate(sdf.format(date));

        org.setOrgCode("0000000000");
        org.setPsdAnswer("haha");
        if (orgmapper.verifyAnswer(org) == 0) {
            return "问题答案错误！";
        }
        orgmapper.updateUser(user);
        return "修改成功！";
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public UserOrgInfo getUserOrg(UserOrgInfo org) throws Exception {
        org.setOrgCode("0000000000");
        return orgmapper.selectOrg(org);
    }

}
