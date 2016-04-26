<%@ page language="java" pageEncoding="utf-8"%>  
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap 101 Template</title>

    <link rel="stylesheet" href="/BootstrapSpringMVCTest/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="/BootstrapSpringMVCTest/resources/css/bootstrap-table.css">
    
    <script type="text/javascript" src="/BootstrapSpringMVCTest/resources/js/jquery-2.2.1.min.js" charset="utf-8" ></script>
    <script type="text/javascript" src="/BootstrapSpringMVCTest/resources/js/bootstrap.js" charset="utf-8" ></script>
    <script type="text/javascript" src="/BootstrapSpringMVCTest/resources/js/bootstrap-table.js" charset="utf-8" ></script>
    <script type="text/javascript" src="/BootstrapSpringMVCTest/resources/js/bootstrap-table-zh-CN.js" charset="utf-8" ></script>
  </head>
  <body>
  	
  	<table id="table"></table>
  	<script type="text/javascript">
	  	$('#table').bootstrapTable({
	  		url:'/BootstrapSpringMVCTest/getData',
	  		method:'post',
	  		sidePagination:"server",
	  		pagination:"true",
	        pageList:[5, 10, 20, 50, 100, 200],
	  	    columns: [{
	  	        field: 'id',
	  	        title: 'Item ID'
	  	    }, {
	  	        field: 'name',
	  	        title: 'Item Name'
	  	    }, {
	  	        field: 'value',
	  	        title: 'Item Price'
	  	    }],
	  	  	responseHandler: function (res) {
	  	  		res.rows = res.records;
	            return res;
	        }
	  	});
  	</script>
  </body>
</html>
