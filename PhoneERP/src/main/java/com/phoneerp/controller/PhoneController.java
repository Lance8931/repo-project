package com.phoneerp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phoneerp.bean.Allot;
import com.phoneerp.bean.Orders;
import com.phoneerp.bean.Phone;
import com.phoneerp.bean.Purchase;
import com.phoneerp.bean.ResultMsg;
import com.phoneerp.bean.SearchPhoneListBean;
import com.phoneerp.dao.AllotMapper;
import com.phoneerp.dao.OrdersMapper;
import com.phoneerp.dao.PhoneMapper;
import com.phoneerp.dao.PurchaseMapper;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年5月15日下午4:01:52
 * @version 1.0
 */
@Controller
@RequestMapping("/phone")
public class PhoneController {
	@Autowired
	private PhoneMapper phoneMapper;

	@Autowired
	private PurchaseMapper purchaseMapper;

	@Autowired
	private AllotMapper allotMapper;

	@Autowired
	private OrdersMapper ordersMapper;

	@RequestMapping("/imeiNoCheck")
	@ResponseBody
	public ResultMsg imeiNoCheck(String imeiNo) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		SearchPhoneListBean searchPhoneListBean = new SearchPhoneListBean();
		searchPhoneListBean.setImeiNo(imeiNo);
		paramMap.put("searchBean", searchPhoneListBean);
		paramMap.put("isCheck", true);
		if (phoneMapper.getCount(paramMap) > 0) {
			return new ResultMsg(false, "存在。");
		} else {
			return new ResultMsg(true, "不存在。");
		}
	}

	/**
	 * 采购
	 * 
	 * @param phone
	 * @return
	 *
	 * @date 2016年5月18日下午3:59:43
	 * @author siping-L.J.H
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg add(Phone phone) {
		Purchase purchase = phone.getPurchase();
		purchase.setShopId(phone.getCurrentShopId());
		purchase.setPrice(phone.getPurPrice());
		phoneMapper.insertSelective(phone);
		purchase.setPhoneId(phone.getId());
		purchaseMapper.insertSelective(purchase);
		System.out.println(phone);
		return new ResultMsg(true, "成功。");
	}

	/**
	 * 获取列表
	 * 
	 * @param phone
	 * @return
	 *
	 * @date 2016年5月18日下午3:59:57
	 * @author siping-L.J.H
	 */
	@RequestMapping(value = "/getPhoneList", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public Map<String, Object> getSupplierList(SearchPhoneListBean searchPhoneListBean, Long page, Long rows) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("searchBean", searchPhoneListBean);
		paramMap.put("startNo", (page - 1) * rows);
		paramMap.put("pageSize", rows);
		map.put("rows", phoneMapper.getList(paramMap));
		map.put("total", phoneMapper.getCount(paramMap));
		return map;
	}

	/**
	 * 添加调拨单
	 * 
	 * @param allot
	 * @return
	 *
	 * @date 2016年5月18日下午4:08:35
	 * @author siping-L.J.H
	 */
	@RequestMapping(value = "/addAllot", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg addAllot(Allot allot) {
		Phone phone = new Phone();
		phone.setId(allot.getId());
		phone.setCurrentShopId(allot.getInShopId());
		allot.setId(null);
		allot.setPhoneId(phone.getId());
		phoneMapper.updateByPrimaryKeySelective(phone);
		allotMapper.insertSelective(allot);
		return new ResultMsg(true, "成功。");
	}

	@RequestMapping(value = "/addOrders", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg addSale(Orders orders) {
		Phone phone = new Phone();
		phone.setId(orders.getId());
		phone.setAmount(0);
		phone.setSalePrice(orders.getBillPrice());
		phone.setIsSold(true);
		orders.setId(null);
		orders.setPhoneId(phone.getId());
		phoneMapper.updateByPrimaryKeySelective(phone);
		ordersMapper.insertSelective(orders);
		return new ResultMsg(true, "成功。");
	}

}
