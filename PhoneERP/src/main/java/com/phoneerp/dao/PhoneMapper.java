package com.phoneerp.dao;

import java.util.List;
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

	List<Phone> getList(Map<?, ?> map);

	int createTable(String tableName);

	int insertBatch(Map<String, Object> map);

	int insertDatasFromTemp(String tableName);

	int insertPurDatas(String tableName);

	int dropTable(String tableName);

	Integer getCountByImeiNo(String imeiNo);
}