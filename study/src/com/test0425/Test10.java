package com.test0425;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Test10 {

	public static void main(String[] args) {

		new Ex10();

	}
}

// - TimeTask
// �߻�Ŭ������ �����ٿ� ���� �ؾ� �� ���� TimerTask�� ��ӹ޾�
// run() �޼ҵ带 ������ �Ѵ�
// Ÿ�̸翡 ���� 1ȸ �Ǵ� �ݺ������� �����ϵ��� �ϴ� ������
// ��� ���, Ȩ��, ���� �湮�� ó����
// Timer: ������

class Ex10 {
	public Ex10() {
		TimerTask tt = new TimerTask() {

			@Override
			public void run() {
				print();

			}
		};
		Timer t = new Timer();

		// t.schedule(tt, 5000); <- 5���� �ѹ��� ����

		// t.schedule(tt, new Data(), 1000); <-- 1�ʸ��� ���� �ݺ�

		// ������ 0�� 0�� 0�ʿ� �����Ͽ� �Ϸ翡 �ѹ��� ����
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		t.schedule(tt, cal.getTime(), 1000 * 60 * 60 * 24);

	}

	public void print() {
		Calendar cal = Calendar.getInstance();

		String s = String.format("%tT%tT", cal, cal);
		System.out.println(s);
	}
}
