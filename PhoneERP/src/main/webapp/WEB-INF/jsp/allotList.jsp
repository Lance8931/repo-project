<%@ page language="java" pageEncoding="utf-8"%>  
<!DOCTYPE html>
<html>
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
	<h2>调拨管理</h2>
	<div class="easyui-layout" fit='true'>
		<div data-options="region:'north',title:'查询条件',split:true" style="height:120px;">
			<form id="queryForm" method="post">
				<table >
		    		<tr>
		    			<td width="120px" align="right">手机串号:</td>
		    			<td><input class="easyui-textbox" type="text" style="width:120px;" name="imeiNo" ></input></td>
		    			<td width="120px" align="right">出库店铺:</td>
		    			<td><input class="easyui-combobox" type="text" style="width:120px;" id="fmccOutShop" name="outShopId" ></input></td>
		    			<td width="120px" align="right">入库店铺:</td>
		    			<td><input class="easyui-combobox" type="text" style="width:120px;" id="fmccInShop" name="inShopId" ></input></td>
		    		</tr>
		    		<tr>	
		    			<td width="120px" align="right">调拨日期:</td>
		    			<td colspan="6">
		    				<input  type="text" class="easyui-datebox" editable="false" prompt="开始时间" name="startTime"></input>
		    				至
		    				<input  type="text" class="easyui-datebox" editable="false" prompt="结束时间" name="endTime"></input>  
		    				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:80px" onclick="query()">查询</a>
		    				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:80px" onclick="reset()">重置</a>
						</td>
		    		</tr>
		    	</table>
			</form>
		</div>
		<div data-options="region:'center',title:'查询结果'">
			<table id="dg"></table>
		</div>
	</div>
    <script type="text/javascript">
    
    	var shopDatas;
    	
        $(function(){
        	getJSONDatas();
        	initGrid();
        });
        
        function getJSONDatas(){
        	$.getJSON("getShopList",
    				  function(result){
  		      			$('#fmccInShop').combobox({
  		        			valueField:'id',
  		        			textField:'shopName',
  		        			data:result.rows
  		        		});
  		      			$('#fmccOutShop').combobox({
  		        			valueField:'id',
  		        			textField:'shopName',
  		        			data:result.rows
  		        		});
  		      			shopDatas = result.rows;
    		});
        }
        
        function initGrid(){
        	$("#dg").datagrid({
	       		url : '../allot/getAllotList',
	       		title : '调拨单列表',
	       		rownumbers : true,
	       		fitColumns : true,
	       		singleSelect : true,
	       		height : 'auto',
	       		columns:[[    
			        {field:'imeiNo',title:'手机串号',width:'120px'},
			        {field:'inShopId',title:'入库店铺',width:'120px',formatter:formatterShop}, 
			        {field:'outShopId',title:'出库店铺',width:'120px',formatter:formatterShop}, 
			        {field:'operatTime',title:'操作时间',width:'120px'}
			    ]],
			    toolbar:'#toolbar',
			    pagination: true
	       	});
        }
        
        function formatterShop(value, row){
        	for(var i = 0; i < shopDatas.length; i++){
        		if(shopDatas[i].id == value){
        			return shopDatas[i].shopName;
        		}
        	}
        	return '-';
        }
        
        function query(){
        	$('#dg').datagrid('load',$('#queryForm').form('serialize'))
        }
        
        function reset(){
			$("#queryForm").form('reset');
		}
    </script>
</body>
</html>
