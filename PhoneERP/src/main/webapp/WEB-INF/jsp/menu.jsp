<%@ page language="java" pageEncoding="utf-8"%>  
<!DOCTYPE html>
<html>
	<head>
		<title>手机店ERP</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link rel="stylesheet" type="text/css" href="../resources/themes/default/easyui.css">
	    <link rel="stylesheet" type="text/css" href="../resources/themes/icon.css">
	    <link rel="stylesheet" type="text/css" href="../resources/themes/color.css">
		<script type="text/javascript" src="../resources/jquery-2.2.1.min.js" charset="utf-8" ></script>
		<script type="text/javascript" src="../resources/jquery.easyui.min.js" charset="utf-8" ></script>
		<script type="text/javascript" src="../resources/easyui-lang-zh_CN.js" charset="utf-8"></script>
	</head>
<body>
	<h3>基础数据</h3>
	<a href="../admin/showSupplier">供应商</a>
	<a href="../admin/showShop">店铺</a>
	<a href="../admin/showSaler">职员</a>
	<a href="../admin/showBrand">手机牌子</a>
	<a href="../admin/showColor">手机颜色</a>
	<a href="../admin/showModel">手机型号</a>
	<h3>商品</h3>
	<a href="../admin/showPhone">手机</a>
	<br /><br /><br />
	
	<form id="phone_import_form" method="post" enctype="multipart/form-data">
        <table cellpadding="5">
            <tr>
                <td><input name="importExcel" class="easyui-filebox" data-options="prompt:'请点击右侧的选择文件，选择一个文件...',width:'300px',buttonText: '选择文件'"></input></td>
            </tr>
            <tr>
                <td><a href="javascript:void(0)" class="easyui-linkbutton" onclick="tijiao()">导入</a></td>
            </tr>
        </table>
    </form>
	
	<a href="#">配件(待开发)</a>
	<h3>采购</h3>
	<a href="../admin/showPur">采购单</a>
	<h3>销售</h3>
	<a href="../admin/showOrder">销售单</a>
	<h3>调拨</h3>
	<a href="../admin/showAllot">调拨单</a>
	<h3>报表</h3>
	<a href="#">月利润</a>
	<script type="text/javascript">
		$(function(){
		});
		
		function tijiao(){
			$.messager.progress({
                title:'导入数据',
                msg:'正在验证数据。。。。。'
            });
			$("#phone_import_form").form('submit',{
				url:'../phone/valiPhones',
				success:function(result){
					$.messager.progress('close');
					result = eval('('+result+')');
					if(result.success){
						$.messager.progress({
			                title:'导入数据',
			                msg:'正在导入数据。。。。。'
			            });
						$("#phone_import_form").form('submit',{
							url:'../phone/importPhones',
							success:function(result){
								$.messager.progress('close');
								$("#phone_import_form").form('reset');
								result = eval('('+result+')');
								if(result.success){
									$.messager.alert(
			                    			'提示信息',
			                    			result.msg,
			                    			'info'
			                    	);
								}else{
									$.messager.alert(
			                    			'提示信息',
			                    			result.msg,
			                    			'info'
			                    	);
								}
							}
						});
					}else{
						$("#phone_import_form").form('reset');
						$.messager.alert(
                    			'提示信息',
                    			result.msg,
                    			'warning'
                    	);
					}
				},
				error: function(){
					$("#phone_import_form").form('reset');
					$.messager.progress('close');
					$.messager.alert(
                			'提示信息',
                			'系统发生异常',
                			'warning'
                	);
				}
			});
		}
	</script>
</body>
</html>
