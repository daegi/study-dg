package com.sist.first;

import java.util.Scanner;

public class EmployeeUI {

	private Scanner scanner;
	private EmployeeService service;

	public EmployeeUI() {
		scanner = new Scanner(System.in);
		service = new EmployeeService();
	}

	public void showUsage() {
		System.out.println("사용법");
		System.out.println("1.등록 2.조회 3.수정 4.삭제 5.종료:");

		String menu = scanner.nextLine();

		if (menu.equals("5") == true) {
			System.out.println("시스템을 종료합니다.");
			return;
		} else {
			getUserinput(menu);// 재귀
		}
		showUsage();// 재귀
	}

	public void getUserinput(String menuStr) {
		System.out.println("키보드로 데이터 입력");
		if (menuStr.equals("1") == true) {
			System.out.println("이름 넣어");
			String userName = scanner.next();
			System.out.println("사번을 넣어");

			int empNO = Integer.parseInt(scanner.next());

			Employee newEmployee = new Employee(userName, empNO);

			service.regist(newEmployee);
		}
		System.out.println("화면에 결과");

	}

	public static void main(String[] args) {

		EmployeeUI ui = new EmployeeUI();
		ui.showUsage();

	}
}
