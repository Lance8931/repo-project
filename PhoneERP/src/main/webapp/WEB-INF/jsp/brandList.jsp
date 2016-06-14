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
	</head>
<body>
	
	<h2>手机牌子管理</h2>
	<a href="../admin/showMenu">返回菜单</a>
	<br />
	<br />
	<div class="easyui-layout" fit='true'>
		<div data-options="region:'north',title:'查询条件',split:true" style="height:80px;">
			<form id="queryForm" method="post">
				<table >
		    		<tr>
		    			<td width="150px" align="right">手机牌子:</td>
		    			<td><input class="easyui-textbox" type="text" style="width:150px;" name="brandName" ></input></td>
		    			<td >
		    				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:80px" onclick="query()">查询</a>
		    			</td>
		    		</tr>
		    	</table>
			</form>
		</div>
		<div data-options="region:'center',title:'查询结果'">
			<table id="dg" title="手机牌子列表" class="easyui-datagrid" style="height:300px"
		            url="getBrandList" toolbar="#toolbar"
		            rownumbers="true" fitColumns="true" singleSelect="true">
		        <thead>
		            <tr>
		                <th field="brandName" width="50px">手机牌子</th>
		            </tr>
		        </thead>
		    </table>
		    <div id="toolbar">
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newBrand()">新增手机牌子</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editBrand()">编辑手机牌子</a>
		    </div>
		</div>
	</div>
	
    <div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons">
        <form id="fm" method="post" novalidate>
        	<table >
	    		<tr>
	    			<td width="80px" align="right">手机牌子:</td>
	    			<td>
	    				<input class="easyui-textbox" type="text" required="required" style="width:150px;" name="brandName" ></input>
	    			</td>
	    		</tr>
	    	</table>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveBrand()" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
    </div>
    <script type="text/javascript">
        var url;
        function newBrand(){
            $('#dlg').dialog('open').dialog('center').dialog('setTitle','新增手机牌子');
            $('#fm').form('clear');
            url = 'addBrand';
        }
        function editBrand(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $('#dlg').dialog('open').dialog('center').dialog('setTitle','编辑手机牌子');
                $.getJSON(
                	'getBrand',
                	{id:row.id},
                	function(data){
                		$('#fm').form('load',data);
                });
                url = 'editBrand?id='+row.id;
            }
        }
        function saveBrand(){
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
        
        function query(){
        	$('#dg').datagrid('load',$('#queryForm').form('serialize'))
        }
    </script>
</body>
</html>
