<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>成都高新区人力资源产业园 后台管理</title>
    <#include "../../common/base.ftl"/>
    <#include "../../common/table.ftl"/>
    <@js charset="utf-8" src="js/siping/admin/user/personal-user.js" />
</head>
<body>
    <div>
        <ol class="breadcrumb">
            <li><a>系统管理</a></li>
            <li><a href="#">个人用户</a></li>
            <li class="active">列表</li>
        </ol>
    </div>
    <div class="container-fluid">
        <div class="col-lg-3">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="输入用户名、用户编号、姓名关键字">
                <span class="input-group-btn">
                    <button class="btn btn-default" type="button"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
                </span>
            </div>
        </div>
        <div class="col-lg-1">
            <select class="form-control" id="selectEnabled" onchange="search()">
                <option value="1">启用</option>
                <option value="0">禁用</option>
            </select>
        </div>
    </div>
    <div class="container-fluid">
        <div id="personal_user_toolbar" class="btn-group">
            <button type="button" class="btn btn-default" onClick="redirectAdd()">
                <i class="glyphicon glyphicon-plus"></i>
            </button>
            <button type="button" class="btn btn-default" onClick="redirectEdit()">
                <i class="glyphicon glyphicon-heart"></i>
            </button>
            <button type="button" class="btn btn-default" onClick="changeStatus('delete')">
                <i class="glyphicon glyphicon-trash"></i>
            </button>
        </div>
        <table id="personalUserList"></table>
    </div>
</body>
</html>