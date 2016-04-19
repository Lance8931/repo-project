package com.siping.domain.common;

import java.io.Serializable;

public final class PagePath implements Serializable {

    private static final long serialVersionUID = 8957070956245738627L;

    /** 登录界面 */
    public static final String LOGIN_INDEX = "user/admin/login";
    /** 后台首页 **/
    public static final String ADMIN_INDEX = "user/admin/index";
    /** 前台首页 */
    public static final String WELCOME = "front/index";
    /** 个人用户列表 */
    public static final String LIST_PERSONAL_USER = "user/personal/listPersonalUser";
    /** 添加个人用户*/
    public static final String ADD_PERSONAL_USER = "user/personal/addPersonalUser";
    /** 修改个人用户 */
    public static final String EDIT_PERSONAL_USER = "user/personal/editPersonalUser";
    /** 个人用户详情 */
    public static final String VIEW_PERSONAL_USER = "user/personal/viewPersonalUser";
    /** 企业用户列表 */
    public static final String LIST_ORG_USER = "user/org/listOrgUser";
    /** 添加企业用户*/
    public static final String ADD_ORG_USER = "user/org/addOrgUser";
    /** 修改企业用户 */
    public static final String EDIT_ORG_USER = "user/org/editOrgUser";
    /** 企业用户详情 */
    public static final String VIEW_ORG_USER = "user/org/viewOrgUser";
    /** 单位用户列表 */
    public static final String LIST_EMP_USER = "user/emp/listEmpUser";
    /** 添加单位用户*/
    public static final String ADD_EMP_USER = "user/emp/addEmpUser";
    /** 修改单位用户 */
    public static final String EDIT_EMP_USER = "user/emp/editEmpUser";
    /** 单位用户详情 */
    public static final String VIEW_EMP_USER = "user/emp/viewEmpUser";
    /** 文章添加 */
    public static final String ARTICLE_ADD = "article/addArticle";
    /** 文章列表 */
    public static final String ARTICLE_LIST = "article/listArticle";
    /** 文章预览*/
    public static final String ARTICLE_PREVIEW = "article/previewArticle";
}
