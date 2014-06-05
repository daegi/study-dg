package com.test0401;

public class Test5 {

	public static void main(String[] args) {
		
		Circle ob= new Circle();
		
		double s;
		s=ob.area();
		System.out.println(s);
		
		//ob.r=10; //private 이므로 오류
		
		ob.set(10);
		s=ob.area();
		ob.write("넓이 :", s);
		
		
		
		
		

	}

}

class Circle{
	private int r; //필드는 초기화 하지 않으면 0
	
	public void set(int a){
		r=a;
	}
	
	//메소드는: 일을 할수 있는 가장 작은 단위
	// 접근자 리턴타입 메소드명([인수들])
		//void가 아닌 경우 return 값;
		//void인 경우 return; -> void인 경우만 return 생략 가능
	public double area(){
		double result = r*r*3.14;
		return result;
	}
	
	public void write(String title, double a){
		System.out.println(title+":"+a);
	}

}
