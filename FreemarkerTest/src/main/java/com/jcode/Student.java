package com.jcode;

//这个地方可以事先定义好需要的类   
import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = 3473802680051587346L;
	private String name;
	private String sex;
	private Integer age;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSex() {
		return this.sex;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getAge() {
		return this.age;
	}

}