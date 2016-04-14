package com.siping.hrip.portal.article.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		return PagePath.ARTICLE_ADD;
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

	@RequestMapping(value = "article/list")
	public String list(Map<String, Object> model) {
		model.put("list", articleService.listArticles());
		return PagePath.ARTICLE_LIST;
	}

	@RequestMapping(value = "article/preview")
	@ResponseBody
	public ResultMsg preview(Map<String, Object> model) {
		Article article = articleService.listArticles().get(0);
		return new ResultMsg(true, article.getContent(), article.getId()
				.toString());
	}

	@RequestMapping(value = "article/edit")
	@ResponseBody
	public ResultMsg edit(String id, String content) {
		Article article = new Article();
		article.setId(Long.valueOf(id));
		article.setContent(content);
		article.setUpdateDate(new Date());
		articleService.updateArticle(article);
		return new ResultMsg(true, "成功！");
	}
}
