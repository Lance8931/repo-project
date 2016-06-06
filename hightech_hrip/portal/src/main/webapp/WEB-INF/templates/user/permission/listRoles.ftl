<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>成都高新区人力资源产业园 后台管理</title> 
<#include "../../common/base.ftl"/>
<#include "../../common/table.ftl"/>
<@js src="js/siping/admin/user/role-list.js" />
</head>
<body  onkeydown="if(event.keyCode==13){return false}">
    <div class="container-fluid">
        <input type="text" style="display: none" id="hrId" value="${hrId}"/>
    </div>
    <div style="padding-top:3%" class="container-fluid">
        <div id="toolbar" class="btn-group">
            <button title="添加角色组" onclick="add();" type="button" id="add" class="btn btn-default" >
                <i class="glyphicon glyphicon-plus"></i>
            </button>
            <button title="编辑" onclick="editPage();" type="button" id="edit" class="btn btn-default">
                <i class="glyphicon glyphicon-pencil"></i>
            </button>
            <button title="删除" type="button" onclick="deleteRole();" id="delete" class="btn btn-default">
                <i class="glyphicon glyphicon-trash"></i>
            </button>
        </div>
        <table id="listRole" >
        </table>
    </div>
</body>
</html>