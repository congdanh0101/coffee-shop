<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<nav class="navbar-shop">
		<a href="index.html"> <img src="resource/img/logo.png" alt="photo"
			class="logo" style="width: 100px; margin-top: 5px;">
		</a>
		<ul class="main_nav">
			<li><a href="${pageContext.request.contextPath}/home">HomePage</a></li>
			<li><a href="index.html#testimonial">How client think</a></li>
			<li><a href="index.html#about">About</a></li>
			<li><a href="index.html#contact">Contact</a></li>
			<li>
                <div class="cart-icon" id="cart-icon">
                    <a href="cart.jsp">Giỏ hàng
                        <i class="fas fa-cart-plus"></i>
                </div>
                </a>
            </li>
		</ul>
	</nav>