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
		this(1,1);//�ٸ� �����ڸ� ȣ��
		
		//Ex5(1,1); // �����ڴ� new������()�����θ� ȣ��
		
	}
	
	public Ex5(int a, int b){
		this.a=a;  //this: ȣ���� ��ü(�ڽ�)�� �ǹ���
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