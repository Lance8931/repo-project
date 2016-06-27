<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>成都高新区人力资源产业园 后台管理</title>
    <#include "../common/base.ftl"/>
    <#include "../common/table.ftl"/>

    <@js src="js/siping/admin/article/article-intro.js" />
    <@js charset="utf-8" src="js/UEditor/ueditor.config.js" />
    <@js charset="utf-8" src="js/UEditor/ueditor.all.js" />
    <@js charset="utf-8" src="js/UEditor/lang/zh-cn/zh-cn.js" />
</head>
<body>
    <br />
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12">
                <div class="tabbable" id="tabs-intro">
                    <ul class="nav nav-tabs">
                        <#if type == 'park-info'>
                            <li class="active">
                                <a href="#" data-toggle="tab" data-type="201">园区简介</a>
                            </li>
                            <li>
                                <a href="#" data-toggle="tab" data-type="202">园区风貌</a>
                            </li>
                            <li>
                                <a href="#" data-toggle="tab" data-type="203">地理区位</a>
                            </li>
                            <li>
                                <a href="#" data-toggle="tab" data-type="204">园区管理机构</a>
                            </li>
                            <li>
                                <a href="#" data-toggle="tab" data-type="205">园区导引</a>
                            </li>
                        <#elseif type == 'org-incoming'>
                            <li class="active">
                                <a href="#" data-toggle="tab" data-type="301">入区优势</a>
                            </li>
                            <li>
                                <a href="#" data-toggle="tab" data-type="302">入区政策</a>
                            </li>
                            <li>
                                <a href="#" data-toggle="tab" data-type="303">入区指南</a>
                            </li>
                            <li>
                                <a href="#" data-toggle="tab" data-type="304">入驻企业</a>
                            </li>
                        <#elseif type == 'innovative'>
                            <li class="active">
                                <a href="#" data-toggle="tab" data-type="401">创新创业优势</a>
                            </li>
                            <li>
                                <a href="#" data-toggle="tab" data-type="402">优惠政策</a>
                            </li>
                            <li>
                                <a href="#" data-toggle="tab" data-type="403">创新创业指南</a>
                            </li>
                        <#elseif type == 'oversea-innovative'>
                            <li class="active">
                                <a href="#" data-toggle="tab">园区动态</a>
                            </li>
                            <li>
                                <a href="#" data-toggle="tab">行业资讯</a>
                            </li>
                            <li>
                                <a href="#" data-toggle="tab">媒体关注</a>
                            </li>
                        </#if>
                        
                    </ul>
                    <br />
                    <div class="tab-content">
                        <input type="text" style="display:none" id="hiddenIntroArticleId" />
                        <div class="form-group">
                            <div class="col-lg-offset-2 col-lg-8">
                              <script id="editor" type="text/plain" style="height:500px;"></script>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-offset-2 col-lg-2">
                              <button type="button" class="btn btn-default" onClick="update()">提交</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>