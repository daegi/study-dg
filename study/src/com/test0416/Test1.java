package com.test0416;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		String name;
		int kor, eng;
		
		//�⺻�����ڴ� ����, ����, ��
		Scanner sc =new Scanner(System.in);
		System.out.print("�̸�, ����, ����[,�� ����]:");
		sc = new Scanner(sc.next()).useDelimiter("\\s,\\s*");
				name =sc.next();
				kor = sc.nextInt();
				eng = sc.nextInt();
				
				System.out.println("�̸�:");
				System.out.println("����:");
				
		
	}

}
