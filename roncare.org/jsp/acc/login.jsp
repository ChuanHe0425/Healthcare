<%@ include file="/includes/header.jsp"%>
<%@ include file="/includes/nav.jsp"%>

<div class="grid">
	<div class="center">

		<form method="post" action="j_security_check">
			
			<br>
			<div class="input_field_inline">
				<label class="col_2 column" for="username">Email:</label> 
				<input id="username" type="text" name="j_username" />
			</div>
			
			<div class="input_field_inline">
				<label class="col_2 column" for="password">Password:</label> 
				<input id="password" type="password" name="j_password" />
			</div>
			<br>
			
			<input class="green" type="submit" value="Login" /> 
			<input class="green" type="reset" value="Reset" />
		</form>
		<br>
		<a href="${pageContext.request.contextPath}/jsp/acc/register.jsp">Register</a>
		
	</div>
	<!-- #main -->
</div>
<!-- #main-container -->

<%@include file="/includes/footer.jsp"%>