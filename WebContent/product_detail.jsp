<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script data-require="jquery@3.1.1" data-semver="3.1.1"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/shop.css">
<link rel="stylesheet" href="css/product_detail.css">
<script src="js/script.js"></script>
<script src="https://kit.fontawesome.com/4666aa241a.js"
	crossorigin="anonymous"></script>

<title>Insert title here</title>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container" style="margin-top: 150px;">
		<div class="row">
			<div class="col">
				<img src="${product.image }" alt="" style="width: 100%;">
			</div>
			<div class="col">
				<h2 style="color: black; font-size: 2rem; text-align: left;">${product.name }
				</h2>
				<div class="clearfix"></div>
				<h3 style="font-weight: bold; font-size: 2rem; color: red;">${product.getPriceCurrencyFormat() }</h3>
				<div class="clearfix"></div>
				<div class="product-description">
					<h3>thông tin sản phẩm:</h3>
					<p>${product.description }</p>
				</div>
				<div class="clearfix"></div>
				<div class="quantity-box">
					<h3>số lượng</h3>
					<form action="${pageContext.request.contextPath}/CartController" method="post">
						<div class="quantity buttons_added">
							<input type="button" value="-" class="minus"> <input
								type="number" step="1" min="1" max="" name="quantity" value="1"
								title="Qty" class="input-text qty text" size="4" pattern=""
								inputmode=""> <input type="button" value="+"
								class="plus">
						</div>
						<div class="clearfix"></div>
						<div class="row">
							<div class="col-9">
								<div class="size-product">
									<h3 style="margin-bottom: 10px;">Size</h3>
									<c:forEach var="item" items="${listSize }" begin="0" end="0">
										<input type="radio" name="size" value="${item.id }" checked />
										<label for="">${item.name }
											(+${item.getPriceCurrencyFormat()})</label>
									</c:forEach>
									<c:forEach var="item" items="${listSize }" begin="1" end="2">
										<input type="radio" name="size" value="${item.id }"
											style="margin-left: 10px;" />
										<label for="">${item.name } (+
											${item.getPriceCurrencyFormat()})</label>
									</c:forEach>
								</div>
							</div>
							<div class="col-3">
								<div class="topping-product">
									<h3 style="margin-bottom: 10px;">topping</h3>
									<select name="topping" id=""
										style="width: 250%; font-size: 1rem;">
										<c:forEach var="item" items="${listTopping }">
											<option value="${item.id }" style="height: 20px;">${item.name }
												(+ ${item.getPriceCurrencyFormat()})</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<input type="hidden" name="productId" value="${product.id}">
						<input type="submit" value="Add To Cart" name="addtocart"
							class="btn btn-primary btn-lg" style="margin-top: 40px;'">
					</form>
				</div>


			</div>
</body>

</html>