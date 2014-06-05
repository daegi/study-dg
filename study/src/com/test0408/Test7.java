package com.test0408;

import java.util.Scanner;

public class Test7 {
	public static void main(String[] args) {
		Demo7 ob=new Demo7();
		
		ob.input();
		double a=ob.area();
		double b=ob.len();
		ob.print("넓이", a);
		ob.print("둘레", b);
	}
}

class Ex7 {
	protected int r;
	public double area() {
		return r*r*3.14;
	}
	public double len() {
		return r*2*3.14;
	}
}

class Demo7 extends Ex7 {
	private Scanner sc=new Scanner(System.in);
	
	public void input() {
		System.out.print("반지름?");
		r=sc.nextInt();
	}
	
	public void print(String title, double result) {
		System.out.println("반지름:"+r);
		System.out.println(title+":"+result);
	}
}

