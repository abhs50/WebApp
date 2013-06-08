package com.analytics.db;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Database implements DatabaseDao{
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	static{
		
	}
	
	public void connectDb(){
		
		
		
		
	}

	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = dataSource;
	    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		
	}

	@Override
	public void create(String message) {
		// TODO Auto-generated method stub
	 String SQL = "insert into Transaction (Date, Category, Amount , Desciption) values (?, ?, ?, ?)";
    // jdbcTemplateObject.update( SQL, name, age);
    // System.out.println("Created Record Name = " + name + " Age = " + age);
     return;

	}


}
