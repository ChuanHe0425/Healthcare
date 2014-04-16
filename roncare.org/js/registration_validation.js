$(document).ready(function()
{
	$('#firstName').bind('blur mousedown mouseup focus', function (e) 
	{
		if (validateFirstName($(this).val()))
		{
			$(this).attr('class', '');
			$(this).nextAll().remove();
		}
		else
		{
			$(this).attr('class', 'error');
			//remove icon before inserting it again
			$(this).nextAll().remove();
			$(this).after('<i class="icon-remove-circle icon-large" style="color:red"></i>');
		}	
	});
	
	$('#lastName').bind('blur mousedown mouseup focus', function (e) 
	{
		if (validateLastName($(this).val()))
		{
			$(this).attr('class', '');
			$(this).nextAll().remove();
		}
		else
		{
			$(this).attr('class', 'error');
			//remove icon before inserting it again
			$(this).nextAll().remove();
			$(this).after('<i class="icon-remove-circle icon-large" style="color:red"></i>');
		}	
	});
	
	$('#password').bind('blur mousedown mouseup focus', function (e) 
	{
		if (checkPwdLength($(this).val()))
		{
			$(this).attr('class', '');
			$(this).nextAll().remove();
		}
		else
		{
			$(this).attr('class', 'error');
			//remove icon before inserting it again
			$(this).nextAll().remove();
			$(this).after('<i class="icon-remove-circle icon-large" style="color:red"></i>');
		}	
	});
	
	$('#confirmPassword').bind('blur mousedown mouseup focus', function (e) 
	{
		if (confirmPwd($(this).val()) && $(this).val() != '')
		{
			$(this).attr('class', '');
			$(this).nextAll().remove();
		}
		else
		{
			$(this).attr('class', 'error');
			//remove icon before inserting it again
			$(this).nextAll().remove();
			$(this).after('<i class="icon-remove-circle icon-large" style="color:red"></i>');
		}	
	});
	
	$('#email').bind('blur mousedown mouseup focus', function (e) 
	{
		if (validateEmail($(this).val()))
		{
			$(this).attr('class', '');
			$(this).nextAll().remove();
		}
		else
		{
			$(this).attr('class', 'error');
			//remove icon before inserting it again
			$(this).nextAll().remove();
			$(this).after('<i class="icon-remove-circle icon-large" style="color:red"></i>');
		}	
	});
	$('#dateOfBirth').bind('blur mousedown mouseup focus', function (e) 
	{
		if (validateEmail($(this).val()))
		{
			$(this).attr('class', '');
			$(this).nextAll().remove();
		}
		else
		{
			$(this).attr('class', 'error');
			//remove icon before inserting it again
			$(this).nextAll().remove();
			$(this).after('<i class="icon-remove-circle icon-large" style="color:red"></i>');
		}	
	});
});

function checkPwdLength(pwd) 
{
	return pwd.length >= 6;	
}

function confirmPwd(pwd) {
	return pwd == $('#password').val();
}

function validateEmail(email) 
{
    var re = /\S+@\S+\.\S+/;
    return re.test(email);
}

function validateDOB(dob) 
{
	var re = /^\d{2}[.\/-]\d{2}[.\/-]\d{4}$/;
	return re.test(dob);
}

function validateFirstName(name)
{
    var re = /^[a-zA-Z0-9]+$/;
    return re.test(name);	
}

function validateLastName(name)
{
    var re = /^[a-zA-Z0-9]+$/;
    return re.test(name);	
}