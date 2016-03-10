package com.siping.system.mapper;

import java.util.List;
import java.util.Map;

import com.siping.system.bean.SysUser;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
    
    List<SysUser> getAll();
	/**
	 *  验证用户登录和获取用户信息
	 * @param par
	 * @return
	 */
	List<SysUser> get(Map<String, Object> par)throws Exception;
	
	void deleteByIds(List<Integer> ids);
	
	Long getCount(Map<?, ?> map);
	/**
	 * 分页查询
	 * @param map
	 * @return
	 */
	List<SysUser> getByPage(Map<?, ?> map);
}