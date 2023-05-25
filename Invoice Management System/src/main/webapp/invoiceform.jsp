<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Invoice Form</title>
<link rel="icon" type="image/x-icon" href="./image/logo.ico">
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Bree+Serif&display=swap')
	;

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Bree Serif', serif;
}

body {
	height: auto;
	display: flex;
	justify-content: center;
	align-items: center;
	padding: 10px;
	background: linear-gradient(135deg, #71b7e6, #9b59b6);
}

.container {
	max-width: 700px;
	width: 100%;
	background-color: #fff;
	padding: 25px 30px;
	border-radius: 5px;
	box-shadow: 0 5px 10px rgba(0, 0, 0, 0.15);
}

.container .title {
	font-size: 25px;
	font-weight: 500;
	position: relative;
}

.container .title::before {
	content: "";
	position: absolute;
	left: 0;
	bottom: 0;
	height: 3px;
	width: 30px;
	border-radius: 5px;
	background: linear-gradient(135deg, #71b7e6, #9b59b6);
}

.content form .user-details {
	display: flex;
	flex-wrap: wrap;
	justify-content: space-between;
	margin: 20px 0 12px 0;
}

form .user-details .input-box {
	margin-bottom: 15px;
	width: calc(100%/ 2 - 20px);
}

form .input-box span.details {
	display: block;
	font-weight: 500;
	margin-bottom: 5px;
}

.user-details .input-box input, .user-details .input-box select {
	height: 45px;
	width: 100%;
	outline: none;
	font-size: 16px;
	border-radius: 5px;
	padding-left: 15px;
	border: 1px solid #ccc;
	border-bottom-width: 2px;
	transition: all 0.3s ease;
}

.user-details .input-box input:focus, .user-details .input-box input:valid
	{
	border-color: #9b59b6;
}

.user-details .input-box select:focus, .user-details .input-box select:valid
	{
	border-color: #9b59b6;
}

form .gender-details .gender-title {
	font-size: 20px;
	font-weight: 500;
}

form .category {
	display: flex;
	width: 80%;
	margin: 14px 0;
	justify-content: space-between;
}

form .category label {
	display: flex;
	align-items: center;
	cursor: pointer;
}

form .category label .dot {
	height: 18px;
	width: 18px;
	border-radius: 50%;
	margin-right: 10px;
	background: #d9d9d9;
	border: 5px solid transparent;
	transition: all 0.3s ease;
}

#dot-1:checked ~ .category label .one, #dot-2:checked ~ .category label .two,
	#dot-3:checked ~ .category label .three {
	background: #9b59b6;
	border-color: #d9d9d9;
}

form input[type="radio"] {
	display: none;
}

form .button {
	width: 100%;
	height: 45px;
	margin: 35px 0
}

form .button input {
	height: 100%;
	width: 100%;
	border-radius: 5px;
	border: none;
	color: #fff;
	font-size: 18px;
	font-weight: 500;
	letter-spacing: 1px;
	cursor: pointer;
	transition: all 0.3s ease;
	background: linear-gradient(135deg, #71b7e6, #9b59b6);
}

form .button input:hover {
	/* transform: scale(0.99); */
	background: linear-gradient(-135deg, #71b7e6, #9b59b6);
}

@media ( max-width : 584px) {
    body{
        height: 100vh;
    }
	.container {
		max-width: 100%;
	}
	form .user-details .input-box {
		margin-bottom: 15px;
		width: 100%;
	}
	form .category {
		width: 100%;
	}
	.content form .user-details {
		max-height: 300px;
		overflow-y: scroll;
	}
	.user-details::-webkit-scrollbar {
		width: 5px;
	}
}

@media ( max-width : 459px) {
	.container .content .category {
		flex-direction: column;
	}
	.user-details .input-box input {
    font-size: 14px;
  }
}

.subtotal {
	display: flex;
	flex-direction: column;
}

.sub {
	display: flex;
}
</style>
</head>
<body>
	<div class="container">
		<div class="title">Fill the Invoice Details</div>
		<div class="content">
			<form action="#">
				<div class="user-details">
					<div class="input-box">
						<span class="details">Invoice Date</span> 
						<input type="date" name="invoiceDate" placeholder="Enter the invoice date" required>
					</div>
					<div class="input-box">
						<span class="details">Due Date</span> 
						<input type="date" name="dueDate" placeholder="Enter the due date" required>
					</div>
					<div class="input-box">
						<span class="details">Invoice Number</span> 
						<input type="text" name="invoiceNo" placeholder="Enter the invoice number" required>
					</div>
					<div class="input-box">
						<span class="details">Invoice Status</span> 
						<select type="text" name="invoiceStatus" required>
							<option value="open">Open</option>
							<option value="paid">Paid</option>
						</select>
					</div>
					<div class="input-box">
						<span class="details">Select a Product</span> 
						<select type="text" name="product" required>
							<option value=""></option>
						</select>
					</div>
					<div class="input-box">
						<span class="details">Select the customer</span> <select name="customer"
							type="text" required>
							<option value=""></option>
						</select>
					</div>
					<div class="input-box">
						<span class="details">Quantity</span> 
						<input type="number" name="quantity" placeholder="Enter the quantity" required>
					</div>
					<div class="input-box">
						<span class="details">Price</span> <input type="number" name="price"
							placeholder="Price of the product" required>
					</div>
					<div class="input-box">
						<span class="details">Discount</span> <input type="number" name="discount"
							placeholder="Enter the discount percentage" required>
					</div>
					<div class="input-box">
						<span class="details">Shipping Cost</span> <input type="number" name="shippingCost"
							placeholder="Enter the shipping cost" required>
					</div>
					<div class="subtotal" style="margin-top: 1%;">
						<div class="sub">
							<h4>TAX & VAT :</h4>
							<p>0 Rupees</p>
						</div>
						<div class="sub">
							<h4>SUB TOTAL :</h4>
							<p>0 Rupees</p>
						</div>
					</div>
				</div>



				<div class="button">
					<input type="submit" value="Create Invoice" name="submit">
				</div>
			</form>
		</div>
	</div>


</body>
</html>