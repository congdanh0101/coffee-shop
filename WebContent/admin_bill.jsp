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
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="navbar_admin.jsp"></jsp:include>
	<div class="container">
		<div class="row"></div>
		<table class="table table-hover table-bordered table-responsive ">
			<h2>list of Category</h2>
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Date</th>
					<th scope="col">Time</th>
					<th scope="col">Customer</th>
					<th scope="col">Status</th>
					<th scope="col">Detail</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${listBill }">
					<tr>
						<th scope="row">${item.getId() }</th>
						<td>${item.getDate() }</td>
						<td>${item.getTime() }</td>
						<td>${item.getCustomer().getName() }</td>
						<td>
						<select name=status id="">
								<c:forEach var="itemStatus" items="${listStatus }">
									<option value="${itemStatus.getId() }">${itemStatus.getName() }</option>
								</c:forEach>
						</select>
							<button style="float: right;">update</button></td>
						<td><a href="bill?bid=${item.getId() }">Detail</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


</body>
</html>