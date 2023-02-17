package com.chat.dao;

import java.sql.Connection;
import java.sql.SQLException;


import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;


public class DBClass {
	private static DBClass obj;
	static DBClass getInstance() {
		if(obj==null)
		synchronized (DBClass.class) {
			if(obj==null)
				obj=new DBClass();
			}
		return obj;
	}
	private static String url = "jdbc:mysql://localhost:3306/ChatApp";
	private static String user = "root";
	private static String password = "11111111";
	private static BasicDataSource dataSource= new BasicDataSource();
	
	private DBClass() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		dataSource.setInitialSize(10);
		dataSource.setMaxTotal(-1);
	}

	static Connection getConnection() {
		Connection con=null;
		try {
			con = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
