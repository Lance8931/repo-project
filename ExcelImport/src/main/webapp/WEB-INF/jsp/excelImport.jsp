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
  </body>  
</html>  