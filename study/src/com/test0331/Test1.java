package com.test0331;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * int a; int arr[] = new int[10];
		 * 
		 * //System.out.println(a); //������ ����(�ʱ�ȭ �ȵ�)
		 * 
		 * System.out.println(arr[7]); System.out.println(arr[10]); //��Ÿ�� ����(����)
		 */

		// 5���� ���� �Է� �޾� �հ� ���, ������ ���� ���
		//num.length: �迭 ����� ���� (5)

		int tot, ave;
		int num[] = new int[5];

		Scanner sc = new Scanner(System.in);
		
		tot=0;
		System.out.println("�Է� : ");
		for (int i = 0; i < num.length; i++) {
			num[i] = sc.nextInt();
			tot+=num[i];
		}

		ave = tot / num.length;

		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i] + ":" + (num[i] - ave));
		}

		System.out.println("��" +tot);
		System.out.println("���" + ave);

	}

}
