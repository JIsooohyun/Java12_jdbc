package com.sh.db.point;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.sh.db.util.DBConnector;


public class PointInsert {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("아이디 입력");
		String id = sc.next();

		System.out.println("국어 점수 입력");
		int kor = sc.nextInt();

		System.out.println("영어 점수 입력");
		int eng = sc.nextInt();

		System.out.println("수학 점수 입력");
		int math = sc.nextInt();
		//id, 국어, 영어, 수학, 입력
		//point테이블에 insert
		//결과 찍어주기

		DBConnector db = new DBConnector();
		Connection conn=null;
		
		PreparedStatement st = null;
		int result = 0;
		try {

			conn = db.getConnect();
			String sql = "insert into point values(?, ?, ?, ?, ?, ?)";

			st = conn.prepareStatement(sql);


			st.setString(1, id);
			st.setInt(2, kor);
			st.setInt(3, eng);
			st.setInt(4, math);
			st.setInt(5, (kor+eng+math));
			st.setDouble(6,(double)(kor+eng+math)/3 );

			result = st.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				st.close();
				conn.close();
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

























