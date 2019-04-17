package com.sh.db.point;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.sh.db.util.DBConnector;


public class PointInsert {
	public static void main(String[] args) {
		
		try {
			new PointController().start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

























