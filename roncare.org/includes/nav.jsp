<div class="header-container">
	<header class="wrapper clearfix">
		<h1 class="title">
			<a href="${pageContext.request.contextPath}/"><img align="middle" src="${pageContext.request.contextPath}/img/logo_small.png"
				alt="logo"></a>
		</h1>
		<nav>
			<ul id="mainnav">
				<li><a href="#">Plans</a></li>
				<!-- 
				<li><a href="#">FAQs</a></li>
				 -->
				<li><a href="#">Apply</a></li>
				
				
				<% if (request.getRemoteUser() != null) { %>
				<li><a href="${pageContext.request.contextPath}/useraccount/account">Profile</a></li>
				<li><a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a></li>
            	<% } else { %>
            	<li><a href="${pageContext.request.contextPath}/account/LoginServlet">Login</a></li>
            	<% } %>
			</ul>
		</nav>
	</header>
</div>