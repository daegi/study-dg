package com.test0414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test6 {

	public static void main(String[] args) throws IOException {
		//자바는 기본 입력은 byte 스트림인 InputStream 이다.
		//System.in ; 바이트 스트림
		//byte 스트림을 문자로 변환하는 스트림 : InputStreamReader
		//BufferedReader : 버퍼를 이용하여 입력하는 필터 스트림
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String s;
		int[] num = new int[2];
		
		
		System.out.print("정수");
		// readLine() 메소드는 checked exception 인 IOExcepiton
		// 를 반드시 처리해야 함
		// 방법1) 메소드에서 throws IOException 
		// 방법2) try~ catch
		s=br.readLine(); //한줄씩 입력
		num[0]=Integer.parseInt(s);
		
		System.out.print("정수");
		s=br.readLine();
		
		//만약 a11이라 입력 하면 NumberFormatException 이
		//발생하며 프로그램 중지(a11는 정수로 변환 불가)
		//NumberFormatException은 unchecked exception
		num[1]=Integer.parseInt(s);
		
		//배열이 2개 인데 num[2]를 사용하여 프로그램 실행중
		//ArrayIndexOutOfBoundsExcepiton 예외가 발생하여
		//프로그램을 종료한다.
		// ArrayIndexOutOfBoundsException는 런타임중 발생한
		//예외로 이런 예외를 반드시 catch 할 필요 없으며
		// unchecked exception이라 한다.
		
		num[2]=num[0]+num[1]; //중지
		System.out.println("결과:"+num[2]);
		
		System.out.println("프로그램 종료..");

	}

}
