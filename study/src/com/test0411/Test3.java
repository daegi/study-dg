package com.test0411;

public class Test3 {
	
	public void print(){
		//�޼ҵ� �ȿ� Ŭ���� ����
		//���� Ŭ����(�̷��� ������ ���� ����)
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

