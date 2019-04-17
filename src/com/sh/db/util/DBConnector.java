package com.sh.db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnector {

	public static Connection getConnect() throws Exception {
		//4개
		String user = "user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@211.238.142.30:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";


		Class.forName(driver);

		Connection conn= DriverManager.getConnection(url, user, password);

		return conn;
	}

	public static void disConnect(PreparedStatement st, Connection conn) throws Exception{

		st.close();
		conn.close();
	}

	//상속받은 메서드를 재정의 하는 것은 오버라이딩
	//이름은 같은데 다른 뜻으로 하는 것은 오버로딩!!!!!!!!!!!!!!!
	//두개 차이점 정리하기 !!!
	public static void disConnect(PreparedStatement st, Connection conn, ResultSet rs) throws Exception{
		
		rs.close();
		//자기자신의 또다른 메서드
		DBConnector.disConnect(st, conn);
		//this는 자기자신의 객체의 주소이다. 그러나 이 메서드는 static이라서 객체를 안만들기 때문에 사용할 수 없다.
		
	}

}
