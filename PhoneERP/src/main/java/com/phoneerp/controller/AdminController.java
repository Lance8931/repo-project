package com.phoneerp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phoneerp.bean.Brand;
import com.phoneerp.bean.Color;
import com.phoneerp.bean.Model;
import com.phoneerp.bean.ResultMsg;
import com.phoneerp.bean.Saler;
import com.phoneerp.bean.Shop;
import com.phoneerp.bean.Supplier;
import com.phoneerp.dao.BrandMapper;
import com.phoneerp.dao.ColorMapper;
import com.phoneerp.dao.ModelMapper;
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

	@Autowired
	private BrandMapper brandMapper;

	@Autowired
	private ColorMapper colorMapper;

	@Autowired
	private ModelMapper modelMapper;

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

	@RequestMapping("/showBrand")
	public String showBrand() {
		return "brandList";
	}

	@RequestMapping("/showColor")
	public String showColor() {
		return "colorList";
	}

	@RequestMapping("/showModel")
	public String showModel() {
		return "modelList";
	}

	@RequestMapping("/test")
	public String showTest() {
		return "test";
	}

	@RequestMapping(value = "/getShopList", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public Map<String, Object> getShopList(Shop shop) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("shop", shop);
		try {
			map.put("rows", shopMapper.getList(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return map;
	}

	@RequestMapping(value = "/getShop", method = RequestMethod.GET)
	@ResponseBody
	public Shop getShop(int id) {
		try {
			return shopMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = "/addShop", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg addShop(Shop shop) {
		try {
			shopMapper.insertSelective(shop);
			return new ResultMsg(true, "添加成功。");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMsg(false, "添加失败。");
		}
	}

	@RequestMapping(value = "/editShop", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg editShop(Shop shop) {
		try {
			shopMapper.updateByPrimaryKeySelective(shop);
			return new ResultMsg(true, "编辑成功。");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMsg(false, "编辑失败。");
		}
	}

	@RequestMapping(value = "/removeShop", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg removeShop(int id) {
		try {
			shopMapper.deleteByPrimaryKey(id);
			return new ResultMsg(true, "删除成功。");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMsg(false, "删除失败。");
		}
	}

	@RequestMapping(value = "/getSupplierList", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public Map<String, Object> getSupplierList(Supplier supplier) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("supplier", supplier);
		try {
			map.put("rows", supplierMapper.getList(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return map;
	}

	@RequestMapping(value = "/getSupplier", method = RequestMethod.GET)
	@ResponseBody
	public Supplier getSupplier(int id) {
		try {
			return supplierMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = "/addSupplier", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg addSupplier(Supplier supplier) {
		try {
			supplierMapper.insertSelective(supplier);
			return new ResultMsg(true, "添加成功。");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMsg(false, "添加失败。");
		}
	}

	@RequestMapping(value = "/editSupplier", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg editSupplier(Supplier supplier) {
		try {
			supplierMapper.updateByPrimaryKeySelective(supplier);
			return new ResultMsg(true, "编辑成功。");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMsg(false, "编辑失败。");
		}
	}

	@RequestMapping(value = "/removeSupplier", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg removeSupplier(int id) {
		try {
			supplierMapper.deleteByPrimaryKey(id);
			return new ResultMsg(true, "删除成功。");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMsg(false, "删除失败。");
		}
	}

	@RequestMapping(value = "/getSalerList", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public Map<String, Object> getSalerList(Saler saler) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("saler", saler);
		try {
			map.put("rows", salerMapper.getList(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return map;
	}

	@RequestMapping(value = "/getSaler", method = RequestMethod.GET)
	@ResponseBody
	public Saler getSaler(int id) {
		try {
			return salerMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = "/addSaler", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg addSaler(Saler saler) {
		try {
			salerMapper.insertSelective(saler);
			return new ResultMsg(true, "添加成功。");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMsg(false, "添加失败。");
		}
	}

	@RequestMapping(value = "/editSaler", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg editSaler(Saler saler) {
		try {
			salerMapper.updateByPrimaryKeySelective(saler);
			return new ResultMsg(true, "编辑成功。");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMsg(false, "编辑失败。");
		}
	}

	@RequestMapping(value = "/removeSaler", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg removeSaler(int id) {
		try {
			salerMapper.deleteByPrimaryKey(id);
			return new ResultMsg(true, "删除成功。");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMsg(false, "删除失败。");
		}
	}

	@RequestMapping(value = "/getBrandList", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public Map<String, Object> getBrandList(Brand brand) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("brand", brand);
		try {
			map.put("rows", brandMapper.getList(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return map;
	}

	@RequestMapping(value = "/getBrand", method = RequestMethod.GET)
	@ResponseBody
	public Brand getBrand(int id) {
		try {
			return brandMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = "/addBrand", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg addBrand(Brand brand) {
		try {
			brandMapper.insertSelective(brand);
			return new ResultMsg(true, "添加成功。");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMsg(false, "添加失败。");
		}
	}

	@RequestMapping(value = "/editBrand", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg editBrand(Brand brand) {
		try {
			brandMapper.updateByPrimaryKeySelective(brand);
			return new ResultMsg(true, "编辑成功。");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMsg(false, "编辑失败。");
		}
	}

	@RequestMapping(value = "/removeBrand", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg removeBrand(int id) {
		try {
			brandMapper.deleteByPrimaryKey(id);
			return new ResultMsg(true, "删除成功。");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMsg(false, "删除失败。");
		}
	}

	@RequestMapping(value = "/getColorList", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public Map<String, Object> getColorList(Color color) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("color", color);
		try {
			map.put("rows", colorMapper.getList(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return map;
	}

	@RequestMapping(value = "/getColor", method = RequestMethod.GET)
	@ResponseBody
	public Color getColor(int id) {
		try {
			return colorMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = "/addColor", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg addColor(Color color) {
		try {
			colorMapper.insertSelective(color);
			return new ResultMsg(true, "添加成功。");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMsg(false, "添加失败。");
		}
	}

	@RequestMapping(value = "/editColor", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg editColor(Color color) {
		try {
			colorMapper.updateByPrimaryKeySelective(color);
			return new ResultMsg(true, "编辑成功。");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMsg(false, "编辑失败。");
		}
	}

	@RequestMapping(value = "/removeColor", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg removeColor(int id) {
		try {
			colorMapper.deleteByPrimaryKey(id);
			return new ResultMsg(true, "删除成功。");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMsg(false, "删除失败。");
		}
	}

	// ---------------------------手机型号--------------------------
	@RequestMapping(value = "/getModelList", method = { RequestMethod.POST,
			RequestMethod.GET })
	@ResponseBody
	public Map<String, Object> getModelList(Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("model", model);
		try {
			map.put("rows", modelMapper.getList(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return map;
	}

	@RequestMapping(value = "/getModel", method = RequestMethod.GET)
	@ResponseBody
	public Model getModel(int id) {
		try {
			return modelMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = "/addModel", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg addModel(Model model) {
		try {
			modelMapper.insertSelective(model);
			return new ResultMsg(true, "添加成功。");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMsg(false, "添加失败。");
		}
	}

	@RequestMapping(value = "/editModel", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg editModel(Model model) {
		try {
			modelMapper.updateByPrimaryKeySelective(model);
			return new ResultMsg(true, "编辑成功。");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMsg(false, "编辑失败。");
		}
	}

	@RequestMapping(value = "/removeModel", method = RequestMethod.POST)
	@ResponseBody
	public ResultMsg removeModel(int id) {
		try {
			modelMapper.deleteByPrimaryKey(id);
			return new ResultMsg(true, "删除成功。");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultMsg(false, "删除失败。");
		}
	}

}
