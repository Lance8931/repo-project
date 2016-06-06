<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户登录</title>
    <link rel = "Shortcut Icon" href="">
    <@css href="css/bootstrap/bootstrap.min.css" />
    <@css href="css/font-awesome.min.css" />
    <@css href="css/about.css" />
    <@css href="css/index-1.css" />
    <@css href="css/login.css" />
</head>
<body>
<#include "../front/header.ftl"/>

<section id="login">
    <div class="head">
        <h4>登录</h4>
        <a href="<@url value='/user/register' />">没有账号？马上注册 ></a>
    </div>
    <form class="form" action="#" method="post">
        <div class="type">
            <ul>
                <li>用户类型</li>
                <li>
                    <label>
                    <input type="radio" name="radiobutton" value="radiobutton" />个人
                    </label>
                </li>
                <li>
                    <label>
                        <input type="radio" name="radiobutton" value="radiobutton" />企业
                    </label>
                </li>
                <li>
                    <label>
                        <input type="radio" name="radiobutton" value="radiobutton" />服务机构
                    </label>
                </li>
            </ul>
        </div>
        <div class="form-group has-feedback">
            <div>
                <input type="text" class="form-control input" id="username" name="username" placeholder="用户名" autofocus>
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
        </div>
        <div class="form-group has-feedback">
            <div>
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                <input type="password" class="form-control input" id="password" name="password" placeholder="密码">
            </div>
        </div>
        <a href="#" class="login">登 录</a>
    </form>

</section>

<section id="footer" class="panel">
    <p>©2016 中国成都人力资源服务产业园 | 蜀ICP备10048374号 ｜ 蜀公网安备11010102123456号</p>
</section>
<@js src="js/jquery/jquery-1.10.2.js" />
<@js src="js/bootstrap/bootstrap.min.js" />
<script>
    $('#header li').mouseover(function(){
        $(this).find('.child-menu').show();
    });
    $('#header li .child-menu').mouseout(function(){
        $(this).hide();
    });

    $('#header li').mouseover(function(){
        $(this).find('.child-menu').addClass('margin-top');
    });
    $('#header li').mouseout(function(){
        $(this).find('.child-menu').removeClass('margin-top');
    });
    $('#header li.active').mouseout(function(){
        $(this).find('.child-menu').addClass('margin-top');
    });

    $('article').hide();
    $('article').find('.show').show();

    /*scroll to top*/
    $(".to-top").click(function () {
        $('html, body').animate({ scrollTop: 0 }, 400);
        return false;
    });
</script>
</body>
</html>