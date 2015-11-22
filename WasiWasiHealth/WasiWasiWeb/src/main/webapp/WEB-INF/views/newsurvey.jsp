<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<!-- Basic Page Needs -->
<meta charset="utf-8">
<title>WasiWasi New Survey</title>
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
<script type="text/javascript" src="js/wasi_util.js"></script>
<script type="text/javascript" src="js/newsurvey.js"></script>

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
				<h3>Create A New Survey</h3>
			</div>
			<div class="one-half column" style="margin-top: 5%">
				<img src="images/hipPOSLogoMedium.png" />
			</div>
		</div>
	</div>
	<div class="container" id="newSurveyDiv" data-bind="with: surveyModel">
		<form>
			<input type="hidden" id="csrfHeader" value="${_csrf.headerName}" />
			<input type="hidden" id="csrfToken" value="${_csrf.token}" /> <input
				type="hidden" name="id" data-bind="value: id" />
			<div class="row">
				<div class="one-half column" style="margin-top: 0%">
					<label for="surveyNameInput">Survey Name</label> <input
						data-bind="value: name" class="u-full-width" type="text"
						placeholder="survey name" id="surveyNameInput"
						name="surveyNameInput">
				</div>
				<div class="one-half column" style="margin-top: 0%">
					<label for="surveyActivationDate">Activation Date</label> <input
						data-bind="value: activationDate" class="u-full-width" type="date"
						id="activationDateInput" name="activationDateInput">
				</div>
			</div>
			<div class="row">
				<div class="one-half column">
					<button data-bind="click: $root.saveSurveyModel"
						class="button primary-button">Save Survey</button>
					&nbsp;&nbsp;
					<a class="button primary-button" href="#" id="createAQuestion">Create
					A Question</a>
				</div>
			</div>
		</form>
	</div>
	<div class="container" id="surveyQuestionDiv">
			<form>
				<div class="row">
					<div class="one-half column" style="margin-top: 0%">
						<label for="surveyQuestionInput">Your Question</label> <input
							class="u-full-width" type="text" placeholder="question"
							id="surveyQuestionInput" name="surveyQuestionInput">
					</div>
					<div class="one-half column" style="margin-top: 0%">
						<label for="surveyQuectionLegendInput">Response Legend</label> <input
							class="u-full-width" type="text" id="surveyQuectionLegendInput"
							name="surveyQuectionLegendInput">
					</div>
				</div>
				<div class="row">
					<div class="one-half column">
						<button 
							class="button primary-button" id="saveAndSendQuestionButton">Save and Send Question</button>
						&nbsp;&nbsp;
					</div>
				</div>
			</form>
	</div>
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
	

	<!-- End Document -->
</body>
</html>
