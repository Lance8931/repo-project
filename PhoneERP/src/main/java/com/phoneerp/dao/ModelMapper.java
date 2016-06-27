package com.phoneerp.dao;

import java.util.List;
import java.util.Map;

import com.phoneerp.bean.Model;

public interface ModelMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Model record);

	int insertSelective(Model record);

	Model selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Model record);

	int updateByPrimaryKey(Model record);

	List<Model> getList(Map<?, ?> map);

	Integer getCountByModelName(String modelName);
}