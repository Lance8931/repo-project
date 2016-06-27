package com.siping.domain.common;

import java.io.Serializable;

public final class PagePath implements Serializable {

    private static final long serialVersionUID = 8957070956245738627L;

    /** 后台登录界面 */
    public static final String ADMIN_LOGIN = "user/admin/login";
    /** 前台登录界面 */
    public static final String FRONT_LOGIN = "user/login";
    /** 后台首页 **/
    public static final String ADMIN_INDEX = "user/admin/index";
    /** 角色页面 **/
    public static final String ADMIN_ROLE = "user/role/listRole";
    /** 菜单页面 **/
    public static final String ADMIN_MENU = "user/role/listMenu";
    /** 角色添加页面 **/
    public static final String ADMIN_ROLE_ADD = "user/role/addRole";
    /** 角色修改页面 **/
    public static final String ADMIN_ROLE_EDIT = "user/role/editRole";
    /** 显示角色组页面---权限页面跳转 */
    public static final String ADMIN_ROLE_LIST = "user/permission/listRoles";
    /** 权限页面 **/
    public static final String ADMIN_PERMISSION = "user/permission/listPermission";
    /** 前台首页 */
    public static final String WELCOME = "front/index";
    /** 关于我们 */
    public static final String ABOUT_US = "front/aboutUs";
    /** 园区概况 */
    public static final String ABOUT_PARK = "front/aboutPark";
    /** 企业入园 */
    public static final String GET_IN_PARK = "front/getInPark";
    /** 创新创业 */
    public static final String INNOVATE = "front/innovate";
    /** 最新资讯 */
    public static final String LATEST_NEWS = "front/latestNews";
    /** 通知公告 */
    public static final String NOTIFICATION = "front/notification";
    /** 个人用户列表 */
    public static final String LIST_PERSONAL_USER = "user/personal/listPersonalUser";
    /** 添加个人用户 */
    public static final String ADD_PERSONAL_USER = "user/personal/addPersonalUser";
    /** 修改个人用户 */
    public static final String EDIT_PERSONAL_USER = "user/personal/editPersonalUser";
    /** 个人用户详情 */
    public static final String VIEW_PERSONAL_USER = "user/personal/viewPersonalUser";
    /** 企业用户列表 */
    public static final String LIST_ORG_USER = "user/org/listOrgUser";
    /** 添加企业用户 */
    public static final String ADD_ORG_USER = "user/org/addOrgUser";
    /** 修改企业用户 */
    public static final String EDIT_ORG_USER = "user/org/editOrgUser";
    /** 企业用户详情 */
    public static final String VIEW_ORG_USER = "user/org/viewOrgUser";
    /** 入住企业用户列表 */
    public static final String LIST_ENTERPRISE_USER = "user/enterprise/listEnterpriseUser";
    /** 入住添加企业用户 */
    public static final String ADD_ENTERPRISE_USER = "user/enterprise/addEnterpriseUser";
    /** 入住修改企业用户 */
    public static final String EDIT_ENTERPRISE_USER = "user/enterprise/editEnterpriseUser";
    /** 入住企业用户详情 */
    public static final String VIEW_ENTERPRISE_USER = "user/enterprise/viewEnterpriseUser";
    /** 入住企业 */
    public static final String APPLY_ENTERPRISE_USER = "user/enterprise/apply";
    /** 单位用户列表 */
    public static final String LIST_EMP_USER = "user/emp/listEmpUser";
    /** 添加单位用户 */
    public static final String ADD_EMP_USER = "user/emp/addEmpUser";
    /** 修改单位用户 */
    public static final String EDIT_EMP_USER = "user/emp/editEmpUser";
    /** 单位用户详情 */
    public static final String VIEW_EMP_USER = "user/emp/viewEmpUser";
    /** 修改密码 */
    public static final String UPDATEPASSWORD_USER = "user/admin/updatePassword";
    /** 找回密码 */
    public static final String SEEKPASSWORD_USER = "user/admin/seekPassWrod";
    /** 注册用户 */
    public static final String REGISTERED_USER = "user/registered";
    /** 文章添加 */
    public static final String ARTICLE_ADD = "article/addArticle";
    /** 文章修改 */
    public static final String ARTICLE_EDIT = "article/editArticle";
    /** 文章列表 */
    public static final String ARTICLE_LIST = "article/listArticle";
    /** 文章预览 */
    public static final String ARTICLE_PREVIEW = "article/previewArticle";
    /** 文章头部页面 */
    public static final String ARTICLE_HEAD = "article/headArticle";
    /** 介绍性说明文页面 */
    public static final String ARTICLE_INTRO = "article/introArticle";
    /** 个人用户列表 */
    public static final String USER_PERSONAL_LIST = "user/personal/listPersonalUser";
    /** 个人用户添加页面 */
    public static final String USER_PERSONAL_ADD = "user/personal/addPersonalUser";
    /** 个人用户编辑页面 */
    public static final String USER_PERSONAL_EDIT = "user/personal/editPersonalUser";
    /** 个人用户查看页面 */
    public static final String USER_PERSONAL_VIEW = "user/personal/viewPersonalUser";
    /** 首页幻灯片列表页面 */
    public static final String SLIDEPIC_LIST = "/user/slide/listSlide";
    /** 首页幻灯片列表页面 */
    public static final String SLIDEPIC_ADD = "/user/slide/uploadSlide";
    /** 首页幻灯片轮播页面 */
    public static final String SLIDEPIC_PREVIEW = "/user/slide/previewSlide";
    /** 报表页面 */
    public static final String REPORT_EMPLOYMENT = "/user/report/employment";
}
