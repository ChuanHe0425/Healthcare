<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <link type="text/css" rel="stylesheet" href="css/main.css"	/>
    <%    	
    	String user = (String)request.getSession().getAttribute("currentUser");
    %>
</head>

<body>
  <div id="page" class="aligncenter">
     <div id="header" class="aligncenter">
         <h1><a href="index.jsp"><img align="middle" src="logo_small.png" alt="logo"></a> <a href="index.jsp">Welcome to RonCare.org</a></h1>         
     </div> 
      <div id="column1" class="alignleft">
        <a href="index.jsp">Home</a> <br/>
        <a href="welcome.jsp">Login</a> <br/>
        <a href="register.jsp">Register</a> <br/>
      </div>
      <div id="column2" class="alignleft">
      <% if (user != null) { %>
		Welcome <%=user%>!
	  <% } %>
	    <h1>RonCare.org</h1>
	    <h2>because Ron cares</h2>  
	  </div>
	  <div id="footer">
		  <p>Copyright: RonCare.org - 2014. All rights reserved.</p>
	  </div>	  
  </div>
   
</body>

</html>