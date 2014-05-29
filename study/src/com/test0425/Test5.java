package com.test0425;

public class Test5 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Ex5());
		Thread t2 = new Thread(new Ex5());
		Thread t3 = new Thread(new Ex5());
		
		t3.setPriority(Thread.MAX_PRIORITY);
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.NORM_PRIORITY);

		t1.start();
		t2.start();
		t3.start();

		System.out.println("∏ﬁ¿Œ");

	}
}

class Ex5 implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			try {
				System.out.println(Thread.currentThread().getName() + ":" + i);

				Thread.sleep(500);
			} catch (Exception e) {
			}
		}

	}

}