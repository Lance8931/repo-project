package com.siping.system.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siping.system.bean.KnowledgeType;
import com.siping.system.mapper.KnowledgeTypeMapper;
import com.siping.system.service.KnowledgeTypeService;
import com.siping.web.bean.PageRequest;
import com.siping.web.bean.PageResponse;

@Service
public class KnowledgeTypeServiceImpl implements KnowledgeTypeService {
	@Autowired
	private KnowledgeTypeMapper ktm;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public PageResponse<KnowledgeType> getAll(PageRequest pageRequest)
			throws Exception {
		PageResponse<KnowledgeType> ps = new PageResponse<KnowledgeType>();
		List<KnowledgeType> listKt = this.ktm.getByPage(pageRequest);
		Integer total = this.ktm.getTotalKnow();
		ps.setRecords(listKt);
		ps.setTotal(total);
		return ps;
	}

	@Override
	public String updateKnow(KnowledgeType kt) throws Exception {
		kt.setUpdateTime(sdf.format(new Date()));// 赋值修改时间
		Integer k = this.ktm.updateByPrimaryKeySelective(kt);
		if (k == 1) {
			return "成功！";
		} else {
			return "失败！";
		}
	}

	@Override
	public String insertKnow(KnowledgeType kt) throws Exception {

		if (ktm.selectNewName(kt) > 0) {
			return "知识类别已存在，请重新输入！";
		}
		kt.setAddTime(sdf.format(new Date()));// 赋值添加时间
		Integer k = this.ktm.insertSelective(kt);
		if (k == 1) {
			return "成功！";
		} else {
			return "失败！";
		}
	}

	@Override
	public String deleteKnow(Integer[] id) throws Exception {
		Integer u = 0;// 判断类别是否被引用
		String err = "ID为：\n";
		for (Integer i : id) {
			u = ktm.getProblem(i);// 判断类别是否被引用
			if (u == 0) {
				this.ktm.deleteByPrimaryKey(i);// 删除类别
			} else {
				err += i + "\n";
			}
		}
		if (!err.equals("ID为：\n")) {
			return err += "的类别已被引用不能删除！";
		} else {
			return "成功！";
		}
	}

	@Override
	public KnowledgeType selectKnow(Integer id) throws Exception {
		return ktm.selectByPrimaryKey(id);
	}
}
