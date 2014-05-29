package com.test0425;

// ���󽺷���: �ٸ������忡�� ������ �ִ� �������
// ���ν����尡 ����Ǹ� ���󽺷��� �����
// ���������� : ���� �����尡 ����Ǿ ��� �����������
//
//

public class Test4 {
	public static void main(String[] args) {
		Ex4 t1 = new Ex4();
		Ex4 t2 = new Ex4();
		Ex4 t3 = new Ex4();
		Ex4 t4 = new Ex4();

		t1.setDaemon(true); // ���󽺷���
		t2.setDaemon(true);
		t3.setDaemon(true);

		t1.start();
		t2.start();
		t3.start();

		try {
			t1.join(); //�����尡 �� ���� �� �� ���� ���
			t2.join();
			t3.join();

		} catch (Exception e) {
		}

	}

}

class Ex4 extends Thread {
	public void run() {
		for (int i = 1; i <= 10; i++) {
			try {
				System.out.println(getName() + ":" + i);
				Thread.sleep(1000);
			} catch (Exception e) {
			}
			
			System.out.println("��������..");
		}
	}
}
