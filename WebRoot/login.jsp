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
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="icon" href="img/favicon.ico">
<title>登录</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/login.css">
</head>
<body class="text-center">
	<form class="form-signin" action="<%=basePath %>main" method="post">
		<img class="mb-4" src="img/bootstrap-solid.svg" alt="" width="72"
			height="72">
		<h1 class="h3 mb-3 font-weight-normal">请登录</h1>
		<label for="inputEmail" class="sr-only">账号</label> <input type="text"
			name="username" id="inputEmail" class="form-control" placeholder="账号"
			required autofocus> <label for="inputPassword"
			class="sr-only">密码</label> <input type="password" name="password"
			id="inputPassword" class="form-control" placeholder="密码" required>
		<div class="checkbox mb-3">
			<label> <input type="checkbox" name="remember-me"
				value="remember-me"> 记住我
			</label>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
		<p class="mt-5 mb-3 text-muted">&copy; 2019-2020</p>
	</form>
</body>
</html>