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
	<h2>手机管理</h2>
	<div class="easyui-layout" fit='true'>
		<div data-options="region:'north',title:'查询条件',split:true" style="height:80px;">
			<form id="phoneList_queryForm" method="post">
				<table >
		    		<tr>
		    			<td width="150px" align="right">手机串号:</td>
		    			<td><input class="easyui-textbox" type="text" style="width:150px;" name="userName" ></input></td>
		    			<td >
		    				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:80px" onclick="userList.formQuery.query()">查询</a>
		    			</td>
		    		</tr>
		    	</table>
			</form>
		</div>
		<div data-options="region:'center',title:'查询结果'">
			<table id="dg" title="手机列表" class="easyui-datagrid" style="height:250px"
		            url="" toolbar="#toolbar" pagination="true"
		            rownumbers="true" fitColumns="true" singleSelect="true">
		        <thead>
		            <tr>
		                <th field="firstname" width="50px">手机串号</th>
		                <th field="lastname" width="50px">手机牌子</th>
		                <th field="phone" width="50px">手机颜色</th>
		                <th field="phone" width="50px">手机型号</th>
		                <th field="email1" width="50px">进货价格</th>
		                <th field="email2" width="50px">建议销售价格</th>
		                <th field="email3" width="50px">是否卖出</th>
		                <th field="email4" width="50px">当前所属店铺</th>
		            </tr>
		        </thead>
		    </table>
		    <div id="toolbar">
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加手机产品</a>
		    </div>
		</div>
	</div>
    <div id="dlg" class="easyui-dialog" style="width:400px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons">
        <form id="fm" method="post" novalidate>
            <div class="fitem">
                <label>手机串号:</label>
                <input name="firstname" class="easyui-textbox" required="true" missingMessage="必须填写">
            </div>
            <div class="fitem">
                <label>手机牌子:</label>
                <input id="cc" class="easyui-combobox" name="dept" required="true" missingMessage="必须选择">
            </div>
            <div class="fitem">
                <label>手机颜色:</label>
                <input id="cc1" class="easyui-combobox" name="dept1" required="true" missingMessage="必须选择">
            </div>
            <div class="fitem">
                <label>手机型号:</label>
                <input id="cc2" class="easyui-combobox" name="dept1" required="true" missingMessage="必须选择">
            </div>
            <div class="fitem">
                <label>建议销售价格:</label>
                <input name="email" class="easyui-numberbox" min="0" max="10000" precision="2" required="true" missingMessage="必须填写0~10000之间的数字">
            </div>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">Save</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
    </div>
    <script type="text/javascript">
	    $('#cc').combobox({    
	        url:'../resources/json/brand.json',    
	        valueField:'id',    
	        textField:'text',
	        method:"GET"
	    }); 
	    $('#cc1').combobox({    
	        url:'../resources/json/color.json',    
	        valueField:'id',    
	        textField:'text',
	        method:"GET"
	    });
	    $('#cc2').combobox({    
	        url:'../resources/json/model.json',    
	        valueField:'id',    
	        textField:'text',
	        method:"GET"
	    });
        var url;
        function newUser(){
        	$.ajax({
        		url:'',
        		type:'get',
        		data:{id:1},
        		success:function(data){
        			$('#fm').form('clear');
        			$('#fm').form('load',data);
        			$('#dlg').dialog('open').dialog('center').dialog('setTitle','添加手机');
        		}
        	});
            $('#dlg').dialog('open').dialog('center').dialog('setTitle','添加手机');
            $('#fm').form('clear');
            url = 'save_user.php';
        }
        function editUser(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $('#dlg').dialog('open').dialog('center').dialog('setTitle','Edit User');
                $('#fm').form('load',row);
                url = 'update_user.php?id='+row.id;
            }
        }
        function saveUser(){
        	var row;
        	$('#fm').form('submit',{
        		onSubmit:function(param){
        			console.info(param);
        	}});
        	//$('#dg').datagrid('appendRow',{});
            /** $('#fm').form('submit',{
                url: url,
                onSubmit: function(){
                    return $(this).form('validate');
                },
                success: function(result){
                    var result = eval('('+result+')');
                    if (result.errorMsg){
                        $.messager.show({
                            title: 'Error',
                            msg: result.errorMsg
                        });
                    } else {
                        $('#dlg').dialog('close');        // close the dialog
                        $('#dg').datagrid('reload');    // reload the user data
                    }
                }
            });**/
        }
        function destroyUser(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $.messager.confirm('Confirm','Are you sure you want to destroy this user?',function(r){
                    if (r){
                        $.post('destroy_user.php',{id:row.id},function(result){
                            if (result.success){
                                $('#dg').datagrid('reload');    // reload the user data
                            } else {
                                $.messager.show({    // show error message
                                    title: 'Error',
                                    msg: result.errorMsg
                                });
                            }
                        },'json');
                    }
                });
            }
        }
    </script>
    <style type="text/css">
        #fm{
            margin:0;
            padding:10px 30px;
        }
        .ftitle{
            font-size:14px;
            font-weight:bold;
            padding:5px 0;
            margin-bottom:10px;
            border-bottom:1px solid #ccc;
        }
        .fitem{
            margin-bottom:5px;
        }
        .fitem label{
            display:inline-block;
            width:80px;
        }
    </style>
</body>
</html>
