package com.test0424;

public class Test4 {
	public static void main(String[] args) {
		Ex4 oo = new Ex4();

		oo.start();
		//oo.run();
		
		System.out.println("메인....");
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("메인:" + i);
				Thread.sleep(1000);

			} catch (Exception e) {
			}
		}
		System.out.println("메인 끝....");

	}
}

class Ex4 extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("쓰레드:" + i);
				sleep(2000);
			} catch (Exception e) {

			}

		}
	}
}