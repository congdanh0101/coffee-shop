<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/admin.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="css/shop.css">
<link rel="stylesheet" href="css/style.css">
<title>TCS Administrator</title>
    <link rel="icon" href="https://cdn-icons-png.flaticon.com/512/2120/2120197.png" type="image/x-icon">

</head>
<body>
	<nav class="navbar-shop">
		<a href="admin.jsp"> <img src="resource/img/logo.png" alt="photo"
			class="logo" style="width: 100px; margin-top: 5px;">
		</a>

	</nav>
	<style>
a {
	text-decoration: none;
	color: black;
}
</style>
	<div class="container admin" style="margin-top: 100px;">
		<div class="row mt-3">
			<!-- first col -->
			<div class="col-md-3">
				<!-- first box -->
				<a href="admin?action=category">
					<div class="card">
						<div class="card-body text-center">
							<div class="container">
								<img style="max-width: 125px" class="img-fluid rounded-circle"
									src="resource/img/Category.png" alt="category_icon">
							</div>
							<h1>Category</h1>
						</div>
					</div>
				</a>
			</div>

			<!-- second col -->
			<div class="col-md-3">
				<a href="admin?action=product">
					<div class="card text-center">
						<div class="card-body">
							<div class="container">
								<img style="max-width: 125px" class="img-fluid rounded-circle"
									src="resource/img/product.png" alt="product_icon">
							</div>
							<h1>Products</h1>

						</div>

					</div>
				</a>

			</div>

			<!-- third col -->
			<div class="col-md-3">
				<a href="admin?action=bill">
					<div class="card">
						<div class="card-body text-center">
							<div class="container">
								<img style="max-width: 100px" class="img-fluid rounded-circle"
									src="resource/img/bill.png" alt="bill_icon">
							</div>
							<h1>Bills</h1>
						</div>
					</div>
				</a>
			</div>
			<div class="col-md-3">
				<a href="admin?action=customer">
					<div class="card">
						<div class="card-body text-center">
							<div class="container">
								<img style="max-width: 100px" class="img-fluid rounded-circle"
									src="resource/img/admin.png" alt="bill_icon">
							</div>
							<h1>Customer</h1>
						</div>
					</div>
				</a>
			</div>
		</div>
		<!-- second row -->
	</div>
</body>
</html>