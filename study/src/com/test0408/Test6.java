/*가로 세로를 입력 받아 사각형 넓이와 둘레를 계산하는
 * 프로그램을 상속을 이용하여 작성
 *
 * 추상화
 * 필드 :가로 세로
 * 기능 : 입력, 넓이(가*세), 둘레((가+세)*2), 출력
 * 
 * 
 * 상위 : 가로, 세로
 * 기능 : 넓이, 둘레
 * 
 * 하위 : Scanner
 * 기능: 입력, 출력
 * 
 */

package com.test0408;

import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Demo6 ob = new Demo6();
		ob.input();
		int s = ob.calc();
		ob.print(s);

	}

}

class Ex6 {
	protected int num1, num2;
	protected String oper;

	public int calc() {
		if (oper == null)
			return 0;

		int result = 0;
		if (oper.equals("넓이"))
			result = num1 * num2;
		else if (oper.equals("둘레"))
			result = (num1 * num2) / 2;

		return result;
	}
}

class Demo6 extends Ex6 {

	private Scanner sc = new Scanner(System.in);

	public void input() {
		System.out.print("가로?");
		num1 = sc.nextInt();
		System.out.print("세로?");
		num2 = sc.nextInt();

		do {
			System.out.print("넓이? 둘레?");
			oper = sc.next();
		} while (!oper.equals("넓이") && !oper.equals("둘레"));
	}

	public void print(int result) {
		System.out.println(result);

	}

}


















