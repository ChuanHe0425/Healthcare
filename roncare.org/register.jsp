<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>RonCare Registration</title>
<link type="text/css" rel="stylesheet" href="css/main.css"/>
</head>
<body>
	<div id="page" class="aligncenter">
	    <div id="header" class="aligncenter">
	        <h1><a href="index.jsp"><img align="middle" src="logo_small.png" alt="logo"></a> <a href="index.jsp">Welcome to RonCare.org</a></h1>
	    </div>
	    <div id="column1" class="alignleft">
	        Already have an account? Sign in <a href="welcome.jsp">here.</a>
	    </div>	
	    <div id="column2" class="alignleft"><br/>
			<form action="/roncare.org/Register" method="post">
				<h2>Registration</h2>
					
				User Name: <input type="text" name="username" > 
				<br/>
				<br/>
				Password: <input type="password" name="password" >
				<br/>
				Confirm Password: <input type="password" name="confirmPassword" >
				<br/>
				<br/>
				First Name: <input type="text" name="firstName" >
				<br/>
				Last Name: <input type="text" name="lastName" >
				<br/>
				Date of Birth Name: <input type="date" name="dateOfBirth" >
				<br/><br/>
				<div align="center">
					<input type="submit" value="Register">
				</div>
			</form>			
		</div>	
	    <div id="footer">
		<p>Copyright: RonCare.org - 2014. All rights reserved.</p>
 	    </div>		  
	</div>

</body>
</html>