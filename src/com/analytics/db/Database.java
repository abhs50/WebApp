package com.analytics.db;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class Database implements DatabaseDao{
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;


	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}

	@Override
	public void createTransaction(String message) {
		// TODO Auto-generated method stub
	 String[] transactionLine = message.split(",");
	 String transactionDate = transactionLine[0];
	 String transactionCategory = transactionLine[1];
	 String transactionAmount = transactionLine[2];
	 String transactionName = transactionLine[3];
	 
	 String SQL = "insert into user_transaction (transactionDate, transactionCategory, transactionAmount , transactionName) values (?, ?, ?, ?)";
	 jdbcTemplateObject.update(SQL, transactionDate, transactionCategory, transactionAmount, transactionName);
	 System.out.println("Inserted Transaction successfully...");

	}
	
	public void connectDb(){
			
		
		
	}
	
	


}
