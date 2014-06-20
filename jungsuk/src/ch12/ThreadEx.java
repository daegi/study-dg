package ch12;

public class ThreadEx {

	public static void main(String[] args) {
		ThreadEx1_1 t1= new ThreadEx1_1();
		Runnable r = new ThreadEx1_2();
		Thread t2 = new Thread(r);
		Runnable r1 = new ThreadEx1_3();
		Thread t3 = new Thread(r1);
		
		Runnable r2 = new ThreadEx1_3();
		Thread t4 = new Thread(r2);
		
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t4.start();
		t4.start();
		t4.start();

	}

}

class ThreadEx1_1 extends Thread{
	public void run(){
		for(int i=0; i<5; i++){
			System.out.println(getName());
		}
	}
}

class ThreadEx1_2 implements Runnable{
	public void run(){
		for(int i=0; i<5; i++){
			System.out.println(Thread.currentThread().getName());
		}
	}
}


class ThreadEx1_3 implements Runnable{
	public void run(){
		for(int i=0; i<5; i++){
			System.out.println(Thread.currentThread().getName());
		}
	}
}
