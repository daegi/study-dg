package com.test0425;

public class Test8 {

	public static void main(String[] args) {
		Ex8 ee = new Ex8();

		Thread t1 = new Thread(ee);
		Thread t2 = new Thread(ee);

		t1.start();
		t2.start();

	}

}

class Ex8 implements Runnable {

	private int money = 10000;

	public int getMoney() {
		return money;
	}

	public int draw(int m) { // 인출
		money -= m;
		return m;
	}

	@Override
	public void run() {
		int need = 600;
		int m;
		String msg;

		try {
			synchronized (this) { //동기화
				if (money >= need) {
					Thread.sleep(500);

					m = draw(need);
					msg = "인출성공:" + m;
				} else {
					m = 0;
					msg = "인출실패:" + m;
				}
			}

			System.out.println(msg + ",잔액:" + money);
		} catch (Exception e) {
		}

	}
}