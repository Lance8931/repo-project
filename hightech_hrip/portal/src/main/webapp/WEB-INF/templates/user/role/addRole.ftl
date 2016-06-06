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
        <form id="roleForm" action="<@url value='/permission/role/add' />" class="form-horizontal" target="id_iframe" method="POST">
        <br/>
        <br/>
        <br/>
        <br/>
            <div class="form-group">
                <label for="firstname" class="col-sm-3 control-label">组名</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" id="groupName" name="groupName" placeholder="请输入组名" />
                </div>
            </div>
            <div class="form-group">
                <label for="lastname" class="col-sm-3 control-label">描述</label>
                <div class="col-sm-5">
                    <input type="text" maxlength="10" class="form-control" name="description" id="description" placeholder="请输入描述" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-5">
                    <button type="button" onclick="add();" class="btn btn-success btn-block">提交</button>
                </div>
            </div>
        </form>
    <iframe id="id_iframe" name="id_iframe" style="display: none;"></iframe>
</body>
</html>