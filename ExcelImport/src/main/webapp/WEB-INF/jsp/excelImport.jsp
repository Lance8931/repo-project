<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <title>Excel文件导入</title>  
  </head>  
  <body>  
    <form name="userForm1" action="/ExcelImport/uploadExcel" enctype="multipart/form-data" method="post">  
        <div id="newUpload1">  
            <input type="file" name="multipartFiles">  
        </div>  
        <input type="submit" value="上传" >  
    </form>  
    <button onclick="downloadExcel();">下载模板</button>
    <button onclick="downloadExcel1();">下载模板1</button>
  </body>  
  <script type="text/javascript">
  	function downloadExcel(){
		window.location="http://localhost:8080/ExcelImport/download";
	}
  	function downloadExcel1(){
		window.location="http://localhost:8080/ExcelImport/downloadOne";
	}
  </script>
</html>  