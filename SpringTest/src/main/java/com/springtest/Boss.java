package com.springtest;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年5月24日上午11:14:42
 * @version 1.0
 */
public class Boss {
	@Resource
	private Car car;

	@Resource(name = "office")
	private Office office;

	@PostConstruct
	public void postConstruct1() {
		System.out.println("postConstruct1");
	}

	@PreDestroy
	public void preDestroy1() {
		System.out.println("preDestroy1");
	}

	@Override
	public String toString() {
		return "car:" + car + "\n" + "office:" + office;
	}

}
