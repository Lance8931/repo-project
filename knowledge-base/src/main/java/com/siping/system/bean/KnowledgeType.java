package com.siping.system.bean;

public class KnowledgeType {
	private Integer id;

	private String name;

	private Integer knowledgeType;

	private String addTime;

	private Integer addBy;

	private String updateTime;

	private Integer updateBy;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Integer getKnowledgeType() {
		return knowledgeType;
	}

	public void setKnowledgeType(Integer knowledgeType) {
		this.knowledgeType = knowledgeType;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public Integer getAddBy() {
		return addBy;
	}

	public void setAddBy(Integer addBy) {
		this.addBy = addBy;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}
}