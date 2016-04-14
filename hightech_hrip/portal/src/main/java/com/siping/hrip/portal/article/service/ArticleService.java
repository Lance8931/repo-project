package com.siping.hrip.portal.article.service;

import java.util.List;

import com.siping.domain.portal.entity.Article;

/**
 * Article的Service层
 *
 * @author siping-L.J.H
 * @date 2016年4月12日上午11:31:26
 * @version 1.0
 */
public interface ArticleService {

	public void addArticle(Article article);

	public List<Article> listArticles();

	public void updateArticle(Article article);
}
