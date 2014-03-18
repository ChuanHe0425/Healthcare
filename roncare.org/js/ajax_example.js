$(document).ready(function()	{  
	$("#email").change(function()	{
		$.ajax({
			type: "GET",
			dataType:"json",
			url: "rest/inputValidation/email/" + $("#email").val(),
			success: function(data)	{
				$("#email_error").text(data.msg);
			},
			error: function(xhr, status, error)	{ 
				$("#email_error").text("Error: " + xhr.responseJSON.msg);
			}
		});
	});
});
