package com.siping.domain.portal.entity;

import java.io.Serializable;

import com.siping.domain.common.Common;

/**
 * @author yangxu
 */
public class UserLoginRequest extends Common implements Serializable {

    private static final long serialVersionUID = 7030148862255256173L;
    private String username;
    private String password;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    

}
