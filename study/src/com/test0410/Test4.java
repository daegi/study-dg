package com.test0410;

public class Test4 {

	public static void main(String[] args) {
		/*
		 * �������̽����߻�Ŭ������ �������� ��ü ���� �Ұ��� 
		 * Inter4 x=new Inter4(); <-����
		 * 
		 */

		// ��ĳ���� ��(�������̽��� ���� Ŭ������ ���� �ƹ���)
		Inter4 ob = new Ex4();
		ob.write(); // Ex4 Ŭ������ �޼ҵ� ����

		// ob.print(); <-����. Inter4�� print() �޼ҵ尡 �����Ƿ�
		// ������ ����. �̷� ��쿡�� �ݵ�� �ٿ� ĳ����
		((Ex4) ob).print();// �ٿ� ĳ�����ؼ� �޼ҵ� ȣ��

		Ex4 ee = (Ex4) ob; 
		ee.print();
		
		/*
		Demo4 dd=(Demo4)ob; //��Ÿ�� ����
		dd.print();
		*/
		
		//ob�� Demo4�� ��ü�� �ƴϹǷ� if���� �������� ����
		if(ob instanceof Demo4){
			Demo4 dd=(Demo4)ob;
			dd.print();
		}
		
		
	}

}

interface Inter4 {
	public void write();
}

class Ex4 implements Inter4 {

	@Override
	public void write() {
		System.out.println("write...");

	}

	public void print() {
		System.out.println("print...");
	}
}

class Demo4 implements Inter4{

	@Override
	public void write() {
		System.out.println("Demo write....");
	}
	
	public void print(){
		System.out.println("Demo print.....");
	}
	
}
