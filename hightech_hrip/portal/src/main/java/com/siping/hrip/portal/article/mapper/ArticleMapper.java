package com.siping.hrip.portal.article.mapper;

import java.util.List;
import java.util.Map;

import com.siping.domain.portal.entity.Article;

public interface ArticleMapper {
	int deleteByPrimaryKey(Long id);

	int insertSelective(Article record);

	Article selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Article record);

	List<Article> getByConditions(Map<?, ?> map);
	
	int deleteByPrimaryKey(Integer id);

}