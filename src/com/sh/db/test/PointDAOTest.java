package com.sh.db.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sh.db.point.PointDAO;

public class PointDAOTest {

	@Test
	public void test() {
		PointDAO dao = new PointDAO();
		
		int result=0;
		try {
			//result = dao.insert();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(1, result);
	}

}
