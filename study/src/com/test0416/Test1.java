package com.test0416;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		String name;
		int kor, eng;
		
		//기본구분자는 공백, 엔터, 탭
		Scanner sc =new Scanner(System.in);
		System.out.print("이름, 국어, 영어[,로 구분]:");
		sc = new Scanner(sc.next()).useDelimiter("\\s,\\s*");
				name =sc.next();
				kor = sc.nextInt();
				eng = sc.nextInt();
				
				System.out.println("이름:");
				System.out.println("총점:");
				
		
	}

}
