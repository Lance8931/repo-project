<#setting number_format=",###.##">
<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>成都高新区人力资源产业园 后台管理</title>
    <@css href="css/bootstrap/bootstrap.min.css" />
    <@css href="css/common.css" />
    <@css href="css/index.css" />

    <script>
        var rootPath = '<@url value="/"/>',
            staticPath = '<@static />',
            uploadPath = '<@fstatic />';
    
        function createUrl(path) {
            return encodeURI(rootPath + path);
        }
        function uploadUrl(path){
            return encodeURI(uploadPath + path);
        }
        function createMenuUrl(icon){
            return encodeURI(staticPath + "/icons/"+icon+".png");
        }
    </script>
    <@js src="js/jquery/jquery-1.10.2.js" />
    <@js src="js/bootstrap/bootstrap.min.js" />
    <@js src="js/siping/admin/index.js" />
</head>
<body id="_body" style="width: 99.8%;">
    <div class="smart_header">
        <#include "header.ftl"/>
    </div>
    <div class="smart_main">
        <div class="left_menus" id="left_menus">
            <#include "menu.ftl"/>
        </div>
        <div class="right_main" id="right_main_page">
            <iframe name="_iframe" style="width:100%;height:100%;border:0;"></iframe>
        </div>
    </div>
</body>
</html>