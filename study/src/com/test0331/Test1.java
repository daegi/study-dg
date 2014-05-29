package com.test0331;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * int a; int arr[] = new int[10];
		 * 
		 * //System.out.println(a); //컴파일 오류(초기화 안됨)
		 * 
		 * System.out.println(arr[7]); System.out.println(arr[10]); //런타임 오류(예외)
		 */

		// 5개의 수를 입력 받아 합과 평균, 각수의 편차 출력
		//num.length: 배열 요소의 개수 (5)

		int tot, ave;
		int num[] = new int[5];

		Scanner sc = new Scanner(System.in);
		
		tot=0;
		System.out.println("입력 : ");
		for (int i = 0; i < num.length; i++) {
			num[i] = sc.nextInt();
			tot+=num[i];
		}

		ave = tot / num.length;

		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i] + ":" + (num[i] - ave));
		}

		System.out.println("합" +tot);
		System.out.println("평균" + ave);

	}

}
