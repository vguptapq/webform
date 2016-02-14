package com.ode.rest.webservice.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.ode.rest.webservice.dao.AddForm;
import com.ode.restwebservice.beans.AddFormBean;
import com.ode.restwebservice.beans.GenericMessage;
import com.ode.restwebservice.constants.FormConstants;
import com.ode.restwebservice.enums.FormEnums;

public class AddFormImpl implements AddForm{
	
	public AddFormImpl() {
		super();
		FormConnectionMasterImpl.getConnection();
	}



	private FormConnectionMasterImpl connMaster;
	private GenericMessage gs;
	

	@Override
	public GenericMessage addForm(AddFormBean afb) {
		
		try{
		if (FormConnectionMasterImpl.conn == null){
			FormConnectionMasterImpl.getConnection();
		}
		String query = " insert into addedrecords (first_name, last_name, date_created, is_admin, num_points)"
		        + " values (?, ?, ?, ?, ?)";
		// create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = FormConnectionMasterImpl.conn.prepareStatement(query);
	      preparedStmt.setString (1, afb.getPersonName());
	      boolean success = preparedStmt.execute();
	      
	      if (success){
	    	  gs=new GenericMessage();
	    	  gs.setReturnCode(FormEnums.CODE_200.getEnumValue());
	    	  gs.setReturnMessage(FormConstants.returnMessage);
	      }
		
		}catch(SQLException e){
			
		}
		// TODO Auto-generated method stub
		return gs;
	}
	
	

}
