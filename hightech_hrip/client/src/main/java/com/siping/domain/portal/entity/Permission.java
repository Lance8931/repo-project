package com.siping.domain.portal.entity;

import java.io.Serializable;

import com.siping.domain.common.Common;

public class Permission extends Common implements Serializable {
    private static final long serialVersionUID = -6709935093674546513L;

    private Integer groupId; // 组ID

    private Integer menuId; // 菜单ID

    private Boolean addible; // 增

    private Boolean editable; // 改

    private Boolean deletable; // 删

    private Boolean readable; // 读

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Boolean getAddible() {
        return addible;
    }

    public void setAddible(Boolean addible) {
        this.addible = addible;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public Boolean getDeletable() {
        return deletable;
    }

    public void setDeletable(Boolean deletable) {
        this.deletable = deletable;
    }

    public Boolean getReadable() {
        return readable;
    }

    public void setReadable(Boolean readable) {
        this.readable = readable;
    }

}
