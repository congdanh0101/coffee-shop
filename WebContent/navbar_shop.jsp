<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<nav class="navbar-shop">
		<a href="index.html"> <img src="resource/img/logo.png" alt="photo"
			class="logo" style="width: 100px; margin-top: 5px;">
		</a>
		<ul class="main_nav">
			<li><a href="${pageContext.request.contextPath}/home">Trang chủ</a></li>
			<li><a href="index.html#testimonial">Đánh giá</a></li>
			<li><a href="index.html#about">Về chúng tôi</a></li>
			<li><a href="index.html#contact">Liên hệ</a></li>
			<li>
                <div class="cart-icon" id="cart-icon">
                    <a href="cart.jsp">Giỏ hàng
                        <i class="fas fa-cart-plus"></i>
                </div>
                </a>
            </li>
		</ul>
	</nav>