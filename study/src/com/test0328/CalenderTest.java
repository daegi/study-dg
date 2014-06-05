package com.test0328;

import java.util.Scanner;

public class CalenderTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int y, m;
		int total, days, w;

		do {
			System.out.println("�⵵ : ");
			y = sc.nextInt();
		} while (y < 1);

		do {
			System.out.println("��?");
			m = sc.nextInt();
		} while (m < 1 || m > 12);

		// 1/1/1 ~ ���ݱ��� ��ü ����

		total = (y - 1) * 365 + (y - 1) / 4 - (y - 1) / 100 + (y - 1) / 400;// y-1�� 12�� 31�ϱ��� ��

		for (int i = 1; i <= m - 1; i++) {
			if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 12) {
				total += 31;
			} else if (y % 4 == 2) {
				if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0)
					total += 29;
				else
					total += 28;
			} else {
				total += 30;

			}
		}
		total++;

		w = total % 7;// �������� 1�̸� y�� m�� 1�� ������

		// m���� ������ ��¥ ���ϱ�

		days = 30;
		if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10
				|| m == 12)
			days = 31;
		else if (m == 2) {
			if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0)
				days = 29;
			else
				days = 28;

		}

		// �޷� ���

		System.out.println("\n\t" + y + "�⵵" + m + "��");
		System.out.println("  ��  ��  ȭ  ��  ��  ��  ��");
		System.out.println("=============================");

		// ����ó��

		for (int i = 1; i <= w; i++)
			System.out.print("    ");

		for (int i = 1; i <= days; i++) {
			System.out.printf("%4d", i);// ������ 4�ڸ��� ���

			if (++w % 7 == 0)
				System.out.println();
		}
		System.out.println();

	}

}
