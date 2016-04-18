package com.siping.hrip.portal.article.controller;

import java.math.BigInteger;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
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

	/**
	 * 跳转至文章添加页面
	 * 
	 * @return
	 *
	 * @date 2016年4月18日上午9:49:22
	 * @author siping-L.J.H
	 */
	@RequestMapping(value = "article/redict")
	public String redirect() {
		return PagePath.ARTICLE_ADD;
	}

	/**
	 * 文章添加
	 * 
	 * @param content
	 * @return
	 *
	 * @date 2016年4月18日上午9:49:39
	 * @author siping-L.J.H
	 */
	@RequestMapping(value = "article/add")
	public ResultMsg add(String content) {
		if (StringUtils.isNotBlank(content)) {
			try {
				articleService.addArticle(content);
				return new ResultMsg(true, "添加成功！");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			return new ResultMsg(false, "内容为空！");
		}
		
		return new ResultMsg(false, "添加失败！");
	}

	/**
	 * 获取文章列表
	 * 
	 * @param model
	 * @return
	 *
	 * @date 2016年4月18日上午9:49:53
	 * @author siping-L.J.H
	 */
	@RequestMapping(value = "article/list")
	public String list(Map<String, Object> model) {
		model.put("list", articleService.listArticles());
		return PagePath.ARTICLE_LIST;
	}

	/**
	 * 文章预览
	 * 
	 * @param model
	 * @return
	 *
	 * @date 2016年4月18日上午9:50:58
	 * @author siping-L.J.H
	 */
	@RequestMapping(value = "article/preview")
	@ResponseBody
	public ResultMsg preview(Map<String, Object> model) {
		try {
			Article article = articleService.listArticles().get(0);
			return new ResultMsg(true, article.getContent(), article.getId()
					.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResultMsg(false, "获取文章内容失败！");
	}

	/**
	 * 编辑文章内容
	 * 
	 * @param id
	 * @param content
	 * @return
	 *
	 * @date 2016年4月18日下午1:38:53
	 * @author siping-L.J.H
	 */
	@RequestMapping(value = "article/edit")
	@ResponseBody
	public ResultMsg edit(String id, String content) {
		Article article = new Article();
		if (StringUtils.isNotBlank(id) && StringUtils.isNumeric(id)) {
			article.setId(new BigInteger(id));
			article.setContent(content);
		} else {
			return new ResultMsg(false, "非法id！");
		}
		try {
			articleService.updateArticle(article);
			return new ResultMsg(true, "成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResultMsg(false, "失败！");
	}

	/**
	 * 修改文章状态(启紧用/删除)
	 * 
	 * @param id
	 * @param action
	 * @return
	 *
	 * @date 2016年4月18日下午1:56:56
	 * @author siping-L.J.H
	 */
	public ResultMsg updateStatus(String id, String action) {
		if (StringUtils.isNotBlank(id) && StringUtils.isNumeric(id)) {
			if (action.equals("enable") || action.equals("delete")) {
				try {
					articleService.updateArticleStatus(id, action);
					return new ResultMsg(true, "操作成功！");
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				return new ResultMsg(false, "不正常操作指令");
			}
		} else {
			return new ResultMsg(false, "非法id");
		}
		return new ResultMsg(false, "操作失败！");
	}
}
