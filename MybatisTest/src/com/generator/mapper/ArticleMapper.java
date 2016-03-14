package com.generator.mapper;

import com.generator.bean.Article;

public interface ArticleMapper {
    /**
    article
     */
    int deleteByPrimaryKey(Integer id);

    /**
    article
     */
    int insert(Article record);

    /**
    article
     */
    int insertSelective(Article record);

    /**
    article
     */
    Article selectByPrimaryKey(Integer id);

    /**
    article
     */
    int updateByPrimaryKeySelective(Article record);

    /**
    article
     */
    int updateByPrimaryKeyWithBLOBs(Article record);

    /**
    article
     */
    int updateByPrimaryKey(Article record);
}