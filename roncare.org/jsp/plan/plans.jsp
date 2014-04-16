<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import = "java.util.List" %>
<%@ page import = "java.util.ArrayList" %>

<%@include file="/includes/header.jsp"%>
<%@include file="/includes/nav.jsp"%>


<div class="main-container">
	<div class="main wrapper clearfix">
			<table>
			<thead>
				<tr>
					<td>Insurance Company</td>
					<td>Plan Name</td>
					<td>State</td>
					<td>Individual Cost</td>
					<td>Family Cost</td>
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
	<!-- #main -->
</div>
<!-- #main-container -->

<%@include file="/includes/footer.jsp"%>