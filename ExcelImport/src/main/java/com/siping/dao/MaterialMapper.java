package com.siping.dao;

import java.util.List;
import java.util.Map;

import com.siping.bean.Material;
import com.siping.bean.MaterialImportBean;

public interface MaterialMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Material record);

	int insertSelective(Material record);

	Material selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Material record);

	int updateByPrimaryKey(Material record);

	int createTable(String tableName);

	int insertBatch(Map<String, Object> map);

	List<MaterialImportBean> getListByPage(Map<String, Object> map);

	int getTotal(Map<String, Object> map);

	/**
	 * 插入正式表数据
	 * 
	 * @param map
	 * @return
	 *
	 * @date 2016年3月21日下午5:11:41
	 * @author siping-L.J.H
	 */
	int insertBatchTwo(Map<String, Object> map);

	Integer getTypeId(String typeName);

	Integer getUnitId(String unitName);
}