package com.phoneerp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phoneerp.bean.Result;

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
	public String showPurchase() {
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

	public List<Result> getBrand() {
		return null;
	}
}
