package com.test0425;

public class Test1 {

	public static void main(String[] args) {
		Ex1 e1 = new Ex1();
		Ex1 e2 = new Ex1();

		e1.start();
		e2.start();

		// ������ ����Ǹ� ���α׷��� ���� �Ǵ� ���� �ƴ϶�
		// ��� ���� �����尡 ���� �Ǿ�� ���α׷��� ���� �ȴ�.
		// �� ������ ���α׷��� ���������� �������� �ƴϴ�.
		System.out.println("���� ����");

	}

}

// ������ ����� ù��° ���
// Thread Ŭ������ ��� �޾� run()�޼ҵ带 ������ �Ѵ�.
// Thread Ŭ������ ��ӹ��� åü�� �����ϰ� start()�޼ҵ� ȣ��

class Ex1 extends Thread {
	
	public Ex1(){
		
	}
	public void run() {
		for (int i = 1; i < 10000000; i++) {
			try {
				System.out.println(getName() + ":" + i);
				//Thread.sleep(1000);
			} catch (Exception e) {
			}
		}

	}
}
