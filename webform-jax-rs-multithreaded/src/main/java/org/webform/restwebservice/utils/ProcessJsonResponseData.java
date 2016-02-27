package org.webform.restwebservice.utils;

import javax.ws.rs.core.Response;

import com.ode.restwebservice.constants.FormConstants;
import com.ode.restwebservice.enums.FormEnums;

public class ProcessJsonResponseData {
	
	public static Response getResponseValidatedForErrors(String json) {
		Response restResp = null;
		if (json == null) {
			restResp = Response.status(Response.Status.NOT_FOUND).entity(null).build();
		} else if (hasError(json)) {
			restResp = Response.status(Response.Status.NOT_ACCEPTABLE).header(FormEnums.CODE_400.getEnumValue(), json).build();
		} else {
			restResp = Response.ok(json).build();
		}
		return restResp;
	}
	
	private static boolean hasError(String jsonForValidate) {
		boolean hasError = false;
		if (jsonForValidate != null & jsonForValidate.contains(FormConstants.ERROR_KEY_MESSAGE)) {
			hasError = true;
		}
		return hasError;
	}

}
