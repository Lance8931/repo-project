package com.siping.hrip.portal.article.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siping.domain.portal.entity.Article;
import com.siping.hrip.portal.article.mapper.ArticleMapper;
import com.siping.hrip.portal.article.service.ArticleService;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年4月13日下午4:22:07
 * @version 1.0
 */
@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleMapper articleMapper;

	@Override
	public void addArticle(Article article) {
		articleMapper.insert(article);
	}

	@Override
	public List<Article> listArticles() {
		return articleMapper.getList(null);
	}

	@Override
	public void updateArticle(Article article) {
		articleMapper.updateByPrimaryKeySelective(article);
	}
}
