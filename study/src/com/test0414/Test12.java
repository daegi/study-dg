package com.test0414;

import java.util.Scanner;

//두수 ? 10 5
//연산자 ? +
//10=5=15

//-두수 입력을 잘못한 경우 예외 처리를 이용하여
// 숫자를 정확히 입력 하세요 메시지를 출력하고 프로그램
// 종료

//-연산자가 +,-,*,/가 아닌경우 연산 오류입니다.
//라는 예외가 출력 되도록 예외를 던질것

//- 나눗셈에서 나누는 수가 0인경우 0으로 나눌수 없습니다.
// 메시지가 나오도록 예외를 던질것

public class Test12 {

	public static void main(String[] args) {
		
		Calculate cc= new Calculate();
		
		cc.input();

	}

}

class Calculate {
	private int num1, num2;
	private char oper;
	private Scanner sc = new Scanner(System.in);

	public void input() {
		try {

			System.out.print("두수 : ");
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			System.out.println("연산자 :");
			oper = sc.next().charAt(0);

			int s = calc();
			System.out.printf("%d %c %d% = %d %n", num1, oper, num2, s);

		} catch (Exception e) {
			System.out.println(e.toString());

		}

	}

	public int calc()throws Exception{
		int s=0;
		
		
		if(oper=='+')
			s=num1+num2;
		else if(oper=='-')
			s=num1-num2;
		else if(oper=='*')
			s=num1*num2;
		else if(oper=='/'){
			s=num1/num2;
				if(num2==0)
					throw new Exception("0으로 나눌수 없다");
				s=num1/num2;
		}else{
				throw new Exception("연산자 에러 입니다.");
			}
		
		return s;
	}
}
