package com.test0424;

public class Test4 {
	public static void main(String[] args) {
		Ex4 oo = new Ex4();

		oo.start();
		//oo.run();
		
		System.out.println("����....");
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("����:" + i);
				Thread.sleep(1000);

			} catch (Exception e) {
			}
		}
		System.out.println("���� ��....");

	}
}

class Ex4 extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("������:" + i);
				sleep(2000);
			} catch (Exception e) {

			}

		}
	}
}