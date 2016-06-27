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
        <ul id="nav">
            <li class="active"><a href="#article-1">联系我们</a></li>
            <li><a href="#article-2">入园企业</a></li>
            <li><a href="#article-3">园区配套</a></li>
            <li><a href="#article-4">大事记</a></li>
        </ul>
    </aside>
    <article id="article" class="wrap pull-right">
        <section id="article-1">
            <h1>联系我们</h1>
            <p>这里是详细信息</p>
            <p>这里是详细信息</p>
            <p>这里是详细信息</p>
            <p>这里是详细信息</p>
            <p>这里是详细信息</p>


            <p>这里是详细信息</p>
            <p>这里是详细信息</p>
        </section>
        <section id="article-2">
            <h1>入园企业</h1>
            <p>这里是详细信息</p>
            <p>这里是详细信息</p>
            <p>这里是详细信息</p>
            <p>这里是详细信息</p>
            <p>这里是详细信息</p>
            <p>这里是详细信息</p>
            <p>这里是详细信息</p>
            <p>这里是详细信息</p>
            <p>这里是详细信息</p>
            <p>这里是详细信息</p>
        </section>
        <section id="article-3">
            <h1>园区配套</h1>
            <p>这里是详细信息</p>
            <p>这里是详细信息</p>
            <p>这里是详细信息</p>
            <p>这里是详细信息</p>
            <p>这里是详细信息</p>
            <p>这里是详细信息</p>
            <p>这里是详细信息</p>
            <p>这里是详细信息</p>
            <p>这里是详细信息</p>
            <p>这里是详细信息</p>
        </section>
        <section id="article-4">
            <h1>大事记</h1>
            <p>这里是详细信息</p>
            <p>这里是详细信息</p>
            <p>这里是详细信息</p>
            <p>这里是详细信息</p>
            <p>这里是详细信息</p>

        </section>
    </article>
</section>
<#include "footer.ftl"/>

<@js src="js/jquery/jquery-1.10.2.js" />
<@js src="js/bootstrap/bootstrap.min.js" />
<@js src="js/jquery/jquery.nav.js" />
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

   $('#aside').find('li').click(function(){
       $(this).addClass('active').siblings().removeClass('active');
   });
    $('#nav').onePageNav({
        currentClass:'active',
        scrollThreshold:'0.4'
    });

    var top = $('#footer').position().top;
    var top2 = $(window).height();
    if(top < top2 ){
        $('#aside').hide();
    }

    /*scroll to top*/
    $(".to-top").click(function () {
        $('html, body').animate({ scrollTop: 0 }, 400);
        return false;
    });
</script>
</body>
</html>