
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Love Calculator</title>
</head>
<body align="center">
	<h1>The Love Calculator</h1>
	<h2>Predicts That...</h2>
	<br> ${userInfo.userName} and ${userInfo.crushName} are.... ${finalResult}

	<br>
	<br>
	<br>
	<a href="/spring-love-calculaotr/sendEmail">Send Results to Email</a>

	<a href="/spring-love-calculaotr/feedback">Leave FeedBack</a>

</body>
</html>