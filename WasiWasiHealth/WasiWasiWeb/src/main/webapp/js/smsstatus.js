
$(document).ready(function() {
	document.onmousemove = function(e){
	
		$.getJSON("/some/url", function(data) { 
			populateTableList(data);
		}
		})
});


function populateTableList(data) {
	$('#questionTable').find('tr:gt(0)').remove();
	
	if (data.length > 0) {
		for(var i=0;i<data.length;i++){
			
			
			$('#questionTable tr:last').after(
				'<tr>'
				+ '<td></td>' 	
				+ '<td>' + data[i].question + '</td>'
				+ '<td>' + data[i].processed + '</td>'
				+ '</tr>'
			);
		}
	}
}

