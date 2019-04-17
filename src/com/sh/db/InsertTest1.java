package com.sh.db;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest1 {

	public static void main(String[] args) {
		//1. DB연결 정보 준비
		String user = "scott";
		String password = "tiger";
		String url="jdbc:oracle:thin:@211.238.142.44:1521:xe";
		//localhost는 자기 자신을 나타내는 ip
		String driver = "oracle.jdbc.driver.OracleDriver"; //라이브러리에서 어떤 것을 쓸 것인가?
		Connection con=null;
		Statement st = null;
		int result=0;
		
		try {
			//2.dirver를 메모리에 로딩
			Class.forName(driver);
			System.out.println("드라이버가 로딩 성공");
			
			//3.DB서비스에 접속해서 로그인해서 Connection 받기
			con = DriverManager.getConnection(url, user, password);
			System.out.println("연결성공");
			
			//4.Query(SQL)문 생성, sql의 ;생략
			String sql = "insert into dept values(11, 'OFFICE', 'BUSAN')";
			
			//5.전송
			st = con.createStatement();
			result = st.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
		if(result>0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		
	}

}























