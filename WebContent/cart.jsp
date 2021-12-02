<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
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
<link rel="stylesheet" href="css/product_detail.css">
<link rel="stylesheet" href="css/cart.css">
<script src="js/script.js"></script>
<script src="https://kit.fontawesome.com/4666aa241a.js"
	crossorigin="anonymous"></script>
<title>The Coffee Shop</title>
    <link rel="icon" href="https://cdn-icons-png.flaticon.com/512/2120/2120197.png" type="image/x-icon">
</head>
<body>
	<jsp:include page="navbar_shop.jsp"></jsp:include>
	<div class="container pb-5 mt-n2 mt-md-n3" style="margin-top: 4rem;">
		<div class="row">
			<div class="col-xl-9 col-md-8">
				<h2
					class="h6 d-flex flex-wrap justify-content-between align-items-center px-4 py-3 bg-secondary">
					<span>Sản phẩm</span><a class="font-size-sm" href="home"
						style="margin-left: 30rem;"><svg
							xmlns="http://www.w3.org/2000/svg" width="24" height="24"
							viewBox="0 0 24 24" fill="none" stroke="currentColor"
							stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
							class="feather feather-chevron-left"
							style="width: 1rem; height: 1rem;">
							<polyline points="15 18 9 12 15 6"></polyline></svg>Tiếp tục mua hàng</a>
				</h2>
				<!-- Item-->
				<c:forEach var="item" items="${cart.items}">
					<div
						class="d-sm-flex justify-content-between my-4 pb-4 border-bottom">
						<div class="media d-block d-sm-flex text-center text-sm-left">
							<a class="cart-item-thumb mx-auto mr-sm-4"
								href="product_detail?pid=${item.product.id }"><img
								src="${item.product.image }" alt="Product"></a>
							<div class="media-body pt-3">
								<h3
									class="product-card-title font-weight-semibold border-0 pb-0">
									<input type="hidden" value="${item.product.id }"
										name="product_id" /> <a
										href="product_detail?pid=${item.product.id }">${item.product.name }</a>
								</h3>
								<div class="font-size-sm">
									<span class="text-muted mr-2">Thông tin sản phẩm: </span>
									<p>Size: ${item.size.name}</p>
									<p>Topping: ${item.topping.name }</p>
								</div>
								<div class="font-size-sm">
									<span class="text-muted mr-2">Đơn giá: </span>${item.getPriceCurrencyFormat()}
								</div>
								<div class="font-size-lg text-primary pt-2">Thành tiền:
									${item.getTotalCurrencyFormat() }</div>
							</div>
						</div>
						<div
							class="pt-2 pt-sm-0 pl-sm-3 mx-auto mx-sm-0 text-center text-sm-left"
							style="max-width: 10rem;">
							<div class="form-group mb-2">
								<label for="quantity1">Số lượng</label>
								<form action="CartController" method="post">

									<div class="quantity buttons_added">
										<input type="button" value="-" class="minus"><input
											type="number" step="1" min="1" max="" name="quantity"
											value="${item.quantity }" title="Qty"
											class="input-text qty text" size="4" pattern="" inputmode=""><input
											type="button" value="+" class="plus">
									</div>
									<input type="hidden" name="productId"
										value="${item.product.id }" /> <input type="hidden"
										name="size" value="${item.size.id }" /> <input type="hidden"
										name="topping" value="${item.topping.id }" /> <input
										type="submit" value="Cập nhật"
										class="btn btn-outline-secondary btn-sm btn-block mb-2 update-btn"
										name="update">

								</form>
								<form action="CartController" method="post">
									<input type="hidden" name="productId"
										value="${item.product.id }" /> <input type="hidden"
										name="size" value="${item.size.id }" /> <input type="hidden"
										name="topping" value="${item.topping.id }" /> <input
										type="hidden" name="quantity" value="0" /> <input
										type="submit" value="Xóa"
										class="btn btn-outline-secondary btn-sm btn-block mb-2 remove-btn"
										name="update">
								</form>

							</div>


						</div>
					</div>
				</c:forEach>



			</div>
			<!-- Sidebar-->
			<div class="col-xl-3 col-md-4 pt-3 pt-md-0">
				<h2 class="h6 px-4 py-3 bg-secondary text-center">Tổng tiền</h2>
				<div class="h3 font-weight-semibold text-center py-3"
					style="color: red;">${cart.getSubTotalCurrencyFormat() }</div>
				<hr>
				<h3 class="h6 pt-4 font-weight-semibold">
					<span class="badge badge-success mr-2">Note</span>Thêm ghi chú cho cửa hàng
				</h3>
				<textarea class="form-control mb-3" id="order-comments" rows="5"></textarea>
				<a class="btn btn-primary btn-block" href="checkout"> <svg
						xmlns="http://www.w3.org/2000/svg" width="24" height="24"
						viewBox="0 0 24 24" fill="none" stroke="currentColor"
						stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
						class="feather feather-credit-card mr-2">
                        <rect x="1" y="4" width="22" height="16" rx="2"
							ry="2"></rect>
                        <line x1="1" y1="10" x2="23" y2="10"></line>
                    </svg> Thanh toán
				</a>


			</div>
		</div>
	</div>
</body>

</html>