<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>CALCULATE It!</title>
<link rel="icon" type="image/x-icon" href="./image/logo.ico">

<link rel="stylesheet" href="./css/calculator.css">
<%
String username = (String) session.getAttribute("username");
if(username==null)
{
	request.getRequestDispatcher("login.jsp").forward(request, response);
}
%>
</head>
<body>
	<div class="container">
		<h1
			style="font-size: 3.5rem; font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif; color: black;">
			CALCULATE <span
				style="color: azure; text-decoration: underline; font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif; font-size: 4.0rem;">your</span>
			INVOICE
		</h1>
		<div class="calculator dark">
			<div class="theme-toggler active">
				<i class="toggler-icon"></i>
			</div>
			<div class="display-screen">
				<div id="display"></div>
			</div>
			<div class="buttons">
				<table>
					<tr>
						<td><button class="btn-operator" id="clear">C</button></td>
						<td><button class="btn-operator" id="/">&divide;</button></td>
						<td><button class="btn-operator" id="*">&times;</button></td>
						<td><button class="btn-operator" id="backspace"><</button></td>
					</tr>
					<tr>
						<td><button class="btn-number" id="7">7</button></td>
						<td><button class="btn-number" id="8">8</button></td>
						<td><button class="btn-number" id="9">9</button></td>
						<td><button class="btn-operator" id="-">-</button></td>
					</tr>
					<tr>
						<td><button class="btn-number" id="4">4</button></td>
						<td><button class="btn-number" id="5">5</button></td>
						<td><button class="btn-number" id="6">6</button></td>
						<td><button class="btn-operator" id="+">+</button></td>
					</tr>
					<tr>
						<td><button class="btn-number" id="1">1</button></td>
						<td><button class="btn-number" id="2">2</button></td>
						<td><button class="btn-number" id="3">3</button></td>
						<td rowspan="2"><button class="btn-equal" id="equal">=</button></td>
					</tr>
					<tr>
						<td><button class="btn-operator" id="(">(</button></td>
						<td><button class="btn-number" id="0">0</button></td>
						<td><button class="btn-operator" id=")">)</button></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<script src="./js/calculator.js"></script>

</body>
</html>