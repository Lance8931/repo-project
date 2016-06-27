<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>成都高新区人力资源产业园 后台管理</title>
    <#include "../common/base.ftl"/>
    <@js charset="utf-8" src="js/UEditor/ueditor.config.js" />
    <@js charset="utf-8" src="js/UEditor/ueditor.all.js" />
    <@js charset="utf-8" src="js/UEditor/lang/zh-cn/zh-cn.js" />
    <@js charset="utf-8" src="js/siping/admin/article/article-edit.js" />

    <@css href="css/bootstrap/fileinput.min.css"/>
    <@js src="js/jquery/jquery.form.js"/>
    <@js src="js/bootstrap/fileinput.min.js"/>
    <@js src="js/bootstrap/fileinput_locale_zh.js"/>
    <@js src="js/laydate/laydate.js" />
</head>
<body onkeydown="if(event.keyCode==13){return false;}">
    <div>
        <ol class="breadcrumb">
            <li><a>系统管理</a></li>
            <#if type == '101'>
                <li><a href="#">园区动态</a></li>
            <#elseif type == '102'>
                <li><a href="#">行业资讯</a></li>
            <#elseif type== '103'>
                <li><a href="#">媒体关注</a></li>
            </#if>
            <li class="active">编辑</li>
        </ol>
    </div>
    <form class="form-horizontal" id="article" enctype="multipart/form-data">
    <input type="text" style="display:none" id="hiddenType" value="${type}" />
      <input type="text" style="display:none" id="hiddenId" value="${id}" />
      <input type="text" style="display:none" id="hiddenPicPath" />
      <div class="form-group">
        <label for="inputTitle" class="col-lg-2 control-label">文章标题</label>
        <div class="col-lg-8">
          <input type="text" class="form-control" id="inputTitle" placeholder="请输入文章标题" >
        </div>
      </div>
      <div class="form-group">
        <label for="inputAuthor" class="col-lg-2 control-label">作者</label>
        <div class="col-lg-2">
          <input type="text" class="form-control" id="inputAuthor" placeholder="请输入作者">
        </div>
      </div>
      <div class="form-group">
        <label for="inputPubTime" class="col-lg-2 control-label">发布时间</label>
        <div class="col-lg-2">
          <input class="form-control" onclick="laydate({istime: false, format: 'YYYY-MM-DD'});" id='inputPubTime'
                    name='publishTime' placeholder="请选择出生日期" readOnly="true">
        </div>
      </div>
      <#if type == '101' || type == '102' || type == '103'>
      <div class="form-group">
        <label for="inputDisplayPosition" class="col-lg-2 control-label">显示位置</label>
        <div class="col-lg-2">
            <select class="form-control" id="inputDisplayPosition">
              <option value="1">top.1</option>
              <option value="2">top.2</option>
              <option value="3">top.3</option>
              <option value="4">top.4</option>
              <option value="5">top.5</option>
          </select>
        </div>
      </div>
      <#else>
        <div class="form-group">
        <label for="inputDisplayPosition" class="col-lg-2 control-label">显示位置</label>
        <div class="col-lg-2">
            <select class="form-control" id="inputDisplayPosition">
              <option value="1">top.1</option>
              <option value="2">top.2</option>
              <option value="3">top.3</option>
          </select>
        </div>
      </div>
      </#if>
      <div class="form-group">
        <label for="selectEnabled" class="col-lg-2 control-label">状态</label>
        <div class="col-lg-2">
          <select class="form-control" id="selectEnabled">
              <option value="1">启用</option>
              <option value="0">禁用</option>
          </select>
        </div>
      </div>
      <#if type == '101' || type == '102' || type == '103'>
      <div class="form-group">
      <label class="col-lg-2 control-label">图片</label>
        <div style="padding:0px 240px 0 230px;">
            <input id="uploadImage"  name="uploadImage" type="file" class="file-loading">
        </div>
      </div>
      </#if>
      <div class="form-group">
        <div class="col-lg-offset-2 col-lg-8">
          <script id="editor" type="text/plain" style="height:500px;"></script>
        </div>
      </div>
      <div class="form-group">
        <div class="col-lg-offset-2 col-lg-2">
          <button type="button" class="btn btn-default" onClick="edit()">保存</button>
        </div>
      </div>
    </form>
</body>
</html>