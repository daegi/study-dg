package com.test0409;

public class Test3 {

	public static void main(String[] args) {
		// Ŭ���� ������ Ŭ���� �޼ҵ� ������ ��ü�� �������� �ʾƵ� Ŭ���� �̸����� ���� �����ϴ�.
		//Ŭ���� ������ �޸� ������ ���α׷� �����
		
		System.out.println(Ex3.b); 
		Ex3.fun();
		
		//�ν��Ͻ� ������ �޼ҵ�� �ݵ�� ��ü�� �����Ŀ� ����
		Ex3 ob =new Ex3();
		System.out.println(ob.a);
		ob.print();	

	}

}

class Ex3 {
	//�ʵ�
	int a = 10; // �ν��Ͻ� ����(��ü�� �����Ǿ�� ��� ����)
	static int b, c = 30; /* 
							*Ŭ���� ����(Ŭ������ �޸𸮿� �ε��� �޸��Ҵ�
							* ��ü�� �������� �ʾƵ� ��밡��)
							* ��ü�� ���� �����ʹ� �����ϰ� �ѹ��� �޸� �Ҵ�
							*/
	
	static { // static �ʱ�ȭ ��(static ���� �ʱ�ȭ)
		c = 20;
	}

	// Ŭ���� �޼ҵ�(��ü�� �������� �ʾƵ� �ٷ� ��밡��)
	public static void fun() {
		// System.out.println(a); -> ����(�ν��ϼ������� ���ٺҰ�)
		System.out.println(b + ":" + c);
		//System.out.println(this.b); <-����(sataic ������ this, super ���Ұ�)
		// print(); -> ����(�ν��Ͻ��޼ҵ� ���� �Ұ�"��ü�� �����Ǿ߸�")
		
		Ex3 oo=new Ex3();
			oo.print();
	}

	// �ν��Ͻ� �޼ҵ�(��ü�� �����Ǿ� ��밡��)
	public void print() {
		System.out.println(a + ":" + b + ":" + c);
	}
}
