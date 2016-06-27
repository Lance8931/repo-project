package com.siping.hrip.portal.article.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.stroma.framework.core.exception.BusinessProcessException;

import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.Article;
import com.siping.domain.portal.entity.IntroArticle;
import com.siping.domain.portal.entity.PageRequest;
import com.siping.domain.portal.entity.PageResponse;

/**
 * Article的Service层
 * @author siping-L.J.H
 * @date 2016年4月12日上午11:31:26
 * @version 1.0
 */
public interface ArticleService {

    /**
     * 添加文章
     * @param article
     * @return
     * @throws BusinessProcessException
     */
    public ResultMsg addArticle(Article article, List<MultipartFile> files, HttpServletRequest request) throws BusinessProcessException, IOException , Exception;

    /**
     * 获取文章列表
     * @param article
     * @param pageRequest
     * @return
     * @throws Exception
     * @date 2016年4月19日下午1:48:58
     * @author siping-L.J.H
     */
    public PageResponse<Article> getListByPage(Article article, PageRequest pageRequest, HttpServletRequest req) throws BusinessProcessException;

    /**
     * 更新文章
     * @param article
     * @return
     * @throws Exception
     * @date 2016年4月19日上午10:13:56
     * @author siping-L.J.H
     */
    public ResultMsg updateArticle(Article article, List<MultipartFile> files, HttpServletRequest request) throws BusinessProcessException;

    /**
     * 批量更改文章的状态(启/禁用，删除)
     * @param ids
     * @param action
     * @return
     * @throws Exception
     * @date 2016年4月27日下午2:05:57
     * @author siping-L.J.H
     */
    public ResultMsg updateArticlesStatus(List<String> ids, String action) throws BusinessProcessException;

    /**
     * 获取单篇文章
     * @param id
     * @return
     * @throws Exception
     * @date 2016年4月19日下午2:21:00
     * @author siping-L.J.H
     */
    public Article getArticle(String id) throws BusinessProcessException;

    /**
     * 获取介绍性说明文
     * @param subTitle 二级标题
     * @return
     * @throws BusinessProcessException
     * @date 2016年5月18日下午1:04:32
     * @author siping-L.J.H
     */
    public IntroArticle getIntroArticle(String subTitle) throws BusinessProcessException;

    /**
     * 更新介绍性说明文
     * @param introArticle
     * @return
     * @throws BusinessProcessException
     * @date 2016年5月18日下午1:05:34
     * @author siping-L.J.H
     */
    public ResultMsg updateIntroArticle(IntroArticle introArticle) throws BusinessProcessException;

    /**
     * 获取门户网站 资讯 通知
     * @return
     * @throws Exception
     */
    public Map<String, List<Article>> frontList() throws Exception;

    /**
     * 获取“园区概况”，“企业入园”，“创新创业”信息
     * @param type 获取类型
     * @return
     * @throws BusinessProcessException
     * @date 2016年5月23日下午3:01:29
     * @author siping-L.J.H
     */
    public List<IntroArticle> getIntroList(String type) throws BusinessProcessException;

    public void exceptionTest() throws Exception;
}
