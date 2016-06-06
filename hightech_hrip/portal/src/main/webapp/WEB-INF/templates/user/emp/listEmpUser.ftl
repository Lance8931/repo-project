<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>成都高新区人力资源产业园 后台管理</title> 
<#include "../../common/base.ftl"/>
<#include "../../common/table.ftl"/>
<@js src="js/siping/admin/user/employee-listUser.js" />
</head>
<body  onkeydown="if(event.keyCode==13){return false}">
	<div>
		<ol class="breadcrumb">
			<li><a>系统管理</a></li>
			<li><a href="<@url value='/view/user/emp/list' />">单位用户</a></li>
			<li class="active">用户列表</li>
		</ol>
	</div>
	<div class="container-fluid">
		<div class="col-lg-3">
			<div class="input-group">
				<input id="querys" type="text" class="form-control"
					placeholder="输入用户名、用户编号、姓名关键字"> <span
					class="input-group-btn">
					<button class="btn btn-default" type="button" onclick="refresh();">
						<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					</button>
				</span>
			</div>
		</div>
		<div class="col-lg-2">
			<select id="enabled" class="form-control" onchange="refresh();">
				<option value="1">启用</option>
				<option value="0">禁用</option>
			</select>
		</div>
	</div>
	<div class="container-fluid">
		<div id="toolbar" class="btn-group">
			<a href="<@url value='/view/user/emp/add' />"><button title="添加" type="button" id="add" class="btn btn-default" >
				<i class="glyphicon glyphicon-plus"></i>
			</button></a>
			<a><button title="编辑" onclick="editHr();" type="button" id="edit" class="btn btn-default">
				<i class="glyphicon glyphicon-pencil"></i>
			</button></a>
			<a><button title="删除" type="button" onclick="deleteHr();" id="delete" class="btn btn-default">
				<i class="glyphicon glyphicon-trash"></i>
			</button></a>
			<a><button type="button" title="重置密码" onclick="resetPassWord();" id="resetPassWord" class="btn btn-default">
				<i class="glyphicon glyphicon-lock"></i>
			</button></a>
		</div>
		<table id="empUserList" >
		</table>
	</div>
</body>
</html>