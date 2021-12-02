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
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/shop.css">
<link rel="stylesheet" href="css/product_detail.css" />
<script src="https://kit.fontawesome.com/4666aa241a.js"
	crossorigin="anonymous"></script>
<title>The Coffee Shop</title>
    <link rel="icon" href="https://cdn-icons-png.flaticon.com/512/2120/2120197.png" type="image/x-icon">
</head>
<body>

	<jsp:include page="navbar_shop.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-lg-3 my-4">
				<div class="card mb-4"
					style="box-shadow: 0 1px 2px rgb(102, 174, 177); background-color: #e0f7ff">
					<p class="card-header" style="font-size: 2rem; font-weight: 700;">Danh
						mục</p>
					<div class="list-group list-group-flush">
						<a href="home" class="list-group-item">Tất cả sản phẩm</a>
						<c:forEach var="item" items="${listCategory }">
							<a href="category?cid=${item.id }" class="list-group-item">${item.name }</a>
						</c:forEach>
						<!-- <a href="#" class="list-group-item">Bút bi</a>
                        <a href="#" class="list-group-item">Bút chì</a>
                        <a href="#" class="list-group-item">Gôm tẩy</a>
                        <a href="#" class="list-group-item">Thước kẻ</a> -->
					</div>
				</div>
			</div>
			<div class="col-lg-9 my-4">
				<div class="row">
					<c:forEach var="item" items="${listProduct }">
						<div class="col-lg-4 col-md-6 mb-4">
							<div class="card h-100 ">
								<a href="product_detail?pid=${item.id }"> <img
									src="${item.image } " alt=" " class="card-img-top ">
								</a>
								<div class="card-body ">
									<h4 class="card-title ">
										<a href="product_detail?pid=${item.id }">${item.name }</a>
									</h4>
									<h5 style="color: red; font-weight: bold;">${item.getPriceCurrencyFormat() }</h5>
									<%-- <p class=" card-text ">${item.description }</p> --%>
								</div>
								<%-- <a class="card-footer text-center " href="CartController?pid=${item.id }"
									style="cursor: pointer; text-decoration: none;">
									<form action="">
										<input type="number" value="1" name="quantity" hidden/>
									</form>
									<p style="margin: auto; padding: 10px 0; font-size: 1.5rem;">Thêm
										vào giỏ hàng</p> <i class="fas fa-cart-plus"
									style="margin: auto; font-size: 2rem;"></i>
								</a> --%>

							</div>

						</div>
					</c:forEach>
				</div>

			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>