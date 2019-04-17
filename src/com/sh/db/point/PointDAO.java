package com.sh.db.point;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sh.db.util.DBConnector;

public class PointDAO {

	//메서드명 delete
	public int delete() throws Exception{
		
		return 1;
	}
	
	//메서드명 insert
	
	public int insert(PointDTO pointDTO) throws Exception{
		
		Connection conn = DBConnector.getConnect();
		
		
		String sql = "insert into point values(?, ?, ?, ?, ?, ?, ?, ?)";
		
		
		PreparedStatement st = conn.prepareStatement(sql);
		
		st.setInt(1, pointDTO.getNum());
		st.setString(2, pointDTO.getSid());
		st.setInt(3, pointDTO.getKor());
		st.setInt(4, pointDTO.getEng());
		st.setInt(5, pointDTO.getMath());
		st.setInt(6, pointDTO.getTotal());
		st.setDouble(7, pointDTO.getAvg());
		st.setInt(8, pointDTO.getBnum());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, conn);
		
		return result;
	}
	
}



















