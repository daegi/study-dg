package com.test0425;

// 데몬스레드: 다른스레드에게 도움을 주는 스레드로
// 메인스레드가 종료되면 데몬스레듣 종료됨
// 독립스레드 : 메인 스레드가 종료되어도 모든 독립스레드로
//
//

public class Test4 {
	public static void main(String[] args) {
		Ex4 t1 = new Ex4();
		Ex4 t2 = new Ex4();
		Ex4 t3 = new Ex4();
		Ex4 t4 = new Ex4();

		t1.setDaemon(true); // 데몬스레드
		t2.setDaemon(true);
		t3.setDaemon(true);

		t1.start();
		t2.start();
		t3.start();

		try {
			t1.join(); //스레드가 다 실행 될 때 까지 대기
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
			
			System.out.println("메인종료..");
		}
	}
}
