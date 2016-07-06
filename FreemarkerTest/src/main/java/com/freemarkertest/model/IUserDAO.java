package com.freemarkertest.model;

import java.util.List;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年4月11日上午10:35:49
 * @version 1.0
 */
public interface IUserDAO {

	public List<UserDo> findAllUser();
}
