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
	<h2>采购管理</h2>
	<div class="easyui-layout" fit='true'>
		<div data-options="region:'north',title:'查询条件',split:true" style="height:80px;">
			<form id="queryForm" method="post">
				<table >
		    		<tr>
		    			<td width="150px" align="right">采购单号(发货单号):</td>
		    			<td><input class="easyui-textbox" type="text" style="width:150px;" name="purNo" ></input></td>
		    			<td width="150px" align="right">发货单位:</td>
		    			<td><input class="easyui-textbox" type="text" style="width:150px;" name="supplierId" ></input></td>
		    			<td width="150px" align="right">收货单位:</td>
		    			<td><input class="easyui-textbox" type="text" style="width:150px;" name="shopId" ></input></td>
		    			<td width="150px" align="right">手机串号:</td>
		    			<td><input class="easyui-textbox" type="text" style="width:150px;" name="imeiNo" ></input></td>
		    			<td width="150px" align="right">采购日期(发货日期):</td>
		    			<td>
		    				<input  type="text" class="easyui-datebox" editable="false" prompt="开始时间" name="startTime"></input>
		    				至
		    				<input  type="text" class="easyui-datebox" editable="false" prompt="结束时间" name="endTime"></input>  
						</td>
		    			<td >
		    				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:80px" onclick="query()">查询</a>
		    			</td>
		    		</tr>
		    	</table>
			</form>
		</div>
		<div data-options="region:'center',title:'查询结果'">
			<table id="dg" title="采购单列表" class="easyui-datagrid" style="height:250px"
		            url="" toolbar="#toolbar"
		            rownumbers="true" fitColumns="true" singleSelect="true">
		        <thead>
		            <tr>
		                <th field="salerName" width="50px">采购单号(发货单号)</th>
		                <th field="salerName" width="50px">采购日期(发货日期)</th>
		                <th field="salerName" width="50px">发货单位</th>
		                <th field="salerName" width="50px">收货单位</th>
		                <th field="salerName" width="50px">备注</th>
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
			    			<td><input class="easyui-textbox" type="text" required="required" style="width:150px;" name="salerName" ></input></td>
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
				<table id="dg1" class="easyui-datagrid" style="width:700px;height:auto"
			            data-options="
			                iconCls: 'icon-edit',
			                singleSelect: true,
			                toolbar: '#tb',
			                url: '../resources/json/datagrid_data1.json',
			                method: 'get',
			                onClickCell: onClickCell,
			                onEndEdit: onEndEdit
			            ">
			        <thead>
			            <tr>
			                <th data-options="field:'itemid',width:80,editor:'textbox'">手机串号</th>
			                <th data-options="field:''">牌子</th>
			                <th data-options="field:''">颜色</th>
			                <th data-options="field:''">型号</th>
			                <th data-options="field:'productid',width:100,
			                        formatter:function(value,row){
			                            return row.productname;
			                        },
			                        editor:{
			                            type:'combobox',
			                            options:{
			                                valueField:'productid',
			                                textField:'productname',
			                                method:'get',
			                                url:'../resources/json/products.json',
			                                required:true
			                            }
			                        }">Product</th>
			                <th data-options="field:'listprice',width:80,align:'right',editor:{type:'numberbox',options:{precision:1}}">List Price</th>
			                <th data-options="field:'unitcost',width:80,align:'right',editor:'numberbox'">Unit Cost</th>
			                <th data-options="field:'attr1',width:250,editor:'textbox'">Attribute</th>
			                <th data-options="field:'status',width:60,align:'center',editor:{type:'checkbox',options:{on:'P',off:''}}">Status</th>
			            </tr>
			        </thead>
			    </table>
			    <div id="tb" style="height:auto">
			        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append()">Append</a>
			        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">Remove</a>
			        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="accept()">Accept</a>
			        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:true" onclick="reject()">Reject</a>
			        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="getChanges()">GetChanges</a>
			    </div>
			</div>
		</div>
    </div>
    
    
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveSaler()" style="width:90px">Save</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
    </div>
    <script type="text/javascript">
        var url;
        function newPur(){
            $('#dlg').dialog('open').dialog('center').dialog('setTitle','新增采购单');
            $('#fm').form('clear');
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
        
        var editIndex = undefined;
        function endEditing(){
            if (editIndex == undefined){return true}
            if ($('#dg1').datagrid('validateRow', editIndex)){
                $('#dg1').datagrid('endEdit', editIndex);
                editIndex = undefined;
                return true;
            } else {
                return false;
            }
        }
        function onClickCell(index, field){
            if (editIndex != index){
                if (endEditing()){
                    $('#dg1').datagrid('selectRow', index)
                            .datagrid('beginEdit', index);
                    var ed = $('#dg1').datagrid('getEditor', {index:index,field:field});
                    if (ed){
                        ($(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target)).focus();
                    }
                    editIndex = index;
                } else {
                    setTimeout(function(){
                        $('#dg1').datagrid('selectRow', editIndex);
                    },0);
                }
            }
        }
        function onEndEdit(index, row){
            var ed = $(this).datagrid('getEditor', {
                index: index,
                field: 'productid'
            });
            row.productname = $(ed.target).combobox('getText');
        }
        function append(){
            if (endEditing()){
                $('#dg1').datagrid('appendRow',{status:'P'});
                editIndex = $('#dg').datagrid('getRows').length-1;
                $('#dg1').datagrid('selectRow', editIndex)
                        .datagrid('beginEdit', editIndex);
            }
        }
        function removeit(){
            if (editIndex == undefined){return}
            $('#dg1').datagrid('cancelEdit', editIndex)
                    .datagrid('deleteRow', editIndex);
            editIndex = undefined;
        }
        function accept(){
            if (endEditing()){
                $('#dg1').datagrid('acceptChanges');
            }
        }
        function reject(){
            $('#dg1').datagrid('rejectChanges');
            editIndex = undefined;
        }
        function getChanges(){
            var rows = $('#dg1').datagrid('getChanges');
            alert(rows.length+' rows are changed!');
        }
    </script>
</body>
</html>
