package com.test0414;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test10 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s;
		int[] num = new int[2];

		// 예외처리 방법 2 : try ~catch
		try {// 예외가 발생할 가능성이 있는 코드를 기술
			System.out.print("정수?");
			s = br.readLine();
			num[0] = Integer.parseInt(s);

			System.out.print("정수?");
			s = br.readLine();
			num[1] = Integer.parseInt(s);

			num[2] = num[1] + num[2];
			System.out.println("결과" + num[2]);

		} catch (Exception e) {
			// checked exception 및 unchecked 예외 모두 처리
			//System.out.println(e.toString());
			e.printStackTrace();
		}finally{
			//예외가 발생하거나 하지 않아도 실행
			System.out.println("나는 언제나 실행....");

		}
		System.out.println("프로그램 끝");

	}

}
