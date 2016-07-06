package com.freemarkertest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freemarkertest.model.IUserDAO;
import com.freemarkertest.model.UserDo;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年4月11日上午10:36:38
 * @version 1.0
 */
@Service("userService")
public class UserService implements IUserService {

	@Autowired
	private IUserDAO userDAO;

	@Override
	public List<UserDo> findAllUser() {
		return userDAO.findAllUser();
	}

}
