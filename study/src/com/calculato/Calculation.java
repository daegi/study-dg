package com.calculato;

import java.util.Scanner;


public class Calculation {
	CalData ca = new CalData();
	Scanner sc = new Scanner(System.in);

	
	public void input(){
		System.out.print("정수 : ");
		ca.a=sc.nextInt();
		System.out.print("연산자 : ");
		ca.c=sc.next().charAt(0);
		System.out.print("정수 : ");
		ca.b=sc.nextInt();
		
		switch(ca.c){
		case '+' : System.out.println(Add()); break;
		case '-' : System.out.println(Sub()); break;
		case '/' : System.out.println(Div()); break;
		case '*' : System.out.println(Mul()); break;
		}		
	}
	
	public int Add() {		
		return ca.a+ca.b;
	}

	public int Sub() {
		return ca.a-ca.b;
	}

	public double Div() {
		return (double)(ca.a/ca.b);
	}

	public int Mul() {
		return ca.a*ca.b;
	}
}
