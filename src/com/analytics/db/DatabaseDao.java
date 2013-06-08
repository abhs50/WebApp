package com.analytics.db;

import javax.sql.DataSource;

public interface DatabaseDao {
	 /** 
	    * This is the method to be used to initialize
	    * database resources ie. connection.
	    */
	   public void setDataSource(DataSource ds);
	   /** 
	    * This is the method to be used to create
	    * a record in the Student table.
	    */
	   public void create(String message);
	   
}
