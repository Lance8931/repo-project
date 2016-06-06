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
			var userNames = new Array();
			for(var i = 0; i < 10; i++){
				userNames.push("中" + i);
			}
			$.getJSON("/SSMTest/ajax/method4",{userNames:userNames.join()},
					function(result){
						if(result.success){
							alert("成功.");
						}else{
							alert("失败.");
						}
			})
		}
		
		function method5(){
			var userNames = new Array();
			for(var i = 0; i < 10; i++){
				userNames.push("中" + i);
			}
			$.getJSON("/SSMTest/ajax/method5",{userNames:userNames.join(),userName:'中国'},
					function(result){
						if(result.success){
							alert("成功.");
						}else{
							alert("失败.");
						}
			})
		}
		
		function method6(){
			var userNames = new Array();
			for(var i = 0; i < 10; i++){
				userNames.push("中" + i);
			}
			$.getJSON("/SSMTest/ajax/method6",{nickNames:userNames.join(),userName:'中国'},
					function(result){
						if(result.success){
							alert("成功.");
						}else{
							alert("失败.");
						}
			})
		}
		
		function method7(){
			var userNames = new Array();
			for(var i = 0; i < 10; i++){
				userNames.push("中" + i);
			}
			$.ajax({
				  url: "/SSMTest/ajax/method7",
				  data: {nickNames:userNames.join()},
				  success: function(result){
							if(result.success){
								alert("成功.");
							}else{
								alert("失败.");
							}
						},
				  dataType: 'json',
				  traditional:true
			});
		}
		
		function method8(){
			var nickNames = new Array();
			for(var i = 0; i < 10; i++){
				nickNames.push("中" + i);
			}
			$.ajax({
				  url: "/SSMTest/ajax/method8",
				  data: JSON.stringify(nickNames.join()),
				  success: function(result){
							if(result.success){
								alert("成功.");
							}else{
								alert("失败.");
							}
						},
				  dataType: 'json',
				  traditional:true
			});
		}
		
		
	</script>
	<div>
		<button onclick="method1()">点击</button>
		<span>使用getJSON传输userName数据</span>
		<br />
		<button onclick="method2()">点击</button>
		<span>使用getJSON传输userName与nickName数据</span>
		<br />
		<button onclick="method3()">点击</button>
		<span>使用getJSON传输userName与nickName数据，后端使用对象接收数据</span>
		<br />
		<button onclick="method4()">点击</button>
		<span>使用getJSON传输数组，后端使用数组接收</span>
		<br />
		<button onclick="method5()">点击</button>
		<span>使用getJSON传输数组，后端使用对象接收，其中对象里有数组</span>
		<br />
		<button onclick="method6()">点击</button>
		<span>使用getJSON传输数组，后端使用对象接收，其中对象里有List对象</span>
		<br />
		<button onclick="method7()">点击</button>
		<span>使用getJSON传输数组，后端使用List对象接收。<span style="color:red">失败，spring不允许注入一个List类型的对象，因为List是接口为参数的对象没有get/set方法</span></span>
		<br />
		<button onclick="method8()">点击</button>
		<span>使用getJSON传输数组，后端使用List对象接收。<span style="color:red">失败。</span></span></span>
		
		<button onclick="">get传输单个数组1</button>
		<button onclick="">get传输单个数组2</button>
	</div>
</body>
</html>
