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
		System.out.println("������....");
		// �ʵ� �ʱ�ȭ�� ����(�ʱ�ȭ ���� ������ int �ʵ�� 0����)
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
		System.out.println("���ھ��� ������.....");
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
		System.out.println("���ھ��� ������......");
	}
	public Sam4(int x, int y){
		System.out.println("���� �ΰ��� ������");
	}
	
	public void print(){
		System.out.println(a+";"+b);
	}
}