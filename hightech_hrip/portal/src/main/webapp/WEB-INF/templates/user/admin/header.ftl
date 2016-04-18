<div class="header_shift_div">
    <span class="vertical_center"></span>
    <span id="shift_icon" class="glyphicon glyphicon-indent-right shift_icon header_icon_comm" aria-hidden="true" title="隐藏/显示菜单栏"></span>
    <span class="sys_title">人力资源产业园 系统后台管理</span>
</div>
<div class="header_right">
    <div class="refresh_setcut">
        <span class="vertical_center"></span>
        <a href="javascript:void(0)" onclick="refreshIframePage();"><span class="refresh_icon header_icon_comm glyphicon glyphicon-refresh" title="刷新"></span></a>
        <#-- <a href="#"><img class="shortcut_set_icon header_icon_comm" src="<@static value='/icons/apply_icon.png' />" title="设置快捷菜单"></a> -->
        <div class="s_userinfo my_radius" title="当前用户">
            <span class="vertical_center"></span>
            <button type="button" class="btn btn-default btn-sm">
                <span class="glyphicon glyphicon-user" aria-hidden="true"></span><span class="s_user_name">admin</span>
            </button>
        </div>
        <a href="javascript:void(0)" onclick="resetMyPsw();" style="margin: 0 0 0 20px;"><span class="refresh_icon header_icon_comm glyphicon glyphicon-lock" title="修改密码"></span></a>
        <a href="<@url value='/logout' />"><span class="logout_icon header_icon_comm glyphicon glyphicon-off" title="退出登录"></span></a>
    </div>
</div>