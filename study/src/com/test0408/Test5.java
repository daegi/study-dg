/*�μ�? 10 5
������?
10+5=15

�ʵ�: ����2��
������(String)
���:�Է�, ��� ���

����:�ʵ�,����
����:�ʵ�:Scanner�Է�,���*/


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
		System.out.print("�μ� ?");
		num1=sc.nextInt();
		num2=sc.nextInt();
		
		do{
			System.out.print("������ ?");
			oper=sc.next();
		}while(!oper.equals("+")&&!oper.equals("-")&&
				!oper.equals("*")&&!oper.equals("/"));
	}
	
	public void print(int result) {
		System.out.println(num1+oper+num2+"="+result);
	}
}


