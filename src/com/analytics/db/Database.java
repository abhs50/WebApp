package com.analytics.db;

import java.util.Date;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;



public class Database implements DatabaseDao{
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;


	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	 //   this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}

	@Override
	public void createTransaction(String message) {
		// TODO Auto-generated method stub
	 String[] transactionLine = message.split(",");
	 
	 Date currentDatetime = new Date(System.currentTimeMillis());  
	 java.sql.Date sqlDate = new java.sql.Date(currentDatetime.getTime());  
	 String transactionCategory = transactionLine[1];
	 String transactionAmount = transactionLine[2];
	 String transactionName = transactionLine[3];
	 
	 
	 System.out.println(transactionCategory);
	 System.out.println(transactionAmount);
	 System.out.println(transactionName);
	 
	 try {
		 String SQL = "insert into user_transaction(transactionDate , transactionCategory, transactionAmount , transactionName) values (?, ?, ?, ?)";
		 jdbcTemplateObject.update(SQL, sqlDate, transactionCategory, transactionAmount, transactionName);
	 } catch(Exception e) {
		e.printStackTrace();
	 }
	 System.out.println("Inserted Transaction successfully...");

	}
	
	public void connectDb(){
			
		
		
	}
	
	


}
