package com.test0403;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Ex4 e=new Ex4();
		e.print();
		
		Demo4 d=new Demo4(100,5);
		e.print();
		
		Sam4 s1=new Sam4();
		s1.print();
		
		Sam4 s2=new Sam4(5,5);
		s2.print();
		
		
		

	}

}

class Ex4{
	int a, b;
	public Ex4(){
		System.out.println("생성자....");
		// 필드 초기화도 가능(초기화 하지 않으면 int 필드는 0으로)
		a=10;
		b=5;
	}
	
	public void print(){
		System.out.println(a+":"+b);
	}
}



class Demo4{
	int a, b;
	public Demo4(int x, int y){
		System.out.println("인자없는 생성자.....");
		a=x;
		b=y;
	}
	
	public void print(){
		System.out.println(a+":"+b);
	}
}


class Sam4{
	int a, b;
	
	public Sam4(){
		System.out.println("인자없는 생성자......");
	}
	public Sam4(int x, int y){
		System.out.println("인자 두개인 생성자");
	}
	
	public void print(){
		System.out.println(a+";"+b);
	}
}