package com.test0403;

public class Test1 {
	//인스턴스 메소드( 객체를 생성해야 호출 가능
	public int pow(int a, int b){
		return b>=1? a*pow(a,b-1):1;
	}
	//클래스 메소드 (바로 호출 가능)
	public int spow(int a, int b){
		return b>=1? a*pow(a,b-1):1;
	}
	
	public int gcm(int a, int b){
		return b==0? a:gcm(b,a%b);
	}
	
	public static void main(String[] args){
		Test1 ob =new Test1();
		
		//인스턴스 메소드 호출(객체를 생성해야 호출 가능)
		int n=ob.pow(2,10); //객체명.메소드
		System.out.println(n);
		
		//클래스 메소드 호출(static 메소드 호출)
		//n=spow(2,3); 동일 클래스이므로
		//n=.spow(2,3); //클래스 이름.메소드(인수);
		System.out.println(n);
		
		
		n= ob.gcm(12, 8);
				System.out.println(n);
	}

}
