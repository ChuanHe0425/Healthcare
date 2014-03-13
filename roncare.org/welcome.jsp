
<%@include file="includes/header.jsp"%>
<%@include file="includes/nav.jsp"%>

<div class="main-container">
	<div class="main wrapper clearfix">

		<h1>RonCare Login</h1>


		<form action="/roncare.org/Login" method="POST">
			<br /> User ID: <input type="text" name="username" size="15" /><br />
			<br /> Password: <input type="password" name="password" size="15" /><br />
			<div class="error"><%=error%></div>
			<div align="center">
				<p>
					<input type="submit" value="Login" />
				</p>
			</div>
		</form>

		Don't have an account yet? Sign up <a href="register.jsp">here</a>.

	</div>

</div>
<!-- #main -->
</div>
<!-- #main-container -->

<%@include file="includes/footer.jsp"%>
