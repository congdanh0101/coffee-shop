<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script data-require="jquery@3.1.1" data-semver="3.1.1"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/shop.css">
<link rel="stylesheet" href="css/add.css">
<title>TCS Administrator</title>
    <link rel="icon" href="https://cdn-icons-png.flaticon.com/512/2120/2120197.png" type="image/x-icon">
</head>
<body>
	<jsp:include page="navbar_admin.jsp"></jsp:include>
	<div class="container">
		<div class="row"></div>
		<table class="table table-hover table-bordered table-responsive ">
			<h2>list of bill detail</h2>
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Product</th>
					<th scope="col">Size</th>
					<th scope="col">Topping</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					<th scope="col">Total</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${listBillDetail }">
					<tr>
						<th scope="row">${item.getId() }</th>
						<td>${item.getProduct().getName() }</td>
						<td>${item.getSize().getName() }</td>
						<td>${item.getTopping().getName() }</td>
						<td>${item.getQuantity() }</td>
						<td>${item.getPriceCurrencyFormat() }</td>
						<td>${item.getTotalCurrencyFormat() }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h3 style="float: right; color: red; font-weight: bold;">Subtotal: ${subtotal}</h3>
	</div>


</body>
</html>