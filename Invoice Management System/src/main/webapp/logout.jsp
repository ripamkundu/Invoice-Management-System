<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
<link rel="icon" type="image/x-icon" href="./image/logo.ico">

<link
	href="https://fonts.googleapis.com/css?family=Encode+Sans+Semi+Condensed:100,200,300,400"
	rel="stylesheet">
<link rel="stylesheet" href="./css/error.css">
</head>
<body class="loading">
<% session.invalidate(); %>
	<h2>You have been successfully logout In your Account.!</h2>
	<h3>Again Login Your Account <a href="./login.jsp" target="_blank">Log In </a></h3>
	<br>
	<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
	<script src="js/main.js" type="text/javascript"></script>

</body>
</html>