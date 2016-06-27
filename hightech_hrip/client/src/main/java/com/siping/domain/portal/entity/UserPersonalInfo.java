package com.siping.domain.portal.entity;

import java.io.Serializable;

import com.siping.domain.common.Common;

public class UserPersonalInfo extends Common implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -1303643984951724364L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 国籍
     */
    private String nationality;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 外文名字
     */
    private String foreignName;

    /**
     * 出生地
     */
    private String birthplace;

    /**
     * 出生日期
     */
    private String birthday;

    /**
     * 所在省
     */
    private Integer province;

    /**
     * 所在市
     */
    private Integer city;

    /**
     * 所在区
     */
    private Integer county;

    /**
     * 所在街道详细地址
     */
    private String address;

    /**
     * 性别，0女，1男
     */
    private Boolean sex;

    /**
     * 民族
     */
    private String nation;

    /**
     * 政治面貌
     */
    private String politicsStatus;

    /**
     * 婚姻状况
     */
    private String maritalStatus;

    /**
     * 办公电话
     */
    private String telephone;

    /**
     * 手机
     */
    private String cellphone;

    /**
     * 传真
     */
    private String fax;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 个人网址/博客
     */
    private String website;

    /**
     * 参加工作年份
     */
    private Integer startWorkYear;

    /**
     * 户口所在城市
     */
    private Integer residentCity;

    private Area provinceArea;

    private Area cityArea;

    private Area countyArea;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality == null ? null : nationality.trim();
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

    public String getForeignName() {
        return foreignName;
    }

    public void setForeignName(String foreignName) {
        this.foreignName = foreignName == null ? null : foreignName.trim();
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace == null ? null : birthplace.trim();
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

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone == null ? null : cellphone.trim();
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

    public Integer getStartWorkYear() {
        return startWorkYear;
    }

    public void setStartWorkYear(Integer startWorkYear) {
        this.startWorkYear = startWorkYear;
    }

    public Integer getResidentCity() {
        return residentCity;
    }

    public void setResidentCity(Integer residentCity) {
        this.residentCity = residentCity;
    }

    public Area getProvinceArea() {
        return provinceArea;
    }

    public void setProvinceArea(Area provinceArea) {
        this.provinceArea = provinceArea;
    }

    public Area getCityArea() {
        return cityArea;
    }

    public void setCityArea(Area cityArea) {
        this.cityArea = cityArea;
    }

    public Area getCountyArea() {
        return countyArea;
    }

    public void setCountyArea(Area countyArea) {
        this.countyArea = countyArea;
    }

}
