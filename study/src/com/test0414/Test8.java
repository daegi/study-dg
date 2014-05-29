package com.test0414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test8 {

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

		} catch (NumberFormatException e) {// unckecked 예외처리
			System.out.println("숫자가 아닙니다.");
		} catch (ArrayIndexOutOfBoundsException e) { // unckecked 예외처리
			System.out.println(e.toString());
		} catch (IOException e) { // checked exception 처리
			// 예외가 발생한 경우 실행을 멈추고 catch 블럭을 실행
			System.out.println(e.toString());

		}
		System.out.println("프로그램 끝");

	}

}
