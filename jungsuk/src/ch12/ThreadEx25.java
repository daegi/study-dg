package ch12;

public class ThreadEx25 {

	public static void main(String[] args) {
		Runnable r = new RunnableEx25();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);

	}

}

class Account25 {
	int balance = 1000;

	public synchronized void withdraw(int money) {
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

class RunnableEx25 implements Runnable {
	Account25 acc = new Account25();

	public void run() {
		while (acc.balance > 0) {
			int money = (int) (Math.random() * 3 + 1) * 100;
			acc.withdraw(money);
			System.out.println("balance:" + acc.balance);
		}
	}
}