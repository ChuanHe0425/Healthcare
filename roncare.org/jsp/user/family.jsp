<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>

<%@include file="/includes/header.jsp"%>
<%@include file="/includes/nav.jsp"%>

<div class="grid">
	
	
	<div class="col_6 column">
		
		<h4>List Of Family Members</h4>
		<% 
			if (session.getAttribute("FamilyRemvoceMsg") != null) 
			{
		%>
		
		<h5>Error: <%= session.getAttribute("FamilyRemvoceMsg") %></h5>
		
		<%
			session.removeAttribute("FamilyRemvoceMsg");
			}
		%>
		
		<table class="tight sortable">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="selectMember" items="${family}">
					<tr>
						<td>
							${selectMember.firstName}
						</td>
						<td>
							${selectMember.lastName} 
						</td>
						<td>
							${selectMember.age} 
						</td>
						<td>
							<form action="${pageContext.request.contextPath}/useraccount/AccountServlet" method="post">
								<input type="hidden" name="id" id="id" value="${selectMember.id}">
								<button class="small" type="submit" name="action" value="remove_family_member">
									<i class="icon-minus-sign icon-normal" style="color:blue"></i>
								</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<br>
		<br>
		
		<h4>Add Family Member</h4>
		
		
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
			<div class="input_field_inline">
				<label class="col_4 column" for="firstName">First Name:</label>
				<input type="text" name="firstName" id="firstName">
			</div>
			<div class="input_field_inline">
				<label class="col_4 column" for="lastName">Last Name:</label>
				<input type="text" name="lastName" id="lastName">
			</div>
			<div class="input_field_inline">
				<label class="col_4 column" for="age">Age:</label>
				<input type="text" name="age" id="age" onkeypress="return numeralsOnly(event)">
			</div>
			
			<br>
			<Button class="green" type="submit" name="action" value="add_family_member">
				Add Family Member
			</button>
		</form>
		<br>
		
	</div>
	
	
	
	<div class="col_6 column">
		Add some text here!!
	</div>
	
	
</div>

<!-- TO CLEAR OUT FLOATS -->
<div class="clear"></div>
	
<%@include file="/includes/footer.jsp"%>