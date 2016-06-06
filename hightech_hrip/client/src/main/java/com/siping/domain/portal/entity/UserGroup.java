package com.siping.domain.portal.entity;

import java.io.Serializable;

import com.siping.domain.common.Common;

public class UserGroup extends Common implements Serializable {
    private static final long serialVersionUID = -8770914249387222821L;
    private String username; // 用户ID
    private Integer groupId; // 组ID

    public String getUsername() {
        return username;
    }

    public void setUserId(String username) {
        this.username = username;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

}
