<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>成都高新区人力资源产业园 后台管理</title> 
<#include "../../common/base.ftl"/>
<@js src="js/bootstrap/bootstrapValidator.js"/>
<@js src="js/siping/admin/user/updatePassword.js" />
<@js src="js/jquery/jquery.form.js" />
</head>
<body onkeydown="if(event.keyCode==13){return false}">
    <div>
        <ol class="breadcrumb">
            <li><a>系统管理</a></li>
            <li class="active">修改密码</li>
        </ol>
    </div>
    
    <form id="updatePassWordForm" action="<@url value='/admin/user/updatePassword' />" 
        class="form-horizontal" target="id_iframe" method="POST">
   <div class="form-group">
      <label for="firstname" class="col-sm-2 control-label">旧密码</label>
      <div class="col-sm-5">
         <input type="password" class="form-control"  id="oldPassWord" name="oldPassWord"
            placeholder="请输入现在使用的密码"/>
      </div>
   </div>
   <div class="form-group">
      <label for="firstname" class="col-sm-2 control-label">新密码</label>
      <div class="col-sm-5">
         <input type="password" class="form-control"  id="passWord" name="passWord"
            placeholder="请输入新密码"/>
      </div>
   </div>
   <div class="form-group">
      <label for="firstname" class="col-sm-2 control-label">确认密码</label>
      <div class="col-sm-5">
         <input type="password" class="form-control"  id="qpassWord" name="qpassWord"
            placeholder="确认新密码"/>
      </div>
   </div>
   <div class="form-group">
      <div class="col-sm-offset-2 col-sm-5">
         <button  type="button" onclick="save();" class="btn btn-success btn-block">确认</button>
      </div>
   </div>
</form>
<iframe id="id_iframe" name="id_iframe" style="display:none;"></iframe>
</body>
</html>