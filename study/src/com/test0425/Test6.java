package com.test0425;

public class Test6 {

	public static void main(String[] args) {
		Ex6 t1 = new Ex6();
		Ex6 t2 = new Ex6();
		Ex6 t3 = new Ex6();
		
		t1.setThread(t2);
		t2.setThread(t3);
		t3.setThread(t1);
		
		

		t1.start();
		t2.start();
		t3.start();
		
		t1.interrupt();
		
		try{
			t1.join();
			t1.join();
			t1.join();
			
		}catch (Exception e) {
			
		}
		
		
		System.out.println("메인 끝...");

	}

}

class Ex6 extends Thread {
	private Thread next;

	public void setThread(Thread next) {
		this.next = next;
	}

	public void run() {
		for (int i = 1; i <= 10; i++) {
			try {

				sleep(1000);
				System.out.println(getName() + ":" + i);
				if (next.isAlive()) // 살아있으면
					next.interrupt(); // 깨움

			} catch (Exception e) {
			}
		}
	}
}
