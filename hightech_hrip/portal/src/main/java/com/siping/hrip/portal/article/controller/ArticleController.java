package com.siping.hrip.portal.article.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.stroma.framework.core.exception.BusinessProcessException;
import org.stroma.framework.core.platform.web.StromaController;

import com.siping.domain.common.PagePath;
import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.Article;
import com.siping.domain.portal.entity.IntroArticle;
import com.siping.domain.portal.entity.PageRequest;
import com.siping.domain.portal.entity.PageResponse;
import com.siping.hrip.portal.article.service.ArticleService;

/**
 * 文章(Article)Controller层
 * @author siping-L.J.H
 * @date 2016年4月12日上午9:59:09
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/article")
public class ArticleController extends StromaController {

    @Autowired
    private ArticleService articleService;

    /**
     * 跳转至文章添加页面
     * @return
     * @date 2016年4月18日上午9:49:22
     * @author siping-L.J.H
     */
    @RequestMapping(value = "/redirect")
    public String redirect() {
        return "article/tempUEditor";
    }

    /**
     * 文章添加
     * @param content
     * @return
     * @date 2016年4月18日上午9:49:39
     * @author siping-L.J.H
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg add(Article article, @RequestParam(value = "uploadImage", required = false) List<MultipartFile> files, HttpServletRequest request) {
        String checkInfo = checkArticle(article, "add");
        if (null != checkInfo) {
            return new ResultMsg(false, "添加失败，" + checkInfo);
        } else {
                try {
                    return articleService.addArticle(article, files, request);
                } catch (BusinessProcessException e) {
                    e.printStackTrace();
                    return new ResultMsg(false, "添加失败，请稍后再试");
                } catch (IOException e) {
                    e.printStackTrace();
                    return new ResultMsg(false, "图片保存失败，请重新上传");
                } catch (Exception e) {
                    e.printStackTrace();
                    return new ResultMsg(false, "发生了一个未知错误，请重新添加");
                }
        }
    }

    /**
     * 获取文章列表
     * @param model
     * @return
     * @date 2016年4月18日上午9:49:53
     * @author siping-L.J.H
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public PageResponse<Article> list(Article article, PageRequest pageRequest, HttpServletRequest req) {
        try {
            return articleService.getListByPage(article, pageRequest, req);
        } catch (BusinessProcessException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 文章预览
     * @param id
     * @return
     * @date 2016年4月18日上午9:50:58
     * @author siping-L.J.H
     */
    @RequestMapping(value = "/preview")
    @ResponseBody
    public ResultMsg preview(String id) {
        if (StringUtils.isNotBlank(id) && StringUtils.isNumeric(id)) {
            try {
                Article article = articleService.getArticle(id);
                return new ResultMsg(true, article.getContent());
            } catch (BusinessProcessException e) {
                e.printStackTrace();
                return new ResultMsg(false, "获取文章内容失败，" + e.getMessage());
            }
        } else {
            return new ResultMsg(false, "获取文章内容失败，id非法");
        }
    }

    /**
     * 编辑文章内容
     * @param article
     * @return
     * @date 2016年4月18日下午1:38:53
     * @author siping-L.J.H
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg edit(Article article, @RequestParam(value = "uploadImage", required = false) List<MultipartFile> files, HttpServletRequest request) {
        String checkInfo = checkArticle(article, "edit");
        if (null != checkInfo) {
            return new ResultMsg(false, "编辑失败，" + checkInfo);
        } else {
            try {
                return articleService.updateArticle(article, files, request);
            } catch (BusinessProcessException e) {
                e.printStackTrace();
                return new ResultMsg(false, "编辑失败，" + e.getMessage());
            }
        }
    }

    /**
     * 批量修改文章状态(启禁用/删除)
     * @param ids
     * @param action
     * @return
     * @date 2016年4月27日下午2:04:49
     * @author siping-L.J.H
     */
    @RequestMapping(value = "/updateStatus")
    @ResponseBody
    public ResultMsg updateStatus(String[] ids, String action) {
        for (String string : ids) {
            if (StringUtils.isBlank(string) || !StringUtils.isNumeric(string)) {
                return new ResultMsg(false, "修改状态失败，存在非法id");
            }
        }
        if (action.equals("enabled") || action.equals("delete") || action.equals("disabled")) {
            try {
                return articleService.updateArticlesStatus(Arrays.asList(ids), action);
            } catch (BusinessProcessException e) {
                e.printStackTrace();
                return new ResultMsg(false, "修改状态失败，" + e.getMessage());
            }
        } else {
            return new ResultMsg(false, "修改状态失败，不正常操作指令。");
        }
    }

    /**
     * 跳转文章表头页面
     * @return
     * @date 2016年4月26日下午1:39:49
     * @author siping-L.J.H
     */
    @RequestMapping(value = "/redirectArticle")
    public String redirectArticle(Integer type, ModelMap map) {
        map.put("type", type);
        return PagePath.ARTICLE_HEAD;
    }

    /**
     * 跳转文章添加页面
     * @return
     * @date 2016年4月26日下午3:08:59
     * @author siping-L.J.H
     */
    @RequestMapping(value = "/redirectAdd")
    public String redirectAdd(String type, ModelMap map) {
        map.put("type", type);
        return PagePath.ARTICLE_ADD;
    }

    /**
     * 跳转文章编辑页面
     * @return
     * @date 2016年4月27日上午10:46:35
     * @author siping-L.J.H
     */
    @RequestMapping(value = "/redirectEdit")
    public String redirectEdit(String id, String type, ModelMap map) {
        map.put("id", id);
        map.put("type", type);
        return PagePath.ARTICLE_EDIT;
    }

    /**
     * 获取单篇文章
     * @param id
     * @return
     * @date 2016年4月27日上午10:46:41
     * @author siping-L.J.H
     */
    @RequestMapping(value = "/getArticle", method = RequestMethod.POST)
    @ResponseBody
    public Article getArticle(String id) {
        if (StringUtils.isNotBlank(id) && StringUtils.isNumeric(id)) {
            try {
                Article article = articleService.getArticle(id);
                return article;
            } catch (BusinessProcessException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * 跳转介绍性说明文
     * @param type 标题类型(park-info园区概况，org-incoming企业入区，innovative创新创业，oversea-
     *            innovative离岸创新创业)
     * @return
     * @date 2016年5月18日上午10:03:53
     * @author siping-L.J.H
     */
    @RequestMapping(value = "/redirectIntro")
    public String redirectIntroArticle(String type, ModelMap map) {
        map.put("type", type);
        return PagePath.ARTICLE_INTRO;
    }

    /**
     * 获取介绍性说明文
     * @param subTitle 二级标题
     * @return
     * @date 2016年5月18日上午11:27:31
     * @author siping-L.J.H
     */
    @RequestMapping(value = "/getIntroArticle", method = RequestMethod.POST)
    @ResponseBody
    public IntroArticle getIntroArticle(String subTitle) {
        if (StringUtils.isNotBlank(subTitle) && StringUtils.isNumeric(subTitle)) {
            try {
                IntroArticle introArticle = articleService.getIntroArticle(subTitle);
                return introArticle;
            } catch (BusinessProcessException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * 修改介绍性说明文
     * @param introArticle
     * @return
     * @date 2016年5月18日下午12:00:05
     * @author siping-L.J.H
     */
    @RequestMapping(value = "/editIntroArticle", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg editIntroArticle(IntroArticle introArticle) {
        if (null == introArticle.getId()) {
            return new ResultMsg(false, "编辑失败，Id非法。");
        } else {
            try {
                return articleService.updateIntroArticle(introArticle);
            } catch (BusinessProcessException e) {
                e.printStackTrace();
                return new ResultMsg(false, "编辑失败，" + e.getMessage());
            }
        }
    }

    /**
     * 检查输入Article数据
     * @param article
     * @param action 操作(add/edit)
     * @return
     * @date 2016年4月19日下午4:13:00
     * @author siping-L.J.H
     */
    private String checkArticle(Article article, String action) {
        if (null != article) {
            if (action.equals("add") || action.equals("edit")) {
                if (StringUtils.isBlank(article.getContent())) {
                    return "内容为空！";
                } else if (StringUtils.isBlank(article.getType()) || !StringUtils.isNumeric(article.getType())) {
                    return "信息类别为空！";
                } else if (StringUtils.isBlank(article.getTitle())) {
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

    /**
     * 门户网站资讯信息加载
     * @return
     */
    @RequestMapping(value = "/frontList", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, List<Article>> frontList() {
        try {
            Map<String, List<Article>> map = articleService.frontList();
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * “园区概况”，“企业入园”，“创新创业”信息
     * @param type 类型
     * @return
     * @date 2016年5月23日下午3:28:04
     * @author siping-L.J.H
     */
    @RequestMapping(value = "/getIntroContentList")
    @ResponseBody
    public Map<String, String> getIntroContentList(String type) {
        Map<String, String> resultMap = new HashMap<String, String>();
        try {
            for (IntroArticle introArticle : articleService.getIntroList(type)) {
                resultMap.put(introArticle.getSubTitle(), introArticle.getContent());
            }
            return resultMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/exceptionTest")
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
