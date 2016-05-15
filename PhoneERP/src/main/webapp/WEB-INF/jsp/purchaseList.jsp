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
		<script type="text/javascript" src="../resources/initPurDetailGrid.js" charset="utf-8" ></script>
		<script type="text/javascript" src="../resources/easyuiExpand.js" charset="utf-8" ></script>	
	</head>
<body>
	<h2>采购管理</h2>
	<div class="easyui-layout" fit='true'>
		<div data-options="region:'north',title:'查询条件',split:true" style="height:120px;">
			<form id="queryForm" method="post">
				<table >
		    		<tr>
		    			<td width="150px" align="right">采购单号(发货单号):</td>
		    			<td><input class="easyui-textbox" type="text" style="width:150px;" name="purNo" ></input></td>
		    			<td width="150px" align="right">发货单位:</td>
		    			<td><input class="easyui-textbox" type="text" style="width:150px;" name="supplier.supplierName" ></input></td>
		    			<td width="150px" align="right">收货单位:</td>
		    			<td><input class="easyui-textbox" type="text" style="width:150px;" name="shop.shopName" ></input></td>
		    			<td width="150px" align="right">手机串号:</td>
		    			<td><input class="easyui-textbox" type="text" style="width:150px;" name="imeiNo" ></input></td>
		    		</tr>
		    		<tr>	
		    			<td width="150px" align="right">采购日期(发货日期):</td>
		    			<td>
		    				<input  type="text" class="easyui-datebox" editable="false" prompt="开始时间" name="startTime"></input>
		    			</td>
		    			<td>至</td>
		    			<td width="150px" align="right">
		    				<input  type="text" class="easyui-datebox" editable="false" prompt="结束时间" name="endTime"></input>  
						</td>
		    			<td>
		    				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:80px" onclick="query()">查询</a>
		    			</td>
		    		</tr>
		    	</table>
			</form>
		</div>
		<div data-options="region:'center',title:'查询结果'">
			<table id="dg" title="采购单列表" class="easyui-datagrid" style="height:250px"
		            url="../purchase/getPurList" toolbar="#toolbar" pagination="true"
		            rownumbers="true" fitColumns="true" singleSelect="true">
		        <thead>
		            <tr>
		                <th field="salerName">采购单号(发货单号)</th>
		                <th field="salerName">采购日期(发货日期)</th>
		                <th field="salerName">发货单位</th>
		                <th field="salerName">收货单位</th>
		                <th field="salerName">备注</th>
		            </tr>
		        </thead>
		    </table>
		    <div id="toolbar">
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newPur()">新增采购单(发货单)</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editPur()">编辑采购单(发货单)</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyPur()">删除采购单(发货单)</a>
		    </div>
		</div>
	</div>
	
    <div id="dlg" class="easyui-dialog" style="width:800px;height:600px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons">
        <div class="easyui-layout" fit='true'>
			<div data-options="region:'north',title:'查询条件',split:true" style="height:100px;">
				<form id="fm" method="post" novalidate>
		        	<table >
			    		<tr>
			    			<td width="120px" align="right">采购单号(发货单号):</td>
			    			<td><input class="easyui-textbox" type="text" required="required" style="width:150px;" name="salerName" ></input></td>
			    			<td width="120px" align="right">采购日期(发货日期):</td>
			    			<td><input  type="text" class="easyui-datebox" required="required" editable="false" prompt="开始时间" name=""></input></input></td>
			    		</tr>
			    		<tr>
			    			<td width="120px" align="right">发货单位:</td>
			    			<td><input class="easyui-textbox" type="text" required="required" style="width:150px;" name="salerName" ></input></td>
			    			<td width="120px" align="right">收货单位:</td>
			    			<td><input class="easyui-textbox" type="text" required="required" style="width:150px;" name="salerName" ></input></td>
			    		</tr>
			    	</table>
		        </form>
			</div>
			<div data-options="region:'center',title:'手机列表'">
				<table id="dg1" class="easyui-datagrid" style="width:auto;height:auto">
			    </table>
			</div>
		</div>
    </div>
    
    
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="savePur()" style="width:90px">Save</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
    </div>
    <script type="text/javascript">
        var url;
        var datas;
        function newPur(){
            $('#dlg').dialog('open').dialog('center').dialog('setTitle','新增采购单');
            $('#fm').form('clear');
            initDetailGrid();
            url = 'addSaler'; 
        }
        function editPur(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $('#dlg').dialog('open').dialog('center').dialog('setTitle','编辑采购单');
                $.getJSON(
                	'getSaler',
                	{id:row.id},
                	function(data){
                		$('#fm').form('load',data);
                });
                url = 'editSaler?id='+row.id;
            }
        }
        function savePur(){
            $('#fm').form('submit',{
                url: url,
                onSubmit: function(){
                    return $(this).form('validate');
                },
                success: function(result){
                    var result = eval('('+result+')');
                    if (result.success){
                    	$.messager.alert(
                    			'提示信息',
                    			result.msg,
                    			'info',
                    			function(){
                    				$('#dlg').dialog('close'); 
                            		$('#dg').datagrid('reload');
                    			}
                    	);
                    } else {
                    	$.messager.alert(
                    			'提示信息',
                    			result.msg,
                    			'error'
                    	);
                    }
                }
            });
        }
        function destroyPur(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $.messager.confirm('Confirm','确定要删除该店铺？',function(r){
                    if (r){
                        $.post('removeSaler',{id:row.id},function(result){
                            if (result.success){
                                $('#dg').datagrid('reload');    // reload the user data
                            } else {
                                $.messager.show({    // show error message
                                    title: 'Error',
                                    msg: result.msg
                                });
                            }
                        },'json');
                    }
                });
            }
        }
        
        function query(){
        	$('#dg').datagrid('load',$('#queryForm').form('serialize'))
        }
    </script>
</body>
</html>
