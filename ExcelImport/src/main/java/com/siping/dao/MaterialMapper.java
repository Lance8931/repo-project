package com.siping.dao;

import java.util.List;
import java.util.Map;

import com.siping.bean.Material;
import com.siping.bean.MaterialImportBean;
import com.siping.bean.ResultBean;

public interface MaterialMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Material record);

	int insertSelective(Material record);

	Material selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Material record);

	int updateByPrimaryKey(Material record);

	/**
	 * 创建表
	 * 
	 * @param tableName
	 * @return
	 *
	 * @date 2016年3月22日上午11:53:30
	 * @author siping-L.J.H
	 * @remark 当传入的参数为单个时，xml中需要使用 _parameter代替传入的参数名称。
	 *         如果需要在xml中使用原本的参数名称，则需要在使用如下格式： int
	 *         createTable(@Param("tableName") tableName)
	 */
	int createTable(String tableName);

	/**
	 * 删除表
	 * 
	 * @param tableName
	 * @return
	 *
	 * @date 2016年3月22日上午11:58:30
	 * @author siping-L.J.H
	 */
	int dropTable(String tableName);

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

	List<String> getTypeList();

	List<String> getUnitList();

	Integer getUnitId(String unitName);

	int insertBatchThree(List<Material> list);

	List<ResultBean> getTypes();

	List<ResultBean> getUnits();
}