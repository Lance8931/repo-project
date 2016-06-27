<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>成都高新区人力资源产业园 后台管理</title>
    <#include "../../common/base.ftl"/>
    <#include "../../common/table.ftl"/>
    <@js src="js/laydate/laydate.js"/>
    <@js src="js/siping/admin/user/enterprise-listUser.js"/>
</head>
<body onkeydown="if(event.keyCode==13){return false}">
    <div>
        <ol class="breadcrumb">
            <li><a href="">系统管理</a></li>
            <li><a href="<@url value='/view/user/enterprise/list' />">入住企业用户</a></li>
            <li class="active">用户列表</li>
        </ol>
    </div>
    <div class="container-fluid">
        <div class="col-sm-3">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="用户名、工商注册号、企业名称" id='orgQuerys' value=""> <span class="input-group-btn">
                    <button class="btn btn-default" type="button" onclick="refresh();">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                    </button>
                </span>
            </div>
        </div>
        <div class="btn-group col-sm" style="display: none;">
            <select id="enabled" class="form-control" onchange="refresh();">
                <option value="1">启用</option>
                <option value="0">禁用</option>
            </select>
        </div>
        <div class="btn-group col-sm" id='divProvince' style="display: none;">
            <select id="selectProvince" class="form-control" onchange="provinceChg(this);" >
                <option value="">--所属省--</option>
            </select>
        </div>
        <div class="btn-group col-sm" id="divCity" style="display: none;">
            <select id="selectCity" class="form-control" onchange="cityChg(this);">
                <option value="">--所属市--</option>
            </select>
        </div>
        <div class="btn-group col-sm" style="display: none;">
            <select id="selectCounty" class="form-control" onchange="refresh();">
                <option value="">--所属区--</option>
            </select>
        </div>
        <div class="btn-group col-sm">
            <select id=orgTypeId class="form-control" onchange="refresh();">
                <option value="">--企业类型--</option>
            </select>
        </div>
        <div class="btn-group col-sm"  style="padding-left: 20px">
            <select class="form-control" onchange="refresh();">
                <option value="">未审核</option>
                <option value="">未通过</option>
                <option value="">已通过</option>
            </select>
        </div>
    </div>

    <div class="container-fluid">
        <div id="org_toolbar" class="btn-group">
            <button type="button" class="btn btn-default" id='addOrg' onclick="addPage();" style="display: none;">
                <i class="glyphicon glyphicon-plus"></i>
            </button>
            <button type="button" class="btn btn-default" id='editOrg' onclick="editEnterprise();" disabled="disabled" style="display: none;">
                <i class="glyphicon glyphicon-pencil"></i>
            </button>
            <button type="button" class="btn btn-default" id='deleteOrg' onclick="deleteEnterprise();" disabled="disabled" style="display: none;">
                <i class="glyphicon glyphicon-trash"></i>
            </button>
        </div>
        <table id="enterpriseList"
            data-toolbar="org_toolbar" data-show-refresh="true" data-show-columns="true" data-minimum-count-columns="2" data-pagination="true" data-id-field="id"
            data-page-list="[10, 25, 50, 80]" data-show-footer="false" data-side-pagination="server">
        </table>
    </div>
    <!-- 审核弹框 -->
    <div id="review" style="display: none;margin: 5% 5% 0 5%">
        <input type="text" class="form-control" style="margin-bottom: 4%" id="explain" placeholder="审核说明，审核不通过时必须输入该项"/>
        <div class="inline-row col-sm-offset-3">
            <div class="col-sm-4">
                <button  type="button" class="btn btn-success btn-block" onclick="review();">通过</button>
            </div>
            <div class="col-sm-4">
                <button  type="button" class="btn btn-warning btn-block"onclick="review();">不通过</button>
            </div> 
        </div>
    </div>
    
</body>
</html>