<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error {
	color: red;
	position: fixed;
	text-align: left;
	margin-left: 3px;
}
</style>


</head>
<body>
	<h1 align="center">Please Register Here</h1>


	<form:form action="register-success" method="get"
		modelAttribute="registerDTO">
		<div align="center">
			<label for="nm">Username : </label>
			<form:input id="nm" path="userName" />
			<form:errors path="userName" cssClass="error"></form:errors>


			<br> <label for="name">Name : </label>
			<form:input id="name" path="name" />
			<form:errors path="name" cssClass="error"></form:errors>


			<br> <label for="pw">Password</label>
			<form:password id="pw" path="password" />
			<form:errors path="password" cssClass="error"></form:errors>

			<br> <label>Country :</label>
			<form:select path="countryName">
				<form:option value="india" label="India" />
				<form:option value="cn" label="China" />
				<form:option value="tw" label="Taiwan" />
				<form:option value="USA" label="United States" />
			</form:select>

			<br> <label>Hobbies: </label> Tennis :
			<form:checkbox path="hobbies" value="tennis" />
			Golf :
			<form:checkbox path="hobbies" value="golf" />
			Coding :
			<form:checkbox path="hobbies" value="coding" />
			Snowboarding :
			<form:checkbox path="hobbies" value="snowboarding" />

			<br> <label>Gender: </label> Male
			<form:radiobutton path="gender" value="male" />
			Female
			<form:radiobutton path="gender" value="female" />


		</div>
		<div align="center">
			<label for="age">Age: </label>
			<form:input path="age" id="age"></form:input>
			<form:errors path="age" cssClass="error"></form:errors>


			<h3>Communication</h3>
			<label for="email">Email :</label>
			<form:input path="communicationDTO.email" id="email" />
			<form:errors path="communicationDTO.email" cssClass="error"></form:errors>
			<br>
			<label for="phone">Phone :</label>
			<form:input path="communicationDTO.phone" id="phone" />
			<br> <input type="submit" value="register">
			<form:errors path="communicationDTO.phone" cssClass="error"></form:errors>

		</div>
	</form:form>




</body>
</html>