package com.sh.db.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest3 {
	public static void main(String[] args) {
		//dept에서 부서의 갯수는 총 몇개?
		//제일 큰/작은 부서번호는 무엇? 

		//1. 4가지
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@211.238.142.30:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		PreparedStatement st = null;
		Connection conn = null;
		ResultSet rs = null;


		//2. 드라이버 메모리
		try {
			Class.forName(driver);

			//3. con연결
			conn = DriverManager.getConnection(url, user, password);


			//4. sql문
			String sql = "select count(deptno), max(deptno), min(deptno) from dept";

			//5.sql문 미리 전송
			st = conn.prepareStatement(sql);

			//6. ?값 세팅

			//7. 최종 전송 후 결과 처리
			rs = st.executeQuery();

			rs.next();// 0이든 1이든 무조건 하나가 오기 때문에
			System.out.println("부서의 갯수는 " + rs.getInt(1)+"/ 최대 : "+rs.getInt(2)+"/ 최소 : "+rs.getInt(3));


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}






	}
}
