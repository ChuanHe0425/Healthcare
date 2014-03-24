<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>

<%@include file="/includes/header.jsp"%>
<%@include file="/includes/nav.jsp"%>

<div class="main-container">
	<div class="main wrapper clearfix">
		<%@include file="/includes/profile_menu.jsp"%>
		
		<form action="${pageContext.request.contextPath}/useraccount/AccountServlet" method="post">
			<h2>Change Personal Info</h2>
			
			<% 
				if (session.getAttribute("InfoChngMsg") != null) 
				{
			%>
			
			<h3>Error: <%= session.getAttribute("InfoChngMsg") %></h3>
			
			<%
				session.removeAttribute("InfoChngMsg");
				}
			%>
			
			<label for="firstName">First Name:</label>
				<input type="text" name="firstName" id="firstName" value="${user.firstName}">
			<label for="lastName">Last Name:</label>
				<input type="text" name="lastName" id="lastName" value="${user.lastName}">
			<label for="streetNo">Street Number:</label>
				<input type="text" name="streetNo" id="streetNo" value="${user.streetNo}">
			<label for="streetName">Street Name:</label>
				<input type="text" name="streetName" id="streetName" value="${user.streetName}">
			<label for="city">City:</label>
				<input type="text" name="city" id="city" value="${user.city}">
			
			<!-- Not working must revisit -->
			<label for="state">State:</label>
				<select name="state" id="state">
					<c:forEach var="selectState" items="${states}">
						<option value="${selectState.id}" ${selectState.selected == true ? 'selected' : ''}>${selectState.abbrevName}</option>
					</c:forEach>
				</select>
			<label for="zip">Postal Code:</label>
				<input type="text" name="zip" id="zip" size="9" maxlength="9" value="${user.zip}">
			<label for="ssn">Social Security Number [No Dashes]:</label>
				<input type="text" name="ssn" id="ssn" size="9" maxlength="9" value="${user.ssn}">
			<label for="phone">Phone Number [No Dashes]:</label>
				<input type="text" name="phone" id="phone" size="10" maxlength="10" value="${user.phoneNum}">
			<label for="cell">Social Security Number [No Dashes]:</label>
				<input type="text" name="cell" id="cell" size="10" maxlength="10" value="${user.cellNum}">
			<br>
			<Button type="submit" name="action" value="change_info">Change Info</button>
		</form>

	</div>
	<!-- #main -->
</div>
<!-- #main-container -->

<%@include file="/includes/footer.jsp"%>