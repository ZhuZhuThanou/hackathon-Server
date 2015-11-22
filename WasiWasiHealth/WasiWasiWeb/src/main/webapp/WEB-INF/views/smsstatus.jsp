<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<!-- Basic Page Needs -->
<meta charset="utf-8">
<title>WasiWasi SMS Status</title>
<meta name="description" content="">
<meta name="author" content="">

<!-- Mobile Specific Metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- FONT -->
<link href="//fonts.googleapis.com/css?family=Raleway:400,300,600"
	rel="stylesheet" type="text/css">

<!-- CSS -->
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/skeleton.css">
<link rel="stylesheet" href="css/wasi.css">

<!-- JavaScripts -->
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/knockout-3.4.0.js"></script>
<script type="text/javascript" src="js/d3.v2.js"></script>
<script type="text/javascript" src="js/wasi_util.js"></script>
<script type="text/javascript" src="js/smsstatus.js"></script>

<!-- Favicon  -->
<link rel="icon" type="image/png" href="images/favicon.png">

</head>
<body>

	<!-- Primary Page Layout -->
	<div class="container">
		<div class="row">
			<div class="one-half column" style="margin-top: 5%">
				<a class="button" href="index.html">Home</a> <a class="button"
					href="logout">Logout</a>
				<h2>WasiWasi Health</h2>
				<h3>SMS Status</h3>
			</div>
			<div class="one-half column" style="margin-top: 5%">
				<img src="images/hipPOSLogoMedium.png" />
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="one-half column">
				<div class="container" id="questionListDiv">
					<table class="u-full-width" id="questionTable">
						<thead>
							<tr>
								<th></th>
								<th>Question</th>
								<th>Responses</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- End Document -->
</body>
</html>
