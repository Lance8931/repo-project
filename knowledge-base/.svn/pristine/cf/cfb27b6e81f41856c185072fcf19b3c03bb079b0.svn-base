package com.siping.problem.mapper;

import java.util.List;
import java.util.Map;

import com.siping.problem.bean.ProblemInfo;
import com.siping.problem.bean.UserProblem;

public interface UserProblemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserProblem record);

    int insertSelective(UserProblem record);

    UserProblem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserProblem record);

    int updateByPrimaryKey(UserProblem record);
    
    List<UserProblem> getAll();
	
	List<UserProblem> get(Map<String, Object> par);
	
	void deleteByIds(List<Integer> ids);
	
	Long getCount(Map<?, ?> map);

	List<UserProblem> getByPage(Map<?, ?> map);
	
	/**
	 * 分页获取问题信息
	 * @param map
	 * @return
	 *
	 * @date 2016年3月3日上午11:42:06
	 * @author siping-L.J.H
	 */
	List<ProblemInfo> getProblemInfoListByPage(Map<?, ?> map);
}