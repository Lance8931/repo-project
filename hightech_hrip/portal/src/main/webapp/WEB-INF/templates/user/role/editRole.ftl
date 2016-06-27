<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>成都高新区人力资源产业园 后台管理</title> 
<#include "../../common/base.ftl"/> 
<@js src="js/bootstrap/bootstrapValidator.js"/> 
<@js src="js/siping/admin/user/role-add.js" /> 
<@js src="js/jquery/jquery.form.js" />
</head>
<body onkeydown="if(event.keyCode==13){return false}">
        <form id="editRoleForm" action="<@url value='/permission/role/updateRole' />" class="form-horizontal" target="id_iframe" method="POST">
        <br/>
        <br/>
        <br/>
        <br/>
        <input name="id" style="display: none" value="${role.id}"/>
            <div class="form-group">
                <label for="firstname" class="col-sm-3 control-label">组名</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="groupName" name="groupName" value="${role.groupName}" placeholder="请输入组名" />
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-3 control-label">描述</label>
                <div class="col-sm-5">
                    <input type="text" maxlength="10" class="form-control" name="description"  value="${role.description}" id="description" placeholder="请输入描述" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-5">
                    <button type="button" onclick="save();" class="btn btn-success btn-block">修改</button>
                </div>
            </div>
        </form>
    <iframe id="id_iframe" name="id_iframe" style="display: none;"></iframe>
</body>
</html>