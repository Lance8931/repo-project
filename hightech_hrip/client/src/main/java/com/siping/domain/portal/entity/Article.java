package com.siping.domain.portal.entity;

import java.io.Serializable;
import java.math.BigInteger;

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
     * 消息公告类型id
     */
    private BigInteger msgTypeId;

    /**
     * 是否启用，0不启用，1启用
     */
    private Integer enabled;

    /**
     * 发布时间
     */
    private String publishTime;

    /**
     * 内容详情
     */
    private String content;

    /**
     * 消息类型
     */
    private MsgType msgType;
    /**
     * 图片路径
     */
    private String picPath;
    /**
     * 显示位置
     */
    private String displayPosition;

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getDisplayPosition() {
        return displayPosition;
    }

    public void setDisplayPosition(String displayPosition) {
        this.displayPosition = displayPosition;
    }

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

    public BigInteger getMsgTypeId() {
        return msgTypeId;
    }

    public void setMsgTypeId(BigInteger msgTypeId) {
        this.msgTypeId = msgTypeId;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public MsgType getMsgType() {
        return msgType;
    }

    public void setMsgType(MsgType msgType) {
        this.msgType = msgType;
    }
}
