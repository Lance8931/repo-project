<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>成都高新区人力资源产业园 后台管理</title> 
    <#include "../../common/base.ftl"/> 
    <#include "../../common/table.ftl"/> 
    <@css href="css/bootstrap/fileinput.min.css"/>
    <@js src="js/jquery/jquery.form.js"/>
    <@js src="js/bootstrap/fileinput.js"/>
    <@js src="js/bootstrap/canvas-to-blob.min.js"/>
    <@js src="js/bootstrap/fileinput_locale_zh.js"/>
    <@js src="js/siping/admin/user/slide-upload.js"/>
    <style type="text/css">
        .noImage{
            margin:0auto; 
            padding: 5% 11% 0 11%;
        }
    </style>
</head>
<body>
    <form enctype="multipart/form-data" id="uploadImageForm" method="post"
        class="form-horizontal" action="<@url value='/slidePic/image/upload'/>">
        <div class="noImage">
            <input id="uploadImage" name="uploadImage" type="file" multiple class="file-loading">
            <span class="glyphicon glyphicon-minus" style="color: #8B8682">图片支持的格式为：jpeg, jpg, png, gif, bmp, tif</span><br>
            <span class="glyphicon glyphicon-minus" style="color: #8B8682">请选择小于2M的图片</span><br>
            <span class="glyphicon glyphicon-minus" style="color: #8B8682">建议上传1080x720的图片</span><br>
            <span class="glyphicon glyphicon-minus" style="color: #8B8682">悬停提示长度应不大于15位，连接地址长度应不大于50位</span>      
        </div>
    </form>
</body>
</html>