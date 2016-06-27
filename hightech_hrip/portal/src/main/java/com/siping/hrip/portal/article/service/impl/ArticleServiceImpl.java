package com.siping.hrip.portal.article.service.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.stroma.framework.core.exception.BusinessProcessException;

import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.Article;
import com.siping.domain.portal.entity.IntroArticle;
import com.siping.domain.portal.entity.PageRequest;
import com.siping.domain.portal.entity.PageResponse;
import com.siping.hrip.portal.article.mapper.ArticleMapper;
import com.siping.hrip.portal.article.mapper.IntroArticleMapper;
import com.siping.hrip.portal.article.service.ArticleService;

/**
 * @author siping-L.J.H
 * @date 2016年4月13日下午4:22:07
 * @version 1.0
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    @Value("${site.imgs.path}")
    private String filePath;

    @Autowired
    private IntroArticleMapper introArticleMapper;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public ResultMsg addArticle(Article article, List<MultipartFile> files, HttpServletRequest request) 
        throws BusinessProcessException, IOException, Exception {
        if (files.size() == 0 && !article.getType().equals("001") && !article.getType().equals("002")) {
            return new ResultMsg(false, "没有要上传的文件");
        }
        article.setCreateBy(new BigInteger("1"));
        article.setIsDelete(1);
        if (files.size() != 0) {
            MultipartFile file = files.get(0);
            if (file.getSize() > 1024 * 1024) {
                return new ResultMsg(false, "上传失败，请选择小于1M的图片");
            }
            String imgName = file.getOriginalFilename();
            String fileName = String.valueOf(System.currentTimeMillis());
            String fileSuffix = imgName.substring(imgName.lastIndexOf(".")).toLowerCase();
            String imgFilePath = filePath + fileName + fileSuffix;
            article.setPicPath(fileName + fileSuffix);
            
            //保存图片
            FileInputStream fis = (FileInputStream)file.getInputStream();
            Iterator<ImageReader> it = ImageIO  
                .getImageReadersByFormatName(fileSuffix.replaceFirst(".", ""));  
            ImageReader reader = it.next();
            ImageInputStream iis = ImageIO.createImageInputStream(fis);
            reader.setInput(iis, true);  
            ImageReadParam param = reader.getDefaultReadParam();  
            java.awt.Rectangle rect = new java.awt.Rectangle(Integer.parseInt(request.getParameter("imageX")),Integer.parseInt(request.getParameter("imageY")),
                Integer.parseInt(request.getParameter("imageW")), Integer.parseInt(request.getParameter("imageH")));
            param.setSourceRegion(rect);  
            BufferedImage bi = reader.read(0, param);  
            ImageIO.write(bi, fileSuffix.replaceFirst(".", ""), new File(imgFilePath));
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("article", article);
        articleMapper.updateDisplayPosition(map); // 修改存在的TOP
        articleMapper.insertSelective(article);
        return new ResultMsg(true, "添加成功。");    
    }

    @Override
    public ResultMsg updateArticle(Article article, List<MultipartFile> files, HttpServletRequest request) throws BusinessProcessException {
        if (null != article) {
            article.setUpdateDate(sdf.format(new Date()));
            try {
                if (files.size() > 0) {
                    MultipartFile file = files.get(0);
                    if (file.getSize() > 1024 * 1024) {
                        return new ResultMsg(false, "上传失败，请选择小于1M的图片");
                    }
                    String imgName = file.getOriginalFilename();
                    String fileName = String.valueOf(System.currentTimeMillis());
                    String fileSuffix = imgName.substring(imgName.lastIndexOf(".")).toLowerCase();
                    String imgFilePath = filePath + fileName + fileSuffix;
                    file.transferTo(new File(imgFilePath));
                    File deleteFile = new File(filePath + article.getPicPath());
                    deleteFile.delete();// 删除之前的图片
                    article.setPicPath(fileName + fileSuffix);
                }
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("article", article);
                articleMapper.updateDisplayPosition(map); // 修改存在的TOP
                articleMapper.updateByPrimaryKeySelective(article);
                return new ResultMsg(true, "更新成功。");
            } catch (Exception e) {
                e.printStackTrace();
                throw new BusinessProcessException("操作数据库失败。");
            }
        } else {
            return new ResultMsg(false, "article不能为null。");
        }
    }

    @Override
    public PageResponse<Article> getListByPage(Article article, PageRequest pageRequest, HttpServletRequest req) throws BusinessProcessException {
        PageResponse<Article> articleResponse = new PageResponse<Article>();
        Map<String, Object> map = new HashMap<String, Object>();
        article.setIsDelete(1);
        try {
            map.put("orderPublish", req.getParameter("orderPublish"));// 根据发布时间排序
            map.put("article", article);
            map.put("startNo", pageRequest.getStartNo());
            map.put("pageSize", pageRequest.getPageSize());
            articleResponse.setRecords(articleMapper.getListByPage(map));
            articleResponse.setTotal(articleMapper.getCount(map).intValue());
            return articleResponse;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessProcessException("查询文章列表失败。");
        }
    }

    @Override
    public ResultMsg updateArticlesStatus(List<String> ids, String action) throws BusinessProcessException {
        List<Article> articles = new ArrayList<Article>();
        Map<String, Object> map = new HashMap<String, Object>();
        for (String string : ids) {
            Article article = new Article();
            article.setId(new BigInteger(string));
            article.setUpdateBy(new BigInteger("1"));
            article.setUpdateDate(sdf.format(new Date()));
            articles.add(article);
        }
        try {
            map.put("action", action);
            map.put("list", articles);
            articleMapper.updateStatusBatch(map);
            return new ResultMsg(true, "修改状态成功。");
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessProcessException("操作数据库失败。");
        }
    }

    @Override
    public Article getArticle(String id) throws BusinessProcessException {
        try {
            return articleMapper.selectByPrimaryKey(Integer.valueOf(id));
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessProcessException("获取预览信息出错。");
        }
    }

    @Override
    public IntroArticle getIntroArticle(String subTitle) throws BusinessProcessException {
        try {
            return introArticleMapper.selectBySubTitle(subTitle);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessProcessException("获取信息出错。");
        }
    }

    @Override
    public ResultMsg updateIntroArticle(IntroArticle introArticle) throws BusinessProcessException {
        if (null != introArticle) {
            introArticle.setUpdateDate(sdf.format(new Date()));
            try {
                introArticleMapper.updateByPrimaryKeySelective(introArticle);
                return new ResultMsg(true, "更新成功。");
            } catch (Exception e) {
                e.printStackTrace();
                throw new BusinessProcessException("操作数据库失败。");
            }
        } else {
            return new ResultMsg(false, "introArticle不能为null。");
        }
    }

    @Override
    public void exceptionTest() throws Exception {
        try {
            throw new Exception("ddd");
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("异常信息");
        }

    }

    @Override
    public Map<String, List<Article>> frontList() throws Exception {
        Map<String, List<Article>> map = new HashMap<String, List<Article>>();
        Map<String, Object> mapNum = new HashMap<String, Object>();
        /* 获取资讯信息 */
        Article article = new Article();
        try {
            article.setType("101");
            mapNum.put("messages", "1");
            mapNum.put("article", article);
            mapNum.put("startNo", 0);
            mapNum.put("pageSize", 5);
            map.put("message", articleMapper.getListByPage(mapNum));
            /* 通知 */
            article.setType("001");
            mapNum.put("article", article);
            mapNum.put("startNo", 0);
            mapNum.put("pageSize", 3);
            map.put("inform", articleMapper.getListByPage(mapNum));
            /* 公告 */
            article.setType("002");
            mapNum.put("article", article);
            map.put("notice", articleMapper.getListByPage(mapNum));
            return map;
        } catch (Exception e) {
            throw new Exception("获取数据失败");
        }
    }

    public List<IntroArticle> getIntroList(String type) throws BusinessProcessException {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        if (type.equals("about-park")) {
            paramMap.put("subTitleList", Arrays.asList(new String[] { "201", "202", "203", "204", "205" }));
        } else if (type.equals("get-in-park")) {
            paramMap.put("subTitleList", Arrays.asList(new String[] { "301", "302", "303", "304" }));
        } else if (type.equals("innovate")) {
            paramMap.put("subTitleList", Arrays.asList(new String[] { "401", "402", "403" }));
        }
        try {
            return introArticleMapper.getList(paramMap);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessProcessException("查询资讯列表失败。");
        }
    }

    
}
