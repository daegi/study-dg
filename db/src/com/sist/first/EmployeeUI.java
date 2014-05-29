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
		System.out.println("����");
		System.out.println("1.��� 2.��ȸ 3.���� 4.���� 5.����:");

		String menu = scanner.nextLine();

		if (menu.equals("5") == true) {
			System.out.println("�ý����� �����մϴ�.");
			return;
		} else {
			getUserinput(menu);// ���
		}
		showUsage();// ���
	}

	public void getUserinput(String menuStr) {
		System.out.println("Ű����� ������ �Է�");
		if (menuStr.equals("1") == true) {
			System.out.println("�̸� �־�");
			String userName = scanner.next();
			System.out.println("����� �־�");

			int empNO = Integer.parseInt(scanner.next());

			Employee newEmployee = new Employee(userName, empNO);

			service.regist(newEmployee);
		}
		System.out.println("ȭ�鿡 ���");

	}

	public static void main(String[] args) {

		EmployeeUI ui = new EmployeeUI();
		ui.showUsage();

	}
}
