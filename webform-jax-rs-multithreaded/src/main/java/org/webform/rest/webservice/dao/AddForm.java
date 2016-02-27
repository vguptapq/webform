package org.webform.rest.webservice.dao;

import org.webform.restwebservice.beans.AddFormBean;
import org.webform.restwebservice.beans.GenericMessage;

public interface AddForm {
	
	GenericMessage addForm(AddFormBean afb);
	
	

}
