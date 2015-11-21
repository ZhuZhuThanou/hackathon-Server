<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

  <!-- Basic Page Needs -->
  <meta charset="utf-8">
  <title>Hip-POS Vendor</title>
  <meta name="description" content="">
  <meta name="author" content="">

  <!-- Mobile Specific Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- FONT -->
  <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">

  <!-- CSS -->
  <link rel="stylesheet" href="css/normalize.css">
  <link rel="stylesheet" href="css/skeleton.css">
  <link rel="stylesheet" href="css/wasi.css">

  <!-- JavaScripts -->
  <script type="text/javascript"  src="js/jquery-1.11.1.min.js"></script>
  <script type="text/javascript"  src="js/knockout-3.4.0.js"></script>
  <script type="text/javascript"  src="js/wasi_util.js"></script>
  <script type="text/javascript"  src="js/admin.js"></script>

  <!-- Favicon  -->
  <link rel="icon" type="image/png" href="images/favicon.png">

</head>
<body>

  <!-- Primary Page Layout -->
  <div class="container">
  	<div class="row">
  		<div class="one-half column" style="margin-top: 5%">
  			<a class="button" href="index.html">Home</a>
  			<a class="button" href="logout">Logout</a>
  			<h2>WasiWasi Health</h2>
  			<h3>Admin</h3>
  		</div>
  		<div class="one-half column" style="margin-top: 5%">
  			<img src="images/hipPOSLogoMedium.png" />
  		</div>
  	</div>
  </div>
  <div class="container">
  	<div class="row">
		<div class="five columns">
			<a class="button" href="survey">Manage WasiWasi Surveys</a><p/>
			<button class="button-primary" id="editAdminButton">Edit My Info</button>
			<button class="button-primary" id="pwdAdminButton">Change Password</button>
		</div>  	
		<div class="seven columns" id="adminInfoDiv"></div>
  	</div>
  </div>
  <div class="container" id="changePasswordForm">
  	<div class="container">
  	 <div class="row">
	      <div class="one-half column" style="margin-top: 5%">
	      	<label for="userPwdInput">New Password</label>
      		<input class="u-full-width" type="password" placeholder="New Password" name="userPwdInput" id="userPwdInput">
	      </div>
	      <div class="one-half column" style="margin-top: 5%">
	      	<label for="userNameInput">Confirm Password</label>
      		<input class="u-full-width" type="password" placeholder="Confirm Passworld" name="userConfirmPwdInput" id="userConfirmPwdInput">
	      </div>
	</div>
	<div class="row">
		<div class="four columns" style="margin-top: 0%">
			<button class="button-primary" id="changePwdButton">Change Password</button>
			<span id="changePwdResult"></span>
		</div>
		<div class="eight columns" style="margin-top: 0%" id="changePwdResponse"></div>
	</div>
	</div>
  </div>
  <div class="container" id="adminEditForm">
  	 <form id="updateForm" action="admin" method="post">	
  	  <input type="hidden" name="adminId" id="adminId" value="${adminId}" />
	  <input type="hidden" id="csrfHeader" value="${_csrf.headerName}"/>
  	  <input type="hidden" id="csrfToken" value="${_csrf.token}"/>
	  <div class="container">
	    <div class="row">
	      <div class="one-half column" style="margin-top: 5%">
	      	<label for="userEmailInput">Your email</label>
      		<input class="u-full-width" type="email" placeholder="your@email.com" name="userEmailInput" id="userEmailInput">
	      </div>
	      <div class="one-half column" style="margin-top: 5%">
	      	<label for="userNameInput">Your Name</label>
      		<input class="u-full-width" type="text" placeholder="Your Name..." name="userNameInput" id="userNameInput">
	      </div>
	    </div>
	    <div class="row">
	    	<div class="five columns" style="margin-top: 0%">
	    		<button type="submit" class="button-primary" id="updateAdminButton">Update Me</button>&nbsp;&nbsp;
	    	</div>
	    </div>
	    <div class="row">
	    	<div id="warningMessage" class="twelve columns" style="margin-top: 0%">
	    	</div>
	    </div>
	  </div>
  </form>
  
  </div>
<!-- End Document -->
</body>
</html>
