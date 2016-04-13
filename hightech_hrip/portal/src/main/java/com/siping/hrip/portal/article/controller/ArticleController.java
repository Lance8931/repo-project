package com.siping.hrip.portal.article.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.siping.domain.common.PagePath;
import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.Article;
import com.siping.hrip.portal.article.service.ArticleService;

/**
 * 文章Controller
 *
 * @author siping-L.J.H
 * @date 2016年4月12日上午9:59:09
 * @version 1.0
 */
@Controller
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@RequestMapping(value = "article/redict")
	public String redirect() {
		return PagePath.ADD_ARTICLE;
	}

	@RequestMapping(value = "article/add")
	public ResultMsg add(String content) {
		Article article = new Article();
		article.setAuthor("作者1");
		article.setContent(content);
		article.setCreateBy(1L);
		article.setCreateDate(new Date());
		article.setTitle("测试文章标题1");
		article.setType("1");
		article.setUpdateBy(1L);
		article.setUpdateDate(new Date());
		article.setEnabled(true);
		article.setIsDelete(false);
		article.setPublishTime(new Date());
		articleService.addArticle(article);
		return new ResultMsg(true, "添加成功！");
	}
}
