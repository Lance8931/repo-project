<%@ page language="java" pageEncoding="utf-8"%>  
<!DOCTYPE html>
<html>
	<title>测试easyui组件解析</title>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link rel="stylesheet" type="text/css" href="../resources/themes/default/easyui.css">
	    <link rel="stylesheet" type="text/css" href="../resources/themes/icon.css">
	    <link rel="stylesheet" type="text/css" href="../resources/themes/color.css">
	    <script type="text/javascript" src="../resources/jquery-2.2.1.min.js" charset="utf-8" ></script>
		<script type="text/javascript" src="../resources/jquery.easyui.min.js" charset="utf-8" ></script>
		<script type="text/javascript" src="../resources/easyuiExpand.js" charset="utf-8" ></script>
		<script type="text/javascript" src="../resources/easyui-lang-zh_CN.js" charset="utf-8"></script>	
	</head>
<body>
	<button id="kkk" onclick="appendHref()" >添加a标签</button>
	<div id ="sdfsdf">
		<a href="#" class="easyui-linkbutton">Text Button</a>
	</div>
	<div id="divdd"></div>
    <script type="text/javascript">
    
    	
        function appendHref(){
    		var str = '<a id="aaaa" href="#" class="easyui-linkbutton" data-options="iconCls:\'icon-add\'" style="height:40px">添加A标签</a>';
        	$("#divdd").append(str);
        	$.parser.parse($('#divdd'));
    	}
    </script>
</body>
</html>
