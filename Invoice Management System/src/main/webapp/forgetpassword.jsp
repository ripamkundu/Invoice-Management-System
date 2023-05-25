<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Forget Password</title>
<link rel="icon" type="image/x-icon" href="./image/logo.ico">
<!-- Font Awesome Icons  -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
	integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA=="
	crossorigin="anonymous" />

<!-- Google Fonts  -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="./css/forget.css">
<style>
@media ( max-width :365px) {
	h2 {
		font-size: 1.2rem !important;
		text-align: center;
	}
	p {
		font-size: 0.8rem;
	}
}
</style>
</head>
<body>
	<form class="card" action="PasswordUpdate" method="POST">

		<p class="lock-icon">
			<i class="fas fa-lock"> </i>
		</p>
		<h2>Forgot Password?</h2>
		<br>
		<p>You can reset your Password here</p>
		<br> <input type="text" class="passInput" name="username"
			placeholder="Enter Username"> <br> <input type="text"
			name="password" class="passInput" placeholder="Enter New Password">
		<br>
		<button type="submit" name="submit">Reset</button>
	</form>

</body>
</html>