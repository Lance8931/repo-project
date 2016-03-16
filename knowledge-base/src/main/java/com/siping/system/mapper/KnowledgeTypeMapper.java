package com.siping.system.mapper;

import java.util.List;
import java.util.Map;

import com.siping.system.bean.KnowledgeType;
import com.siping.web.bean.PageRequest;

public interface KnowledgeTypeMapper {
    /**
     * 删除知识类别
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    int insert(KnowledgeType record);

    /**
     * 添加知识类别
     * @param record
     * @return
     */
    int insertSelective(KnowledgeType record);
    /**
     * 根据ID获取知识类别详细信息
     * @param id
     * @return
     */
    KnowledgeType selectByPrimaryKey(Integer id);

    /**
     * 修改知识类别
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(KnowledgeType record);

    int updateByPrimaryKey(KnowledgeType record);

    List<KnowledgeType> getAll();

    List<KnowledgeType> get(Map<String, Object> par);

    void deleteByIds(List<Integer> ids);

    Long getCount(Map<?, ?> map);

    /**
     * 查询知识类别分页显示
     * @param pageRequest
     * @return
     */
    List<KnowledgeType> getByPage(PageRequest pageRequest) throws Exception;

    /**
     * 查询知识类别总条数
     * @return
     * @throws Exception
     */
    Integer getTotalKnow() throws Exception;

    /**
     * 查询问题表是否引用了要删除的知识类别
     * @param id
     * @return
     * @throws Exception
     */
    Integer getProblem(Integer id) throws Exception;
    /**
     * 根据ID获取类型详情
     * @param id
     * @return
     * @throws Exception
     */
    List<KnowledgeType> getKnowById(Integer id) throws Exception;
    /**
     * 验证知识类别是否存在
     * @param kt
     * @return
     * @throws Exception
     */
    Integer selectNewName(KnowledgeType kt)throws Exception;
}
