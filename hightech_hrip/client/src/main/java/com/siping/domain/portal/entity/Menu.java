package com.siping.domain.portal.entity;

import java.io.Serializable;

import com.siping.domain.common.Common;

/**
 * @author yangxu
 */
public class Menu extends Common implements Serializable {
    private static final long serialVersionUID = -4018575362137819279L;
    private String menuName;
    private String menuUrl;
    private Integer orderNo;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }
}
