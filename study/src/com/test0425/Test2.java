package com.test0425;

public class Test2 {

	public static void main(String[] args) {

		Thread th = new Thread(new Ex2());
		th.start();

		System.out.println("��������");
	}
}

// �����带 ����� �ι�° ���
// 1.Runnable �������̽��� �����ϴ� Ŭ������ �����.
// run()�޼ҵ� ������
// 2.Thread Ŭ������ ��ü�� �����ϸ鼭 Thread Ŭ������ �����ڿ�
// Runnable �������̽��� �����ϴ� Ŭ���� ��ü�� ���ڷ� �ѱ��.
// 3. Thread Ŭ������ ��ü�� �̿��Ͽ� start()�޼ҵ带 ȣ�� �Ѵ�.

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
