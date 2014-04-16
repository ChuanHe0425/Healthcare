<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>

<!DOCTYPE html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>RonCare.org</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/normalize.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/kickstart.css" media="all" />

<script type="text/javascript" src="${pageContext.request.contextPath}/js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/vendor/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/validation.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/kickstart.js"></script>

<%
	if (!request.getRequestURL().toString().contains("login.jsp") && 
		(request.getRequestURL().toString().contains("/user/") ||
		request.getRequestURL().toString().contains("register.jsp")))
	{
		System.out.println("{header.jsp}: Using form validators");
%>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/registration_validation.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/formvalidators.css">
<%		
	}

	String error = (String) request.getAttribute("error");
	if (error == null) {
		error = "";
	}
%>
</head>

<body>