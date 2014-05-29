package com.test0425;

public class Test9 {

	public static void main(String[] args) {

		Data ob = new Data();
		Up uu = new Up(ob, "up");
		Down dd = new Down(ob, "down");

		uu.start();
		dd.start();

	}

}

class Data {

	private int val = 100;
	
	// synchronized 메소드(동기화 메소드)
	public synchronized void up(String title) {
		System.out.print(title + ":" + val);
		val++;
		System.out.println(",증가:" + val);
	}

	public synchronized void down(String title) {
		System.out.print(title + ":" + val);
		val--;
		System.out.println(",감소:" + val);
	}
}

class Up extends Thread {
	private Data share;
	private String title;

	public Up(Data share, String title) {
		this.share = share;
		this.title = title;
	}

	public void run() {
		for (int i = 1; i < 10; i++) {
			try {
				sleep(500);
				share.up(title);
			} catch (Exception e) {
			}
		}
	}
}

class Down extends Thread {
	private Data share;
	private String title;

	public Down(Data share, String title) {
		this.share = share;
		this.title = title;
	}

	public void run() {
		for (int i = 1; i < 10; i++) {
			try {
				sleep(500);
				share.down(title);
			} catch (Exception e) {
			}
		}
	}
}
