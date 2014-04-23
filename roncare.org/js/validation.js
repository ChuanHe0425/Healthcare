function validateRegister() {
	var email = document.getElementById("email").value;
	var pwd = document.getElementById("password").value;
	var cpwd = document.getElementById("confirmPassword").value;
	var fname = document.getElementById("firstName").value;
	var lname = document.getElementById("lastName").value;
	var dob = document.getElementById("dateOfBirth").value;
		
	var msg = "";
	
	if (!validateEmail(email)) {
		msg += "Email is invalid.\n";
	}
	if (!checkPwdLength(pwd)) {
		msg += "Password is too short. It should be at least 6 characters.\n";
	}
	if (!confirmPwd(pwd,cpwd)) {
		msg += "Confirmation password does not match Password.\n";
	}
	if (!validateName(fname)) {
		msg += "First name contains invalid characters.\n";
	}
	if (!validateName(lname)) {
		msg += "Last name contains invalid characters.\n";
	}
	if (!validateDOB(dob)) {
		msg += "Date of birth is invalid.\n";
	}
	
	if (msg.length>0) {
		alert("The following errors exist:\n" + msg);
		return false;
	} else {		
		return true;
	}	
}

function checkPwdLength(pwd) {
	return pwd.length >= 6;	
}

function confirmPwd(pwd, cpwd) {
	return pwd == cpwd;
}

function validateName(name) {
    var re = /^[a-zA-Z0-9]+$/;
    return re.test(name);	
}

function validateEmail(email) 
{
    var re = /\S+@\S+\.\S+/;
    return re.test(email);
}

function validateDOB(dob) {
	console.log(dob);
	var re = /^\d{2}[.\/-]\d{2}[.\/-]\d{4}$/;
	return re.test(dob);
}

function validatePostcode(zip) {
	return zip.length == 5;
}

function validateSSN(ssn) {
	return ssn.length == 9;
}


function validatePhone(phone) {
	return (phone.length == 10 || phone.length == 11);
}

function validateAge(age) {
	return (age > 0 && age < 120);
}


function numeralsOnly(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode;
   if (charCode > 31 && (charCode < 48 || charCode > 57))
      return false;

   return true;
}