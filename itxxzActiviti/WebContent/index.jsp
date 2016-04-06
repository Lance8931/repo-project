<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>流程演示|www.itxxz.com</title>
</head>
<body>
<center>

	<h2><a href="<c:url value='flow/deploy' />">activiti5.17演示开始</a> </h2>
	
	<form action="<c:url value='flow/showTask' />" method="post">
		<input type="radio" name="assignee" value="apply" checked="checked">我的申请</input> 
		<input type="radio" name="assignee" value="leader">经理审批</input> 
		<input type="radio" name="assignee" value="boss">老板审批</input> 
		<input type="submit" value="任务查看">
	</form>
	<br/><br/><br/>
	
		© IT学习者 <a href="http://www.itxxz.com">www.itxxz.com</a>
</center>
	
</body>
</html>