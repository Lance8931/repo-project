package com.ssm.service;

import com.ssm.bean.User;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年3月15日上午11:01:42
 * @version 1.0
 */
public interface UserService {
	public User getUserById(int userId);

	public int getCount(String temp, String tempID) throws Exception;

	public void insertData(String temp, String tempId) throws Exception;
}
