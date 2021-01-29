<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hi ${userInfo.userName }</h1>
<h2>Give us Feedback</h2>

	<form:form action="processFeedBack" method = "GET" modelAttribute="feedBackDTO">
	
		<label for="Name">Enter Your Name: </label>
		<form:input path="userName" name="name" />
		<form:errors path= "userName"/>
		
		<br/>
		<label for="email">Enter Your Email: </label>
		<form:input path="userEmail" name="email" />
		<form:errors path= "userEmail"/>
		<br/>
		<label for="feedBack">Your FeedBack: </label>
		<form:textarea path="feedBack" name="feedBack" />
		<form:errors path= "feedBack"/>
		

		
		
		<input type="submit" value="Send" />
	</form:form>


</body>
</html>