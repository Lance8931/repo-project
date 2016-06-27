package com.siping.hrip.portal.user.controller;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.Map;

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
import com.siping.domain.portal.entity.UserOrgInfo;
import com.siping.hrip.portal.user.service.UserOrgService;

/**
 * 招聘企业用户action
 * @author yangxu
 *
 */
@Controller
@RequestMapping(value = "/userOrg")
public class UserOrgController extends StromaController {
    @Autowired
    private UserOrgService orgService;

    /**
     * 添加企业信息--跳转页面
     * @return 
     */
    @RequestMapping(value = "/add/page", method = RequestMethod.GET)
    public String addOrg() {
        return PagePath.ADD_ORG_USER;
    }
    
    /**
     * 修改企业信息--跳转页面
     * @param org
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/edit/page", method = {RequestMethod.POST,RequestMethod.GET})
    public String editOrg(UserOrgInfo org, ModelMap modelMap){
        try {
            modelMap.put("org", orgService.getUserOrg(org));
        } catch (Exception e) {
            e.printStackTrace();
            return "跳转失败，请稍后再试";
        }
        return PagePath.EDIT_ORG_USER;
    }
    
    /**
     * 获取详细信息--页面
     * @param org
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/view/page", method = {RequestMethod.POST,RequestMethod.GET})
    public String viewOrg(UserOrgInfo org, ModelMap modelMap){
        try {
            modelMap.put("org", orgService.getUserOrg(org));
        } catch (Exception e) {
            e.printStackTrace();
            return "跳转失败，请稍后再试";
        }
        return PagePath.VIEW_ORG_USER;
    }
    
    /**
     * 添加企业用户信息
     * @param licenseImage 营业执照图片
     * @param org 招聘企业信息
     * @param logoImage 公司logo图片
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg addOrg(@RequestParam(value="licenseImage", required=false) MultipartFile licenseImage,
            UserOrgInfo org, @RequestParam(value="logoImage" , required=false) MultipartFile logoImage) {
        try {
            return orgService.addOrg(org, licenseImage, logoImage);
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
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public ResultMsg deleteUserOrg(String[] userNames) {
        try {
            return orgService.deleteUserOrg(userNames);
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
    }
    
    /**
     * 修改企业信息
     * @return
     */
    @RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ResultMsg updateOrg(UserOrgInfo org, @RequestParam(value="licenseImage", required=false)MultipartFile licenseImage,
            @RequestParam(value="logoImage" , required=false) MultipartFile logoImage) {
        try {
            return orgService.updateOrg(org, licenseImage, logoImage);
        } catch(CannotGetJdbcConnectionException ex){
            ex.printStackTrace();
            return new ResultMsg(false, "数据库连接失败");  
        } catch(SQLException ex){
            ex.printStackTrace();
            return new ResultMsg(false, "修改失败，请检查输入参数");  
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(false, "删除失败，请稍后再试");
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
    public PageResponse<UserOrgInfo> getAllOrg(HttpServletRequest request, UserOrgInfo org ,PageRequest pageRequest) {
        try {
            return orgService.getAllOrg(request, org, pageRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    @RequestMapping(value = "/type/list", method = RequestMethod.GET)
    @ResponseBody
    public Map<BigInteger, String> getOrgType() {
        try {
            return orgService.getOrgType();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
