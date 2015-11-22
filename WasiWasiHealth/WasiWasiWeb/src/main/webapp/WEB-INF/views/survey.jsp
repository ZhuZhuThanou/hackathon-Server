<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

  <!-- Basic Page Needs -->
  <meta charset="utf-8">
  <title>WasiWasi Survey</title>
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
  <script type="text/javascript"  src="js/d3.v2.js"></script>
  <script type="text/javascript"  src="js/wasi_util.js"></script>
  <script type="text/javascript"  src="js/survey.js"></script>

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
  			<h3>Survey Manager</h3>
  		</div>
  		<div class="one-half column" style="margin-top: 5%">
  			<img src="images/hipPOSLogoMedium.png" />
  		</div>
  	</div>
  </div>
  <div class="container">
  	<div class="row">
  		<div class="one-half column">
  			<a class="button primary-button" href="newsurvey">Create New WasiWasi Survey</a>
  		
  		</div>
  	</div>
  	<!-- <a href="#" data-bind="click: $parent.removePerson">Remove</a> -->
  	<div class="row">
		<div class="eleven columns">
			<table>
			<thead>
        		<tr><th></th><th>Survey Date</th><th>Name</th><th>% Completed</th><th># Participants</tr>
    		</thead>
    			<tbody data-bind="foreach: surveyList">
    				<tr>
    					<td><a class="button button-primary" href="#" data-bind="click: $parent.viewSurvey">View</a></td>
    					<td data-bind="text:surveyDate"></td>
    					<td data-bind="text:surveyName"></td>
    					<td data-bind="text:percentCompleted"></td>
    					<td data-bind="text:participantNumber"></td>
    				</tr>	
    			</tbody>
			</table>
		</div>  	
  	</div>
  </div>
  <div class="container" id="overlayForm">
		<div class="RemoveMediaNotif"><img src="images/closeIcon.png" id="closeDialogButton" /></div>
  </div>
  
<!-- End Document -->
</body>
</html>
