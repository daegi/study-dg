/*두수? 10 5
연산자?
10+5=15

필드: 숫자2개
연산자(String)
기능:입력, 계산 출력

상위:필드,연산
하위:필드:Scanner입력,출력*/


package com.test0408;

import java.util.Scanner;

public class Test5 {
	public static void main(String[] args) {
		Demo6 ob=new Demo6();
		ob.input();
		int s=ob.calc();
		ob.print(s);
	}
}

class Ex5 {
	protected int num1, num2;
	protected String oper;
	
	public int calc() {
		if(oper==null)
			return 0;
		
		int result=0;
		if(oper.equals("+"))
			result=num1+num2;
		else if(oper.equals("-"))
			result=num1-num2;
		else if(oper.equals("*"))
			result=num1*num2;
		else if(oper.equals("/"))
			result=num1/num2;
		
		return result;
	}
}

class Demo5 extends Ex6 {
	private Scanner sc=new Scanner(System.in);
	
	public void input() {
		System.out.print("두수 ?");
		num1=sc.nextInt();
		num2=sc.nextInt();
		
		do{
			System.out.print("연산자 ?");
			oper=sc.next();
		}while(!oper.equals("+")&&!oper.equals("-")&&
				!oper.equals("*")&&!oper.equals("/"));
	}
	
	public void print(int result) {
		System.out.println(num1+oper+num2+"="+result);
	}
}


