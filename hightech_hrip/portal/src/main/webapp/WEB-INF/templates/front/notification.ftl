<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>关于我们</title>
    <link rel = "Shortcut Icon" href="">
    <@css href="css/bootstrap/bootstrap.min.css" />
    <@css href="css/font-awesome.min.css" />
    <@css href="css/about.css" />
    <@css href="css/index-1.css" />
</head>
<body>
<#include "header.ftl"/>
<section id="main">
    <aside id="aside">
        <h3>关于我们</h3>
        <ul>
            <li class="active"><a href="#article-1">联系我们</a></li>
            <li><a href="#article-2">入园企业</a></li>
            <li><a href="#article-3">园区配套</a></li>
            <li><a href="#article-4">大事记</a></li>
        </ul>
    </aside>
    <article class="show article pull-right">
        <h1 id="article-1">联系我们</h1>
        <p>这里是联系我们信息</p>
        <h1 id="article-2">入园企业</h1>
        <p>这里展示入园企业信息</p>
        <h1 id="article-3">园区配套</h1>
        <p>这里展示园区配套信息</p>
        <h1 id="article-4">大事记</h1>
        <p>这里展示大事记</p>
    </article>
</section>
<#include "footer.ftl"/>

<@js src="js/jquery/jquery-1.10.2.js" />
<@js src="js/bootstrap/bootstrap.min.js" />
<script>

    $('#header li').mouseover(function(){
        $('.child-menu').hide();
        $(this).find('.child-menu').show();
    });
    $('#header li .child-menu').mouseout(function(){
        $(this).hide();
    });
    /*$('#header li').mouseover(function(){
        $(this).find('.child-menu').addClass('margin-top');
    });
    $('#header li').mouseout(function(){
        $(this).find('.child-menu').removeClass('margin-top');
    });
    $('#header li.active').mouseout(function(){
        $(this).find('.child-menu').addClass('margin-top');
    });*/

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