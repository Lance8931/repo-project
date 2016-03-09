package com.user.mapper;

import java.util.List;

import org.apache.ibatis.session.ResultHandler;

import com.user.bean.Article;
import com.user.bean.User;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年3月7日下午1:00:18
 * @version 1.0
 */
public interface UserMapper {
	
	public User selectUserByID(int id);
	
	public List<User> selectUsers(String userName);
	
	public void addUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(int id);
	
	public List<Article> getUserArticles(int id);
	
	public List<User> selectUsersByHandler(String userName,MyResultHandler resultHandler);
}
