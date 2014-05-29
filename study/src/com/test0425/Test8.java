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

	public int draw(int m) { // ����
		money -= m;
		return m;
	}

	@Override
	public void run() {
		int need = 600;
		int m;
		String msg;

		try {
			synchronized (this) { //����ȭ
				if (money >= need) {
					Thread.sleep(500);

					m = draw(need);
					msg = "���⼺��:" + m;
				} else {
					m = 0;
					msg = "�������:" + m;
				}
			}

			System.out.println(msg + ",�ܾ�:" + money);
		} catch (Exception e) {
		}

	}
}