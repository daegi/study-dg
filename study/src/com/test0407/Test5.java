package com.test0407;

import java.text.SimpleDateFormat;

import java.util.Date;

/*
 * SimpleDateFormat 클래스
 * DateFormat 클래스를 상속받은 클래스로
 * DATE 객체를 String로 변환하거나
 * String 객체를 Date로 변환하기 위해 사용
 * 
 * 
 */

public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date date = new Date();

		// Date -> 텍스트로
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		String s = sdf.format(date);
		System.out.println(s);
		
		//텍스트를 -> Date로 변환
		try {
			//예외가 발생할 사능성이 있는 코드를 작성
			//예외가 발생하면 catch()블럭으로 실행 제어를 옮기
			
			SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd");
			String ss="2014-03-03";
			
			// 문자열을 Date로 변환
			Date date1=format.parse(ss);  //예외처리가 필요
			System.out.println(date1);
			//1970년 1월 1일을 기준으로 밀리초 단위로 계산
			System.out.println(date1.getTime());
			
			Date eDay=format.parse("2014-04-07");
			Date sDay=format.parse("1982-07-03");
			
			long a=(eDay.getTime()-sDay.getTime())/(24*60*60*1000);
			System.out.println("살아온날수:"+a);
			
			
			
		} catch (Exception e) {
			// 예외가 발생할때 실행할 코드 작성
			
			
		}

	}

}
