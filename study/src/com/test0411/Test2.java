package com.test0411;

public class Test2 {

	public static void main(String[] args) {
		
		Ex2 ee=new Ex2();
		ee.print();
		
		// �ٸ� Ŭ�������� ��ø Ŭ���� ��ü ����
		// �ܵ����δ� ��ü�� ���� �� �� ����.
		//Ex2.Demo2 dd= new Ex2.Demo2(); <-->����
		
		
		//�ܺ�Ŭ���� ��ü�� �̿��Ͽ� ��ü�� �����ؾ� ��
		Ex2.Demo2 dd= ee.new Demo2();
		dd.write();

	}

}

class Ex2 {
	int a = 10;
	static int b = 20;

	public void print() {
		System.out.println(a + ":" + b);
		
		Demo2 dd= new Demo2();
		dd.write();
	}

	// ��øŬ����
	class Demo2 {
		int c = 30;
		public void write() {
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);

		}
	}
}
