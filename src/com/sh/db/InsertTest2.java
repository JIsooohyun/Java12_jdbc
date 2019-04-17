package com.sh.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest2 {

	public static void main(String[] args) {
		//부서번호, 부서명, 지역명을 입력받아서
		//dept테이블에 insert하기
		String dnum=null;
		String dname=null;
		String dloc=null;
		Scanner sc = new Scanner(System.in);
		
		//1. DB연결 정보 준비
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@211.238.142.44:1521:xe";
		String dirver = "oracle.jdbc.driver.OracleDriver";
		Connection con = null;
		Statement st = null;
		int result = 0;
		try {
			//2.driver를 메모리에 로딩
			Class.forName(dirver);
			System.out.println("드라이버가 로딩 성공");
			
			//3.DB서비스에 접속하고 로그인해서 Cnnection 받기
			con = DriverManager.getConnection(url, user, password);
			System.out.println("연결성공");
			
			//4.Query(SQL)문 생성, 
			System.out.println("부서번호를 입력하세요");
			dnum = sc.next();
			
			System.out.println("부서명을 입력하세요");
			dname = sc.next();
			
			System.out.println("지역명을 입력하세요");
			dloc = sc.next();
			
			String sql = "insert into dept values("+dnum+",'"+ dname+"','"+dloc+"')";
			
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



















