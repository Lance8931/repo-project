package com.siping.domain.common;

import java.io.Serializable;

public final class PagePath implements Serializable {

    private static final long serialVersionUID = 8957070956245738627L;

    /** 登录界面 */
    public static final String LOGIN_LOGIN = "login/login";
    /** 首页 **/
    public static final String INDEX_PAGE = "login/homePage";
    /** 主页 */
    public static final String WELCOME = "login/welcome";
    /** 添加文章 */
    public static final String ADD_ARTICLE = "article/addArticle";
}
