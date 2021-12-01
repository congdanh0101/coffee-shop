<%@page import="nhom2.project.model.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="nhom2.project.model.*"%>
<%@page import="nhom2.project.data.*"%>
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
					<th scope="col">Name</th>
					<th scope="col">Remove</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${listCategory }">
					<tr>
						<th scope="row">${item.getId() }</th>
						<td><a href="categoryadmin?cid=${item.getId() }">${item.getName() }</a></td>
						<td><a href="#">remove</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<button class="open-button" onclick="openForm()">Add Category</button>

	<div class="form-popup" id="myForm">
		<form action="${pageContext.request.contextPath}/admin"
			class="form-container" method="post">

			<label for="name"><b>Name</b></label> <input type="text"
				placeholder="Enter name" name="category" required>

			<button type="submit" class="btn">Submit</button>
			<button type="button" class="btn cancel" onclick="closeForm()">Close</button>
		</form>
	</div>
</body>

<script>
	function openForm() {
		document.getElementById("myForm").style.display = "block";
	}

	function closeForm() {
		document.getElementById("myForm").style.display = "none";
	}
</script>
</html>