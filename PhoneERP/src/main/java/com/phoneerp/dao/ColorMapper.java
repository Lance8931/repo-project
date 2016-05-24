package com.phoneerp.dao;

import java.util.List;
import java.util.Map;

import com.phoneerp.bean.Color;

public interface ColorMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Color record);

	int insertSelective(Color record);

	Color selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Color record);

	int updateByPrimaryKey(Color record);

	List<Color> getList(Map<?, ?> map);
}