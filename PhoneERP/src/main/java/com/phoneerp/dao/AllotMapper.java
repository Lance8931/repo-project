package com.phoneerp.dao;

import java.util.List;
import java.util.Map;

import com.phoneerp.bean.Allot;

public interface AllotMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Allot record);

	int insertSelective(Allot record);

	Allot selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Allot record);

	int updateByPrimaryKey(Allot record);

	List<Allot> getList(Map<?, ?> map);

	Integer getCount(Map<?, ?> map);
}