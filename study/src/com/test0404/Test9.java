package com.test0404;

import java.util.Calendar;

public class Test9 {

	public static void main(String[] args) {
		//날짜를 처리하는 클래스
		//calendar는 추상 클래스로 객체를 바로 생성 할 수 없다.
		// Calendar cc= new Calendar(); 오류
		
		Calendar now  = Calendar.getInstance();
		
		System.out.printf("%tF %n", now);
		
		//2014년 7월 3일로 설정
		now.set(2014, 7-1,4); //월은 0~11로 표현
		System.out.printf("%tF %n",now);
		
		System.out.println(now.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		System.out.println(now.get(Calendar.DAY_OF_WEEK));
	}

}



/*
년 월을 입력 받아 해당 월의 달력 구하기
-calendar 클래스 이용
*/