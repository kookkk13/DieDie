<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DIE DIE</title>
</head>
<body>
<h1>잠시만 기다려 주세요..</h1>
<% if(exception != null){ %>
	<%= exception.getMessage() %><br>
<% }else{ %>
	<%= request.getAttribute("message") %><br>
<% } %>
</body>
</html>