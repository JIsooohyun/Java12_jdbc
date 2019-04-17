package com.sh.db.point;

import java.util.Scanner;

public class PointController {

	private Scanner sc;
	private PointInput pi;
	private PointDAO pa; //값을  db로 넣어주는 클래스
	private PointDTO pd; //값을 입력받는 클래스
	private PointView pv;
	
	public PointController() {
		sc= new Scanner(System.in);
		pa = new PointDAO();
		pd = new PointDTO();
		pi = new PointInput();
		pv = new PointView();
		
	}
	public void start() throws Exception{

		boolean check=true;
		 
		while(check) {
			System.out.println("1. 점수정보 등록");
			System.out.println("2. 종료");
			int select= sc.nextInt();
			switch(select) {
			case 1:		//1.점수 정보 등록
				
				PointDTO dto = pi.setPoint();
				int result = pa.insert(dto);
				String message = "등록실패";
				
				if(result>0) {
					message = "등록성공";
					pv.view(message);
				}
				break;

			default:	//2.종료
				System.out.println("종료됩니다.");
				check = false;
			}
		}
	}

}
