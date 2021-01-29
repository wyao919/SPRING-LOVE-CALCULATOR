<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body align ="center">
<h1>Hi ${userInfo.userName} </h1>
<h2>Send results to your email</h2>

	<form:form action="processEmail" method = "GET" modelAttribute="emailDTO">
		<label for="email">Enter Your Email: </label>
		<form:input path="userEmail" name="email" />
		<input type="submit" value="Send" />
	</form:form>


</body>
</html>