$(document).ready(function()
{
	$('#firstName').bind('blur mousedown mouseup focus change input propertychange', function (e) 
	{
		if (validateFirstName($(this).val()))
		{
			$(this).attr('class', '');
			$(this).nextAll().remove();
			$(this).after('<i class="icon-ok icon-large" style="color:green"></i>');
		}
		else
		{
			$(this).attr('class', 'error');
			//remove icon before inserting it again
			$(this).nextAll().remove();
			$(this).after('<i class="icon-remove-circle icon-large" style="color:red"></i>');
		}	
	});
	
	$('#lastName').bind('blur mousedown mouseup focus change input propertychange', function (e) 
	{
		if (validateLastName($(this).val()))
		{
			$(this).attr('class', '');
			$(this).nextAll().remove();
			$(this).after('<i class="icon-ok icon-large" style="color:green"></i>');
		}
		else
		{
			$(this).attr('class', 'error');
			//remove icon before inserting it again
			$(this).nextAll().remove();
			$(this).after('<i class="icon-remove-circle icon-large" style="color:red"></i>');
		}	
	});
	
	$('#password').bind('blur mousedown mouseup focus change input propertychange', function (e) 
	{
		if (checkPwdLength($(this).val()))
		{
			$(this).attr('class', '');
			$(this).nextAll().remove();
			$(this).after('<i class="icon-ok icon-large" style="color:green"></i>');
		}
		else
		{
			$(this).attr('class', 'error');
			//remove icon before inserting it again
			$(this).nextAll().remove();
			$(this).after('<i class="icon-remove-circle icon-large" style="color:red"></i>');
		}	
	});
	
	$('#confirmPassword').bind('blur mousedown mouseup focus change input propertychange', function (e) 
	{
		if (confirmPwd($(this).val()) && $(this).val() != '')
		{
			$(this).attr('class', '');
			$(this).nextAll().remove();
			$(this).after('<i class="icon-ok icon-large" style="color:green"></i>');
		}
		else
		{
			$(this).attr('class', 'error');
			//remove icon before inserting it again
			$(this).nextAll().remove();
			$(this).after('<i class="icon-remove-circle icon-large" style="color:red"></i>');
		}	
	});
	
	$('#email').bind('change', function (e) 
	{
		if (validateEmail($(this).val()))
		{
			$(this).attr('class', '');
			$(this).nextAll().remove();
			$(this).after('<i class="icon-ok icon-large" style="color:green"></i>');
		}
		else
		{
			$(this).attr('class', 'error');
			//remove icon before inserting it again
			$(this).nextAll().remove();
			$(this).after('<i class="icon-remove-circle icon-large" style="color:red"></i>');
		}	
	});
	$('#dateOfBirth').bind('blur mousedown mouseup focus change input propertychange', function (e) 
	{
		if (validateDOB($(this).val()))
		{
			$(this).attr('class', '');
			$(this).nextAll().remove();
			$(this).after('<i class="icon-ok icon-large" style="color:green"></i>');
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
    if(!re.test(email))	{
    	console.log('regex fail');
    	return false;
    }
    
    var result;
    $.ajax({
		type: "GET",
		async: false,
		dataType:"json",
		url: "/roncare.org/rest/inputValidation/email/" + $("#email").val(),
		success: function(data)	{
//			$("#email").attr('class', '');
//			$("#email").nextAll().remove();
//			$("#email").after('<i class="icon-ok icon-large" style="color:green"></i>');
			result = true;
		},
		error: function(xhr, status, error)	{
//			$("#email").attr('class', 'error');
//			//remove icon before inserting it again
//			$("#email").nextAll().remove();
//			$("#email").after('<i class="icon-remove-circle icon-large" style="color:red"></i>');
			result = false;
		}
	});
    
    return result;
}

function validateDOB(dob) 
{
	console.log(dob);
	var re = /^\d{4}[.\/-]\d{2}[.\/-]\d{2}$/;
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