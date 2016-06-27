<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>成都高新区人力资源产业园 后台管理</title> 
<#include "../../common/base.ftl"/>
<#include "../../common/table.ftl"/>
<@js src="js/siping/admin/user/menu-list.js" />
</head>
<body  onkeydown="if(event.keyCode==13){return false}">
     <input type="text" id="groupId" name="groupId" style="display: none" value="${groupId}" />
    <div class="container-fluid">
        <table id="listMenu" >
        </table>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-8">
            <button  type="button" onclick="save();" class="btn btn-success btn-block">提交</button>
            </div>
      </div>
    </div>
</body>
</html>