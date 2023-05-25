<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Home</title>
<link rel="icon" type="image/x-icon" href="./image/logo.ico">

<link rel="stylesheet"href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="./css/home.css">
<link rel="stylesheet" type="text/css" href="./css/responsive.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<link href="/dist/output.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap">
<!-- Font Awesome CDN -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">
<link rel="stylesheet" href="https://unpkg.com/aos@next/dist/aos.css" />

<%
String username = (String) session.getAttribute("username");
if(username==null)
{
	request.getRequestDispatcher("login.jsp").forward(request, response);
}
%>
</head>
<body>
	<!-- -------------------------------Header Section---------------------------- -->
	<header>
		<nav>
			<div class="logo">
				<img src="./image/logo.png" alt="No-Pic">
			</div>
			<div class="menu">
				<a href="./index.jsp">Home</a> 
				<a href="./invoice.jsp">Invoice</a>
				<a href="./product.jsp">Products</a> 
				<a href="./customer.jsp">Customers</a>
				<a href="./calculator.jsp" target="_blank">Calculate It</a>
				<a href="./registration.jsp" target="_blank">Sign In</a>
				<a href="./login.jsp" target="_blank">Log In</a>
				<a href="./logout.jsp" target="_blank">Logout</a>

			</div>
			<!-- <div class="login">
                <a href="#">Login</a>
            </div> -->
		</nav>
		<section class="header_text">
			<span class="something">Invoice Management System</span>
			<h1>
				Wait Wait! Where are you going take your invoice It's your <br>
				<span class="auto-type"></span>
			</h1>
			<br>
		</section>

	</header>
	<!-- -------------------------------About Section---------------------------- -->
	<main data-aos="fade-up">
		<div class="container" style="margin-top: 4%;">
			<h1 style="margin-top: 3%;">
				ABOUT <span>US</span>
			</h1>
			<div class="row">
				<div class="col-md-6">
					<img src="./image/about.png" alt="No-Pic">
				</div>
				<div class="col-md-6">
					<p class="para">While similar information is included in sales
						receipts and invoices, they are not the same. An invoice is issued
						to collect payments from customers, and a sales receipt documents
						proof of payment that a customer has made to a seller. Receipts
						are used as documentation to confirm that a customer has received
						the goods or services they paid for, and as a record that the
						business has been paid.A payment letter is a polite way of
						reminding your customer of their pending bill. Because of busy
						schedules, some people forget to service their bills in time. In
						such a case, the individual can write a letter to remind them they
						are yet to pay the bill. A landlord, business owner, or learning
						institution can write a letter to ask for payment.</p>
				</div>
			</div>
		</div>
	</main>
	<!-- -------------------------------Statistics Section---------------------------- -->
	<section style="margin-top: 3%;" data-aos="fade-up">
		<div class="hero">
			<div class="title">
				<h1 style="margin-top: 3%;">STATISTICS</h1>
				<!-- <p>Duis vulputate et nulla ac dapibus. Nullam feugiat massa elit, at scelerisque urna facilisis id. Suspendisse commodo scelerisque sem sit amet aliquam. Curabitur nulla lectus, pretium ac arcu sed, laoreet eleifend nunc.Duis vulputate et nulla ac dapibus. Nullam feugiat massa elit.</p> -->
			</div>

			<div class="row">
				<div class="col">
					<div class="counter-box">
						<i class="fa fa-inr" aria-hidden="true"></i>
						<h2 class="counter" data-number="215">0+</h2>
						<h4>SALES AMOUNT</h4>
					</div>
				</div>
				<div class="col">
					<div class="counter-box">
						<i class="fa fa-users"></i>
						<h2 class="counter" data-number="312">0+</h2>
						<h4>USERS</h4>
					</div>
				</div>
				<div class="col">
					<div class="counter-box">
						<i class="fa fa-exclamation-triangle" aria-hidden="true"></i>
						<h2 class="counter" data-number="205">0+</h2>
						<h4>DUE AMOUNT</h4>
					</div>
				</div>
				<div class="col">
					<div class="counter-box">
						<i class="fa fa-file-text" aria-hidden="true"></i>
						<h2 class="counter" data-number="519">0+</h2>
						<h4>TOTAL INVOICE</h4>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- -------------------------------Contact Form---------------------------- -->
	<section class="text-gray-600 body-font relative">
		<div class="container px-5 py-24 mx-auto">
			<div class="flex flex-col text-center w-full mb-12">
				<h1
					class="sm:text-3xl text-2xl font-medium title-font mb-4 text-gray-900">CONTACT
					US</h1>
				<p class="lg:w-2/3 mx-auto leading-relaxed text-base">Feel free
					to drop any feedback where we need to work more. :)</p>
			</div>
			<div class="lg:w-1/2 md:w-2/3 mx-auto">
				<div class="flex flex-wrap -m-2">
					<div class="p-2 w-1/2">
						<div class="relative">
							<label for="name" class="leading-7 text-sm text-gray-600">Name</label>
							<input type="text" id="name" name="name"
								class="w-full bg-gray-100 bg-opacity-50 rounded border border-gray-300 focus:border-blue-500 focus:bg-white focus:ring-2 focus:ring-blue-200 text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out">
						</div>
					</div>
					<div class="p-2 w-1/2">
						<div class="relative">
							<label for="email" class="leading-7 text-sm text-gray-600">Email</label>
							<input type="email" id="email" name="email"
								class="w-full bg-gray-100 bg-opacity-50 rounded border border-gray-300 focus:border-blue-500 focus:bg-white focus:ring-2 focus:ring-blue-200 text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out">
						</div>
					</div>
					<div class="p-2 w-full">
						<div class="relative">
							<label for="message" class="leading-7 text-sm text-gray-600">Message</label>
							<textarea id="message" name="message"
								class="w-full bg-gray-100 bg-opacity-50 rounded border border-gray-300 focus:border-blue-500 focus:bg-white focus:ring-2 focus:ring-blue-200 h-32 text-base outline-none text-gray-700 py-1 px-3 resize-none leading-6 transition-colors duration-200 ease-in-out"></textarea>
						</div>
					</div>
					<div class="p-2 w-full">
						<button
							class="flex mx-auto text-white bg-blue-500 border-0 py-2 px-8 focus:outline-none hover:bg-blue-600 rounded text-lg"
							style="font-family: 'Bree Serif', sans-serif;">Submit</button>
					</div>

				</div>
			</div>
		</div>
	</section>
	<!-- -------------------------------Footer Section---------------------------- -->
	<section>
		<footer class="footer" style="margin-top: 5%;">
			<div class="waves">
				<div class="wave" id="wave1"></div>
				<div class="wave" id="wave2"></div>
				<div class="wave" id="wave3"></div>
				<div class="wave" id="wave4"></div>
			</div>
			<ul class="social-icon">
				<li class="social-icon__item"><a class="social-icon__link"
					href="https://www.facebook.com/rk.kundu26/"> <ion-icon name="logo-facebook"></ion-icon>
				</a></li>
				<li class="social-icon__item"><a class="social-icon__link"
					href="https://twitter.com/RipamKundu?fbclid=IwAR025OdxOKMLPmm_Z6uHQeimXUKbj9s9elwNoj7wFwpQvPCQHRAFhwo3hEQ"> <ion-icon name="logo-twitter"></ion-icon>
				</a></li>
				<li class="social-icon__item"><a class="social-icon__link"
					href="https://www.linkedin.com/in/rk-ripam-kundu/"> <ion-icon name="logo-linkedin"></ion-icon>
				</a></li>
				<li class="social-icon__item"><a class="social-icon__link"
					href="https://www.instagram.com/rk_ripam_kundu/?hl=en"> <ion-icon name="logo-instagram"></ion-icon>
				</a></li>
			</ul>
			<p>&copy; MadeBy MCA Student 2k22 - 23 | All Rights Reserved</p>
		</footer>
	</section>

	<script src="https://unpkg.com/typed.js@2.0.15/dist/typed.umd.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
	<script src="https://cdn.tailwindcss.com"></script>
	<script src="https://unpkg.com/aos@next/dist/aos.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
	<script type="module"
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script src="./js/custom.js"></script>
</body>
</html>