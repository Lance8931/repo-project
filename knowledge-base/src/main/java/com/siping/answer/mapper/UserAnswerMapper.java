package com.siping.answer.mapper;

import java.util.List;
import java.util.Map;

import com.siping.answer.bean.UserAnswer;

public interface UserAnswerMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(UserAnswer record);

	int insertSelective(UserAnswer record);

	UserAnswer selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(UserAnswer record);

	int updateByPrimaryKey(UserAnswer record);

	List<UserAnswer> getAll();

	List<UserAnswer> get(Map<String, Object> par);

	void deleteByIds(List<Integer> ids);

	Long getCount(Map<?, ?> map);

	List<UserAnswer> getByPage(Map<?, ?> map);

	/**
	 * 根据问题Ids删除答案
	 * 
	 * @param ids
	 *
	 * @date 2016年3月3日上午11:30:55
	 * @author siping-L.J.H
	 */
	void deleteByProblemIds(List<Integer> ids);
}