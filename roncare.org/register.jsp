<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
	<h1>RonCare Registration</h1>

	<div>
		<form action="http://localhost:8080/roncare.org/Register" method="post">
			
			User Name: <input type="text" name="username" > 
			<br>
			<br>
			Password: <input type="password" name="password" >
			<br>
			Confirm Password: <input type="password" name="confirmPassword" >
			<br>
			<br>
			First Name: <input type="text" name="firstName" >
			<br>
			Last Name: <input type="text" name="lastName" >
			<br>
			Date of Birth Name: <input type="date" name="dateOfBirth" >
			<br>
			<input type="submit" value="Register">
		</form>
	</div>

</body>
</html>