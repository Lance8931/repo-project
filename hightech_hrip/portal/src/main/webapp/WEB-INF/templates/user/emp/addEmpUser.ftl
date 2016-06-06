<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>成都高新区人力资源产业园 后台管理</title> 
<#include "../../common/base.ftl"/>
<@js src="js/bootstrap/bootstrapValidator.js"/>
<@js src="js/siping/admin/user/employee-addUser.js" />
<@js src="js/jquery/jquery.form.js" />
</head>
<body  onkeydown="if(event.keyCode==13){return false}">
    <div>
        <ol class="breadcrumb">
            <li><a>系统管理</a></li>
            <li><a href="<@url value='/view/user/emp/list' />">单位用户</a></li>
            <li class="active">用户添加</li>
        </ol>
    </div>
    
    
    <form id="employeeForm" action="<@url value='/admin/hrEmployee/add' />" class="form-horizontal" target="id_iframe" method="POST">
   <div class="form-group">
      <label for="firstname" class="col-sm-2 control-label">用户名</label>
      <div class="col-sm-5">
         <input type="text" class="form-control"  id="userName" name="userName"
            placeholder="请输入用户名"/>
      </div>
   </div>
   <div class="form-group">
      <label for="lastname" class="col-sm-2 control-label">用户编号</label>
      <div class="col-sm-5">
         <input type="text" maxlength="10" class="form-control" name="empNo" id="empNo"
            placeholder="请输入用户编号"/>
      </div>
   </div>
   <div class="form-group">
      <label for="lastname" class="col-sm-2 control-label">员工姓名</label>
      <div class="col-sm-5">
         <input type="text" class="form-control" id="empName" name="empName"
            placeholder="请输入员工姓名"/>
      </div>
   </div>
   <div class="form-group">
      <label for="lastname" class="col-sm-2 control-label">部门</label>
      <div class="col-sm-5">
         <input type="text" class="form-control" id="department" name="department"
            placeholder="请输入员工部门"/>
      </div>
   </div>
   <div class="form-group">
      <label for="lastname" class="col-sm-2 control-label">职位</label>
      <div class="col-sm-5">
         <input type="text"  class="form-control" id="position" name="position"
            placeholder="请输入职位"/>
      </div>
   </div>
   <div class="form-group">
      <label for="lastname" class="col-sm-2 control-label">联系电话</label>
      <div class="col-sm-5">
         <input type="text"  class="form-control" id="telephone" name="telephone"
            placeholder="请输入固定电话"/>
      </div>
   </div>
   <div class="form-group">
      <label for="lastname" class="col-sm-2 control-label">手机</label>
      <div class="col-sm-5">
         <input type="text"  class="form-control" id="cellphone" name="cellphone"
            placeholder="请输入手机号"/>
      </div>
   </div>
   <div class="form-group">
      <label for="lastname" class="col-sm-2 control-label">邮箱</label>
      <div class="col-sm-5">
         <input type="text" class="form-control" id="email" name="email"
            placeholder="请输入电子邮箱"/>
      </div>
   </div>
   <div class="form-group">
      <label for="lastname" class="col-sm-2 control-label">性别</label>
      <div class="col-sm-5">
        <select id="sex" name="sex" class="form-control">
            <option value="1">男</option>
            <option value="0">女</option>
        </select>
      </div>
   </div>
   <div class="form-group">
      <div class="col-sm-offset-2 col-sm-5">
         <button  type="button" onclick="save();" class="btn btn-success btn-block">提交</button>
      </div>
   </div>
</form>
<iframe id="id_iframe" name="id_iframe" style="display:none;"></iframe>
</body>
</html>