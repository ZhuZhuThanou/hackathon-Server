var isEditFormDisplayed = false;
var isPasswordDisplayed = false;
$(document).ready(function() {
	hideAdminEditForm();
	hidePasswordForm();
	
	$('#editAdminButton').click(function(){
		hidePasswordForm();
		if (isEditFormDisplayed) {
			hideAdminEditForm();
		} else {
			showAdminEditForm();
		}
	});
	
	$('#pwdAdminButton').click(function(){
		hideAdminEditForm();
		if (isPasswordDisplayed) {
			hidePasswordForm();
		} else {
			showPasswordForm();
		}
	});
	
});

function hideAdminEditForm() {
	$('#adminEditForm').hide();
	isEditFormDisplayed = false;
}

function showAdminEditForm() {
	$('#adminEditForm').show();
	isEditFormDisplayed = true;
}

function showPasswordForm() {
	$('#changePasswordForm').show();
	isPasswordDisplayed = true;
}

function hidePasswordForm() {
	$('#changePasswordForm').hide();
	isPasswordDisplayed = false;
}
