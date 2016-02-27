package com.ode.restwebservice.utils;

import com.ode.restwebservice.beans.ErrorMessage;
import com.ode.restwebservice.constants.FormConstants;
import com.ode.restwebservice.enums.FormEnums;

public class SystemErrorPrepareMessage {
	
	public static String getSystemErrorMessage(final Exception e) {
		String messageReturned = (e.getLocalizedMessage() != null) ? e.getLocalizedMessage() : 
												(e.getMessage() != null) ? e.getMessage() : FormConstants.NULL_MESSAGE;
		messageReturned = removeSpecialChars(messageReturned.toString());
		final ErrorMessage sem = new ErrorMessage(FormEnums.CODE_500.getEnumValue(), messageReturned);								
		return sem.toString();
	}
	
	public static String removeSpecialChars(final String message) {
		StringBuffer sb = null;
		if (message != null && message.trim().length() > 0) {
			sb = new StringBuffer(message.replaceAll("\\r\\n|\\r|\\n", ""));
			sb = new StringBuffer(sb.toString().replaceAll("-", "").replaceAll(":", "").replaceAll("\"", ""));
		}
		final String valueToReturn = (sb != null)? sb.toString() : null;
		return valueToReturn;
	}

}
