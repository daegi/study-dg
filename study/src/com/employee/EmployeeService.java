package com.employee;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeService {
	private Scanner sc = new Scanner(System.in);
	private ArrayList<EmployeeDAO> list;

	public EmployeeService() {
		list = new ArrayList<>();
	}

	// 등록
	public void input() {
		
		EmployeeDAO dao = new EmployeeDAO();
		System.out.println("키보드로 데이터 입력 받는 부분");

		System.out.println("이름을 넣어주세요");
		dao.setName(sc.next());
		System.out.println("사번을 넣어주세요");
		dao.setSabun(sc.next());
		System.out.println("서비스가 새로운 직원을 등록할 것입니다.");
		list.add(dao);
		
		
		for (EmployeeDAO vv : list) {
			if (dao.getName().equals(sc.next(dao.name))) {
				System.out.println(dao.getName()+"\n"+dao.getSabun());
			}
		}
				
		System.out.println("화면에 결과 출력");
		
		

	}

	// 조회
	public void search() {

	}

	// 수정
	public void update() {

	}

	// 삭제
	public void remove() {

	}
	
	// 종료
	public void exit() {
		
		System.out.println("시스템을 종료 합니다");
		System.exit(0);

	}
	

}
