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
// 추상클래스로 스케줄에 따라 해야 할 일은 TimerTask를 상속받아
// run() 메소드를 재정의 한다
// 타이며에 의해 1회 또는 반복적으로 실행하도록 하는 스케줄
// 디비 백업, 홈피, 일일 방문자 처리등
// Timer: 스케줄

class Ex10 {
	public Ex10() {
		TimerTask tt = new TimerTask() {

			@Override
			public void run() {
				print();

			}
		};
		Timer t = new Timer();

		// t.schedule(tt, 5000); <- 5초후 한번만 실행

		// t.schedule(tt, new Data(), 1000); <-- 1초마다 무한 반복

		// 다음날 0시 0분 0초에 시작하여 하루에 한번씩 실행
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
