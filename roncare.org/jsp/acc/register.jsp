<%@include file="/includes/header.jsp"%>
<%@include file="/includes/nav.jsp"%>

<div class="grid">

	<div class="col_6 column">
		<blockquote class="small">
			<p>
				RonCare.org was created to help you. 
				Our motto is to help ensure that you are able to cover your medical bills. 
				Don't live a life of fear when your next emergency bill arrives.
			</p>
		</blockquote>
	</div>
	<div class="col_6 column">
		Already have an account? Sign in <a
			href="${pageContext.request.contextPath}/account/LoginServlet">here.</a>
		<div class="error">${error}</div>

		<form onsubmit="return validateRegister();"
			action="${pageContext.request.contextPath}/Register" method="post">
			
			<h2>Register</h2>


			<div class="input_field_inline">
				<label class="col_4 column" for="firstName">First name:</label> 
				<input type="text" 	name="firstName" id="firstName">
			</div>

			<div class="input_field_inline">
				<label class="col_4 column" for="lastName">Last Name: </label> 
				<input type="text" name="lastName" id="lastName">
			</div>

			<div class="input_field_inline">
				<label class="col_4 column" for="email">Email:</label> 
				<input type="text" name="email" id="email" />
			</div>

			<div class="input_field_inline">
				<label  class="col_4 column" for="password">Password:</label>
				<input type="password" name="password" id="password">
			</div>

			<div class="input_field_inline">
				<label  class="col_4 column" for="confirmPassword">Confirm Password:</label> 
				<input type="password" name="confirmPassword" id="confirmPassword">
			</div>

			<div class="input_field_inline">
				<label  class="col_4 column" for="dateOfBirth">Date of Birth:</label> 
				<input type="date" name="dateOfBirth" id="dateOfBirth">
			</div>
			<br>
			<div class="center">
				<button name="" class="green" value="Register">
					<i class="icon-ok-circle icon-large"></i> Register
				</button>
			</div>
			<br>
			<!-- <input type="submit" value="Register" class="green">  -->
		</form>
	</div>
	<!-- #main -->
</div>

<!-- TO CLEAR OUT FLOATS -->
<div class="clear"></div>

<!-- #main-container -->

<%@include file="/includes/footer.jsp"%>