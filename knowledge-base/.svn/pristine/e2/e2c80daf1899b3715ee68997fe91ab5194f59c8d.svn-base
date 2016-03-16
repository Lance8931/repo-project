package com.siping.system.action;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.siping.system.bean.KnowledgeType;
import com.siping.system.service.KnowledgeTypeService;
import com.siping.web.bean.PageModel;
import com.siping.web.bean.PageRequest;
import com.siping.web.bean.PageResponse;
import com.siping.web.bean.ResultMsg;

@Controller
public class KnowledgeTypeAction {
    @Autowired
    private KnowledgeTypeService kts;
    /**
     * 获取所有的知识类别并分页显示
     * @param pq
     * @return
     */
    @RequestMapping(value = "/system/getKnow", method = RequestMethod.POST)
    @ResponseBody
    public PageModel<KnowledgeType> getAll(@RequestBody PageRequest pq) {
        PageModel<KnowledgeType> pm = null;
        PageResponse<KnowledgeType> ps = new PageResponse<KnowledgeType>();
        try {
            ps = kts.getAll(pq);
        } catch (Exception e) {
            e.printStackTrace();
        }
        pm = new PageModel<KnowledgeType>(pq.getPageNo(), pq.getPageSize(), ps.getTotal(), ps.getRecords());
        return pm;
    }

    /**
     * 添加知识类别
     * @param kt
     * @return
     */
    @RequestMapping(value = "/system/insertKnow", method = RequestMethod.GET)
    @ResponseBody
    public ResultMsg insertKnow(KnowledgeType kt) {
        String k = "添加失败！";
        try {
            k = kts.insertKnow(kt);
            return new ResultMsg(true,1,k);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultMsg(false,2,k);
    }

    /**
     * 修改知识类别
     * @param kt
     * @return
     */
    @RequestMapping(value = "/system/updateKnow", method = RequestMethod.GET)
    @ResponseBody
    public ResultMsg updateKnow(KnowledgeType kt) {
        String k = "修改失败！";
        try {
            k = kts.updateKnow(kt);
            return new ResultMsg(true,1,k);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultMsg(false,2,k);
    }

    /**
     * 删除知识类别
     * @param id
     * @return
     */
    @RequestMapping(value = "/system/deleteKnow", method = RequestMethod.GET)
    @ResponseBody
    public ResultMsg deleteKnow(Integer[] id) {
        String k = "删除失败！";
        try {
            k = kts.deleteKnow(id);
            return new ResultMsg(true,1,k);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultMsg(false,2,k);
    }
    /**
     * 根据ID查询知识类别详情
     * @param id
     * @return
     */
    @RequestMapping(value="/system/getKnowById",method = RequestMethod.GET)
    @ResponseBody
    public KnowledgeType getKnowById(Integer id){
        try {
            return kts.selectKnow(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
