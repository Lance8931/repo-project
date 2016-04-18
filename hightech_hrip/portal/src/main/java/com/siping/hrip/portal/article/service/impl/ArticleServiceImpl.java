package com.siping.hrip.portal.article.service.impl;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.enterprise.inject.New;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siping.domain.common.ResultMsg;
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
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = null;

	@Override
	public void addArticle(String content) throws Exception {
		Article article = new Article();
		article.setCreateBy(new BigInteger("1"));
		article.setCreateDate(sdf.format(new Date()));
		article.setTitle("测试文章标题1");
		article.setType("1");
		article.setUpdateBy(new BigInteger("1"));
		article.setUpdateDate(sdf.format(new Date()));
		article.setEnabled(true);
		article.setIsDelete(true);
		article.setPublishTime(new Date());
		article.setAuthor("作者1");
		articleMapper.insertSelective(article);

	}

	@Override
	public List<Article> listArticles() {
		return articleMapper.getByConditions(null);
	}

	@Override
	public void updateArticle(Article article) {
		if (null != article) {
			article.setUpdateDate(sdf.format(new Date()));
		}
		articleMapper.updateByPrimaryKeySelective(article);
	}
	
	@Override
	public void updateArticleStatus(String id, String action) throws Exception{
		Article article = new Article();
		if (action.equals("enable")) {
			article.setEnabled(false);// 已在SQL语句中取反，该处具体值无所谓，只要不为空即可。
		} else if (action.equals("delete")) {
			article.setIsDelete(false);
		} 
		try {
			article.setId(new BigInteger(id));
			article.setUpdateBy(new BigInteger("1"));
			article.setUpdateDate(sdf.format(new Date()));
			articleMapper.updateByPrimaryKeySelective(article);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
