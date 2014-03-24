<%@include file="/includes/header.jsp"%>
<%@include file="/includes/nav.jsp"%>

<div class="main-container">
	<div class="main wrapper clearfix">

		Already have an account? Sign in <a href="welcome.jsp">here.</a>
		<div class="error">${error}</div>

		<form action="${pageContext.request.contextPath}/Register" method="post">
			<h2>Registration</h2>

			<label for="email">Email:</label> 
			<input type="text" name="email" id="email"/>
			<label for="password">Password:</label>
			<input type="password" name="password" id="password">
			<label for="confirmPassword">Confirm Password:</label>
			<input type="password" name="confirmPassword" id="confirmPassword"> 
			<label for="firstName">First name:</label>
			<input type="text" name="firstName" id="firstName">
			<label for="lastName">Last Name:</label>
			<input type="text" name="lastName">
			<label for="dateOfBirth">Date of Birth:</label>
			<input type="date" name="dateOfBirth" id="dateOfBirth">
			<div align="center">
				<input type="submit" value="Register">
			</div>
		</form>

	</div>
	<!-- #main -->
</div>
<!-- #main-container -->

<%@include file="/includes/footer.jsp"%>