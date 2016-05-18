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
			<table id="dg" ></table>
		    <div id="toolbar">
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newPur()">采购</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newAllot()">调拨</a>
		        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newOrders()">销售</a>
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
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="savePur()" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
    </div>
    
    <div id="dlgAllot" class="easyui-dialog" style="width:400px;padding:10px 20px"
            closed="true" buttons="#dlgAllot-buttons">
        <form id="fmAllot" method="post" novalidate>
        	<table >
	    		<tr>
	    			<td width="80px" align="right">手机串号:</td>
	    			<td>
	    				<input class="easyui-textbox" readonly="true" name="imeiNo"/>
	    				<input type="text" style="display:none" name="id"/>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td width="80px" align="right">出库店铺:</td>
	    			<td><input class="easyui-combobox" required="true" id="fmAllotOutShopId" missingMessage="必须填写" name="outShopId" /></td>
	    		</tr>
	    		<tr>
	    			<td width="80px" align="right">入库店铺:</td>
	    			<td><input class="easyui-combobox" required="true" id="fmAllotInShopId" missingMessage="必须填写" name="inShopId" /></td>
	    		</tr>
	    		<tr>
	    			<td width="80px" align="right">调拨日期:</td>
	    			<td><input class="easyui-datebox" required="true" missingMessage="必须填写" name="operatTime" /></td>
	    		</tr>
	    	</table>
        </form>
    </div>
    <div id="dlgAllot-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveAllot()" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlgAllot').dialog('close')" style="width:90px">Cancel</a>
    </div>
    
    <div id="dlgOrders" class="easyui-dialog" style="width:400px;padding:10px 20px"
            closed="true" buttons="#dlgOrders-buttons">
        <form id="fmOrders" method="post" novalidate>
        	<table >
	    		<tr>
	    			<td width="80px" align="right">手机串号:</td>
	    			<td>
	    				<input class="easyui-textbox" readonly="true" name="imeiNo"/>
	    				<input type="text" style="display:none" name="id"/>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td width="80px" align="right">卖出店铺:</td>
	    			<td><input class="easyui-combobox" required="true" id="fmOrdersShopId" missingMessage="必须填写" name="shopId" /></td>
	    		</tr>
	    		<tr>
	    			<td width="80px" align="right">销售员:</td>
	    			<td><input class="easyui-combobox" required="true" id="fmOrdersSalerId" missingMessage="必须填写" name="salerId" /></td>
	    		</tr>
	    		<tr>
	    			<td width="80px" align="right">销售日期:</td>
	    			<td><input class="easyui-datebox" required="true" missingMessage="必须填写" name="orderTime" /></td>
	    		</tr>
	    		<tr>
	    			<td width="80px" align="right">发票流水号:</td>
	    			<td><input class="easyui-textbox" required="true" name="billNo"/></td>
	    		</tr>
	    		<tr>
	    			<td width="80px" align="right">销售价格:</td>
	    			<td><input class="easyui-numberbox" required="true" name="billPrice"/></td>
	    		</tr>
	    		<tr>
	    			<td width="80px" align="right">顾客姓名:</td>
	    			<td><input class="easyui-textbox" required="true" name="buyerName"/></td>
	    		</tr>
	    		<tr>
	    			<td width="80px" align="right">顾客联系方式:</td>
	    			<td><input class="easyui-textbox" required="true" name="buyerPhone"/></td>
	    		</tr>
	    		<tr>
	    			<td width="80px" align="right">销售备注:</td>
	    			<td><input class="easyui-textbox" required="true" name="orderRemark"/></td>
	    		</tr>
	    	</table>
        </form>
    </div>
    <div id="dlgOrders-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveOrders()" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlgOrders').dialog('close')" style="width:90px">Cancel</a>
    </div>
    
    <script type="text/javascript">
    
	    
    
    	var supplierDatas,brandDatas,shopDatas,salerDatas,modelDatas,colorDatas;
    	$(function(){
    		getJSONDatas();
    		initGrid();
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
        
        
        function newAllot(){
        	var row = $('#dg').datagrid('getSelected');
        	if (row){
                $('#dlgAllot').dialog('open').dialog('center').dialog('setTitle','添加调拨');
                $('#fmAllot').form('clear');
                $('#fmAllot').form('load',row);
                $('#fmAllotOutShopId').combobox({
         			valueField:'id',
         			textField:'shopName',
         			data:shopDatas,
         			value:row.currentShopId,
         			readonly:true
         		});
                $('#fmAllotInShopId').combobox({
         			valueField:'id',
         			textField:'shopName',
         			data:shopDatas,
         			loadFilter:function(data){
         				var tempData=[];
         				for(var i = 0; i < data.length; i++){
         					if(data[i].id != row.currentShopId){
         						tempData.push(data[i]);
         					}
         				}
         				return tempData;
         			}
         		});
                url = '../phone/addAllot';
            }
        }
        
        function saveAllot(){
        	$('#fmAllot').form('submit',{
        		url: url,
                onSubmit: function(){
                    return $(this).form('validate');
                },
                success: function(result){
                	result = eval('('+result+')');
                	if (result.success){
                    	$.messager.alert(
                    			'提示信息',
                    			result.msg,
                    			'info',
                    			function(){
                    				$('#dlgAllot').dialog('close'); 
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
        
        function newOrders(){
	    	var row = $('#dg').datagrid('getSelected');
	    	if (row){
	            $('#dlgOrders').dialog('open').dialog('center').dialog('setTitle','添加销售');
	            $('#fmOrders').form('clear');
	            $('#fmOrders').form('load',row);
	            $('#fmOrdersShopId').combobox({
	     			valueField:'id',
	     			textField:'shopName',
	     			data:shopDatas,
	     			value:row.currentShopId,
	     			readonly:true
	     		});
	            $('#fmOrdersSalerId').combobox({
	     			valueField:'id',
	     			textField:'salerName',
	     			data:salerDatas
	     		});
	            url = '../phone/addOrders';
	        }
	    }
        
        function saveOrders(){
        	$('#fmOrders').form('submit',{
        		url: url,
                onSubmit: function(){
                    return $(this).form('validate');
                },
                success: function(result){
                	result = eval('('+result+')');
                	if (result.success){
                    	$.messager.alert(
                    			'提示信息',
                    			result.msg,
                    			'info',
                    			function(){
                    				$('#dlgOrders').dialog('close'); 
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
                	result = eval('('+result+')');
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
        
       
        
        function formatterBrand(value,row){
        	for(var i = 0; i < brandDatas.length; i++){
        		if(brandDatas[i].id == value){
        			return brandDatas[i].text;
        		}
        	}
        	return '-';
        }
        
		function formatterColor(value,row){
			for(var i = 0; i < colorDatas.length; i++){
        		if(colorDatas[i].id == value){
        			return colorDatas[i].text;
        		}
        	}
        	return '-';
		}
        
		function formatterModel(value,row){
			for(var i = 0; i < modelDatas.length; i++){
        		if(modelDatas[i].id == value){
        			return modelDatas[i].text;
        		}
        	}
        	return '-';
		}
		
		function formatterIsSold(value,row){
        	if(value){
        		return '已卖出';
        	}else{
        		return '未卖出';
        	}
		}
		
		function initGrid(){
	       	$("#dg").datagrid({
	       		url : '../phone/getPhoneList',
	       		title : '手机列表',
	       		rownumbers : true,
	       		fitColumns : true,
	       		singleSelect : true,
	       		height : 'auto',
	       		columns:[[    
			        {field:'supplier.supplierName',title:'批发商',width:'80px'},
			        {field:'purchase.purTime',title:'进货日期',width:'80px'},
			        {field:'imeiNo',title:'手机串号',width:'80px'},
			        {field:'brandId',title:'手机牌子',width:'80px',formatter:formatterBrand}, 
			        {field:'colorId',title:'手机颜色',width:'80px',formatter:formatterColor}, 
			        {field:'modelId',title:'手机型号',width:'80px',formatter:formatterModel}, 
			        {field:'amount',title:'数量',width:'80px'}, 
			        {field:'purPrice',title:'进货价格',width:'80px'}, 
			        {field:'remark',title:'备注',width:'80px'}, 
			        {field:'shop.shopName',title:'当前所在店铺',width:'80px'}, 
			        {field:'isSold',title:'是否卖出',width:'80px',formatter:formatterIsSold}, 
			        {field:'orders.billPrice',title:'实际销售价格',width:'80px'}, 
			        {field:'saler.salerName',title:'销售员',width:'80px'}, 
			        {field:'orders.orderTime',title:'销售日期',width:'80px'},     
			    ]],
			    toolbar:'#toolbar'
	       	});
	   }
    </script>
</body>
</html>
