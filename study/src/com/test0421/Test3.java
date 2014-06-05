package com.test0421;

//InputStream의 read() 메소드는 IOException의
// checked exception이 발생하므로 예외처리를 위해 IOExcoption
// IOExcepiton 을 import
import java.io.IOException;

//하나의 java 파일에는 public class는 하나만 존재해야 함
public class Test3 {

	public static void main(String[] args) {
		int n, s, data; // 기본 자료형인 int변수 선언
						// n: 입력은 정수 저장
						// s: 합저장
						// data : 키보드로 입력한 문자의 ASCII코드 저장

		try { // 예외처리 : read()메소드는 반드시 예욀르 처리해야함
				// 예외가 발생할 가능성이 있는 코드를 기술

			// 무엇을 입력해야 하는지를 화면에 출
			System.out.print("정수?");

			// 정수 입력
			n = 0; // 입력받은 정수를 누적하기 위해 0으로 초기화

			// 엔터를 누를 때까지 입력(엔터:ASCII코드 13)
			while ((data = System.in.read()) != -13) {
				// 문자 0의 ASCII코드는 48이며 숫자로 바꾸기 위해 48을 뺀다
				// 앞에 입력된 숫자를 처리하기 위해 10을 곱해줌
				n = n * 10 + (data - 48);
			}

			// 합계산
			s = 0;// 합을 누적하기 위해 0으로 초기화
			// 반복문: for(초기화:조건:재초기)
			// 조건을 만족하면 반복 수행하며 반복횟수가 정해진경우
			// for문을 반복횟수가 일정하지 않은 경우 while문 사용
			for (int i = 1; i <= n; i++) {
				s += i; // 1~입력받은 수까지의 합을 s변수에 누적
			}

			// 출력
			System.out.println(s); // 합을 출력

		} catch (IOException e) { // IOException 처리
			// IOException이 발생할 경우 실행
			// 오류 메시지를 콘솔에 출력
			System.out.println(e.toString());
		} // chatch 끝

	}

}
