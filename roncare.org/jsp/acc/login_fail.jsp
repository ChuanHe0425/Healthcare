<%@ include file="/includes/header.jsp" %>
<%@ include file="/includes/nav.jsp" %>

<%
	String user = (String) request.getSession().getAttribute("currentUser");
%>
<div class="main-container">
	<div class="main wrapper clearfix">

		<h2>Failed To Login. Retry <a href="${pageContext.request.contextPath}/account/LoginServlet">Login</a>  or <a href="${pageContext.request.contextPath}/jsp/acc/register.jsp">Register a new Account</a></h2>
		
	</div>
	<!-- #main -->
</div>
<!-- #main-container -->

<%@include file="/includes/footer.jsp"%>