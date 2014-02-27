<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>RonCare.org</title>
</head>
<body>
	<h1>RonCare</h1>

	<div>
		<form action="http://localhost:8080/roncare.org/Login" method="post">
			User Name: <input type="text" name="username" > 
			Password: <input type="password" name="password" > 
			<input type="submit" value="Login">
		</form>
		<button onclick="location.href = 'http://localhost:8080/roncare.org/register.jsp';" >Register</button>
	</div>
	



</body>
</html>