package com.siping.system.mapper;

import java.util.List;
import java.util.Map;

import com.siping.problem.bean.UserProblem;
import com.siping.system.bean.KnowledgeType;

public interface KnowledgeTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(KnowledgeType record);

    int insertSelective(KnowledgeType record);

    KnowledgeType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(KnowledgeType record);

    int updateByPrimaryKey(KnowledgeType record);
    
    List<KnowledgeType> getAll();
	
	List<KnowledgeType> get(Map<String, Object> par);
	
	void deleteByIds(List<Integer> ids);
	
	Long getCount(Map<?, ?> map);
	
	List<KnowledgeType> getByPage(Map<?, ?> map);
}