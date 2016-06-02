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
	</head>
<body>
	<h2>供应商管理</h2>
	<a href="../admin/showMenu">返回菜单</a>
	<br />
	<br />
	<div class="easyui-layout" fit='true'>
		<div data-options="region:'north',title:'查询条件',split:true" style="height:80px;">
			<form id="queryForm" method="post">
				<table >
		    		<tr>
		    			<td width="150px" align="right">供应商(批发商)名称:</td>
		    			<td><input class="easyui-textbox" type="text" style="width:150px;" name="supplierName" ></input></td>
		    			<td width="150px" align="right">供应商(批发商)地址:</td>
		    			<td><input class="easyui-textbox" type="text" style="width:150px;" name="supplierAddress" ></input></td>
		    			<td >
		    				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:80px" onclick="query()">查询</a>
		    			</td>
		    		</tr>
		    	</table>
			</form>
		</div>
		<div data-options="region:'center',title:'查询结果'">
			<table id="dg" title="供应商列表" class="easyui-datagrid" style="height:250px"
		            url="getSupplierList" toolbar="#toolbar"
		            rownumbers="true" fitColumns="true" singleSelect="true">
		        <thead>
		            <tr>
		                <th field="supplierName" width="50px">供应商名称</th>
		                <th field="supplierAddress" width="50px">供应商地址</th>
		            </tr>
		        </thead>
		    </table>
		    <div id="toolbar">
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newSupplier()">新增供应商</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editSupplier()">编辑供应商</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroySupplier()">删除供应商</a>
		    </div>
		</div>
	</div>
	
    <div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons">
        <form id="fm" method="post" novalidate>
        	<table >
	    		<tr>
	    			<td width="80px" align="right">供应商名称:</td>
	    			<td><input class="easyui-textbox" type="text" required="required" style="width:150px;" name="supplierName" ></input></td>
	    		</tr>
	    		<tr>
	    			<td width="80px" align="right">供应商地址:</td>
	    			<td><input class="easyui-textbox" type="text" required="required" style="width:150px;" name="supplierAddress" ></input></td>
	    		</tr>
	    	</table>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveSupplier()" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
    </div>
    <script type="text/javascript">
        var url;
        function newSupplier(){
            $('#dlg').dialog('open').dialog('center').dialog('setTitle','新增供应商');
            $('#fm').form('clear');
            url = 'addSupplier';
        }
        function editSupplier(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $('#dlg').dialog('open').dialog('center').dialog('setTitle','编辑供应商');
                $.getJSON(
                	'getSupplier',
                	{id:row.id},
                	function(data){
                		$('#fm').form('load',data);
                });
                url = 'editSupplier?id='+row.id;
            }
        }
        function saveSupplier(){
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
        function destroySupplier(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $.messager.confirm('Confirm','确定要删除该店铺？',function(r){
                    if (r){
                        $.post('removeSupplier',{id:row.id},function(result){
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
