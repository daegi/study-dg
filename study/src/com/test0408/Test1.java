package com.test0408;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo1 ob1 =new Demo1();
		
				
		ob1.print(); //���۱۷����� �޼ҵ� ȣ��
		ob1.write(); //
		//System.out.println(e); <--sub Ŭ���� ����� ���ٺҰ�
		
		// ob.a= 300; <--����(������ private)
		
		ob1.b=200;
		ob1.e=500;
		ob1.print();
		ob1.write();
		
		//���� Ŭ���� ��ü�� ���� Ŭ������ ����Ű�� ���� upcasting�̶� ��
		//upcasting�� ������ ����
		Ex1 ob2=new Demo1();

	}

}

// superŬ����
class Ex1 {
	private int a = 10;
	int b = 20;
	protected int c = 30, d = 40;

	public void print() {
		
		///System.out.println(a); <- ����
		System.out.println(a + ":" + b + ":" + c + ":" + d);
	}
}

// Demo1�� superŬ���� Ex1�� b, c, print()�� ��ӹ���
// sub Ŭ����.(���� ��Ӹ� ����)
class Demo1 extends Ex1 {
	int d = 50, e = 60;

	public void write() {
		System.out.println(b + ":" + c + ":" + d + ":" + e);
	}
}