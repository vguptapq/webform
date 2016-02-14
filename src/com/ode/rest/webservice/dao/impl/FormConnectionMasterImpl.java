package com.ode.rest.webservice.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public final class FormConnectionMasterImpl {
	
	public static Connection conn = null;
	
	public static void getConnection(){
		
		try{
		
		InitialContext cxt = new InitialContext();
		DataSource ds = (DataSource) cxt.lookup( "java:/comp/env/jdbc/mysql" );

		conn=ds.getConnection();
		
	}catch(NamingException | SQLException e){
		conn=null;
	}
		
	}

}
