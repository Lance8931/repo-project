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
    /** 文章添加 */
    public static final String ARTICLE_ADD = "article/addArticle";
    /** 文章列表 */
    public static final String ARTICLE_LIST = "article/listArticle";
    /** 文章预览*/
    public static final String ARTICLE_PREVIEW = "article/previewArticle";
}
