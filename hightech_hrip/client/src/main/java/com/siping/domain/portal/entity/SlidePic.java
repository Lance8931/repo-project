package com.siping.domain.portal.entity;

import java.io.Serializable;

import com.siping.domain.common.Common;

/**
 * 
 * @author yangxu
 *
 */
public class SlidePic extends Common implements Serializable {
    private static final long serialVersionUID = 6698998612421845292L;
    private String picPath;
    private String url;
    private String hoverTips;
    private Integer orderNo;
    private Byte enabled;
    public String getPicPath() {
        return picPath;
    }
    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public Integer getOrderNo() {
        return orderNo;
    }
    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }
    public String getHoverTips() {
        return hoverTips;
    }
    public void setHoverTips(String hoverTips) {
        this.hoverTips = hoverTips;
    }
    public Byte getEnabled() {
        return enabled;
    }
    public void setEnabled(Byte enabled) {
        this.enabled = enabled;
    }
    
    
}
