<%@ include file="/includes/header.jsp"%>
<%@ include file="/includes/nav.jsp"%>

<div class="main-container">
	<div class="main wrapper clearfix">

		<form method="post" action="j_security_check">
			
			<label for="username">Email:</label> 
				<input id="username" type="text" name="j_username" /><br /> 
			<label for="password">Password:</label> 
				<input id="password" type="password" name="j_password" /><br /> 
			<input type="submit" value="Login" /> 
			<input type="reset" value="Reset" /> <br>
		</form>
		
		<a href="${pageContext.request.contextPath}/jsp/acc/register.jsp">Register</a>
		
	</div>
	<!-- #main -->
</div>
<!-- #main-container -->

<%@include file="/includes/footer.jsp"%>