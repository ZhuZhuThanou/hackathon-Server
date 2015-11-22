$(document).ready(function() {

	$('#newQuestionDiv').hide();
	ko.applyBindings(surveyViewModel);
});


var surveyViewModel = {
	surveyModel: {
		id: ko.observable(""),
		name: ko.observable("Survey Name"),
		activationDate: ko.observable(""),
		createdBy: ko.observable(""),
		createdTs: ko.observable("")
	},
	save: function(model) {
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
				  }
			  },
			  error: function(e) {
				    console.log(e);
				  }
			});
	}
};