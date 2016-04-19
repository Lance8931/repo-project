package com.siping.hrip.portal.article.service;

import com.siping.domain.portal.entity.Article;
import com.siping.domain.portal.entity.PageRequest;
import com.siping.domain.portal.entity.PageResponse;

/**
 * Article的Service层
 *
 * @author siping-L.J.H
 * @date 2016年4月12日上午11:31:26
 * @version 1.0
 */
public interface ArticleService {

	/**
	 * 添加文章
	 * 
	 * @param article
	 * @throws Exception
	 *
	 * @date 2016年4月19日上午10:14:24
	 * @author siping-L.J.H
	 */
	public void addArticle(Article article) throws Exception;

	/**
	 * 获取文章列表
	 * 
	 * @param article
	 * @param pageRequest
	 * @return
	 * @throws Exception
	 *
	 * @date 2016年4月19日下午1:48:58
	 * @author siping-L.J.H
	 */
	public PageResponse<Article> getListByPage(Article article,
			PageRequest pageRequest) throws Exception;

	/**
	 * 更新文章
	 * 
	 * @param article
	 * @throws Exception
	 *
	 * @date 2016年4月19日上午10:13:56
	 * @author siping-L.J.H
	 */
	public void updateArticle(Article article) throws Exception;

	/**
	 * 更改文章的状态(启/禁用，删除)
	 * 
	 * @param id
	 * @param action
	 * @throws Exception
	 *
	 * @date 2016年4月19日上午10:13:28
	 * @author siping-L.J.H
	 */
	public void updateArticleStatus(String id, String action) throws Exception;

	/**
	 * 文章预览
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 *
	 * @date 2016年4月19日下午2:21:00
	 * @author siping-L.J.H
	 */
	public Article getForPreview(String id) throws Exception;

	public void exceptionTest() throws Exception;
}
