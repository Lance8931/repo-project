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
	<h2>销售管理</h2>
	<a href="../admin/showMenu">返回菜单</a>
	<br />
	<br />
	<div class="easyui-layout" fit='true'>
		<div data-options="region:'north',title:'查询条件',split:true" style="height:120px;">
			<form id="queryForm" method="post">
				<table >
		    		<tr>
		    			<td width="120px" align="right">手机串号:</td>
		    			<td><input class="easyui-textbox" type="text" style="width:120px;" name="imeiNo" ></input></td>
		    			<td width="120px" align="right">发票流水号:</td>
		    			<td><input class="easyui-textbox" type="text" style="width:120px;" name="billNo" ></input></td>
		    			<td width="120px" align="right">销售员:</td>
		    			<td><input class="easyui-combobox" type="text" style="width:120px;" id="fmccSaler" name="salerId" ></input></td>
		    			<td width="120px" align="right">卖出店铺:</td>
		    			<td><input class="easyui-combobox" type="text" style="width:120px;" id="fmccShop" name="shopId" ></input></td>
		    		</tr>
		    		<tr>
		    			<td width="120px" align="right">顾客姓名:</td>
		    			<td><input class="easyui-textbox" type="text" style="width:120px;" name="buyerName" ></input></td>
		    			<td width="120px" align="right">顾客手机号:</td>
		    			<td><input class="easyui-textbox" type="text" style="width:120px;" name="buyerPhone" ></input></td>
		    			<td width="150px" align="right">销售金额:</td>
		    			<td colspan="4">
		    				<input  type="text" class="easyui-numberbox" style="width:120px;" prompt="从" name="orderStartPrice" />
		    				至
		    				<input  type="text" class="easyui-numberbox" style="width:120px;" prompt="止" name="orderEndPrice" />
		    			</td>
		    		</tr>
		    		<tr>	
		    			<td width="150px" align="right">销售日期:</td>
		    			<td colspan="4">
		    				<input  type="text" class="easyui-numberbox" style="width:120px;" prompt="从" name="orderStartTime" />
		    				至
		    				<input  type="text" class="easyui-numberbox" style="width:120px;" prompt="止" name="orderEndTime" />
		    				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:80px" onclick="query()">查询</a>
		    				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:80px" onclick="reset()">重置</a>
		    			</td>
		    		</tr>
		    	</table>
			</form>
		</div>
		<div data-options="region:'center',title:'查询结果'">
			<table id="dg" title="" class="easyui-datagrid" style="height:250px"
		            url="" pagination="true"
		            rownumbers="true" fitColumns="true" singleSelect="true">
		        <thead>
		            <tr>
		                
		            </tr>
		        </thead>
		    </table>
		</div>
	</div>
	
    <script type="text/javascript">
    var shopDatas,salerDatas;
	
    $(function(){
    	getJSONDatas();
    	initGrid();
    });
    
    function getJSONDatas(){
    	$.getJSON("getShopList",
				  function(result){
		      			$('#fmccShop').combobox({
		        			valueField:'id',
		        			textField:'shopName',
		        			data:result.rows
		        		});
		      			shopDatas = result.rows;
		});
    	$.getJSON("getSalerList",
				  function(result){
	      			$('#fmccSaler').combobox({
	        			valueField:'id',
	        			textField:'salerName',
	        			data:result.rows
	        		});
					salerDatas = result.rows;
		});
    }
    
    function initGrid(){
    	$("#dg").datagrid({
       		url : '../orders/getOrdersList',
       		title : '销售单列表',
       		rownumbers : true,
       		fitColumns : true,
       		singleSelect : true,
       		height : 'auto',
		    toolbar:'#toolbar',
		    pagination: true,
       		columns:[[    
       		    {field:'billNo',title:'发票流水号',width:'120px'},
		        {field:'imeiNo',title:'手机串号',width:'120px'},
		        {field:'orderTime',title:'销售日期',width:'120px'}, 
		        {field:'salerId',title:'销售员',width:'120px',formatter:formatterSaler}, 
		        {field:'shopId',title:'卖出店铺',width:'120px',formatter:formatterShop}, 
		        {field:'billPrice',title:'销售金额',width:'120px'},
		        {field:'buyerName',title:'顾客姓名',width:'120px'}, 
		        {field:'buyerPhone',title:'顾客手机',width:'120px'}, 
		    ]]
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
    
    function formatterSaler(value, row){
    	for(var i = 0; i < salerDatas.length; i++){
    		if(salerDatas[i].id == value){
    			return salerDatas[i].salerName;
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
