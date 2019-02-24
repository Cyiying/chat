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
<link rel="stylesheet" href="css/bootstrap.min.css">
<title>主体部分</title>
</head>
<body>
	<form action="<%=basePath %>contentServlet" method="post">
		<textarea readonly="readonly" class="form-control" rows="3"><%=request.getAttribute("content")%></textarea>
		<div class="input-group">
			<input type="text" class="form-control" name="content" placeholder="input for...">
			<span class="input-group-btn">
				<input class="btn btn-primary" type="submit" value="Go!"/>
			</span>
		</div>
		<!-- /input-group -->
	</form>
</body>
</html>