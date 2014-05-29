package com.test0425;

public class Test7 {

	public static void main(String[] args) {
		Ex7 ee= new Ex7();
		
		Thread t1 = new Thread(ee);
		Thread t2 = new Thread(ee);
		
		t1.start();
		t2.start();
		
	}

}

class Ex7 implements Runnable {

	private int money = 1000;

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
			if (money >= need) {
				Thread.sleep(500);

				m = draw(need);
				msg = "인출성공:" + m;
			} else {
				m = 0;
				msg = "인출실패:" + m;
			}
			System.out.println(msg + ",잔액:" + money);
		} catch (Exception e) {
		}

	}
}