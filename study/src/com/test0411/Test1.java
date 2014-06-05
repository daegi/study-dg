package com.test0411;

/*���ð� ���� * interface
 * �޼ҵ尡 ���� �ϰ� ���Ǹ� ���� �ȴ� �߻� �޼ҵ�� ����
 * static final �ʵ常 ����
 * interface�� ���� ����� �����ϴ�(Ŭ������ �Ұ�)
 * 
 *  -����
 *  class Ŭ������ implements �������̽���{
 *  }
 *  �߻�Ŭ������ �ƴ� ��� ��� �޼ҵ带 ������ �ؾ��Ѵ�.
 */

public class Test1 {

	public static void main(String[] args) {
		
		Ex1 ee= new Ex1();
		ee.fun();
		
		// �ٸ� Ŭ�������� static ��ø Ŭ������ ��ü�� ����
		// �ܵ����� ��ü�� �����Ͽ� ��� �����ϴ�.
		 Ex1.Demo1 dd= new Ex1.Demo1();
		 dd.write();

	}

}



class Ex1 {
	int a = 10;
	static int b = 20;

	public void print() {
		System.out.println(a + ":" + b);
	}
	
	public void fun(){
		//static ��ø Ŭ���� ��ü ���� �� ����
		Demo1 dd=new Demo1();
		dd.write();
	}

	// static ��ø Ŭ����(Ŭ���� �տ� static Ű����� ��ø Ŭ������ ����)
	static class Demo1 {
		int c = 30;

		public void write() {
			// static ��øŬ���� ���� �ν��Ͻ� ������ ���� �Ұ�
			// System.out.println(a); <--����
			System.out.println(b);
			System.out.println(c);

			// ��ü�� �����ؼ� ��øŬ���� ���� ���� �� �޼ҵ带 ����
			Ex1 oo = new Ex1();
			System.out.println(oo.a);
			oo.print();
		}
	}
}