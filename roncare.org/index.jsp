<%@include file="includes/header.jsp"%>
<%@include file="includes/nav.jsp"%>
<%
	String user = (String) request.getSession().getAttribute("currentUser");
%>
<div class="main-container">
	<div class="main wrapper clearfix">

		<%
			if (user != null) {
		%>
		Welcome
		<%=user%>!
		<%
			}
		%>
		<h1>RonCare.org</h1>
		<h2>because Ron cares</h2>

	</div>
	<!-- #main -->
</div>
<!-- #main-container -->

<%@include file="includes/footer.jsp"%>
