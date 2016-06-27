package com.siping.hrip.portal.article.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stroma.framework.core.exception.BusinessProcessException;

import com.siping.domain.common.DataConvertUtil;
import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.Article;
import com.siping.domain.portal.entity.MsgType;
import com.siping.domain.portal.entity.PageRequest;
import com.siping.domain.portal.entity.PageResponse;
import com.siping.hrip.portal.article.mapper.ArticleMapper;
import com.siping.hrip.portal.article.mapper.MsgTypeMapper;
import com.siping.hrip.portal.article.service.MsgTypeService;

/**
 * @author siping-L.J.H
 * @date 2016年4月19日上午10:49:21
 * @version 1.0
 */
@Service
public class MsgTypeServiceImpl implements MsgTypeService {

    @Autowired
    private MsgTypeMapper msgTypeMapper;

    @Autowired
    private ArticleMapper articleMapper;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public PageResponse<MsgType> getListByPage(MsgType msgType, PageRequest pageRequest) throws BusinessProcessException {
        PageResponse<MsgType> msgTypeResponse = new PageResponse<MsgType>();
        try {
            Map<String, Object> map = DataConvertUtil.convertBean(msgType);
            map.put("startNo", pageRequest.getStartNo());
            map.put("pageSize", pageRequest.getPageSize());
            msgTypeResponse.setRecords(msgTypeMapper.getByPage(map));
            msgTypeResponse.setTotal(msgTypeMapper.getCount(map).intValue());
            return msgTypeResponse;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessProcessException("查询信息类别列表失败。");
        }
    }

    @Override
    public ResultMsg add(MsgType msgType) throws BusinessProcessException {
        if (null != msgType) {
            msgType.setCreateDate(sdf.format(new Date()));
            msgType.setUpdateDate(sdf.format(new Date()));
            try {
                msgTypeMapper.insertSelective(msgType);
                return new ResultMsg(true, "添加成功。");
            } catch (Exception e) {
                e.printStackTrace();
                throw new BusinessProcessException("添加信息类别失败");
            }
        } else {
            return new ResultMsg(false, "传入值为null，添加失败。");
        }
    }

    @Override
    public ResultMsg edit(MsgType msgType) throws BusinessProcessException {
        if (null != msgType) {
            msgType.setUpdateDate(sdf.format(new Date()));
            try {
                msgTypeMapper.updateByPrimaryKeySelective(msgType);
                return new ResultMsg(true, "编辑成功。");
            } catch (Exception e) {
                e.printStackTrace();
                throw new BusinessProcessException("编辑信息类别失败");
            }
        } else {
            return new ResultMsg(false, "传入值为null，编辑失败。");
        }
    }

    @Override
    public ResultMsg delete(MsgType msgType) throws BusinessProcessException {
        if (null != msgType) {
            Article article = new Article();
            article.setIsDelete(1);
            article.setMsgTypeId(msgType.getId());
            try {
                Map<String, Object> map = DataConvertUtil.convertBean(article);
                if (articleMapper.getCount(map) <= 0) {// 先判断是否被未删除的文章引用
                    msgTypeMapper.deleteByPrimaryKey(msgType.getId().intValue());
                    return new ResultMsg(true, "删除成功。");
                } else {
                    return new ResultMsg(false, "该信息类别被文章引用，不可删除。");
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new BusinessProcessException("删除信息类别失败。");
            }
        } else {
            return new ResultMsg(false, "值为null，删除失败。");
        }
    }

    public List<MsgType> get(MsgType msgType) throws BusinessProcessException {
        try {
            Map<String, Object> map = DataConvertUtil.convertBean(msgType);
            return msgTypeMapper.get(map);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessProcessException("查询信息类别列表失败。");
        }
    }
}
