package com.test0328;

import java.util.Scanner;

/*-������ �Է� �޾� �Է� ���� ������ �ڸ��� ���ϱ�
����? 256
�ڸ��� : 3
*/


public class Ex1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, len, temp;

		System.out.println("�� : ");
		n = sc.nextInt();
		temp = n;

		if (temp < 0)

			temp -= temp;
		len = 1;

		while (temp >= 10) {
			len++;
			temp /= 10;
		}
		System.out.println(n + "�� ���� : " + len);

	}

}
