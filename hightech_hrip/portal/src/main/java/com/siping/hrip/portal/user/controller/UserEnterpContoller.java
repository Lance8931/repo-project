package com.siping.hrip.portal.user.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.stroma.framework.core.platform.web.StromaController;

import com.siping.domain.common.PagePath;
import com.siping.domain.common.ResultMsg;
import com.siping.domain.portal.entity.PageRequest;
import com.siping.domain.portal.entity.PageResponse;
import com.siping.domain.portal.entity.User;
import com.siping.domain.portal.entity.UserEnterprise;
import com.siping.hrip.portal.user.service.UserEnterpService;

/**
 * 入住企业用户action
 * @author yangxu
 *
 */
@Controller
@RequestMapping(value = "/enterprise")
public class UserEnterpContoller extends StromaController {
    @Autowired
    private UserEnterpService userEnterpService;

    /**
     * 添加企业信息--跳转页面
     * @return 
     */
    @RequestMapping(value = "/add/page", method = RequestMethod.GET)
    public String addOrg() {
        return PagePath.ADD_ENTERPRISE_USER;
    }
    
    /**
     * 入驻企业申请
     * @return 
     */
    @RequestMapping(value = "/apply/page", method = RequestMethod.GET)
    public String applay() {
        return PagePath.APPLY_ENTERPRISE_USER;
    }
    
    /**
     * 修改企业信息--跳转页面
     * @param org
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/edit/page", method = {RequestMethod.POST,RequestMethod.GET})
    public String editOrg(UserEnterprise enterprise, ModelMap modelMap){
        try {
            modelMap.put("org", userEnterpService.getUserEnterprise(enterprise));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return PagePath.EDIT_ENTERPRISE_USER;
    }
    
    /**
     * 获取详细信息--页面
     * @param org
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/view/page", method = {RequestMethod.POST,RequestMethod.GET})
    public String viewOrg(UserEnterprise enterprise, ModelMap modelMap){
        try {
            modelMap.put("org", userEnterpService.getUserEnterprise(enterprise));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return PagePath.VIEW_ENTERPRISE_USER;
    }
    
    /**
     * 添加企业用户信息
     * @param licenseImage 营业执照图片
     * @param org 招聘企业信息
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg addOrg(@RequestParam("licenseImage") MultipartFile licenseImage,UserEnterprise enterprise,User user) {
        try {
            return userEnterpService.addEnterprise(enterprise, licenseImage);
        } catch(CannotGetJdbcConnectionException ex){
            ex.printStackTrace();
            return new ResultMsg(false, "数据库连接失败");  
        } catch(SQLException ex){
            ex.printStackTrace();
            return new ResultMsg(false, "保存失败，请检查输入参数");  
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(false, "保存失败，请稍后再试");
        }
    }
    
    /**
     * 删除企业用户
     * @return
     */
    @RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ResultMsg deleteUserOrg(String[] userNames) {
        ResultMsg msg = new ResultMsg();
        try {
            msg = userEnterpService.deleteEnterprise(userNames);
        } catch(CannotGetJdbcConnectionException ex){
            ex.printStackTrace();
            return new ResultMsg(false, "数据库连接失败");  
        } catch(SQLException ex){
            ex.printStackTrace();
            return new ResultMsg(false, "删除失败");  
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(false, "删除失败，请稍后再试");
        }
        return msg;
    }
    
    /**
     * 修改企业信息
     * @return
     */
    @RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ResultMsg updateOrg(UserEnterprise enterprise, @RequestParam("licenseImage")MultipartFile file) {
        try {
            return userEnterpService.updateEnterprise(enterprise, file);
        } catch(CannotGetJdbcConnectionException ex){
            ex.printStackTrace();
            return new ResultMsg(false, "数据库连接失败");  
        } catch(SQLException ex){
            ex.printStackTrace();
            return new ResultMsg(false, "修改失败，请检查输入参数");  
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(false, "修改失败，请稍后再试");
        }
    }
    
    /**
     * 查询所有企业人用户
     * @param request
     * @param org
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public PageResponse<UserEnterprise> getAllOrg(HttpServletRequest request, UserEnterprise enterprise, PageRequest pageRequest) {
        try {
            return userEnterpService.getAllEnterprise(request, enterprise, pageRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    
}
