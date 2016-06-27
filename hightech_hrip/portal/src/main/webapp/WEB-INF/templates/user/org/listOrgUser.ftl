<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>成都高新区人力资源产业园 后台管理</title> 
    <#include "../../common/base.ftl"/> 
    <#include "../../common/table.ftl"/> 
    <@js src="js/laydate/laydate.js" /> 
    <@js src="js/siping/admin/user/personal-userOrg.js" />
</head>
<body onkeydown="if(event.keyCode==13){return false}" >
    <div>
        <ol class="breadcrumb">
            <li><a href="">系统管理</a></li>
            <li><a href="<@url value='/view/user/org/list' />">企业用户</a></li>
            <li class="active">用户列表</li>
        </ol>
    </div>
    <div class="container-fluid">
            <div class="col-sm-3">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="用户名、工商注册号、企业名称" id='orgQuerys' value=""> <span class="input-group-btn">
                        <button class="btn btn-default" type="button">
                            <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                        </button>
                    </span>
                </div>
            </div>
            <div class="btn-group col-sm">
                <select id="enabled" class="form-control">
                    <option value="1">启用</option>
                    <option value="0">禁用</option>
                </select>
            </div>
            <div class="btn-group col-sm" id='divProvince'>
                <select id="selectProvince" class="form-control" onchange='chgOrgSelectArea(this, "province");'>
                    <option value="">--所属省--</option>
                </select>
            </div>
            <div class="btn-group col-sm" id="divCity">
                <select id="selectCity" class="form-control" onchange='chgOrgSelectArea(this, "city");'>
                    <option value="">--所属市--</option>
                </select>
            </div>
            <div class="btn-group col-sm">
                <select id="selectCounty" class="form-control">
                    <option value="">--所属区--</option>
                </select>
            </div>
            <div class="btn-group col-sm">
                <select id=orgTypeId class="form-control">
                    <option value="">--企业类型--</option>
                </select>
            </div>
    </div>

    <div class="container-fluid">
        <div id="org_toolbar" class="btn-group">
            <button type="button" class="btn btn-default" id='addOrg' onclick="addPage();">
                <i class="glyphicon glyphicon-plus"></i>
            </button>
            <button type="button" class="btn btn-default" id='editOrg' onclick="editOrg();" disabled="disabled">
                <i class="glyphicon glyphicon-pencil"></i>
            </button>
            <button type="button" class="btn btn-default" id='deleteOrg' onclick="deleteOrg();" disabled="disabled">
                <i class="glyphicon glyphicon-trash"></i>
            </button>
        </div>
        <table id="orgInfoList" data-toolbar="org_toolbar" data-show-refresh="true" data-show-columns="true" data-minimum-count-columns="2" data-pagination="true" data-id-field="id"
            data-page-list="[10, 25, 50, 80]" data-show-footer="false" data-side-pagination="server">
        </table>
    </div>
</body>
</html>