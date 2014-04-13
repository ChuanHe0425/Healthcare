<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>

<%@include file="/includes/header.jsp"%>
<%@include file="/includes/nav.jsp"%>

<div class="main-container">
	<div class="main wrapper clearfix">
		
		<h2>List Of Family Members</h2>
		<% 
				if (session.getAttribute("FamilyRemvoceMsg") != null) 
				{
			%>
			
			<h3>Error: <%= session.getAttribute("FamilyRemvoceMsg") %></h3>
			
			<%
				session.removeAttribute("FamilyRemvoceMsg");
				}
			%>
		
		<table>
			<c:forEach var="selectMember" items="${family}">
				<tr>
					<td>
						${selectMember.lastName}, ${selectMember.firstName} 
					</td>
					<td>
						<form action="${pageContext.request.contextPath}/useraccount/AccountServlet" method="post">
							<input type="hidden" name="id" id="id" value="${selectMember.id}">
							<Button type="submit" name="action" value="remove_family_member">Remove Family Member</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
		
		<br>
		<br>
		
		<h2>Add Family Member</h2>
		
		
		<form action="${pageContext.request.contextPath}/useraccount/AccountServlet" method="post">
			
			<% 
				if (session.getAttribute("FamilyAddMsg") != null) 
				{
			%>
			
			<h3>Error: <%= session.getAttribute("FamilyAddMsg") %></h3>
			
			<%
				session.removeAttribute("FamilyAddMsg");
				}
			%>
			
			<label for="firstName">First Name:</label>
				<input type="text" name="firstName" id="firstName">
			<label for="lastName">Last Name:</label>
				<input type="text" name="lastName" id="lastName">
			<label for="age">Age:</label>
				<input type="text" name="age" id="age" onkeypress="return numeralsOnly(event)">
			
			<br>
			<Button type="submit" name="action" value="add_family_member">Add Family Member</button>
		</form>

	</div>
	<!-- #main -->
</div>
<!-- #main-container -->

<%@include file="/includes/footer.jsp"%>