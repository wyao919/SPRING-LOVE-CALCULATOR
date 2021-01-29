<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Your Details are</h1>
		Name: ${registerDTO.name} <br> User Name: ${registerDTO.userName} <br>
		Password :${registerDTO.password} <br> Hobbies :

		<c:forEach var="temp" items="${registerDTO.hobbies}">
			${temp} 
	</c:forEach>

		<br> Country : ${registerDTO.countryName} <br> Gender :
		${registerDTO.gender}
		<br>
		Age : ${registerDTO.age}
		<br>
		Email : ${registerDTO.communicationDTO.email}
		<br>
		Phone : ${registerDTO.communicationDTO.phone}
	</div>

</body>
</html>