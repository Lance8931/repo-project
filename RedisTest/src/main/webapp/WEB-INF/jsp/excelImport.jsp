<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <title>Excel文件导入</title>  
    <script src="/RedisTest/resources/js/jquery/jquery-1.10.2.js" type="text/javascript"></script>
  </head>  
  <body>  
    <button onclick="downloadExcel3();">测试</button>
    <button onclick="downloadExcel4();">清除Keys</button>
  </body>  
  <script type="text/javascript">
  	function downloadExcel3(){
  		$.ajax({
  			url:"/RedisTest/test"
  		});
  	}
  	function downloadExcel4(){
  		$.ajax({
  			url:"/RedisTest/clear"
  		});
  	}
  </script>
</html>  