package com.employee;

import java.util.Scanner;

public class EmployeeUI {

	static {
		System.out.println("��� ����Դϴ�.");
	}

	public void employeeUi() {
		Scanner sc = new Scanner(System.in);
		int a;

		EmployeeService es = new EmployeeService();

		while (true) {
			do {
				System.out.println("1. ��� 2. ��ȸ 3. ���� 4.���� 5.���� :");
				a = sc.nextInt();
				sc.nextLine();

			} while (a < 1 || a > 5);

			switch (a) {
			case 1:
				es.input();
				break;
			case 2:
				es.update();
				break;
			case 3:
				es.search();
				break;
			case 4:
				es.remove();
				break;
			case 5:
				es.exit();
				break;
			}
		}
	}
}