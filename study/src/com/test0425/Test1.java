package com.test0425;

public class Test1 {

	public static void main(String[] args) {
		Ex1 e1 = new Ex1();
		Ex1 e2 = new Ex1();

		e1.start();
		e2.start();

		// 메인이 종료되면 프로그램이 종료 되는 것이 아니라
		// 모든 독립 스레드가 종료 되어야 프로그램이 종료 된다.
		// 즉 메인은 프로그램의 시작점이지 종료점은 아니다.
		System.out.println("메인 종료");

	}

}

// 스레드 만드는 첫번째 방법
// Thread 클래스를 상속 받아 run()메소드를 재정의 한다.
// Thread 클래스를 상속받은 책체를 생성하고 start()메소드 호출

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
