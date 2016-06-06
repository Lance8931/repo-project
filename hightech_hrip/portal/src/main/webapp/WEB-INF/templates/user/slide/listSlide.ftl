<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>成都高新区人力资源产业园 后台管理</title> 
    <#include "../../common/base.ftl"/> 
    <#include "../../common/table.ftl"/> 
    <@js src="js/laydate/laydate.js" /> 
    <@js src="js/siping/admin/user/slide-list.js" /> 
</head>
<body>
    <div>
        <ol class="breadcrumb">
            <li><a href="">业务菜单</a></li>
            <li><a href="#">设置</a></li>
            <li class="active">首页幻灯片</li>
        </ol>
    </div>
    <div class="container-fluid">
        <div id="slide_toolbar" class="btn-group">
            <button type="button" class="btn btn-default" id='add' onclick="add();" title="添加">
                <i class="glyphicon glyphicon-plus"></i>
            </button>
            <button type="button" class="btn btn-default" id='edit' onclick="updateMulti(0);" disabled="disabled" title="禁用">
                  <i class="glyphicon glyphicon-ban-circle"></i>
            </button>
            <button type="button" class="btn btn-default" id='delete' onclick="deleteSlide();" disabled="disabled" title="删除">
                <i class="glyphicon glyphicon-trash"></i>
            </button>
            <div class="btn-group col-sm" style="padding:0px 20px 0px 20px">
                <button type="button" class="btn btn-default" onclick="preview();" title="预览">
                    <span class="glyphicon glyphicon-list-alt" aria-hidden="true"> 预览</span> 
                </button>
            </div>
            <div class="btn-group col-sm">
                <select id="enabled" class="form-control" onchange="enabledChg(this.value);">
                    <option value="1">启用</option>
                    <option value="0">禁用</option>
               </select>    
            </div>
        </div>
        <table id="slideList" data-toolbar="slide_toolbar" data-show-refresh="true" data-show-columns="true" data-minimum-count-columns="2" data-pagination="true" data-id-field="id"
            data-page-list="[5, 10, 50, 80]" data-show-footer="false" data-side-pagination="server">
        </table>
    </div>
    <img id="previewImg" style="width: 100%; height: 60%; display: none" src="" alt="">
</body>
</html>