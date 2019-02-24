<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>">
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="icon" href="img/favicon.ico">
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>欢迎</title>
</head>
<body>
	<div class="container-fluid">
  <div class="row">
    <div class="col-xs-12 col-md-12">
    	<h1 class="text-center">网上聊天室</h1>
    	<p class="text-center">欢迎你，<%=(String)request.getSession().getAttribute("nameSession") %>！<small>当前的在线人数为<%=application.getAttribute("online") %>人</small></p>
    </div>
  </div>
  <div class="row">
    <div class="col-xs-3 col-md-3">一些用户列表</div>
    <div class="col-xs-9 col-md-9">
    	<jsp:include page="main.jsp"/>
    </div>
  </div>
</div>
</body>
</html>