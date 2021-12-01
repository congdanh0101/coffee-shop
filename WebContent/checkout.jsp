<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/shop.css">
<link rel="stylesheet" href="css/product_detail.css">
<link rel="stylesheet" href="css/cart.css">
<script src="https://kit.fontawesome.com/4666aa241a.js"
	crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
<body>
	<jsp:include page="navbar_shop.jsp"></jsp:include>
	<form action="${pageContext.request.contextPath}/register" method="post">
		<div class="container">
			<div class="row">
				<!-- panel preview -->
				<div class="col-sm-4" style="margin-left: -250px; width: 60%;">
					<h2>Your information:</h2>
					<div class="panel panel-default">
						<div class="panel-body form-horizontal payment-form">
							
								<div class="form-group">
									<label for="concept" class="col-sm-3 control-label">Your
										name</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="fullName"
											name="fullName" required>
									</div>
								</div>
								<div class="form-group">
									<label for="description" class="col-sm-3 control-label">Email</label>
									<div class="col-sm-9">
										<input type="email" class="form-control" id="email"
											name="email" required>
									</div>
								</div>
								<div class="form-group">
									<label for="amount" class="col-sm-3 control-label">Your
										phone</label>
									<div class="col-sm-9">
										<input type="number" class="form-control" id="phoneNumber"
											name="phoneNumber" required min="100000000" max="9999999999">
									</div>
								</div>
								<div class="form-group">
									<label for="status" class="col-sm-3 control-label">Address</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="address"
											name="address" required>
									</div>
								</div>
								<div class="form-group">
									<label for="status" class="col-sm-3 control-label">Comment</label>
									<div class="col-sm-9">
										<textarea name="comment" id="" cols="30" rows="5"
											class="form-control"></textarea>
									</div>
								</div>

								<div class="form-group">
									<div class="col-sm-12 text-right">
										<a href="cart.jsp">
										<button type="button"
											class="btn btn-default preview-add-button">
											<span class="fas fa-cart-plus"></span> Back to cart
										</button>
									</a>
										<!-- <button type="submit" class=" btn btn-primary btn-block "
											style="width: 150px; padding: 5px 0; font-size: 1.5rem;">Submit
											all</button> -->
									</div>

								</div>

							

						</div>
					</div>
				</div>
				<!-- / panel preview -->
				<div class="col-sm-8" style="width: 70%; margin-right: -150px;">
					<h2>Preview:</h2>
					<div class="row">
						<div class="col-xs-12">
							<div class="table-responsive">
								<table class="table preview-table">
									<thead>
										<tr>
											<th>Product</th>
											<th>Description</th>
											<th>Quantity</th>
											<th>Price</th>
											<th>Total</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="item" items="${cart.items }">
											<tr style="font-size: 20px;">
												<td>${item.product.name }<br /> <br /> <img
													src="${item.product.image }" style="width: 100px" alt="" />
												</td>
												<td><%-- ${item.product.description } --%></td>
												<td>${item.quantity }</td>
												<td style="font-weight: bold;">${item.getPriceCurrencyFormat() }</td>
												<td style="font-weight: bold;">${item.getTotalCurrencyFormat() }</td>

											</tr>
										</c:forEach>
									</tbody>
									<!-- preview content goes here-->
								</table>
							</div>
						</div>
					</div>
					<hr style="border: 1px dashed #dddddd;">
					<div class="row text-right">
						<div class="col-xs-12">
							<h3 style="color: red; font-weight: bold;">
								Subtotal: ${cart.getSubTotalCurrencyFormat() } <strong><span
									class="preview-total"></span></strong>
							</h3>
						</div>
					</div>
					<div class="row">
						<hr style="border: 1px dashed #dddddd;">
						<div class="col-xs-12"
							style="margin-left: 77.5%; margin-top: 1rem;">
							
								<button type="submit" class=" btn btn-primary btn-block "
									style="width: 150px; padding: 5px 0; font-size: 1.5rem;">Submit
									all</button>
							

						</div>
					</div>
				</div>
			</div>
		</div>
	</form>

</body>
</body>

</html>

