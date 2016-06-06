<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>成都高新区人力资源产业园 后台管理</title>
    <#include "../common/base.ftl"/>
    <#include "../common/table.ftl"/>

    <#if type==1>
        <@js src="js/siping/admin/article/article-inform.js" />
    <#else>
        <@js src="js/siping/admin/article/article-head-news.js" />
    </#if>
</head>
<body>
    <br />
    <#if type==1>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span12">
                    <div class="tabbable" id="tabs-1">
                        <ul class="nav nav-tabs">
                            <li class="active">
                                <a href="#panel-1" data-toggle="tab">通知</a>
                            </li>
                            <li>
                                <a href="#panel-2" data-toggle="tab">公告</a>
                            </li>
                        </ul>
                        <br />
                        <div class="tab-content">
                            <div class="tab-pane active" id="panel-1">
                                <#include "informArticle.ftl"/>
                            </div>
                            <div class="tab-pane fade" id="panel-2">
                                <#include "announcementAtricle.ftl"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    <#else>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span12">
                    <div class="tabbable" id="tabs-news">
                        <ul class="nav nav-tabs">
                            <li class="active">
                                <a href="#" data-toggle="tab" data-type="101">园区动态</a>
                            </li>
                            <li>
                                <a href="#" data-toggle="tab" data-type="102">行业资讯</a>
                            </li>
                            <li>
                                <a href="#" data-toggle="tab" data-type="103">媒体关注</a>
                            </li>
                        </ul>
                        <br />
                        <div class="tab-content">
                            <#include "tableListArticle.ftl" />
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </#if>
</body>
</html>