package org.roncare.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;
import org.roncare.api.InputValidation;

@Path("/inputValidation")
public class InputValidation_Rest {
	
	private InputValidation inputValidation = InputValidation.createInputValidation();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/email/{param}")
	public Response validateEmail(@PathParam("param") String email)	{
		if(	inputValidation.validateEmail(email)	)	{
			JSONObject obj=new JSONObject();
			obj.put("msg","Valid Email");
			  
			return Response.status(200).entity(obj).build();
		}
		else 	{
			JSONObject obj=new JSONObject();
			obj.put("msg","Invalid Email Address");
			return Response.status(422).entity(obj).build();
		}
	}
}