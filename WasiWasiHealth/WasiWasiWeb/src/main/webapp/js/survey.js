var cursorX;
var cursorY;
$(document).ready(function() {
	document.onmousemove = function(e){
	    cursorX = e.pageX;
	    cursorY = e.pageY;
	}
	$("#closeDialogButton").click(function(){
			hideForm();
	});
	ko.applyBindings(new SurveyViewModel());
});


function displayForm(xCoord, yCoord) {
	$('#overlayForm').css("visibility", "visible");
	$('#overlayForm').css("height", "50%");
	$('#overlayForm').css("width", "50%");	
	$('#overlayForm').css("z-index", "1000");
	$('#overlayForm').css("top", yCoord + "px");
	$('#overlayForm').css("left", xCoord + "px");
}

function hideForm() {
	$('#overlayForm').css("visibility", "hidden");
	$('#overlayForm').css("height", "3%");
	$('#overlayForm').css("z-index", "-1");
}

function SurveyViewModel() {
	var self = this;
	self.surveyList = ko.observableArray([
		 {id:"1001", surveyDate: "2015-11-20", surveyName: "Cardiac Lifestyle Screen", percentCompleted: "80%", participantNumber:"120"},       
		 {id:"1000", surveyDate: "2015-10-20", surveyName: "Cardiac Initial Screen", percentCompleted: "100%", participantNumber: "190"},
		 {id:"999", surveyDate: "2015-09-20", surveyName: "Demographic Info", percentCompleted: "100%", participantNumber: "200"}]);
	
	self.viewSurvey = function() {
		console.log(this.id);
		displayForm(cursorX, cursorY);
		// show graph
	};
}