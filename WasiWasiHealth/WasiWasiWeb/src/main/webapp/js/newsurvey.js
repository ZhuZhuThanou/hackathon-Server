$(document).ready(function() {

	ko.applyBindings(surveyViewModel);
	populateTableList(questions);
	$('#surveyQuestionDiv').hide();
	$('#createAQuestion').hide();
	$('#createAQuestion').click(function(){
		// create a form
		$('#surveyQuestionDiv').show();
	});
	
	$("#saveAndSendQuestionButton").click(function(){
		var qdata = {question: $('#surveyQuestionInput').val(),
					legend: $('#surveyQuectionLegendInput').val(),
					surveyId: $('#id').val()};
		
		var header = $("#csrfHeader").val();
		var token =  $("#csrfToken").val();
		var json = JSON.stringify(qdata);
		console.log(json);
		$.ajax({
			  type: "POST",
			  url: "smsquestion",
			  data: json,
			  dataType: "json",
			  contentType: 'application/json',
			  beforeSend: function(xhr) {
			        xhr.setRequestHeader("Accept", "application/json");
			        xhr.setRequestHeader("Content-Type", "application/json");
			        xhr.setRequestHeader(header, token);
			    },
			  success: function(obj) {
				  
			  },
			  error: function(e) {
				    console.log(e);
				  }
			});
			return false;
	});
});

var questions = [
	{id:"1", surveyId: "s1", order:"1", question:"question 1",
		response1: "response1", response1Key: "key1",
		response2: "response2", response2Key: "key2",
		response3: "response3", response3Key: "key3"},	
	{id:"2", surveyId: "s2", order:"2", question:"question 2",
		response1: "response12", response1Key: "key12",
		response2: "response22", response2Key: "key22",
		response3: "response32", response3Key: "key32"}
		
];

function populateTableList(data) {
	$('#questionTable').find('tr:gt(0)').remove();
	
	if (data.length > 0) {
		for(var i=0;i<data.length;i++){
			var editUrl ='<a href="#" class="button" onClick="sendQuestion(\'' + i  + '\')">Send Message</a>';
			var deleteUrl ='<a href="#" class="button" onClick="reviewQuestion(\'' + i  + '\')">Review Message</a>';
			var resStr = data[i].response1 + "=" + data[i].response1Key;
			resStr += " " + data[i].response2 + "=" + data[i].response2Key;
			resStr += " " + data[i].response3 + "=" + data[i].response3Key;
			
			$('#questionTable tr:last').after(
				'<tr>'
				+ '<td>' + editUrl + '&nbsp;&nbsp;'+ deleteUrl + '</td>' 	
				+ '<td>' + data[i].question + '</td>'
				+ '<td>' + resStr + '</td>'
				+ '</tr>'
			);
		}
	}
}

function sendQuestion(index) {
	var header = $("#csrfHeader").val();
	var token =  $("#csrfToken").val();
	var question = questions[index];
	var json = JSON.stringify(question);
	$.ajax({
		  type: "POST",
		  url: "surveyquestion",
		  data: json,
		  dataType: "json",
		  contentType: 'application/json',
		  beforeSend: function(xhr) {
		        xhr.setRequestHeader("Accept", "application/json");
		        xhr.setRequestHeader("Content-Type", "application/json");
		        xhr.setRequestHeader(header, token);
		    },
		  success: function(obj) {
			  if (obj.statusCode == 200) {
				alert("got it");  
			  }
		  },
		  error: function(e) {
			    console.log(e);
			  }
		});
}

var surveyViewModel = {
	surveyModel: {
		id: ko.observable(""),
		name: ko.observable("Survey Name"),
		activationDate: ko.observable(""),
		createdBy: ko.observable(""),
		createdTs: ko.observable("")
	},
	saveSurveyModel: function(model) {
		console.log(model);
		var data = ko.toJSON(model); /* Your data in JSON format - see below */;
		var header = $("#csrfHeader").val();
		var token =  $("#csrfToken").val();
		$.ajax({
			  type: "POST",
			  url: "newsurvey",
			  data: data,
			  dataType: "json",
			  contentType: 'application/json',
			  beforeSend: function(xhr) {
			        xhr.setRequestHeader("Accept", "application/json");
			        xhr.setRequestHeader("Content-Type", "application/json");
			        xhr.setRequestHeader(header, token);
			    },
			  success: function(obj) {
				  if (obj.statusCode == 200) {
					  console.log("1. " + obj.data.id);
					  surveyViewModel.surveyModel.id(obj.data.id);
					  surveyViewModel.surveyModel.createdBy(obj.data.createdBy);
					  console.log("Show me the create question button ");
					  $("#surveyQuestionDiv").show();
				  }
			  },
			  error: function(e) {
				    console.log(e);
				  }
			});
	}
};


function displayForm(xCoord, yCoord) {
	$('#overlayForm').css("visibility", "visible");
	$('#overlayForm').css("height", "60%");
	$('#overlayForm').css("width", "60%");	
	$('#overlayForm').css("z-index", "1000");
	$('#overlayForm').css("top", yCoord + "px");
	$('#overlayForm').css("left", xCoord + "px");
}

function hideForm() {
	$('#overlayForm').css("visibility", "hidden");
	$('#overlayForm').css("height", "3%");
	$('#overlayForm').css("z-index", "-1");
}