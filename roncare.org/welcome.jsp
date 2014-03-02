<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>RonCare.org</title>
<link type="text/css" rel="stylesheet" href="css/main.css"/>
<%
	String error = (String)request.getAttribute("error");
	if (error==null) {
		error="";
	}
%>
</head>
<body>
<div id="page" class="aligncenter">
   <div id="header" class="aligncenter">
      <h1><a href="index.jsp"><img align="middle" src="logo_small.png" alt="logo"></a> <a href="index.jsp">Welcome to RonCare.org</a></h1>	 
   </div>
   <div id="column1" class="alignleft">
      <form action="/roncare.org/Login" method="POST">
             <br />
              User ID: <input type="text" name="username" size="15" /><br/><br/>
              Password: <input type="password" name="password" size="15" /><br/>
              <div class="error"><%=error%></div>              	
              <div align="center">
                <p><input type="submit" value="Login" /></p>                
              </div>
      </form> 
    </div> 
    <div id="column2" class="alignleft">
        Don't have an account yet? Sign up <a href="register.jsp">here</a>.
    </div>
    <div id="footer">
		<p>Copyright: RonCare.org - 2014. All rights reserved.</p>
   	</div>
</div>
	



</body>
</html>