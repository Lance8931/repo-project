package com.phoneerp.dao;

import java.util.Map;

import com.phoneerp.bean.Phone;

public interface PhoneMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Phone record);

	int insertSelective(Phone record);

	Phone selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Phone record);

	int updateByPrimaryKey(Phone record);

	Integer getCount(Map<?, ?> map);
}