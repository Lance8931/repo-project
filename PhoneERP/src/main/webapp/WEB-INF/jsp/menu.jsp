<%@ page language="java" pageEncoding="utf-8"%>  
<!DOCTYPE html>
<html>
	<head>
		<title>手机店ERP</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<script type="text/javascript" src="../resources/jquery-2.2.1.min.js" charset="utf-8" ></script>
		<script type="text/javascript" src="../resources/jquery.form.js" charset="utf-8" ></script>
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
	<!--  --><form id="phone_import_form" method="post" enctype="multipart/form-data">
		<input type="file" name="importExcel" />
		<button type="button" onclick="tijiao()">导入</button>
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
			
			$("#phone_import_form").ajaxSubmit({
				url:'../phone/valiPhones',
				success:function(result){
					if(result.success){
						$("#phone_import_form").ajaxSubmit({
							url:'../phone/importPhones',
							success:function(result){
								if(result.success){
									alert(result.msg);
								}
							}
						});
					}else{
						alert(result.msg);
					}
				},
				error: function(){
					alert("系统发生异常。");
				}
			});
		}
	</script>
</body>
</html>
