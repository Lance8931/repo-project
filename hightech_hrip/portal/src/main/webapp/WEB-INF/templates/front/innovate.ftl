<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>园区概况</title>
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
        <h3>创新创业</h3>
        <ul id="nav">
            <li class="active"><a href="#article-1">创新创业优势</a></li>
            <li><a href="#article-2">优惠政策</a></li>
            <li><a href="#article-3">创新创业指南</a></li>
        </ul>
    </aside>
    <article id="article" class="wrap pull-right">
        <section id="article-1">
            <h1>创新创业优势</h1>

        </section>
        <section id="article-2">
            <h1>优惠政策</h1>

        </section>
        <section id="article-3">
            <h1>创新创业指南</h1>

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
    
    var rootPath = '<@url value="/"/>';
    function createUrl(path) {
        return encodeURI(rootPath + path);
    }
    $(function(){
        $.getJSON(createUrl('article/getIntroContentList?type=innovate'),
                function(results){
                    for(var result in results){
                        if(result == '401'){
                            $("#article-1").append(results[result]);
                        }
                        if(result == '402'){
                            $("#article-2").append(results[result]);
                        }
                        if(result == '403'){
                            $("#article-3").append(results[result]);
                        }
                    }
                }
        );
    });
</script>
</body>
</html>