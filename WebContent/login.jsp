<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/login.css" />
<title>Insert title here</title>
</head>
<body>

	<div class="login-box">
		<h1>Login</h1>
		<form action="login" method="post">
			<div class="textbox">
				<input type="text" name="username" placeholder="Username"
					required="required">
			</div>

			<div class="textbox">
				<input type="password" name="password" placeholder="Password"
					required="required">
			</div>
			<input class="btn" type="submit" name="" value="Sign In">
		</form>
	</div>

</body>
</html>