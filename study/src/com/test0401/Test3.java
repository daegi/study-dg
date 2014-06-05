package com.test0401;

public class Test3 {

	public static void main(String[] args) {
		
	// 3. 객체 생성	
		Sum ss=new Sum();
		
	ss.num=100;
	System.out.println("합 : "+ss.hap());
	System.out.println("짝수합 : "+ss.even());

	}

}

// 합, 짝수합, 홀수 합 구하는 클래스 만들기

/*
 * 
 * 1. 추상화 -데이터 : 정수(합을구할) -기능: 합,짝수합,홀수합
 * 
 * 
 */




// 2. 클래스 만들기
class Sum {
	int num;
	
	
	//자연수 합
	public int hap() {
		int s = 0;
		for (int i = 0; i <= num; i++)
			s += i;
		return s;
	}
	
	//짝수합
	public int even() {
		int s = 0;
		for (int i = 2; i <= num; i += 2)
			s += i;
		return s;
	}
	
	//홀수합
	public int odd() {
		int s = 0;
		for (int i = 1; i <= num; i += 2)
			s += i;
		return s;
	}
}
