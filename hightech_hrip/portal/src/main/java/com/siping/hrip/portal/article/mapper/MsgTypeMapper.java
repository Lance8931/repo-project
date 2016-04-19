package com.siping.hrip.portal.article.mapper;

import java.util.List;
import java.util.Map;

import com.siping.domain.portal.entity.MsgType;

public interface MsgTypeMapper {
	int deleteByPrimaryKey(Integer id);

	int insertSelective(MsgType record);

	MsgType selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(MsgType record);

	List<MsgType> getByPage(Map<?, ?> map);

	Long getCount(Map<?, ?> map);

}