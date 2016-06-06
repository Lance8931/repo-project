<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>成都高新区人力资源产业园 后台管理</title>
<#include "../../common/base.ftl"/>
<@js src="js/bootstrap/bootstrapValidator.js"/>
<@js src="js/siping/admin/user/seekPassword.js" />
<@js src="js/jquery/jquery.form.js" />
</head>
<body  onkeydown="if(event.keyCode==13){return false}">
	<div>
		<ol class="breadcrumb">
			<li><a>系统管理</a></li>
			<li class="active">修改密码</li>
		</ol>
	</div>


	<form id="seekPassWordForm" class="form-horizontal" target="id_iframe">
		<div class="form-group" id="userNameDiv">
			<label for="firstname" class="col-sm-2 control-label">用户名</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="userName"
					name="userName" placeholder="请输入用户名" />
			</div>
		</div>
		<div id="updatePwd" style="display: none">
			<div class="form-group" >
				<label for="firstname" class="col-sm-2 control-label">密保问题</label>
				<div class="col-sm-5">
					<input type="text" readonly="readonly" class="form-control"
						id="psdQuestion" name="psdQuestion" placeholder="密保问题" />
				</div>
			</div>
			<div class="form-group">
				<label for="firstname" class="col-sm-2 control-label">问题答案</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" id="psdAnswer"
						name="psdAnswer" placeholder="请输入密保问题的答案" />
				</div>
			</div>
			<div class="form-group">
				<label for="firstname" class="col-sm-2 control-label">新密码</label>
				<div class="col-sm-5">
					<input type="password" class="form-control" id="passWord"
						name="passWord" placeholder="请输入新密码" />
				</div>
			</div>
			<div class="form-group">
				<label for="firstname" class="col-sm-2 control-label">确认密码</label>
				<div class="col-sm-5">
					<input type="password" class="form-control" id="pwdHash" name="pwdHash"
						placeholder="请再次输入新密码" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-5" id="getPsdQuestion">
				<button onclick="getQuestion();" class="btn btn-success btn-block">确认</button>
			</div>
			<div class="col-sm-offset-2 col-sm-5" id="updatePassWord"
				style="display: none">
				<button type="button" onclick="savePassWrod();"
					class="btn btn-success btn-block">确认</button>
			</div>
		</div>
	<input type="text" id="userType" name="userType" style="display:none;">
	</form>
	<iframe id="id_iframe" name="id_iframe" style="display: none;"></iframe>
</body>
</html>