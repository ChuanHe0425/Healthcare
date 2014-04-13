<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>

<%@include file="/includes/header.jsp"%>
<%@include file="/includes/nav.jsp"%>

<div class="main-container">
	<div class="main wrapper clearfix">		
		
		<form id="profile" action="${pageContext.request.contextPath}/useraccount/AccountServlet" method="post">
			<h2>Update Personal Info</h2>
			
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
				<input type="text" name="firstName" id="firstName" value="${user.firstName}"> <br/>
			<label for="lastName">Last Name:</label>
				<input type="text" name="lastName" id="lastName" value="${user.lastName}"> <br/>
			<label for="streetNo">Street Number:</label>
				<input type="text" name="streetNo" id="streetNo" value="${user.streetNo}" onkeypress="return numeralsOnly(event)"> <br/>
			<label for="streetName">Street Name:</label>
				<input type="text" name="streetName" id="streetName" value="${user.streetName}"> <br/>
			<label for="city">City:</label>
				<input type="text" name="city" id="city" value="${user.city}"> <br/>
			
			<!-- Not working must revisit -->
			<label for="state">State:</label>
				<select name="state" id="state">
					<c:forEach var="selectState" items="${states}">
						<option value="${selectState.id}" ${selectState.selected == true ? 'selected' : ''}>${selectState.abbrevName}</option>
					</c:forEach>
				</select> <br/>
			<label for="zip">Postal Code:</label>
				<input type="text" name="zip" id="zip" size="9" maxlength="9" value="${user.zip}" onkeypress="return numeralsOnly(event)"> <br/>
			<label for="ssn">Social Security Number:</label>
				<input type="text" name="ssn" id="ssn" size="9" maxlength="9" value="${user.ssn}" onkeypress="return numeralsOnly(event)"> <br/>
			<label for="phone">Phone Number:</label>
				<input type="text" name="phone" id="phone" size="10" maxlength="10" value="${user.phoneNum}" onkeypress="return numeralsOnly(event)"> <br/>
			<label for="cell">Cell Phone Number:</label>
				<input type="text" name="cell" id="cell" size="10" maxlength="10" value="${user.cellNum}" onkeypress="return numeralsOnly(event)">
			<br>
			<Button type="submit" name="action" value="change_info">Update Info</button>
		</form>

	</div>
	<!-- #main -->
</div>
<!-- #main-container -->

<%@include file="/includes/footer.jsp"%>