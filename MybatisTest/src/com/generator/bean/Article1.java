package com.generator.bean;

import java.util.Date;

public class Article1 {
    /**
     * This field was generated by MyBatis Generator.
     * 自增主键
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * 标题
     *
     * @mbggenerated
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * 作者
     *
     * @mbggenerated
     */
    private String author;

    /**
     * This field was generated by MyBatis Generator.
     * 类型
     *
     * @mbggenerated
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * 是否启用，0不启用，1启用
     *
     * @mbggenerated
     */
    private Boolean enabled;

    /**
     * This field was generated by MyBatis Generator.
     * 是否已删除，0已删除，1未删除
     *
     * @mbggenerated
     */
    private Boolean isDelete;

    /**
     * This field was generated by MyBatis Generator.
     * 发布时间
     *
     * @mbggenerated
     */
    private Date publishTime;

    /**
     * This field was generated by MyBatis Generator.
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator.
     * 创建人
     *
     * @mbggenerated
     */
    private Integer createBy;

    /**
     * This field was generated by MyBatis Generator.
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateDate;

    /**
     * This field was generated by MyBatis Generator.
     * 更新人
     *
     * @mbggenerated
     */
    private Integer updateBy;

    /**
     * This field was generated by MyBatis Generator.
     * 内容详情
     *
     * @mbggenerated
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.id
     *
     * @return the value of article.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.id
     *
     * @param id the value for article.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.title
     *
     * @return the value of article.title
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.title
     *
     * @param title the value for article.title
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.author
     *
     * @return the value of article.author
     *
     * @mbggenerated
     */
    public String getAuthor() {
        return author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.author
     *
     * @param author the value for article.author
     *
     * @mbggenerated
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.type
     *
     * @return the value of article.type
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.type
     *
     * @param type the value for article.type
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.enabled
     *
     * @return the value of article.enabled
     *
     * @mbggenerated
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.enabled
     *
     * @param enabled the value for article.enabled
     *
     * @mbggenerated
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.is_delete
     *
     * @return the value of article.is_delete
     *
     * @mbggenerated
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.is_delete
     *
     * @param isDelete the value for article.is_delete
     *
     * @mbggenerated
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.publish_time
     *
     * @return the value of article.publish_time
     *
     * @mbggenerated
     */
    public Date getPublishTime() {
        return publishTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.publish_time
     *
     * @param publishTime the value for article.publish_time
     *
     * @mbggenerated
     */
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.create_date
     *
     * @return the value of article.create_date
     *
     * @mbggenerated
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.create_date
     *
     * @param createDate the value for article.create_date
     *
     * @mbggenerated
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.create_by
     *
     * @return the value of article.create_by
     *
     * @mbggenerated
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.create_by
     *
     * @param createBy the value for article.create_by
     *
     * @mbggenerated
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.update_date
     *
     * @return the value of article.update_date
     *
     * @mbggenerated
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.update_date
     *
     * @param updateDate the value for article.update_date
     *
     * @mbggenerated
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.update_by
     *
     * @return the value of article.update_by
     *
     * @mbggenerated
     */
    public Integer getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.update_by
     *
     * @param updateBy the value for article.update_by
     *
     * @mbggenerated
     */
    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column article.content
     *
     * @return the value of article.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column article.content
     *
     * @param content the value for article.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}