<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login page</title>

<!-- Mobile Specific Metas
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- FONT
  –––––––––––––––––––––––––––––––––––––––––––––––––– -->
<link href="//fonts.googleapis.com/css?family=Raleway:400,300,600"
	rel="stylesheet" type="text/css">

<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/skeleton.css">
<link rel="icon" type="image/png" href="images/favicon.png">
</head>

<body>


	<c:url var="loginUrl" value="/login" />
	
	<div class="container">
		<div class="row">
			<div class="one-half column" style="margin-top: 5%">
				<a class="button" href="index.html">Home</a>
				<h2>WasiWasi</h2>
				<h3>Login Page</h3>
			</div>
			<div class="one-half column">
				<img src="images/hipPOSLogoSmall.png" />
			</div>
		</div>
	</div>

	<form id="loginForm" action="${loginUrl}" method="post" >
		<c:if test="${param.error != null}">
			
			<div class="container">
				<div class="row">
					<p>Invalid username and password.</p>
				</div>
			</div>
		</c:if>
		<c:if test="${param.logout != null}">
			<div class="container">
				<div class="row">
					<p>You have been logged out successfully.</p>
				</div>
			</div>
		</c:if>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<div class="container">
			<div class="row">
				<div class="one-half column" style="margin-top: 0%">
					<label for="userEmailInput">Your email</label> <input
						class="u-full-width" type="email" placeholder="test@mailbox.com"
						id="userEmailInput" name="ssoId">
				</div>
				<div class="one-half column" style="margin-top: 0%">
					<label for="userPasswordInput">Your Password</label> <input
						class="u-full-width" type="password" id="userPasswordInput" name="password">
				</div>
			</div>
			<div class="row">
				<div class="one-half column" style="margin-top: 0%">
					<button class="button-primary" id="loginButton">Login</button>
					&nbsp;&nbsp; <a href="forgotPassword.html">Forgot Password</a>
				</div>
			</div>
		</div>
	</form>

	<!-- 			

	<form action="${loginUrl}" method="post" class="form-horizontal">
		<div class="container">
			
			<div class="row">
				<div class="one-half column" style="margin-top: 5%">
					<label for="username">User Name</label>
					<input type="text" id="username" name="ssoId" placeholder="Enter Username" required>
				</div>
			</div>
			<div class="row">	
				<div class="one-half column" style="margin-top: 0%">
					<label for="password">Password</label> 
					<input type="password" id="password" name="password" placeholder="Enter Password" required>
				</div>
			</div>	
				

				<div class="form-actions">
					<input type="submit" class="btn btn-block btn-primary btn-default"
						value="Log in">
				</div>
			</div>
	</form>

 -->
</body>
</html>