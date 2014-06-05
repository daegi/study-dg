package com.test0410;

public class Test1 {
	public static void main(String[] args) {
		Ex1 ob=new Ex1();
		
		int s;
		char c;
		
		c=ob.upper('x');
		System.out.println(c);
		
		s=ob.sum(1, 20);
		System.out.println(s);
		ob.trangle(7);

		ob.gugudan(7);
		
		int []nn={2,4,6,8,10};
		s=ob.sum(nn);
		System.out.println(s);
		
	}
}

class Ex1 {
	
	// 1~n까지 합 구하기(sum)
	public int sum(int n) {
		int s=0;
		for(int i=1; i<=n; i++)
			s+=i;
		return s;
	}
	
	// n이 짝수이면 true 홀수 이면 false(isEven)
	public boolean isUpisEven(int n) {
		return n%2==0;
	}
	
	// 문자가 소문자이면 대문자로 변환(upper)
	public char upper(char c) {
		return c>='a'&&c<='z'?(char)(c-32):c;
	}
	// c가 대문자이면 true 그렇지 않으면 false(isUpper)
	public boolean isUpper(char c) {
		return c>='A'&&c<='Z';
	}
	// 두수(a, b) 중 적은수에서 큰수까지합(sum(int a, int b))
	public int sum(int a, int b) {
		int t;
		if(a>b) {
			t=a;a=b;b=t;
		}
		int s=0;
		for(int i=a;i<=b;i++) 
			s+=i;
		return s;
	}
	
	// 정수를 인자로 받아 삼각형 만들기(trangle)
	public void trangle(int n) {
		for(int i=1; i<=n; i++) {
			// 공백
			for(int j=1; j<=n-i; j++)
				System.out.print(" ");
			
			for(int j=1; j<=i*2-1; j++)
				System.out.print("*");
			System.out.println();
		}
	}
	
	// 점수에 따른 평점(95~100:4.5, 90~94:4.0.... 0.0) : grade(int n)
	public double grade(int n) {
		double s;
		if(n>=95) s=4.5;
		else if(n>=90) s=4.0;
		else if(n>=85) s=3.5;
		else if(n>=80) s=3.0;
		else if(n>=75) s=2.5;
		else if(n>=70) s=2.0;
		else if(n>=65) s=1.5;
		else if(n>=60) s=1.0;
		else s=0.0;
		return s;
	}
	
	// 점수에 따른 학점(수우미양가) : hak(int n)(switch~case)
	public String hak(int n) {
		String s;
		switch(n/10) {
		case 10:
		case 9:s="수";break;
		case 8:s="우";break;
		case 7:s="미";break;
		case 6:s="양";break;
		default:s="가";break;
		}
		return s;
	}
	
	// n단의 구구단을 출력: void gugudan(int n)
	// 단 n이 1~9가 아니면 아무것도 출력하지 않는다.
	public void gugudan(int n) {
		if(n<1 || n>9)
			return;
		
		for(int i=1; i<=9; i++)
			System.out.println(n+"*"+i+"="+(n*i));
	}
	
	// 년도가 윤년인지 평년인지 판별 : boolean isLeap(int y)
	// 년도가 4의 배수이고 100의 배수가 아니거나 400의 배수이면
	public boolean isLeap(int y) {
		return y%4==0&&y%100!=0||y%400==0;
	}
	
	// 인자로 넘어온 정수형 배열의 합 구하기
	public int sum(int[] num) {
		int s=0;
		
/*		for(int n : num)
			s+=n;
*/
		for(int i=0; i<num.length; i++)
			s+=num[i];
		
		return s;
	}

}
