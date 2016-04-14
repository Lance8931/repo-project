package com.siping.domain.portal.entity;

import java.io.Serializable;

import com.siping.domain.common.Common;

/**
 * @author zhangjing
 */
public class User extends Common implements Serializable {
    private static final long serialVersionUID = -8785958061377307192L;
    private String username; // 用户名
    private String pwdHash;
    private Integer pwdIterator;
    private String pwdSalt;
    private Integer userType; // 用户类型：1，平台管理员用户；2，平台普通用户；3，企业用户；4，普通用户（求职者）

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwdHash() {
        return pwdHash;
    }

    public void setPwdHash(String pwdHash) {
        this.pwdHash = pwdHash;
    }

    public Integer getPwdIterator() {
        return pwdIterator;
    }

    public void setPwdIterator(Integer pwdIterator) {
        this.pwdIterator = pwdIterator;
    }

    public String getPwdSalt() {
        return pwdSalt;
    }

    public void setPwdSalt(String pwdSalt) {
        this.pwdSalt = pwdSalt;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
}
