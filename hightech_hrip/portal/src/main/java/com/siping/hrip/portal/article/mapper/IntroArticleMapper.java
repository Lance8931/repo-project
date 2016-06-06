package com.siping.hrip.portal.article.mapper;

import java.util.List;
import java.util.Map;

import com.siping.domain.portal.entity.IntroArticle;

public interface IntroArticleMapper {

    IntroArticle selectBySubTitle(String subTitle);

    int updateByPrimaryKeySelective(IntroArticle record);

    List<IntroArticle> getList(Map<?, ?> map);
}
