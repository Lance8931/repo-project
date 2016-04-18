package com.siping.domain.portal.entity;

import java.io.Serializable;

import com.siping.domain.common.Common;

public class UserOrgInfo extends Common implements Serializable {
    private static final long serialVersionUID = -8282527715736134321L;

    private String orgCode; // 组织机构代码

    private String psdQuestion; // 找回密码问题

    private String psdAnswer; // 问题答案

    private String registeredNo; // 工商注册号

    private String licensePic; // 营业执照图片地址

    private String orgName; // 企业名称

    private Boolean isHightech; // 是否高新技术企业

    private Integer orgTypeId; // 企业类型

    private String industry; // 主营行业

    private Double turnover; // 营业额

    private Integer employees; // 雇员人数

    private String legalPerson; // 法定代表人

    private String foundDate; // 企业成立时间

    private Integer province; // 企业所属省

    private Integer city; // 市

    private Integer county; // 区

    private String street; // 企业注册地址

    private String orgProfile; // 企业简介

    private String product; // 产品介绍

    private String businessScope; // 业务范围

    private String contacts; // 联系人

    private String telephone; // 联系电话

    private String fax; // 传真

    private String email; // 邮箱

    private String postcode; // 邮编

    private String address; // 办公地点

    private String website; // 网址

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
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

    public String getRegisteredNo() {
        return registeredNo;
    }

    public void setRegisteredNo(String registeredNo) {
        this.registeredNo = registeredNo == null ? null : registeredNo.trim();
    }

    public String getLicensePic() {
        return licensePic;
    }

    public void setLicensePic(String licensePic) {
        this.licensePic = licensePic == null ? null : licensePic.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public Boolean getIsHightech() {
        return isHightech;
    }

    public void setIsHightech(Boolean isHightech) {
        this.isHightech = isHightech;
    }

    public Integer getOrgTypeId() {
        return orgTypeId;
    }

    public void setOrgTypeId(Integer orgTypeId) {
        this.orgTypeId = orgTypeId;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public Double getTurnover() {
        return turnover;
    }

    public void setTurnover(Double turnover) {
        this.turnover = turnover;
    }

    public Integer getEmployees() {
        return employees;
    }

    public void setEmployees(Integer employees) {
        this.employees = employees;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson == null ? null : legalPerson.trim();
    }

    public String getFoundDate() {
        return foundDate;
    }

    public void setFoundDate(String foundDate) {
        this.foundDate = foundDate;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street == null ? null : street.trim();
    }

    public String getOrgProfile() {
        return orgProfile;
    }

    public void setOrgProfile(String orgProfile) {
        this.orgProfile = orgProfile == null ? null : orgProfile.trim();
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product == null ? null : product.trim();
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope == null ? null : businessScope.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
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

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }
}
