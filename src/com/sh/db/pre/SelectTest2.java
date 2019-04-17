package com.sh.db.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SelectTest2 {
	public static void main(String[] args) {
		//조회할 부서 번호를 입력 받기
		Scanner sc = new Scanner(System.in);
		System.out.println("부서번호를 입력하세요");
		int snum = sc.nextInt();
		
		//1. 4가지 정보
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@211.238.142.30:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		PreparedStatement st = null;
		Connection con = null;
		ResultSet rs = null;
		
		
		
		try {
			//2. 드라이버 로딩
			Class.forName(driver);
			
			//3.Connection
			con = DriverManager.getConnection(url, user, password);
			
			//4.SQL문
			String sql = "select * from dept where deptno=?";
			
			//5. 미리전송
			st = con.prepareStatement(sql);
			
			//6. ? 세팅
			st.setInt(1, snum);
			
			//7. 최종 전송 후 처리
			rs = st.executeQuery();
			
			if(rs.next()) { //한둘만 읽어주는 것이기 때문에 while문 보다는  if문 사용
				System.out.println("부서번호 : "+rs.getInt("deptno")+"/ 부서명 : "+rs.getString("dname")+"/ 지역명 : "+rs.getString("dname"));
			}else {
				System.out.println("없는 부서 번호입니다.");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
		
	}

}
