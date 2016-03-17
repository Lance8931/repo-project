package com.ssm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.bean.User;
import com.ssm.dao.UserMapper;
import com.ssm.service.IUserService;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年3月15日上午11:01:58
 * @version 1.0
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource
	private UserMapper userMapper;

	public User getUserById(int userId) {
		return this.userMapper.selectByPrimaryKey(userId);
	}
}
