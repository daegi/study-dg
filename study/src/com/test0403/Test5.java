package com.test0403;

public class Test5 {

	public static void main(String[] args) {
		Ex5 e1=new Ex5();
		e1.set(10,5);
		e1.print();
		
		Ex5 e2=new Ex5(100,200);
		e2.print();
		
		Ex5 e3=new Ex5();
		e3.print();

	}

}


class Ex5{
	private int a, b;
	public Ex5(){
		this(1,1);//다른 생성자를 호출
		
		//Ex5(1,1); // 생성자는 new생성자()식으로만 호출
		
	}
	
	public Ex5(int a, int b){
		this.a=a;  //this: 호출한 개체(자신)을 의미하
		this.b=b;
		
	}
	
	public void set(int a, int b){
		this.a=a;
		this.b=b;
		
	}
	public void print(){
		//System.out.println(a+":"+b);
		System.out.println(this.a+":"+this.b);
	}
}