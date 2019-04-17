package com.sh.db.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.sh.db.point.PointDAO;
import com.sh.db.util.DBConnector;

public class DBConnectorTest {

	
	//Anotation : 설명+실행 기능
	@Test
	public void test() throws Exception{ //이 안에다가 테스트할 코드를 적는다 
		
		PointDAO dao = new PointDAO();
		
		assertEquals(1, 0);
		
		/*
		assertNotNull(conn); // 단정함수 : null이 아니였으면 좋겠다.
		//null이 아니면 성공 null이면 실패이다. */
	}

}
