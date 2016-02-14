package com.ode.restwebservice.rest.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ode.rest.webservice.dao.AddForm;
import com.ode.rest.webservice.dao.impl.AddFormImpl;
import com.ode.restwebservice.beans.AddFormBean;
import com.ode.restwebservice.beans.GenericMessage;
import com.ode.restwebservice.utils.ProcessJsonResponseData;

@Path("addForm")
public class SearchServiceRest {
	
	@POST
	@Path("add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addForm(final String value){
		Response resp = null;
		try{
		
			AddForm formDAO = new AddFormImpl();
			final ObjectMapper mapper = new ObjectMapper();
			final AddFormBean addFormModel = mapper.readValue(value, AddFormBean.class);
			GenericMessage rs = formDAO.addForm(addFormModel);
			final String json = mapper.writeValueAsString(rs);
			resp = ProcessJsonResponseData.getResponseValidatedForErrors(json);
		
		}catch(Exception e){
			
			
		}
		
		return resp;
		
	}
	
	

}
