package com.calculato;

import java.util.Scanner;
public class CalculatorMain {

	public static void main(String[] args) {
		int menu;

		Calculation ca = new Calculation();
		Scanner sc = new Scanner(System.in);

		while (true) {
			do {
				System.out.print("1.계산  2. 종료: ");
				menu = sc.nextInt();
			} while (menu < 1 || menu > 2);

			switch (menu) {
			case 1:
				ca.input();
				break;
			case 2:
				System.out.println("\n프로그램이 종료되었습니다.");
				System.exit(0);
				break;
			}
		}
	}
}