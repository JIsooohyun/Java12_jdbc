package com.sh.db.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteTest1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//부서번호를 입력 받아서
		//dept에서 삭제
		
		//1.4가지 정보 입력
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@211.238.142.30:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
		
		int num = 0;
		String name = null;
		String loc = null;
		
		try {
			//2.드라이버를 메모리에 로딩
			Class.forName(driver);
			System.out.println("드라이버 연결 성공");
			
			//2.1 로그인하고 conn받아오기
			con = DriverManager.getConnection(url, user, password);
			System.out.println("연결성공");
			
			//3.sql문 작성
			System.out.println("부서번호를 입력하세요");
			num = sc.nextInt();
			
			String sql = "delete dept where deptno = ?";
			
			//4.sql문 미리 전송
			st = con.prepareStatement(sql);
			
			//5.? 값 세팅
			st.setInt(1, num);
			
			
			//6.최종 전송 후 결과 처리
			result = st.executeUpdate();
			
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
		
		
		
		
		
		
		//7.연결끊기
	}

}
