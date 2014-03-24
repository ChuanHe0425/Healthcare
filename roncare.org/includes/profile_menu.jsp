<nav>
	<ul id="submenu">
		<% if (request.getRemoteUser() != null) { %>
		<li><a href="${pageContext.request.contextPath}/useraccount/account">Account</a></li>
		<li><a href="${pageContext.request.contextPath}/useraccount/profile">Profile</a></li>
		<li><a href="${pageContext.request.contextPath}/useraccount/family">Family</a></li>
       	<% } %>
	</ul>
</nav>