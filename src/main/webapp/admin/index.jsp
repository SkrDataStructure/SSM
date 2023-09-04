<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>后台管理</title>
<link rel="stylesheet" href="css/bootstrap.css"/> 
</head>
<body>
<div class="container-fluid">

	<%
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Pragma","no-cache");
		response.setDateHeader ("Expires", -1);
	%>




<jsp:include page="header.jsp"></jsp:include>

	<br><br>
	
	<div class="alert alert-success" role="alert">恭喜你! 登录成功了</div>
	
</div>	
</body>
</html>