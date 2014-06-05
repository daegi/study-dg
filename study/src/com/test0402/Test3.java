package com.test0402;

public class Test3 {


	// a의 b승 구하기
	public double pow(int a, int b) {

		double d = 1;
		if (b > 0) {
			for (int i = 1; i <= b; i++)
				d *= a;
		} else {
			for (int i = 1; i <= (-b); i++)
				d /= a;
		}
		return d;
	}

	// 대문자인 경우 소문자로

	public char lower(char ch) {
		return ch > 'A' && ch <= 'z' ? (char) (ch + 32) : ch;

	}

	// 윤년 평년

	public boolean isLeap(int y) {
		return y % 4 == 0 && y % 100 != 0 && y % 400 == 0;
	}
	
	//재귀 호출(되부름)
	public void print(int n){
		if(n>1)
			print(n-1);
		
		System.out.print(n+"     ");
		
	}
	
	public int sum(int n){
		return n>1 ? n+sum(n-1) : n;
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test3 t = new Test3();
		double a;
		a = t.pow(2, 10);
		System.out.println(a);
		
		System.out.println(t.sum(100));

		a = t.pow(4, -2);
		System.out.println(a);

		System.out.println(t.lower('B'));
		
		
		if(t.isLeap(2014))
			System.out.println("평년");
		else
			System.out.println("윤년");
		
		
		t.print(5);
		
		
		
	}

}
