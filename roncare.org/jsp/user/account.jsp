<%@include file="/includes/header.jsp"%>
<%@include file="/includes/nav.jsp"%>


<div class="main-container">
	<div class="main wrapper clearfix">
		<%@include file="/includes/profile_menu.jsp"%>
		
		<form action="${pageContext.request.contextPath}/useraccount/AccountServlet" method="post">
			<h2>Change Your Password</h2>
			
			<% 
				if (session.getAttribute("PasswordMsg") != null) 
				{
			%>
			
			<h3>Error: <%= session.getAttribute("PasswordMsg") %></h3>
			
			<%
				session.removeAttribute("PasswordMsg");
				}
			%>
			
			<label for="confirmPassword">Current Password:</label>
				<input type="password" name="confirmPassword" id="confirmPassword">
			<label for="newPassword">New Password:</label>
				<input type="password" name="newPassword" id="newPassword">
			<label for="newPassword1">Confirm New Password:</label>
				<input type="password" name="newPassword1" id="newPassword1">
			<Button type="submit" name="action" value="change_password">Change Password</button>
		</form>
		
	</div>
	<!-- #main -->
</div>
<!-- #main-container -->

<%@include file="/includes/footer.jsp"%>