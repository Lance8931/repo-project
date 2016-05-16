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
	<h2>手机管理</h2>
	<div class="easyui-layout" fit='true'>
		<div data-options="region:'north',title:'查询条件',split:true" style="height:150px;">
			<form id="phoneList_queryForm" method="post">
				<table >
		    		<tr>
		    			<td width="150px" align="right">手机串号:</td>
		    			<td><input class="easyui-textbox" type="text" style="width:150px;" name="" ></input></td>
		    			<td width="150px" align="right">批发商:</td>
		    			<td><input class="easyui-combobox" type="text" style="width:150px;" id="ccSupplier" name="" ></input></td>
		    			<td width="150px" align="right">手机牌子:</td>
		    			<td><input class="easyui-combobox" type="text" style="width:150px;" id="ccBrand" name="" ></input></td>
		    			<td width="150px" align="right">进货日期:</td>
		    			<td>
		    				<input  type="text" class="easyui-datebox" style="width:150px;" editable="false" prompt="开始" name="" />
		    				至
		    				<input  type="text" class="easyui-datebox" style="width:150px;" editable="false" prompt="结束" name="" />
		    			</td>
		    		</tr>
		    		<tr>
		    			<td width="150px" align="right">当前店铺:</td>
		    			<td><input class="easyui-combobox" type="text" style="width:150px;" id="ccShop" name="" ></input></td>
		    			<td width="150px" align="right">是否卖出:</td>
		    			<td><input class="easyui-combobox" type="text" style="width:150px;" name="" ></input></td>
		    			<td width="150px" align="right">销售员:</td>
		    			<td><input class="easyui-combobox" type="text" style="width:150px;" id="ccSaler" name="" ></input></td>
		    			<td width="150px" align="right">销售日期:</td>
		    			<td>
		    				<input  type="text" class="easyui-datebox" style="width:150px;" editable="false" prompt="开始" name="" />
		    				至
		    				<input  type="text" class="easyui-datebox" style="width:150px;" editable="false" prompt="结束" name="" />
		    			</td>
		    		</tr>
		    		<tr>
		    			<td width="150px" align="right">手机型号:</td>
		    			<td><input class="easyui-combobox" type="text" style="width:150px;" id="ccModel" name="" ></input></td>
		    			<td width="150px" align="right">手机颜色:</td>
		    			<td><input class="easyui-combobox" type="text" style="width:150px;" id="ccColor" name="" ></input></td>
		    			<td width="150px" align="right">进货价:</td>
		    			<td colspan="3">
		    				<input  type="text" class="easyui-numberbox" style="width:150px;" prompt="从" name="" />
		    				至
		    				<input  type="text" class="easyui-numberbox" style="width:150px;" prompt="止" name="" />
		    			</td>
		    		</tr>
		    		<tr>
		    			<td width="150px" align="right">实际销售金额:</td>
		    			<td colspan="4">
		    				<input  type="text" class="easyui-numberbox" style="width:150px;" prompt="从" name="" />
		    				至
		    				<input  type="text" class="easyui-numberbox" style="width:150px;" prompt="止" name="" />
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
		            	<th data-options="field:'code',width:100">批发商</th>
		            	<th data-options="field:'code1',width:100">进货日期</th>
		                <th data-options="field:'code2',width:100">手机串号</th>
		                <th data-options="field:'code3',width:100">手机牌子</th>
		                <th data-options="field:'code4',width:100">手机颜色</th>
		                <th data-options="field:'code5',width:100">手机型号</th>
		                <th data-options="field:'code6',width:100">数量</th>
		                <th data-options="field:'code7',width:100">进货价格</th>
		                <th data-options="field:'code8',width:100">备注</th>
		                <th data-options="field:'code9',width:100">当前所在店铺</th>
		                <th data-options="field:'code10',width:100">是否卖出</th>
		                <th data-options="field:'code11',width:100">实际销售价格</th>
		                <th data-options="field:'code12',width:100">销售员</th>
		                <th data-options="field:'code13',width:100">销售日期</th>
		            </tr>
		        </thead>
		    </table>
		    <div id="toolbar">
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newPur()">采购</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newAllot()">调拨</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newSale()">销售</a>
		    </div>
		</div>
	</div>
    <div id="dlg" class="easyui-dialog" style="width:400px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons">
        <form id="fm" method="post" novalidate>
        	<table >
	    		<tr>
	    			<td width="80px" align="right">手机串号:</td>
	    			<td><input class="easyui-textbox" required="true" missingMessage="必须填写" name="imeiNo" validType="imeiNoCheck"/></td>
	    		</tr>
	    		<tr>
	    			<td width="80px" align="right">手机牌子:</td>
	    			<td><input class="easyui-combobox" required="true" id="fmccBrand" missingMessage="必须填写" name="brandId" /></td>
	    		</tr>
	    		<tr>
	    			<td width="80px" align="right">手机颜色:</td>
	    			<td><input class="easyui-combobox" required="true" id="fmccColor" missingMessage="必须填写" name="colorId" /></td>
	    		</tr>
	    		<tr>
	    			<td width="80px" align="right">手机型号:</td>
	    			<td><input class="easyui-combobox" required="true" id="fmccModel" missingMessage="必须填写" name="modelId" /></td>
	    		</tr>
	    		<tr>
	    			<td width="80px" align="right">批发商:</td>
	    			<td><input class="easyui-combobox" required="true" id="fmccSupplier" missingMessage="必须填写" name="purchase.supplierId" /></td>
	    		</tr>
	    		<tr>
	    			<td width="80px" align="right">入库店铺:</td>
	    			<td><input class="easyui-combobox" required="true" id="fmccShop" missingMessage="必须填写" name="currentShopId" /></td>
	    		</tr>
	    		<tr>
	    			<td width="80px" align="right">进货价格:</td>
	    			<td><input class="easyui-textbox" required="true" missingMessage="必须填写" name="purPrice" /></td>
	    		</tr>
	    		<tr>
	    			<td width="80px" align="right">数量:</td>
	    			<td><input class="easyui-numberbox" required="true" missingMessage="必须填写" name="amount" /></td>
	    		</tr>                 
	    		<tr>
	    			<td width="80px" align="right">采购单号:</td>
	    			<td><input class="easyui-textbox" required="true" missingMessage="必须填写" name="purchase.purNo" /></td>
	    		</tr>
	    		<tr>
	    			<td width="80px" align="right">采购日期:</td>
	    			<td><input class="easyui-datebox" required="true" missingMessage="必须填写" name="purchase.purTime" /></td>
	    		</tr>
	    	</table>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="savePur()" style="width:90px">Save</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
    </div>
    <script type="text/javascript">
    
    	var supplierDatas,brandDatas,shopDatas,salerDatas,modelDatas,colorDatas;
    	$(function(){
    		getJSONDatas();
    	});
    	
        var url;
        function newPur(){
            $('#dlg').dialog('open').dialog('center').dialog('setTitle','添加手机');
            $('#fm').form('clear');
            $('#fmccBrand').combobox({
    			valueField:'id',
    			textField:'text',
    			data:brandDatas
    		});
            $('#fmccColor').combobox({
    			valueField:'id',
    			textField:'text',
    			data:colorDatas
    		});
            $('#fmccModel').combobox({
    			valueField:'id',
    			textField:'text',
    			data:modelDatas
    		});
            $('#fmccShop').combobox({
    			valueField:'id',
    			textField:'shopName',
    			data:shopDatas
    		});
            $('#fmccSupplier').combobox({
    			valueField:'id',
    			textField:'supplierName',
    			data:supplierDatas
    		});
            url = '../phone/add';
        }
        function editUser(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $('#dlg').dialog('open').dialog('center').dialog('setTitle','Edit User');
                $('#fm').form('load',row);
                url = 'update_user.php?id='+row.id;
            }
        }
        function savePur(){
        	var row;
        	$('#fm').form('submit',{
        		url: url,
                onSubmit: function(){
                    return $(this).form('validate');
                },
                success: function(result){
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
        
        function getJSONDatas(){
    		$.getJSON("../resources/json/brand.json",
    				  function(result){
    					$('#ccBrand').combobox({
    	        			valueField:'id',
    	        			textField:'text',
    	        			data:result
    	        		});
    					brandDatas = result;
    		});
      		$.getJSON("../resources/json/color.json",
      				  function(result){
		      			$('#ccColor').combobox({
		        			valueField:'id',
		        			textField:'text',
		        			data:result
		        		});
      					colorDatas = result;
      		});
      		$.getJSON("../resources/json/model.json",
      				  function(result){
		      			$('#ccModel').combobox({
		        			valueField:'id',
		        			textField:'text',
		        			data:result
		        		});
      					modelDatas = result;
      		});
      		$.getJSON("getShopList",
    				  function(result){
		      			$('#ccShop').combobox({
		        			valueField:'id',
		        			textField:'shopName',
		        			data:result.rows
		        		});
    					shopDatas = result.rows;
    		});
      		$.getJSON("getSupplierList",
  				  function(result){
		      			$('#ccSupplier').combobox({
		        			valueField:'id',
		        			textField:'supplierName',
		        			data:result.rows
		        		});
  						supplierDatas = result.rows;
  			});
      		$.getJSON("getSalerList",
    				  function(result){
  		      			$('#ccSaler').combobox({
  		        			valueField:'id',
  		        			textField:'salerName',
  		        			data:result.rows
  		        		});
    					salerDatas = result.rows;
    		});
    	}
    </script>
</body>
</html>
