package com.xiaoti.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMysqlConnection {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager
					.getConnection("jdbc:mysql://114.215.125.186/test?user=xiaoti&password=xiaoti");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from dept");
			while (rs.next()) {
				System.out.println(rs.getString("deptno"));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			try {
				if(rs != null) {
				   rs.close();
				   rs = null;
				}
				if(stmt != null) {
				   stmt.close();
				   stmt = null;
				}
				if(conn != null) {
				   conn.close();
				   conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void test() {
		logger.debug("hello");
	}
}
