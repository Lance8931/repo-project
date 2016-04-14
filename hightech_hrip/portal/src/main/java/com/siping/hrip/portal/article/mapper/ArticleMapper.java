package com.siping.hrip.portal.article.mapper;

import java.util.List;
import java.util.Map;

import com.siping.domain.portal.entity.Article;

public interface ArticleMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Article record);

	int insertSelective(Article record);

	Article selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Article record);

	int updateByPrimaryKeyWithBLOBs(Article record);

	int updateByPrimaryKey(Article record);

	List<Article> getList(Map<?, ?> map);
}