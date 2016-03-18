package com.siping.dao;

import java.util.Map;

import com.siping.bean.Material;

public interface MaterialMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Material record);

	int insertSelective(Material record);

	Material selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Material record);

	int updateByPrimaryKey(Material record);

	void createTable(String tableName);

	int insertBatch(Map<String, Object> map);
}