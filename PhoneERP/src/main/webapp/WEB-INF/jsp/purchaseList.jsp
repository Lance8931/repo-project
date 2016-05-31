<%@ page language="java" pageEncoding="utf-8"%>  
<!DOCTYPE html>
<html>
	<head>
		<title>采购管理</title>
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
	<h2>采购管理</h2>
	<a href="../admin/showMenu">返回菜单</a>
	<br />
	<br />
	<div class="easyui-layout" fit='true'>
		<div data-options="region:'north',title:'查询条件',split:true" style="height:120px;">
			<form id="queryForm" method="post">
				<table >
		    		<tr>
		    			<td width="120px" align="right">采购单号(发货单号):</td>
		    			<td><input class="easyui-textbox" type="text" style="width:120px;" name="purNo" ></input></td>
		    			<td width="120px" align="right">供应商:</td>
		    			<td><input class="easyui-combobox" type="text" style="width:120px;" id="fmccSupplier" name="supplierId" ></input></td>
		    			<td width="120px" align="right">收货单位:</td>
		    			<td><input class="easyui-combobox" type="text" style="width:120px;" id="fmccShop" name="shopId" ></input></td>
		    			<td width="120px" align="right">手机串号:</td>
		    			<td><input class="easyui-textbox" type="text" style="width:120px;" name="imeiNo" ></input></td>
		    		</tr>
		    		<tr>	
		    			<td width="120px" align="right">采购日期(发货日期):</td>
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
			<table id="dg" title="采购单列表" class="easyui-datagrid" style="height:250px"
		            url="../purchase/getPurList" pagination="true"
		            rownumbers="true" fitColumns="true" singleSelect="true">
		        <thead>
		            <tr>
		                <th data-options="field:'purNo',width:'120px'">采购单号(发货单号)</th>
		                <th data-options="field:'imeiNo',width:'120px'">手机串号</th>
		                <th data-options="field:'purTime',width:'120px'">采购日期(发货日期)</th>
		                <th data-options="field:'supplier.supplierName',width:'120px'">发货单位</th>
		                <th data-options="field:'shop.shopName',width:'120px'">收货单位</th>
		                <th data-options="field:'remark',width:'120px'">备注</th>
		            </tr>
		        </thead>
		    </table>
		</div>
	</div>
	
    <script type="text/javascript">
        $(function(){
        	$.getJSON("getShopList",
  				  function(result){
		      			$('#fmccShop').combobox({
		        			valueField:'id',
		        			textField:'shopName',
		        			data:result.rows
		        		});
  		});
    		$.getJSON("getSupplierList",
				  function(result){
		      			$('#fmccSupplier').combobox({
		        			valueField:'id',
		        			textField:'supplierName',
		        			data:result.rows
		        		});
			});
        });
        
        function query(){
        	$('#dg').datagrid('load',$('#queryForm').form('serialize'))
        }
        
        function reset(){
			$("#queryForm").form('reset');
		}
    </script>
</body>
</html>
