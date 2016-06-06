<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>关于我们</title>
    <link rel = "Shortcut Icon" href="">
    <#include "../common/base.ftl"/>
    <@css href="css/bootstrap/bootstrap.min.css" />
    <@css href="css/font-awesome.min.css" />
    <@css href="css/about.css" />
    <@css href="css/index-1.css" />
    <@css href="css/gonggao.css" />
    <@css href="css/dongtai.css" />
    <@js src="js/jquery/jquery-1.10.2.js" />
    <@js src="js/bootstrap/bootstrap.min.js" />
    <@js src="js/siping/front/latestNews.js" />
</head>
<body>
<#include "header.ftl"/>

<section id="main">
    <nav>
        <ul class="nav-box">
            <li id="xwdt" class="xwdt active">
                <a href="javascript:;">园区动态</a>
                <i></i>
            </li>
            <li id="hyzx" class="hyzx">
                <a href="javascript:;">行业资讯</a>
                <i></i>
            </li>
            <li id="mtgz" class="mtgz">
                <a href="javascript:;">媒体关注</a>
                <i></i>
            </li>
        </ul>
    </nav>
    <article id="new-notice">
        <ul class="xwdt" id='xwdtContent'>
        
        </ul>
        <ul class="hyzx" id='hyzxContent'>
        
        </ul>
        <ul class="mtgz" id='mtgzContent'>
            
        </ul>
    </article>
    <nav id='new-page'>
        <ul class="pagination xwdt" id='xwdtPage'>
            
        </ul>
        <ul class="pagination hyzx" id='hyzxPage'>
            
        </ul>
        <ul class="pagination mtgz" id='mtgzPage'>
            
        </ul>
    </nav>
</section>
<#include "footer.ftl"/>
</body>
</html>