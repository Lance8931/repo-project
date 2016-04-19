package com.siping.hrip.portal.article.service.impl;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siping.domain.common.DataConvertUtil;
import com.siping.domain.portal.entity.Article;
import com.siping.domain.portal.entity.PageRequest;
import com.siping.domain.portal.entity.PageResponse;
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

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public void addArticle(Article article) throws Exception {
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
		try {
			articleMapper.insertSelective(article);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("操作数据库失败。");
		}

	}

	@Override
	public PageResponse<Article> getListByPage(Article article,
			PageRequest pageRequest) throws Exception {
		PageResponse<Article> articleResponse = new PageResponse<Article>();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = DataConvertUtil.convertBean(article);
			map.put("startNo", pageRequest.getStartNo());
			map.put("pageSize", pageRequest.getPageSize());
			articleResponse.setRecords(articleMapper.getByPage(map));
			articleResponse.setTotal(articleMapper.getCount(map).intValue());
			return articleResponse;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查询文章列表失败。");
		}
	}

	@Override
	public void updateArticle(Article article) throws Exception {
		if (null != article) {
			article.setUpdateDate(sdf.format(new Date()));
			try {
				articleMapper.updateByPrimaryKeySelective(article);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("更新文章失败。");
			}
		} else {
			throw new Exception("article不能为null。");
		}
	}

	@Override
	public void updateArticleStatus(String id, String action) throws Exception {
		Article article = new Article();
		if (action.equals("enable")) {
			article.setEnabled(false);// 已在SQL语句中取反，该处具体值无所谓，只要不为空即可。
		} else if (action.equals("delete")) {
			article.setIsDelete(false);
		}
		article.setId(new BigInteger(id));
		article.setUpdateBy(new BigInteger("1"));
		article.setUpdateDate(sdf.format(new Date()));
		try {
			articleMapper.updateByPrimaryKeySelective(article);
		} catch (Exception e) {
			throw new Exception("更新文章状态失败。");
		}
	}

	@Override
	public Article getForPreview(String id) throws Exception {
		try {
			return articleMapper.selectByPrimaryKey(Long.valueOf(id));
		} catch (Exception e) {
			throw new Exception("获取预览信息出错。");
		}
	}

	@Override
	public void exceptionTest() throws Exception {
		try {
			throw new Exception("ddd");
		} catch (Exception e) {
			throw new Exception("异常信息");
		}

	}
}
