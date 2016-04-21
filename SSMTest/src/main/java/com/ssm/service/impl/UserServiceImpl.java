package com.ssm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.bean.User;
import com.ssm.dao.UserMapper;
import com.ssm.service.UserService;

/**
 *
 *
 * @author siping-L.J.H
 * @date 2016年3月15日上午11:01:58
 * @version 1.0
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	@Override
	public User getUserById(int userId) {
		return this.userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public int getCount(String temp, String tempID) throws Exception {
		int cityCount = userMapper.getCountByCity(temp);
		int areaCount = userMapper.getCountByArea(temp);
		Map<String, Object> map = new HashMap<String, Object>();
		if (cityCount == 0 && tempID.substring(4).equals("00")) {
			map.put("cityID", tempID);
			map.put("city", temp);
			map.put("father", tempID.substring(0, 2) + "0000");
			try {
				userMapper.insertCity(map);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(tempID + "   存在重复ID!");
			}
			throw new Exception(temp + "不存在，已添加至数据库！");
		} else if (cityCount == 0 && areaCount == 0
				&& !tempID.substring(4).equals("00")) {
			map.put("areaID", tempID);
			map.put("area", temp);
			map.put("father", tempID.substring(0, 4) + "00");
			try {
				userMapper.insertArea(map);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(tempID + "   存在重复ID!");
			}
			throw new Exception(temp + "不存在，已添加至数据库！");
		} else if (cityCount == 1) {
			userMapper.updateCity(temp);
			return 1;
		} else if (cityCount > 1) {
			List<User> list = userMapper.getProvinceListByCity(temp);
			List<String> name = new ArrayList<String>();
			String fatherID = tempID.substring(0, 4) + "00";

			for (int i = 0; i < list.size(); i++) {
				if (fatherID.equals(list.get(i).getPassword())) {
					map.put("father", fatherID);
					map.put("city", temp);
					userMapper.updateCityIsExist(map);
					throw new Exception(temp + "存在多个，确实位于该省："
							+ list.get(i).getUserName() + " "
							+ list.get(i).getPassword());
				} else {
					name.add(list.get(i).getUserName());
				}
			}
			throw new Exception(temp + "存在多个，分别位于省：" + name.toString());
		} else if (areaCount == 1) {
			userMapper.updateArea(temp);
			return 1;
		} else if (areaCount > 1) {
			List<User> list = userMapper.getCityListByArea(temp);
			List<String> name = new ArrayList<String>();
			String fatherID = tempID.substring(0, 4) + "00";
			for (int i = 0; i < list.size(); i++) {
				if (fatherID.equals(list.get(i).getPassword())) {
					map.put("father", fatherID);
					map.put("area", temp);
					userMapper.updateAreaIsExist(map);
					throw new Exception(temp + "存在多个，确实位于该市："
							+ list.get(i).getUserName() + " "
							+ list.get(i).getPassword());
				} else {
					name.add(list.get(i).getUserName());
				}
			}
			throw new Exception(temp + "存在多个，分别位于市：" + name.toString());
		}
		return 0;
	}

	@Override
	public void insertData(String temp, String tempId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (tempId.substring(2).equals("0000")) {
				map.put("provinceId", tempId);
				map.put("province", temp);
				userMapper.insertProvince1(map);
				return;
			} else if (tempId.substring(4).equals("00")) {
				map.put("cityId", tempId);
				map.put("city", temp);
				map.put("parentId", tempId.substring(0, 2) + "0000");
				userMapper.insertCity1(map);
				return;
			} else if (!tempId.substring(4).equals("00")) {
				map.put("areaId", tempId);
				map.put("area", temp);
				map.put("parentId", tempId.substring(0, 4) + "00");
				userMapper.insertArea1(map);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("失败！");
		}

	}
}
