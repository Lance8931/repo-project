package com.ssm.dao;

import java.util.List;
import java.util.Map;

import com.ssm.bean.User;

public interface UserMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	Integer getCountByProvince(String provinceName);

	Integer getCountByCity(String cityName);

	Integer getCountByArea(String areaName);

	void updateCity(String cityName);

	void updateArea(String areaName);

	List<User> getProvinceListByCity(String cityName);

	List<User> getCityListByArea(String areaName);

	void insertArea(Map<String, Object> map);

	void insertCity(Map<String, Object> map);

	void updateCityIsExist(Map<String, Object> map);

	void updateAreaIsExist(Map<String, Object> map);

	void insertArea1(Map<String, Object> map);

	void insertCity1(Map<String, Object> map);

	void insertProvince1(Map<String, Object> map);
}