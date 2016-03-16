package com.siping.system.mapper;

import java.util.List;
import java.util.Map;

import com.siping.system.bean.SysUser;
import com.siping.web.bean.PageRequest;

public interface SysUserMapper {
    /**
     * 根据ID删除用户信息
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);
    /**
     * 根据ID获取用户详情
     * @param id
     * @return
     */
    SysUser selectByPrimaryKey(Integer id);
    /**
     * 修改用户信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
    /**
     * 获取所有普通用户的信息分页查询
     * @return
     */
    List<SysUser> getAll(PageRequest pageRequest);
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
	List<SysUser> getByPage(Map<?, ?> map)throws Exception;
    /**
     * 获取各个状体用户总数
     * @param userType 用户状态 0管理员 1、普通用户2、待审核用户3、不通过
     * @return
     * @throws Exception
     */
    Integer getTotalUsers(int userType) throws Exception;
    /**
     * 验证新建用户账号是否被注册
     * @param su
     * @return
     * @throws Exception
     */
    Integer selectNewName(SysUser su)throws Exception;
}