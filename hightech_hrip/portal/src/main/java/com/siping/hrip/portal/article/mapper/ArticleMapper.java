package com.siping.hrip.portal.article.mapper;

import java.util.List;
import java.util.Map;

import com.siping.domain.portal.entity.Article;

public interface ArticleMapper {

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Article record);

    List<Article> getByConditions(Map<?, ?> map);

    Long getCount(Map<?, ?> map);

    List<Article> getByPage(Map<?, ?> map);

    void updateStatusBatch(Map<?, ?> map);

    List<Article> getListByPage(Map<?, ?> map);

    void updateDisplayPosition(Map<?, ?> map);
}
