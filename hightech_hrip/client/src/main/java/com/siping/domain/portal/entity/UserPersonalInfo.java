package com.siping.domain.portal.entity;

import java.io.Serializable;

import com.siping.domain.common.Common;

public class UserPersonalInfo extends Common implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -1303643984951724364L;

    private String idCode; // 身份证号

    private String psdQuestion; // 找回密码的问题

    private String psdAnswer; // 问题答案

    private String nickname; // 昵称

    private String realname; // 真实姓名

    private String birthday; // 出生年月日

    private Integer province; // 所在省

    private Integer city; // 市

    private Integer county; // 区

    private String address; // 街道详情

    private Boolean sex; // 性别

    private String nation; // 民族

    private String politicsStatus; // 政治面貌

    private String maritalStatus; // 婚姻情况

    private String telephone; // 电话

    private String fax; // 传真

    private String email; // 邮箱

    private String website; // 博客

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode == null ? null : idCode.trim();
    }

    public String getPsdQuestion() {
        return psdQuestion;
    }

    public void setPsdQuestion(String psdQuestion) {
        this.psdQuestion = psdQuestion == null ? null : psdQuestion.trim();
    }

    public String getPsdAnswer() {
        return psdAnswer;
    }

    public void setPsdAnswer(String psdAnswer) {
        this.psdAnswer = psdAnswer == null ? null : psdAnswer.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getCounty() {
        return county;
    }

    public void setCounty(Integer county) {
        this.county = county;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getPoliticsStatus() {
        return politicsStatus;
    }

    public void setPoliticsStatus(String politicsStatus) {
        this.politicsStatus = politicsStatus == null ? null : politicsStatus.trim();
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus == null ? null : maritalStatus.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }
}
