<%@include file="/includes/header.jsp"%>
<%@include file="/includes/nav.jsp"%>


<div class="main-container">
	<div class="main wrapper clearfix">
			<table>
			<thead>
				<tr>
					<td>First Nqme</td>
					<td>Last Name</td>
					<td>Age</td>
					<td>Action</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="plan" items="${plans}">
					<tr>
						<td>
							${plan.name}
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