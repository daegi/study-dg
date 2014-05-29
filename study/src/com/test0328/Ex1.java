package com.test0328;

import java.util.Scanner;

/*-정수를 입력 받아 입력 받은 정수의 자리수 구하기
정수? 256
자리수 : 3
*/


public class Ex1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, len, temp;

		System.out.println("수 : ");
		n = sc.nextInt();
		temp = n;

		if (temp < 0)

			temp -= temp;
		len = 1;

		while (temp >= 10) {
			len++;
			temp /= 10;
		}
		System.out.println(n + "의 길이 : " + len);

	}

}
