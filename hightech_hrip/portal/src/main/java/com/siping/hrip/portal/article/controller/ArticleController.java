package com.siping.hrip.portal.article.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.siping.domain.common.PagePath;
import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.Article;
import com.siping.domain.portal.entity.PageRequest;
import com.siping.domain.portal.entity.PageResponse;
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
	public ResultMsg add(Article article) {
		String checkInfo = checkArticle(article, "add");
		if (null != checkInfo) {
			return new ResultMsg(false, "添加失败，" + checkInfo);
		} else {
			try {
				articleService.addArticle(article);
				return new ResultMsg(true, "添加成功！");
			} catch (Exception e) {
				e.printStackTrace();
				return new ResultMsg(false, "添加失败，" + e.getMessage());
			}
		}
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
	@ResponseBody
	public PageResponse<Article> list(Article article, PageRequest pageRequest) {
		try {
			return articleService.getListByPage(article, pageRequest);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 文章预览
	 * 
	 * @param id
	 * @return
	 *
	 * @date 2016年4月18日上午9:50:58
	 * @author siping-L.J.H
	 */
	@RequestMapping(value = "article/preview")
	@ResponseBody
	public ResultMsg preview(String id) {
		if (StringUtils.isNotBlank(id) && StringUtils.isNumeric(id)) {
			try {
				Article article = articleService.getForPreview(id);
				return new ResultMsg(true, article.getContent(), article
						.getId().toString());
			} catch (Exception e) {
				e.printStackTrace();
				return new ResultMsg(false, "获取文章内容失败，" + e.getMessage());
			}
		} else {
			return new ResultMsg(false, "获取文章内容失败，id非法");
		}
	}

	/**
	 * 编辑文章内容
	 * 
	 * @param article
	 * @return
	 *
	 * @date 2016年4月18日下午1:38:53
	 * @author siping-L.J.H
	 */
	@RequestMapping(value = "article/edit")
	@ResponseBody
	public ResultMsg edit(Article article) {
		String checkInfo = checkArticle(article, "edit");
		if (null != checkInfo) {
			return new ResultMsg(false, "编辑失败，" + checkInfo);
		} else {
			try {
				articleService.updateArticle(article);
				return new ResultMsg(true, "编辑成功！");
			} catch (Exception e) {
				e.printStackTrace();
				return new ResultMsg(false, "编辑失败，" + e.getMessage());
			}
		}
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
	@RequestMapping(value = "article/updateStatus")
	@ResponseBody
	public ResultMsg updateStatus(String id, String action) {
		if (StringUtils.isNotBlank(id) && StringUtils.isNumeric(id)) {
			if (action.equals("enable") || action.equals("delete")) {
				try {
					articleService.updateArticleStatus(id, action);
					return new ResultMsg(true, "修改状态成功！");
				} catch (Exception e) {
					e.printStackTrace();
					return new ResultMsg(false, "修改状态失败，" + e.getMessage());
				}
			} else {
				return new ResultMsg(false, "修改状态失败，不正常操作指令。");
			}
		} else {
			return new ResultMsg(false, "修改状态失败，非法id");
		}
	}

	/**
	 * 检查输入Article数据
	 * 
	 * @param article
	 * @param action
	 *            操作(add/edit)
	 * @return
	 *
	 * @date 2016年4月19日下午4:13:00
	 * @author siping-L.J.H
	 */
	private String checkArticle(Article article, String action) {
		if (null != article) {
			if (action.equals("add") || action.equals("edit")) {
				if (StringUtils.isBlank(article.getContent())) {
					return "内容为空！";
				} else if (!StringUtils.isNotBlank(article.getType())
						|| !StringUtils.isNumeric(article.getType())) {
					return "信息类别为空！";
				} else if (!StringUtils.isNotBlank(article.getTitle())) {
					return "文章标题为空！";
				}
			}
			if (action.equals("edit")) {
				if (null != article.getId() && article.getId().intValue() <= 0) {
					return "id非法";
				}
			}
		} else {
			return "article为null！";
		}
		return null;
	}

	@RequestMapping(value = "article/exceptionTest")
	@ResponseBody
	public ResultMsg test() {
		try {
			articleService.exceptionTest();
			return new ResultMsg(true, "成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMsg(false, "失败");
		}
	}
}
