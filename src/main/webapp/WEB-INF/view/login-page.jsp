<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

<c:if test = "${param.error !=null}">

Username or password is incorrect

</c:if>


	<h1 align="center">Custom Login Page</h1>

	<div align = "center">

		<form:form action="" method="post">
		<input type="text" placeholder="username" name = "username">
		<input type="password" placeholder="password" name = "password">
		<input type="submit" value = "login">
		</form:form>


	</div>

</body>
</html>