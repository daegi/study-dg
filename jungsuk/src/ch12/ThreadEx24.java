package ch12;

public class ThreadEx24 {

	public static void main(String[] args) {
		Runnable r = new RunnableEx24();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();

	}

}

class Account24 {
	int balance = 1000;

	public void withdraw(int money) {
		if (balance >= money) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			balance -= money;
		}
	}
}

class RunnableEx24 implements Runnable {
	Account24 acc = new Account24();

	public void run() {
		while (acc.balance > 0) {
			int money = (int) (Math.random() * 3 + 1) * 100;
			acc.withdraw(money);
			System.out.println("balance:" + acc.balance);
		}
	}
}