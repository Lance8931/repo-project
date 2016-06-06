package com.siping.hrip.portal.user.service.impl;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.stroma.framework.core.exception.BusinessProcessException;
import org.stroma.framework.core.util.DigestUtils;

import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.User;
import com.siping.hrip.portal.user.mapper.LoginMapper;
import com.siping.hrip.portal.user.service.LoginService;

/**
 * 用户登录
 * @author yangxu
 *
 */
@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    private LoginMapper loginMapper;
    
    public User get(BigInteger id) {
        
        return null;
    }

    /**
     * 登录
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public ResultMsg login(String username, String password, HttpServletRequest request) throws Exception {
        if(StringUtils.isEmpty(username))
            return new ResultMsg(false, "用户名不能为空");
        if(StringUtils.isEmpty(password))
            return new ResultMsg(false, "密码不能为空");
        User user = new User(); 
        HttpSession session = request.getSession();
        
        if("admin".equals(username)){
            if(checkAdminPwd(password)){
                user.setUsername(username);
            }else{
                return new ResultMsg(false, "登录密码错误");
            }
        }else{
            user = loginMapper.login(username);
            if((null == user) || (!user.getPwdHash().equalsIgnoreCase(
                    DigestUtils.calculatePasswordHashWithSha512(password, user.getPwdSalt(), user.getPwdIterator())))){
                return new ResultMsg(false, "账号或密码错误");
            }    
        }        
        session.setAttribute("loggeduser", user);
        return new ResultMsg(true, "登录成功");
    }
    
    /**
     * 重置密码
     * @param oldPwd
     * @param pwd
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = false, propagation = Propagation.REQUIRED)
    public ResultMsg resetPwd(String oldPwd, String pwd, HttpServletRequest request) throws Exception {
        if(StringUtils.isEmpty(oldPwd))
            return new ResultMsg(false, "原始密码不能为空");
        if(StringUtils.isEmpty(pwd))
            return new ResultMsg(false, "新密码不能为空");
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(null == user)
            return new ResultMsg(false, "请重新登陆");
        
        if("admin".equalsIgnoreCase(user.getUsername())){
            if(checkAdminPwd(oldPwd)){
                Properties prop = new Properties();
                String filePath;
                FileOutputStream fos = null;
                filePath = getResourcePath("i18n/identify.properties");
                String newPwdHash = DigestUtils.calculatePasswordHashWithSha512(pwd, "AR1SYc", 7);
                prop.setProperty("siping.i18n.sys.identify", newPwdHash);
                fos = new FileOutputStream(new File(filePath));    
                prop.store(fos, "siping.i18n.sys.identify");
                fos.close();    
            }else{
                return new ResultMsg(false, "原密码错误");
            }
        }else{
            String oldpwdHash = DigestUtils.calculatePasswordHashWithSha512(oldPwd, user.getPwdSalt(), user.getPwdIterator());
            String salt = RandomStringUtils.randomAlphanumeric(6);
            Integer iterator = RandomUtils.nextInt((10) + 1);
            String pwdHash = DigestUtils.calculatePasswordHashWithSha512(pwd, salt, iterator);
            if(oldpwdHash.equalsIgnoreCase(loginMapper.login(user.getUsername()).getPwdHash())){
                user.setPwdHash(pwdHash);
                user.setPwdSalt(salt);
                user.setPwdIterator(iterator);
                loginMapper.resetPwd(user);
            }else{
                return new ResultMsg(false, "原密码不正确");
            }    
        } 
        session.setAttribute("user", user);
        return new ResultMsg(true, "修改成功");
    }

    
    /**
     * admin账号密码校验
     * @param oldPwd
     * @return
     * @throws Exception
     */
    private Boolean checkAdminPwd(String pwd) throws Exception{
        Properties prop = new Properties();
        FileInputStream fis = null;
        String pwdHash = DigestUtils.calculatePasswordHashWithSha512(pwd, "AR1SYc", 7);
        String filePath = getResourcePath("i18n/identify.properties");
        fis = new FileInputStream(new File(filePath));
        prop.load(fis);
        fis.close();
        String adminPwd = prop.getProperty("siping.i18n.sys.identify");
        if(pwdHash.equals(adminPwd)){
            return true;
        }else{
            return false;
        }    
    }
    
    /**
     * 根据资源名称，计算当前资源的绝对路径.
     * @param _sResourceName : TcdApp.ini
     * @return 在服务器端的完整绝对物理路径
     * @throws Exception
     */
    private String getResourcePath(String _sResourceName) throws Exception {
        URL url = Thread.currentThread().getContextClassLoader().getResource(_sResourceName);
        if (url == null) {
            throw new BusinessProcessException("资源文件[" + _sResourceName + "]没有找到！");
        }
        // 匹配绝对路径
        String sAbsolutePath = null;
        try {
            sAbsolutePath = url.getFile();
            if (sAbsolutePath.indexOf("%") >= 0) {
                // 转换编码为GBK
                String sEncoding = System.getProperty("file.encoding", "GBK");
                sAbsolutePath = URLEncoder.encode(sAbsolutePath, sEncoding);
            }
        } catch (Exception ex) {
            throw new Exception("转换文件[" + url.getFile() + "]的编码失败！", ex);
        }
        return sAbsolutePath;
    }
}
