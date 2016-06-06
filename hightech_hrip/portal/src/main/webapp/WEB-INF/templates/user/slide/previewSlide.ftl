<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>成都高新区人力资源产业园 后台管理</title> 
    <#include "../../common/base.ftl"/> 
    <#include "../../common/table.ftl"/> 
    <@css href="css/index-1.css" />
    <@css href="css/font-awesome.min.css" />
    <@js src="js/jquery/responsiveslides.min.js" />
    <@js src="js/jquery/jquery.scrollify.min.js" />
    <@js src="js/jquery/jquery.easing.min.js" />
    <@js src="js/jquery/move.js" />
    <@js src="js/siping/admin/user/slide-preview.js" />
</head>
<body>
    <!--  
    <div>
        <ol class="breadcrumb">
            <li><a href="">用户设置</a></li>
            <li><a href="<@url value='/slidePic/list/page' />">首页幻灯片</a></li>
            <li class="active">幻灯片预览</li>
        </ol>
    </div>
    
    <div id="playBox">
    <div class="pre"></div>
    <div class="next"></div>
    <div class="smalltitle">
      <ul id='previewUl'>
        <li class="thistitle"></li>
      </ul>
    </div>
    <ul id="homeImageChg" class="oUlplay"> </ul>
  </div>
  -->
  <section id="slide" class="panel" style="width:1115px; height: 575px;">
    <div class="logo">
        <a href="javascript:;"><img src="<@static value='/imgs/logo.png'/>" class="img-responsive"></a>
    </div>
    <div class="change">
       <a href="#">EN</a>
    </div>
    <ul class="rslides" id='slide_ul'>
    
    </ul>
    <a class="next-section" href="#news"><i class="fa fa-angle-down"></i></a>
</section>
</body>
</html>