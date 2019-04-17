package com.sh.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		String ename = null;
		String job = null;
		int mnum = 0;
		
		//emp 테이블에 insert
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@211.238.142.30:1521:xe";
		String dirver = "oracle.jdbc.driver.OracleDriver";
		Statement st = null;
		Connection con = null;
		int result = 0;
		
		try {
			//1. 드라이버를 메모리에 로딩
			Class.forName(dirver);
			System.out.println("드라이버 연결 성공");
			
			//2. db서비스에 접속해서 로그인하고 connection받기
			con = DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공");
			
			//3. Query(sql)문 생성
			System.out.println("사번을 입력하세요");
			num = sc.nextInt();
			
			System.out.println("이름을 입력하세요");
			ename = sc.next();
			
			System.out.println("직업을 입력하세요");
			job = sc.next();
			
			System.out.println("매니저 사번을 입력하세요");
			mnum = sc.nextInt();
			
			String sql = "insert into emp values("+num+", '"+ename+"', '"+job+"', "+mnum+", sysdate, 1000, 0, 30)";
			
			//5. 전송
			st = con.createStatement();
			result = st.executeUpdate(sql);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
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




















