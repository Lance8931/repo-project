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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.stroma.framework.core.exception.BusinessProcessException;
import org.stroma.framework.core.util.DigestUtils;

import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.User;
import com.siping.domain.portal.entity.UserLoginRequest;
import com.siping.hrip.portal.user.mapper.LoginMapper;
import com.siping.hrip.portal.user.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    private LoginMapper loginMapper;

    
    public User get(BigInteger id) {
        return loginMapper.get(id);
    }
    /**
     * 用户登录
     * @param userLoginRequest
     * @param request
     * @return
     * @throws Exception
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public ResultMsg login(UserLoginRequest userLoginRequest,HttpServletRequest request) throws Exception {
//        if(!StringUtils.hasText(userLoginRequest.getUsername()))
//            throw new BusinessProcessException("账号为空！");
//        if(!StringUtils.hasText(userLoginRequest.getPassword()))
//            throw new BusinessProcessException("密码为空！");
        
        User user = new User(); //用于登录过后将信息存入session，方便后续业务从中取信息 
        HttpSession session = request.getSession();
        
        if("admin".equals(userLoginRequest.getUsername())){
            //admin账号,读取properties文件中admin账号的信息
            String pwdHash = DigestUtils.calculatePasswordHashWithSha512(userLoginRequest.getPassword(), "AR1SYc", 7);
            String filePath = getResourcePath("i18n/identify.properties");
            FileInputStream in = new FileInputStream(new File(filePath));
            Properties prop = new Properties();
            prop.load(in);
            in.close();
            String pwd = prop.getProperty("siping.i18n.sys.identify");//文件中存入的密码
            if(pwdHash.equals(pwd)){
               user.setUsername("admin");
               user.setPwdHash(pwdHash);
               user.setPwdIterator(7);
               user.setPwdSalt("AR1SYc");
            }else{
                return new ResultMsg(false, "登录密码错误");
            }         
        }else{
            //普通账号     
            user = loginMapper.login(userLoginRequest);                 
            if(null == user)
                return new ResultMsg(false, "登录账号不存在");         
            String pwdHash = DigestUtils.calculatePasswordHashWithSha512(userLoginRequest.getPassword(), user.getPwdSalt(), user.getPwdIterator());
            if (!pwdHash.equalsIgnoreCase(user.getPwdHash()))
                return new ResultMsg(false, "登录密码错误");             
        }        
        session.setAttribute("user", user);  
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
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public ResultMsg resetPwd(String oldPwd, String pwd, HttpServletRequest request) throws Exception{
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        if(null == user)
            return new ResultMsg(false, "请重新登录");
        if(!"admin".equalsIgnoreCase(user.getUsername())){
            //非admin账号修改密码
            String pwdHash = DigestUtils.calculatePasswordHashWithSha512(oldPwd, user.getPwdSalt(), user.getPwdIterator());
            if(!user.getPwdHash().equalsIgnoreCase(pwdHash))
                return new ResultMsg(false, "原密码错误");
            String newPwdHash = DigestUtils.calculatePasswordHashWithSha512(pwd, user.getPwdSalt(), user.getPwdIterator());
            Integer isReset = loginMapper.resetPwd(user.getId(), user.getUsername().toString(), newPwdHash);
            if(isReset != 1)
                throw new BusinessProcessException("修改失败");                
        }else{
            //admin账号修改密码
            if(!checkAdminPwd(oldPwd))
                return new ResultMsg(false, "原密码错误");
            resetAdminPwd(oldPwd, pwd);
        } 
        return new ResultMsg(true, "修改成功");
    }
   
    /**
     * 重置admin账号密码
     * @param oldPwd
     * @param pwd
     * @return
     * @throws Exception
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    private Boolean resetAdminPwd(String oldPwd, String pwd) throws Exception {      
        Properties prop = new Properties();
        String filePath = getResourcePath("i18n/identify.properties");
        String newPwdHash = DigestUtils.calculatePasswordHashWithSha512(pwd, "AR1SYc", 7);
        prop.setProperty("siping.i18n.sys.identify", newPwdHash);
        FileOutputStream fos = new FileOutputStream(new File(filePath));    
        prop.store(fos, "siping.i18n.sys.identify");
        fos.close(); 
        return true;
}
    
    /**
     * admin账号密码校验
     * @param oldPwd
     * @return
     * @throws Exception
     */
    private Boolean checkAdminPwd(String oldPwd) throws Exception {
        Properties prop = new Properties();
        String pwdHash = DigestUtils.calculatePasswordHashWithSha512(oldPwd, "AR1SYc", 7);
        String filePath = getResourcePath("i18n/identify.properties");
        FileInputStream fis = new FileInputStream(new File(filePath));
        prop.load(fis);
        fis.close();
        String adminPwd = prop.getProperty("siping.i18n.sys.identify");
        if(!pwdHash.equals(adminPwd))
            return false;
        return true;
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
