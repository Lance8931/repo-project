package com.user.mapper;

import java.util.List;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import com.user.bean.User;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年3月8日下午5:12:46
 * @version 1.0
 */
public class MyResultHandler implements ResultHandler {

	@Override
	public void handleResult(ResultContext arg0) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) arg0.getResultObject();
		for (User user : users) {
			user.setUserAge(user.getUserAge()+1);
		}
	}

}
