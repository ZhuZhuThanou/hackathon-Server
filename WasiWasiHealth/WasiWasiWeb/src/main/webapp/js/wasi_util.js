function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

function formatDate(dateValue) {
	if (dateValue) {
		var formattedDate = new Date(dateValue);
		var d = formattedDate.getDate();
		var m =  formattedDate.getMonth();
		m += 1;  // JavaScript months are 0-11
		var y = formattedDate.getFullYear();
		if (m < 10) {
			m = '0' + m;
		}
		if (d < 10) {
			d = '0' + d;
		}
		return y + "-" + m + "-" + d;
	} else {
		return "";
	}
}

function RadionButtonSelectedValueSet(name, SelectdValue) {
    $('input[name="' + name+ '"][value="' + SelectdValue + '"]').prop('checked', true);
}

function formatTime(dateValue) {
	var formattedDate = new Date(dateValue);
	var h = formattedDate.getHours();
	var m =  formattedDate.getMinutes();
	if (m < 10) {
		m = '0' + m;
	}
	return h + ":" + m;
}

function encode(value) {
	if (value) {
		return encodeURIComponent(value);
	} else {
		return "";
	}
}

function getQueryStringParams(sParam) {
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++) {
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] == sParam) {
        	return decodeURIComponent(sParameterName[1]);
        }
    }
}

function notNullValue(value) {
	if (value) return value;
	return "";
}

function isNull(value) {
	return (!value || 0 === value.length);
}

function isStringEqual(value1, value2) {
	if (value1 == null && value2 == null) return true;
	return new String(value1).valueOf() == new String(value2).valueOf();
}

function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}
