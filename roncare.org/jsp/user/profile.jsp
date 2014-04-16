<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>

<%@include file="/includes/header.jsp"%>
<%@include file="/includes/nav.jsp"%>

<div class="grid">

	
	<div class="col_6 column">
		Something
	</div>

	<div class="col_6 column">		
		
		<form id="profile" action="${pageContext.request.contextPath}/useraccount/AccountServlet" method="post">
			<h4>Update Personal Info</h4>
			
			<% 
				if (session.getAttribute("InfoChngMsg") != null) 
				{
			%>
			
			<h5>Error: <%= session.getAttribute("InfoChngMsg") %></h5>
			
			<%
				session.removeAttribute("InfoChngMsg");
				}
			%>
			
			
			<div class="input_field_inline">
				<label class="col_4 column" for="firstName">First Name:</label>
				<input type="text" name="firstName" id="firstName" value="${user.firstName}"> <br/>
			</div>
			
			<div class="input_field_inline">
				<label class="col_4 column" for="lastName">Last Name:</label>
				<input type="text" name="lastName" id="lastName" value="${user.lastName}"> <br/>
			</div>
			
			<div class="input_field_inline">
				<label class="col_4 column" for="streetNo">Street Number:</label>
				<input type="text" name="streetNo" id="streetNo" value="${user.streetNo}" onkeypress="return numeralsOnly(event)"> <br/>
			</div>
			
			<div class="input_field_inline">
				<label class="col_4 column" for="streetName">Street Name:</label>
				<input type="text" name="streetName" id="streetName" value="${user.streetName}"> <br/>
			</div>
			
			<div class="input_field_inline">
				<label for="city">City:</label>
				<input type="text" name="city" id="city" value="${user.city}"> <br/>
			</div>
			
			<div class="input_field_inline">
				<label for="state">State:</label>
				<select name="state" id="state">
					<c:forEach var="selectState" items="${states}">
						<option value="${selectState.id}" ${selectState.selected == true ? 'selected' : ''}>${selectState.abbrevName}</option>
					</c:forEach>
				</select> <br/>
			</div>
			
			<div class="input_field_inline">	
				<label for="zip">Postal Code:</label>
				<input type="text" name="zip" id="zip" size="9" maxlength="9" value="${user.zip}" onkeypress="return numeralsOnly(event)"> <br/>
			</div>
			
			<div class="input_field_inline">
				<label for="ssn">Social Security Number:</label>
				<input type="text" name="ssn" id="ssn" size="9" maxlength="9" value="${user.ssn}" onkeypress="return numeralsOnly(event)"> <br/>
			</div>
			
			<div class="input_field_inline">
				<label for="phone">Phone Number:</label>
				<input type="text" name="phone" id="phone" size="10" maxlength="10" value="${user.phoneNum}" onkeypress="return numeralsOnly(event)"> <br/>
			</div>
			
			<div class="input_field_inline">
				<label for="cell">Cell Phone Number:</label>
				<input type="text" name="cell" id="cell" size="10" maxlength="10" value="${user.cellNum}" onkeypress="return numeralsOnly(event)">
			</div>
			
			<br>
			<Button type="submit" name="action" value="change_info">Update Info</button>
		</form>

	</div>
	
	
</div>

<!-- TO CLEAR OUT FLOATS -->
<div class="clear"></div>

<%@include file="/includes/footer.jsp"%>