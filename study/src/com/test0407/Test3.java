package com.test0407;

import java.util.Calendar;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 특정 날짜의 주 시작과 끝 구하기
		Calendar cal = Calendar.getInstance();
		String week[] = { "일", "월", "화", "수", "목", "금", "토" };

		// 2014년 4월 3일로 설정

		cal.set(2014, 4 -1, 6);

		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH)+1;
		int d = cal.get(Calendar.DATE);
		int w = cal.get(Calendar.DAY_OF_WEEK);
		
		System.out.println(w);
		
		System.out.printf("%4d-%02d-%02d %s요일 %n", y, m, d, week[w-1]);

		// System.out.printf("%tF %tA %n",cal,cal);

		// 주의 시작일(일요일)은?
		Calendar sday = (Calendar) cal.clone();
		int _w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		sday.add(Calendar.DAY_OF_MONTH, _w * -1);
		System.out.printf("시작:%tF%n", sday);

		// 주의 끝나는일(토요일)은?
		Calendar eday = (Calendar) cal.clone();
		_w = 7 - cal.get(Calendar.DAY_OF_WEEK);
		eday.add(Calendar.DAY_OF_MONTH, _w);
		System.out.printf("끝:%tF%n", eday);

	}

}
