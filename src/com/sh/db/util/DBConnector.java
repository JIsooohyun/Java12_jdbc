package com.sh.db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBConnector {
	
	public Connection getConnect() throws Exception {
		//4개
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@211.238.142:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Connection conn = null;
		PreparedStatement st = null;
		
		Class.forName(driver);
		
		conn = DriverManager.getConnection(url, user, password);
		
		return conn;
	}

}
