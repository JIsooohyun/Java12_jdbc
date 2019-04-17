package com.sh.db.point;

import java.util.Scanner;
import org.junit.experimental.theories.PotentialAssignment;

public class PointInput {
	
	public PointDTO setPoint() {
		Scanner sc = new Scanner(System.in);
		
		PointDTO pointDTO = new PointDTO();
		
		System.out.println("번호를 입력");
		pointDTO.setNum(sc.nextInt());
		
		System.out.println("아이디 입력");
		pointDTO.setSid(sc.next());
		
		System.out.println("국어점수 입력");
		pointDTO.setKor(sc.nextInt());
		
		System.out.println("영어점수 입력");
		pointDTO.setEng(sc.nextInt());
		
		System.out.println("수학점수 입력");
		pointDTO.setMath(sc.nextInt());
		
		System.out.println("반번호 입력");
		pointDTO.setBnum(sc.nextInt());
		
		pointDTO.setTotal(pointDTO.getKor()+pointDTO.getEng()+pointDTO.getMath());
		pointDTO.setAvg(pointDTO.getTotal()/3.0);
		
		
		return pointDTO;
	}
	
}
