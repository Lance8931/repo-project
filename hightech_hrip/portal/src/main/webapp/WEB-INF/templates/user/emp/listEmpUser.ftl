<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>成都高新区人力资源产业园 后台管理</title>
    <#include "../../common/base.ftl"/>
    <#include "../../common/table.ftl"/>
    <@js src="js/siping/admin/user/personal-user.js" />
</head>
<body>
    <div>
        <ol class="breadcrumb">
            <li><a>系统管理</a></li>
            <li><a href="#">单位用户</a></li>
            <li class="active">用户列表</li>
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
            <select class="form-control">
                <option>启用</option>
                <option>禁用</option>
            </select>
        </div>
    </div>
    <div class="container-fluid">
        <div id="user_toolbar" class="btn-group">
            <button type="button" class="btn btn-default">
                <i class="glyphicon glyphicon-plus"></i>
            </button>
            <button type="button" class="btn btn-default">
                <i class="glyphicon glyphicon-heart"></i>
            </button>
            <button type="button" class="btn btn-default">
                <i class="glyphicon glyphicon-trash"></i>
            </button>
        </div>
        <table id="empUserList"
           data-toolbar="#user_toolbar"
           data-show-refresh="true"
           data-show-columns="true"
           data-minimum-count-columns="2"
           data-pagination="true"
           data-id-field="id"
           data-page-list="[10, 25, 50, 80]"
           data-show-footer="false"
           data-side-pagination="server">
        </table>
    </div>
</body>
</html>