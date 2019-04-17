package com.sh.db.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int deptno=13;
		String dname = "HR";
		String loc="Paris";
		
		Connection con = null;
		PreparedStatement st = null;
		
		//1.로그인정보 4가지
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin@211.238.142.30:1521:xe";
		String driver = "oracle.jdbc.OracleDriver";
		int result=0;
		
		
		try {
			//2. 드라이버를 메모리에 로딩
			Class.forName(driver);
			
			//3.로그인하고 connection받아오기
			con = DriverManager.getConnection(url, user, password);
			
			//4. sql문 작성
			String sql = "insert into dept values(?, ?, ?)"; //컬럼명을 매개변수로 집어넣는것은 X
			
			//5.sql문 미리 전송
			st = con.prepareStatement(sql);
			
			//6.?에 대한 값을 셋팅해준다
			//st.setXXX(?의인덱스번호, 해당하는값);
			//오라클에서는 인덱스번호가 1번부터 시작하기 떄문에 1번부터 넣어준다.
			st.setInt(1, deptno);
			st.setString(2, dname);
			st.setString(3, loc);
			
			//7.최종 전송 후 처리
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
	}
}











