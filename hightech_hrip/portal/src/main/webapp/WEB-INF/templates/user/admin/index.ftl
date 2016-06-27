<#setting number_format=",###.##">
<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>成都高新区人力资源产业园 后台管理</title>
    <script type="text/javascript">
        var rootPath = '<@url value="/"/>',staticPath = '<@static />',uploadPath = '<@fstatic />';
        function createUrl(path) {
            return encodeURI(rootPath + path);
        }
        function uploadUrl(path){
            return encodeURI(uploadPath + path);
        }
    </script>
    <#include "../../common/bui.ftl"/>
    <@js src="js/siping/admin/index.js" />
</head>
<body id="_body">
  <div class="header">
    <div class="dl-title">
        <span class="lp-title-port"><img src="<@static value='/imgs/about-logo.png' />" /></span>&nbsp;&nbsp;<span class="dl-title-text">成都高新区人力资源产业园系统后台管理</span>
    </div>
    <div class="dl-log">欢迎您，<span class="dl-log-user">${loguser.username}</span>
        <a href="<@url value='/user/admin/logout'/>" title="退出系统" class="dl-log-quit">
            <button type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
            </button>
        </a>
    </div>
  </div>
   <div class="content">
    <div class="dl-main-nav">
      <ul id="J_Nav" class="nav-list ks-clear">
        <li class="nav-item dl-selected"><div class="nav-item-inner"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> 个人中心</div></li>
        <li class="nav-item"><div class="nav-item-inner"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> 业务菜单</div></li>
        <li class="nav-item"><div class="nav-item-inner"><span class="glyphicon glyphicon-th" aria-hidden="true"></span> 报表</div></li>
      </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten"></ul>
   </div>
</body>
</html>