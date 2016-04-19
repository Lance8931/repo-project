package com.siping.domain.portal.entity;

import java.io.Serializable;
import java.util.Date;

import com.siping.domain.common.Common;

public class Article extends Common implements Serializable {
    
    private static final long serialVersionUID = -4970330069799080198L;

    /**
     * 标题
     */
    private String title;

    /**
     * 作者
     */
    private String author;

    /**
     * 类型
     */
    private String type;

    /**
     * 是否启用，0不启用，1启用
     */
    private Boolean enabled;


    /**
     * 发布时间
     */
    private Date publishTime;

    /**
     * 内容详情
     */
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}