package com.siping.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Material {
    private Integer id;

    private String materialNo;

    private String materialName;

    private String foreignName;

    private Integer materialType;

    private String brand;

    private String specificationsModel;

    private String season;

    private Boolean isPurchase;

    private Boolean isSell;

    private Boolean isInventory;

    private Integer unitId;

    private String barcode;

    private String shops;

    private Boolean isBatch;

    private Integer expirationDate;

    private Integer partnerId;

    private Integer minOrder;

    private Integer minInventory;

    private Integer maxInventory;

    private Boolean isEnable;

    private String description;

    private Boolean isDelete;

    private String transactionId;

    private Date createDate;

    private Integer createBy;

    private Date updateDate;

    private Integer updateBy;

    private Integer declareUnit;

    private Integer legalUnit;

    private Float legalTranslationQuantity;

    private Integer entryUnit;

    private Float entryTranslationQuantity;

    private String manufacturer;

    private String provenance;

    private String ebec;

    private String eben;

    private String hscode;

    private String postTaxNumber;

    private String custom1;

    private String custom2;

    private String custom3;

    private String itemNo;

    private BigDecimal weight;

    private BigDecimal postTaxRate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaterialNo() {
        return materialNo;
    }

    public void setMaterialNo(String materialNo) {
        this.materialNo = materialNo == null ? null : materialNo.trim();
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName == null ? null : materialName.trim();
    }

    public String getForeignName() {
        return foreignName;
    }

    public void setForeignName(String foreignName) {
        this.foreignName = foreignName == null ? null : foreignName.trim();
    }

    public Integer getMaterialType() {
        return materialType;
    }

    public void setMaterialType(Integer materialType) {
        this.materialType = materialType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getSpecificationsModel() {
        return specificationsModel;
    }

    public void setSpecificationsModel(String specificationsModel) {
        this.specificationsModel = specificationsModel == null ? null : specificationsModel.trim();
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season == null ? null : season.trim();
    }

    public Boolean getIsPurchase() {
        return isPurchase;
    }

    public void setIsPurchase(Boolean isPurchase) {
        this.isPurchase = isPurchase;
    }

    public Boolean getIsSell() {
        return isSell;
    }

    public void setIsSell(Boolean isSell) {
        this.isSell = isSell;
    }

    public Boolean getIsInventory() {
        return isInventory;
    }

    public void setIsInventory(Boolean isInventory) {
        this.isInventory = isInventory;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode == null ? null : barcode.trim();
    }

    public String getShops() {
        return shops;
    }

    public void setShops(String shops) {
        this.shops = shops == null ? null : shops.trim();
    }

    public Boolean getIsBatch() {
        return isBatch;
    }

    public void setIsBatch(Boolean isBatch) {
        this.isBatch = isBatch;
    }

    public Integer getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Integer expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    public Integer getMinOrder() {
        return minOrder;
    }

    public void setMinOrder(Integer minOrder) {
        this.minOrder = minOrder;
    }

    public Integer getMinInventory() {
        return minInventory;
    }

    public void setMinInventory(Integer minInventory) {
        this.minInventory = minInventory;
    }

    public Integer getMaxInventory() {
        return maxInventory;
    }

    public void setMaxInventory(Integer maxInventory) {
        this.maxInventory = maxInventory;
    }

    public Boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId == null ? null : transactionId.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getDeclareUnit() {
        return declareUnit;
    }

    public void setDeclareUnit(Integer declareUnit) {
        this.declareUnit = declareUnit;
    }

    public Integer getLegalUnit() {
        return legalUnit;
    }

    public void setLegalUnit(Integer legalUnit) {
        this.legalUnit = legalUnit;
    }

    public Float getLegalTranslationQuantity() {
        return legalTranslationQuantity;
    }

    public void setLegalTranslationQuantity(Float legalTranslationQuantity) {
        this.legalTranslationQuantity = legalTranslationQuantity;
    }

    public Integer getEntryUnit() {
        return entryUnit;
    }

    public void setEntryUnit(Integer entryUnit) {
        this.entryUnit = entryUnit;
    }

    public Float getEntryTranslationQuantity() {
        return entryTranslationQuantity;
    }

    public void setEntryTranslationQuantity(Float entryTranslationQuantity) {
        this.entryTranslationQuantity = entryTranslationQuantity;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public String getProvenance() {
        return provenance;
    }

    public void setProvenance(String provenance) {
        this.provenance = provenance == null ? null : provenance.trim();
    }

    public String getEbec() {
        return ebec;
    }

    public void setEbec(String ebec) {
        this.ebec = ebec == null ? null : ebec.trim();
    }

    public String getEben() {
        return eben;
    }

    public void setEben(String eben) {
        this.eben = eben == null ? null : eben.trim();
    }

    public String getHscode() {
        return hscode;
    }

    public void setHscode(String hscode) {
        this.hscode = hscode == null ? null : hscode.trim();
    }

    public String getPostTaxNumber() {
        return postTaxNumber;
    }

    public void setPostTaxNumber(String postTaxNumber) {
        this.postTaxNumber = postTaxNumber == null ? null : postTaxNumber.trim();
    }

    public String getCustom1() {
        return custom1;
    }

    public void setCustom1(String custom1) {
        this.custom1 = custom1 == null ? null : custom1.trim();
    }

    public String getCustom2() {
        return custom2;
    }

    public void setCustom2(String custom2) {
        this.custom2 = custom2 == null ? null : custom2.trim();
    }

    public String getCustom3() {
        return custom3;
    }

    public void setCustom3(String custom3) {
        this.custom3 = custom3 == null ? null : custom3.trim();
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo == null ? null : itemNo.trim();
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getPostTaxRate() {
        return postTaxRate;
    }

    public void setPostTaxRate(BigDecimal postTaxRate) {
        this.postTaxRate = postTaxRate;
    }
}