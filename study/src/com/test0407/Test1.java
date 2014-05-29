package com.test0407;

import java.util.Calendar;

public class Test1 {
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();

		// Calendar 클래스는 추상 클래스로 객체를 생성할수 없다.
		//    추상 클래스 : 미완성된 클래스
		/*
		    Calendar now = new Calendar(); // 불가
			Calendar 클래스 객체를 생성할수 있는 방법
			1. Calendar now = Calendar.getInstance();
			2. Calendar now = new GregorianCalendar();
			3. GregorianCalendar now = new GregorianCalendar();
			// GregorianCalendar : Calendar 하위 클래스
		*/

		String str1 = String.format("%1$tF %1$tA %1$tT",
				now);

		System.out.println(str1);

		int y = now.get(Calendar.YEAR);
		int m = now.get(Calendar.MONTH)+1;
		int d = now.get(Calendar.DATE);
		int w = now.get(Calendar.DAY_OF_WEEK); // 1~7
		String week="";

		switch(w) {
			case 1:week="일";break;
			case 2:week="월";break;
			case 3:week="화";break;
			case 4:week="수";break;
			case 5:week="목";break;
			case Calendar.FRIDAY:week="금";break;
			case 7:week="토";break;
		}

		System.out.println(y+"-"+m+"-"+d+ " " + week);

		// 현재 날짜에 1000일 더한다면
		now.add(Calendar.DATE, 1000);
		System.out.printf("%tF%n", now);

		// 2009년 5월 30일로 변경
		now.set(2009, 5-1, 30);  // 월은 0~11
		System.out.printf("%tF%n", now);

		// 일자만 10일로 변경
		now.set(Calendar.DATE, 10);
		System.out.printf("%tF%n", now);

		// 2011년 5월 32일로 변경
		now.set(2011, 5-1, 32);
		System.out.printf("%tF%n", now);

		int end = now.getActualMaximum(Calendar.DATE);
		System.out.println("해당 월의 마지막 일자 : "  + end);
	}

}
