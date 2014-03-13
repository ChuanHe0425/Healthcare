
<%@include file="includes/header.jsp"%>
<%@include file="includes/nav.jsp"%>

<div class="main-container">
	<div class="main wrapper clearfix">

		Already have an account? Sign in <a href="welcome.jsp">here.</a>
		<div class="error">${error}</div>

		<form action="Register" method="post">
			<h2>Registration</h2>

			Email: <input type="text" name="email" /> <br /> <br /> Password:
			<input type="password" name="password"> <br /> Confirm
			Password: <input type="password" name="confirmPassword"> <br />
			<br /> First Name: <input type="text" name="firstName"> <br />
			Last Name: <input type="text" name="lastName"> <br /> Date
			of Birth: <input type="date" name="dateOfBirth"> <br /> <br />
			<div align="center">
				<input type="submit" value="Register">
			</div>
		</form>

	</div>
	<!-- #main -->
</div>
<!-- #main-container -->

<%@include file="includes/footer.jsp"%>
