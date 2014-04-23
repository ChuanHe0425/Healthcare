<%@include file="/includes/header.jsp"%>
<%@include file="/includes/nav.jsp"%>


<div class="grid">
	<div class="center">		
		
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
			
			<div class="input_field_inline">
				<label class="col_3 column" for="password">Current Password:</label>
				<input type="password" name="password" id="password">
			</div>
			<div class="input_field_inline">
				<label class="col_3 column" for="newPassword">New Password:</label>
				<input type="password" name="newPassword" id="newPassword">
			</div>
			<div class="input_field_inline">
				<label class="col_3 column" for="newPassword1">Confirm New Password:</label>
				<input type="password" name="newPassword1" id="newPassword1">
			</div>
			<br>
			<Button class="green" type="submit" name="action" value="change_password">Change Password</button>
		</form>
		<br>
	</div>
	
</div>

<%@include file="/includes/footer.jsp"%>