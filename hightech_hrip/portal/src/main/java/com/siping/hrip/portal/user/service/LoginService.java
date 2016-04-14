package com.siping.hrip.portal.user.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stroma.framework.core.exception.BusinessProcessException;
import org.stroma.framework.core.util.DigestUtils;


import org.stroma.framework.core.util.StringUtils;

import com.siping.domain.portal.entity.User;
import com.siping.domain.portal.entity.UserLoginRequest;
import com.siping.hrip.portal.user.mapper.LoginMapper;

@Service
public class LoginService {
    @Autowired
    private LoginMapper loginMapper;
    
    public User get(BigInteger id) {
        return loginMapper.get(id);
    }
    
    public User login(UserLoginRequest userLoginRequest){
        if(!StringUtils.hasText(userLoginRequest.getUsername()))
            throw new BusinessProcessException("账号为空！");
        if(!StringUtils.hasText(userLoginRequest.getPassword()))
            throw new BusinessProcessException("密码为空！");
        
        User user = null;     
        if("admin".equals(userLoginRequest.getUsername())){//admin账号,读取properties文件中admin账号的信息
            try {
                String pwdHash = DigestUtils.calculatePasswordHashWithSha512(userLoginRequest.getPassword(), "AR1SYc", 7);
                String filePath = getResourcePath("i18n/identify.properties");
                FileInputStream in = new FileInputStream(new File(filePath));
                Properties prop = new Properties();
                prop.load(in);
                in.close();
                String pwd = prop.getProperty("siping.i18n.sys.identify");
                if(pwdHash.equals(pwd)){
                   user.setUsername("admin");
                   user.setPwdHash(pwdHash);
                   user.setPwdIterator(7);
                   user.setPwdSalt("AR1SYc");
                   return user;
                }else{
                    throw new BusinessProcessException("登录密码错误！");
                }
            } catch (FileNotFoundException e) {
                throw new BusinessProcessException("identify.properties is not found!");
            } catch (IOException e) {
                throw new BusinessProcessException("IO Exception occured");
            } catch (Exception e) {
                e.printStackTrace();
                throw new BusinessProcessException("Exception occured");
            }
        }else{//普通账号     
            try{
                 user = loginMapper.login(userLoginRequest);         
            }catch(Exception e){
                e.printStackTrace();
                throw new BusinessProcessException("Exception occured");
            }
            
            if(null == user)
                throw new BusinessProcessException("账号不存在！");
            String pwdHash = DigestUtils.calculatePasswordHashWithSha512(userLoginRequest.getPassword(), user.getPwdSalt(), user.getPwdIterator());
            if (!pwdHash.equalsIgnoreCase(user.getPwdHash())) 
                throw new BusinessProcessException("登录密码错误！");
            return user;
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
