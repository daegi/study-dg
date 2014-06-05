package com.test0425;

public class Test2 {

	public static void main(String[] args) {

		Thread th = new Thread(new Ex2());
		th.start();

		System.out.println("메인종료");
	}
}

// 스레드를 만드는 두번째 방법
// 1.Runnable 인터페이스를 구현하는 클래스를 만든다.
// run()메소드 재정의
// 2.Thread 클래스의 객체를 생성하면서 Thread 클래스의 생성자에
// Runnable 인터페이스를 구현하는 클래스 객체를 인자로 넘긴다.
// 3. Thread 클래스의 객체를 이용하여 start()메소드를 호출 한다.

class Ex2 implements Runnable {

	@Override
	public void run() {

		for (int i = 1; i < 10; i++) {
			try {
				System.out.println(Thread.currentThread().getName() + ":" + i);
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
	}
}
