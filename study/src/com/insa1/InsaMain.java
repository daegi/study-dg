package com.insa1;

import java.util.Scanner;

public class InsaMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		InsaService ss = new InsaService();

		while (true) {
			do {
				System.out.print("1.�Է� 2.���� 3.�˻� 4.���� 5.�̸��� 6.�޿��� 7.���� >>");
				n = sc.nextInt();
				sc.nextLine();
			} while (n < 1 || n > 5);

			switch (n) {
			case 1:
				ss.input();
				break;
			case 2:
				ss.update();
				break;
			case 3:
				ss.search();
				break;
			case 4:
				ss.remove();
				break;
			case 5:
				ss.printNameOrder();
				break;
			case 6:
				ss.printPayOrder();
				break;
			case 7:
				System.exit(0);
				break;
			}
		}
	}
}
