<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>成都高新区人力资源产业园 后台管理</title> 
<#include "../../common/base.ftl"/> <#include "../../common/table.ftl"/> 
<@js src="js/siping/admin/user/permission-list.js" />
</head>
<body onkeydown="if(event.keyCode==13){return false}">
    <div class="container-fluid"></div>
    <div style="padding-top: 3%" class="container-fluid">
        <div class="col-lg-3">
            <div class="input-group">
                <input id="querys" type="text" class="form-control" placeholder="输入用户名、用户编号、姓名关键字"> <span class="input-group-btn">
                    <button class="btn btn-default" type="button" onclick="refresh();">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                    </button>
                </span>
            </div>
        </div>
        <table id="listRole">
        </table>
    </div>
</body>
</html>