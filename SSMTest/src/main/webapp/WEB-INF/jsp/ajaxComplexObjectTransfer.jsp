<%@ page language="java" pageEncoding="utf-8"%>  
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<script type="text/javascript" src="/SSMTest/resources/jquery-2.2.1.min.js" charset="utf-8" ></script>
	</head>
<body>
	<script type="text/javascript">
		function method1(){
			$.getJSON("/SSMTest/ajax/method1?userName=我是中国人",
					function(result){
						if(result.success){
							alert("成功.");
						}else{
							alert("失败.");
						}
			})
		}
		
		function method2(){
			$.getJSON("/SSMTest/ajax/method2?userName=我是中国人&nickName=龙的传人",
					function(result){
						if(result.success){
							alert("成功.");
						}else{
							alert("失败.");
						}
			})
		}
		
		function method3(){
			$.getJSON("/SSMTest/ajax/method3?userName=我是中国人&nickName=龙的传人",
					function(result){
						if(result.success){
							alert("成功.");
						}else{
							alert("失败.");
						}
			})
		}
		
		function method4(){
			$.getJSON("/SSMTest/ajax/method3",{bean:{userName:'我是',nickName:'中国人'}},
					function(result){
						if(result.success){
							alert("成功.");
						}else{
							alert("失败.");
						}
			})
		}
	</script>
	<div>
		<button onclick="method1()">get传输单个数据1</button>
		<button onclick="method2()">get传输多个数据</button>
		<button onclick="method3()">get传输单个对象1</button>
		<button onclick="method4()">get传输单个对象2</button>
		<button onclick="">get传输单个数组1</button>
		<button onclick="">get传输单个数组2</button>
	</div>
</body>
</html>
