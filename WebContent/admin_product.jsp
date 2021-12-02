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
			<h2>list of product</h2>
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Name</th>
					<th scope="col">Price</th>
					<th scope="col">Description</th>
					<th scope="col">Code</th>
					<th scope="col">Category</th>
					<th scope="col">Remove</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${listProduct }">
					<tr>
						<th scope="row">${item.getId() }</th>
						<td>${item.getName() }</td>
						<td>${item.getPriceCurrencyFormat() }</td>
						<td>${item.getDescription() }</td>
						<td>${item.getCode() }</td>
						<td>${item.getCategory().getName() }</td>
						<td><a href="AdminProduct?pid=${item.getId() }">Remove</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<button class="open-button" onclick="openForm()">Add product</button>

	<div class="form-popup" id="myForm">
		<form action="AdminProduct" class="form-container" method="post">

			<label for="name"><b>Name</b></label>
            <input type="text" placeholder="Enter name" name="name" required>

            <label for="code"><b>Code</b></label>
            <input type="text" placeholder="Enter code" name="code" >

            <label for="description"><b>Description</b></label>
            <input type="text" placeholder="Enter description" name="description" >

            <label for="img"><b>Image</b></label>
            <input type="text" placeholder="Enter image address" name="img" required>

            <label for="price"><b>Price</b></label>
            <input type="number" placeholder="Enter price" min="0" name="price" required>
            
            <label for="category"><b>Category</b></label>
			<select name="category" id=""
				style="width: 50%;">
				<c:forEach var="item" items="${listCategory }">
					<option value="${item.getId() }">${item.getName() }</option>
				</c:forEach>
			</select>


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