package com.rmi;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年4月1日下午1:53:52
 * @version 1.0
 */
public class MessageProviderImpl implements MessageProvider {

	public String queryForMessage(String name) {
		return "Hello, " + name;
	}

}
