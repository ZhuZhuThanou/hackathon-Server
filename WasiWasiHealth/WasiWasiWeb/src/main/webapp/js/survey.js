var cursorX;
var cursorY;
var graphCreated = false;
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
		if (!graphCreated) {
			runGraph();
			graphCreated = true;
		}
		
	};
}



function runGraph() {

	var data = [
		     {"legendLabel":"Q.1", "magnitude":20}, 
		     {"legendLabel":"Q.2", "magnitude":40}, 
		     {"legendLabel":"Q.3", "magnitude":50}, 
		     {"legendLabel":"Q.4", "magnitude":16}, 
		     {"legendLabel":"Q.5", "magnitude":50}, 
		     {"legendLabel":"Q.6", "magnitude":8}, 
		     {"legendLabel":"Q.7", "magnitude":30}];
	
	//.json("js/piechartdata.json",  function (data) {

		
        var canvasWidth = 400, //width
        canvasHeight = 400,   //height
        outerRadius = 100,   //radius
        color = d3.scale.category20(); //builtin range of colors
    
        var vis = d3.select("#overlayForm")
          .append("svg:svg") //create the SVG element inside the <body>
            .data([data]) //associate our data with the document
            .attr("width", canvasWidth) //set the width of the canvas
            .attr("height", canvasHeight) //set the height of the canvas
            .append("svg:g") //make a group to hold our pie chart
              .attr("transform", "translate(" + 1.5*outerRadius + "," + 1.5*outerRadius + ")") // relocate center of pie to 'outerRadius,outerRadius'

        // This will create <path> elements for us using arc data...
        var arc = d3.svg.arc()
          .outerRadius(outerRadius);

        var pie = d3.layout.pie() //this will create arc data for us given a list of values
          .value(function(d) { return d.magnitude; }) // Binding each value to the pie
          .sort( function(d) { return null; } );

        // Select all <g> elements with class slice (there aren't any yet)
        var arcs = vis.selectAll("g.slice")
          // Associate the generated pie data (an array of arcs, each having startAngle,
          // endAngle and value properties) 
          .data(pie)
          // This will create <g> elements for every "extra" data element that should be associated
          // with a selection. The result is creating a <g> for every object in the data array
          .enter()
          // Create a group to hold each slice (we will have a <path> and a <text>
          // element associated with each slice)
          .append("svg:g")
          .attr("class", "slice");    //allow us to style things in the slices (like text)

        arcs.append("svg:path")
          //set the color for each slice to be chosen from the color function defined above
          .attr("fill", function(d, i) { return color(i); } )
          //this creates the actual SVG path using the associated data (pie) with the arc drawing function
          .attr("d", arc);

        // Add a legendLabel to each arc slice...
        arcs.append("svg:text")
          .attr("transform", function(d) { //set the label's origin to the center of the arc
            //we have to make sure to set these before calling arc.centroid
            d.outerRadius = outerRadius + 50; // Set Outer Coordinate
            d.innerRadius = outerRadius + 45; // Set Inner Coordinate
            return "translate(" + arc.centroid(d) + ")";
          })
          .attr("text-anchor", "middle") //center the text on it's origin
          .style("fill", "Black")
          .style("font", "bold 14px Arial")
          .text(function(d, i) { return data[i].legendLabel; }); //get the label from our original data array

        // Add a magnitude value to the larger arcs, translated to the arc centroid and rotated.
        arcs.filter(function(d) { return d.endAngle - d.startAngle > .2; }).append("svg:text")
          .attr("dy", ".35em")
          .attr("text-anchor", "middle")
          //.attr("transform", function(d) { return "translate(" + arc.centroid(d) + ")rotate(" + angle(d) + ")"; })
          .attr("transform", function(d) { //set the label's origin to the center of the arc
            //we have to make sure to set these before calling arc.centroid
            d.outerRadius = outerRadius; // Set Outer Coordinate
            d.innerRadius = outerRadius/2; // Set Inner Coordinate
            return "translate(" + arc.centroid(d) + ")rotate(" + angle(d) + ")";
          })
          .style("fill", "White")
          .style("font", "bold 12px Arial")
          .text(function(d) { return d.data.magnitude; });

        // Computes the angle of an arc, converting from radians to degrees.
        function angle(d) {
          var a = (d.startAngle + d.endAngle) * 90 / Math.PI - 90;
          return a > 90 ? a - 180 : a;
        }
}