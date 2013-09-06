package com.analytics.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.sql.DataSource;

public class Database implements DatabaseDao {

	private DataSource dataSource;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;

	}

	@Override
	public void createTransaction(String message) {
		// TODO Auto-generated method stub
		String[] transactionLine = message.split(",");

		Date currentDatetime = new Date(System.currentTimeMillis());
		java.sql.Date sqlDate = new java.sql.Date(currentDatetime.getTime());
		String transactionCategoryName = transactionLine[1];
		String transactionAmount = transactionLine[2];
		String transactionName = transactionLine[3];

		System.out.println(transactionCategoryName);
		System.out.println(transactionAmount);
		System.out.println(transactionName);

		String transactionCategoryId = selectData(transactionCategoryName,
				"transaction_category", "categoryName", "idtransactionCategory");

		Connection conn = null;
		String sql = "insert into user_transaction(transactionDate , transactionCategory, transactionAmount , transactionName) values (?, ?, ?, ?)";

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDate(1, sqlDate);
			ps.setString(2, transactionCategoryId);
			ps.setString(3, transactionAmount);
			ps.setString(4, transactionName);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		System.out.println("Inserted Transaction successfully...");

	}

	public String selectData(String searchKey, String TableName,
			String columnName, String retrieveColumnName) {

		String sql = "SELECT * FROM " + TableName + " WHERE " + columnName
				+ "= ?";
		String returnValue = null;
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, searchKey);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				returnValue = rs.getString(retrieveColumnName);

			}
			rs.close();
			ps.close();
			return returnValue;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public void connectDb() {

	}

}
