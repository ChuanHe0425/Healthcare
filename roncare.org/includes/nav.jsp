<div class="header-container">
	<header class="wrapper clearfix">
		<h1 class="title">
			<a href="${pageContext.request.contextPath}/"><img align="middle" src="${pageContext.request.contextPath}/img/logo_small.png"
				alt="logo"></a>
		</h1>
		<div class="navmenu">
			<ul class="dropdown dropdown-horizontal">
				<li class="dir"><a href="${pageContext.request.contextPath}/plans/">Plans</a></li>
				<!-- 
				<li class="dir"><a href="${pageContext.request.contextPath}/faqs/">FAQs</a></li>
				 -->
				<li class="dir"><a href="${pageContext.request.contextPath}/apply/apply.jsp">Apply</a></li>
				
				
				<% if (request.getRemoteUser() != null) { %>
				<li class="dir"><a href="${pageContext.request.contextPath}/useraccount/account">Profile</a>
					<%@include file="/includes/profile_menu.jsp"%>
				</li>
				<li class="dir"><a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a></li>
            	<% } else { %>
            	<li class="dir"><a href="${pageContext.request.contextPath}/account/LoginServlet">Login</a></li>
            	<% } %>
			</ul>
		</div>
	</header>
</div>