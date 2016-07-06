package com.freemarkertest.service;

import java.util.List;

import com.freemarkertest.model.UserDo;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年4月11日上午10:37:12
 * @version 1.0
 */
public interface IUserService {
	public List<UserDo> findAllUser();
}
