<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>

<%@include file="/includes/header.jsp"%>
<%@include file="/includes/nav.jsp"%>


<div>
	<table class="tight sortable">
	<thead>
		<tr>
			<th>Insurance Company</th>
			<th>Plan Name</th>
			<th>State</th>
			<th>Individual Cost</th>
			<th>Family Cost</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="plan" items="${plans}">
			<tr>
				<td>
					${plan.insuranceCompany.name}
				</td>
				<td>
					${plan.name}
				</td>
				<td>
					${plan.insuranceCompany.state}
				</td>
				<td>
					${plan.costIndividual}
				</td>
				<td>
					${plan.costFamilyZero}
				</td>

			</tr>
		</c:forEach>
	</tbody>
</table>
		
</div>
<!-- #main-container -->

<%@include file="/includes/footer.jsp"%>