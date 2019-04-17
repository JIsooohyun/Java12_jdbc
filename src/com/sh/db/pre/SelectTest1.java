package com.sh.db.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest1 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;    //조회한 결과가 있는 값

		//1. 4가지 로그인 정보
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@211.238.142.30:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		int result = 0;
		//System.out.println("부서번호를 입력하세요");

		try {
			Class.forName(driver);

			con = DriverManager.getConnection(url, user, password);

			String sql = "select * from dept ";

			st = con.prepareStatement(sql);

			//7. 최종전송 후 결과처리
			rs = st.executeQuery();  //select문은 executeQuery()!!!!

			while(rs.next()) {
				 // 한줄을 읽은 것 데이터가 있으면 true, 없으면 false
				System.out.println("부서번호 : "+rs.getInt("deptno"));//컬럼명을 써준다.
				System.out.println("부서명    :"+rs.getString("dname"));
				System.out.println("지역명    : "+rs.getString("loc"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
