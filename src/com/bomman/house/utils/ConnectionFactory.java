package com.bomman.house.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static Connection connection;

	public static Connection getConnection() {
		return connect();
	}
	
	private static Connection connect(){
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
//			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			connection = DriverManager.getConnection("jdbc:hsqldb:file:E:\\hsqldb-2.3.3\\MYHSQLDB", "sa", "Hallmark1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Got The Connection Hurrey..!!");
		return connection;
	}
}
