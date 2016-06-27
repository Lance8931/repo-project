package com.siping.domain.portal.entity;

import java.io.Serializable;

import com.siping.domain.common.Common;

public class UserOrgInfo extends Common implements Serializable {

    private static final long serialVersionUID = -8282527715736134321L;

    private String username; // 用户名

    private String orgCode; // 组织机构代码

    private String registeredNo; // 工商注册号

    private String licensePic; // 营业执照图片地址

    private String orgName; // 企业名称

    private Integer orgTypeId; // 企业类型

    private String mainIndustry; // 主营行业

    private String secondaryIndustry; // 次营行业

    private Integer employees; // 雇员人数，公司规模

    private Integer province; // 企业所属省
    private String provinceName;

    private Integer city; // 市
    private String cityName;

    private Integer county; // 区
    private String countyName;

    private String street; // 企业注册街道地址

    private String orgProfile; // 企业简介

    private String logoPic; // 企业logo地址

    private String contacts; // 联系人

    private String telephone; // 联系电话
    
    private String cellphone; // 手机号码

    private String fax; // 传真

    private String email; // 邮箱

    private String postcode; // 邮编

    private String address; // 办公地点

    private String website; // 网址

    private String  hrContacts; // 招聘联系人

    private String  hrTelephone; // 招聘联电话

    private String  hrEmail; // 招聘联系邮箱

    private String  hrCellphone; // 招聘联系手机号


    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getRegisteredNo() {
        return registeredNo;
    }

    public void setRegisteredNo(String registeredNo) {
        this.registeredNo = registeredNo;
    }

    public String getLicensePic() {
        return licensePic;
    }

    public void setLicensePic(String licensePic) {
        this.licensePic = licensePic;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getOrgTypeId() {
        return orgTypeId;
    }

    public void setOrgTypeId(Integer orgTypeId) {
        this.orgTypeId = orgTypeId;
    }

    public String getMainIndustry() {
        return mainIndustry;
    }

    public void setMainIndustry(String mainIndustry) {
        this.mainIndustry = mainIndustry;
    }

    public String getSecondaryIndustry() {
        return secondaryIndustry;
    }

    public void setSecondaryIndustry(String secondaryIndustry) {
        this.secondaryIndustry = secondaryIndustry;
    }

    public Integer getEmployees() {
        return employees;
    }

    public void setEmployees(Integer employees) {
        this.employees = employees;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getCounty() {
        return county;
    }

    public void setCounty(Integer county) {
        this.county = county;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getOrgProfile() {
        return orgProfile;
    }

    public void setOrgProfile(String orgProfile) {
        this.orgProfile = orgProfile;
    }

    public String getLogoPic() {
        return logoPic;
    }

    public void setLogoPic(String logoPic) {
        this.logoPic = logoPic;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getHrContacts() {
        return hrContacts;
    }

    public void setHrContacts(String hrContacts) {
        this.hrContacts = hrContacts;
    }

    public String getHrTelephone() {
        return hrTelephone;
    }

    public void setHrTelephone(String hrTelephone) {
        this.hrTelephone = hrTelephone;
    }

    public String getHrEmail() {
        return hrEmail;
    }

    public void setHrEmail(String hrEmail) {
        this.hrEmail = hrEmail;
    }

    public String getHrCellphone() {
        return hrCellphone;
    }

    public void setHrCellphone(String hrCellphone) {
        this.hrCellphone = hrCellphone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
}
