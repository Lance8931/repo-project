package com.phoneerp.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phoneerp.bean.Result;
import com.phoneerp.bean.ResultMsg;
import com.phoneerp.bean.Saler;
import com.phoneerp.bean.Shop;
import com.phoneerp.bean.Supplier;
import com.phoneerp.dao.SalerMapper;
import com.phoneerp.dao.ShopMapper;
import com.phoneerp.dao.SupplierMapper;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年5月12日下午4:01:52
 * @version 1.0
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ShopMapper shopMapper;

	@Autowired
	private SupplierMapper supplierMapper;

	@Autowired
	private SalerMapper salerMapper;

	@RequestMapping("/showMenu")
	public String showMenu() {
		return "menu";
	}

	@RequestMapping("/showSupplier")
	public String showSupplier() {
		return "supplierList";
	}

	@RequestMapping("/showShop")
	public String showShop() {
		return "shopList";
	}

	@RequestMapping("/showPhone")
	public String showPhone() {
		return "phoneList";
	}

	@RequestMapping("/showAllot")
	public String showAllot() {
		return "allotList";
	}

	@RequestMapping("/showOrder")
	public String showOrder() {
		return "orderList";
	}

	@RequestMapping("/showInventory")
	public String showInventory() {
		return "inventoryList";
	}

	@RequestMapping("/showProfit")
	public String showProfit() {
		return "menu";
	}

	@RequestMapping("/showRowEdit")
	public String showRowEdit() {
		return "rowEditing";

	}

	@RequestMapping("/showPur")
	public String showPurchase() {
		return "purchaseList";
	}

	@RequestMapping("/showSaler")
	public String showSaler() {
		return "salerList";
	}

	public List<Result> getBrand() {
		return null;
	}

	@RequestMapping(value = "/getShopList", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public Map<String, Object> getShopList(Shop shop) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("shop", shop);
		map.put("rows", shopMapper.getList(paramMap));
		return map;
	}

	@RequestMapping(value = "/getShop", method = RequestMethod.GET)
	@ResponseBody
	public Shop getShop(int id) {
		return shopMapper.selectByPrimaryKey(id);
	}

	@RequestMapping(value = "/addShop", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg addShop(Shop shop) {
		shop.setCreateTime(new Date());
		shopMapper.insert(shop);
		return new ResultMsg(true, "添加成功。");
	}

	@RequestMapping(value = "/editShop", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg editShop(Shop shop) {
		shopMapper.updateByPrimaryKeySelective(shop);
		return new ResultMsg(true, "编辑成功。");
	}

	@RequestMapping(value = "/removeShop", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg removeShop(int id) {
		shopMapper.deleteByPrimaryKey(id);
		return new ResultMsg(true, "删除成功。");
	}

	@RequestMapping(value = "/getSupplierList", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public Map<String, Object> getSupplierList(Supplier supplier) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("supplier", supplier);
		map.put("rows", supplierMapper.getList(paramMap));
		return map;
	}

	@RequestMapping(value = "/getSupplier", method = RequestMethod.GET)
	@ResponseBody
	public Supplier getSupplier(int id) {
		return supplierMapper.selectByPrimaryKey(id);
	}

	@RequestMapping(value = "/addSupplier", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg addSupplier(Supplier supplier) {
		supplier.setCreateTime(new Date());
		supplierMapper.insert(supplier);
		return new ResultMsg(true, "添加成功。");
	}

	@RequestMapping(value = "/editSupplier", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg editSupplier(Supplier supplier) {
		supplierMapper.updateByPrimaryKeySelective(supplier);
		return new ResultMsg(true, "编辑成功。");
	}

	@RequestMapping(value = "/removeSupplier", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg removeSupplier(int id) {
		supplierMapper.deleteByPrimaryKey(id);
		return new ResultMsg(true, "删除成功。");
	}

	@RequestMapping(value = "/getSalerList", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public Map<String, Object> getSalerList(Saler saler) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("saler", saler);
		map.put("rows", salerMapper.getList(paramMap));
		return map;
	}

	@RequestMapping(value = "/getSaler", method = RequestMethod.GET)
	@ResponseBody
	public Saler getSaler(int id) {
		return salerMapper.selectByPrimaryKey(id);
	}

	@RequestMapping(value = "/addSaler", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg addSaler(Saler saler) {
		saler.setCreateTime(new Date());
		salerMapper.insert(saler);
		return new ResultMsg(true, "添加成功。");
	}

	@RequestMapping(value = "/editSaler", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg editSaler(Saler saler) {
		salerMapper.updateByPrimaryKeySelective(saler);
		return new ResultMsg(true, "编辑成功。");
	}

	@RequestMapping(value = "/removeSaler", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg removeSaler(int id) {
		salerMapper.deleteByPrimaryKey(id);
		return new ResultMsg(true, "删除成功。");
	}

}
