package com.test0411;

public class Test3 {
	
	public void print(){
		//메소드 안에 클래스 선언
		//로컬 클래스(이렇게 할일이 거의 없음)
		class Demo3{
			int a=10;
			public void write(){
				System.out.println(a);
			}
		}
		Demo3 a= new Demo3();
		a.write();
	}
	public static void main(String[] args) {
		
		Test3 ob=new Test3();
		ob.print();

	}

}

