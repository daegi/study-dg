package com.test0407;

import java.math.BigInteger;

public class Test6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Wrapper 클래스: 기본자료형에 대흥되어지는 클래스
		// Byte, Character, Short, Long, Float, Double, boolean

		int a = 10, b;
		Integer ob;

		// 기본자료형이 Integer형으로 변환
		// 컴파일시 다음과 같이 코드가 변경됨
		// ob=new integer(a);
		// 이름 autoboxing이라 하며 JDK 5.0부터 지원

		ob = a;

		// Integer가 int로 변환
		// 컴파일시 다음과 같이 코디가 변경됨
		// b=ob.intValue();
		// 이름 Auto-unboxing이라함
		b = ob;

		System.out.println(a + ":" + b + ":" + ob);

		// 문자열을 정수로
		String s;
		s = "1234";
		a = Integer.parseInt(s);
		System.out.println(a);

		/*
		 * //정수로 변경 불가능->런타임 오류 s = "123.5"; a = Integer.parseInt(s);
		 * System.out.println(a);
		 */

		a = Integer.parseInt("ab122", 16);
		System.out.println(a);
		/*
		 * //런타임 오류 s = "1,234,123"; a = Integer.parseInt(s);
		 * System.out.println(a);
		 */

		s = "1,234,123";
		s = s.replaceAll(",", "");
		a = Integer.parseInt(s);
		System.out.println(a);

		// 정수->문자열
		s = Integer.toString(a);
		System.out.println(s);

		s = String.format("%d,d", a);
		System.out.println(s);

		// 정수를 2진수로
		s = Integer.toBinaryString(512);
		System.out.println(s);

		// 문자열을 실수로
		s = "123.45";
		double dd = Double.parseDouble(s);
		System.out.println(s);

		// 정말큰수
		BigInteger bi1 = new BigInteger("12321211111145664");
		BigInteger bi2 = new BigInteger("1232124511111111111111664");

		BigInteger bi3;
		bi3 = bi1.add(bi2);
		System.out.println(bi3);

		// 수학과 관련
		System.out.println(Math.PI);

		double d1;
		d1 = Math.sin(30 * Math.PI / 180); // 라디안
		System.out.println(d1);
		
		d1=Math.pow(2,10);
		System.out.println(d1);

		int i1 = (int)Math.random() * 100;
		System.out.println(i1);
		
		d1=Math.sqrt(d1);
		System.out.println(d1);

	}

}
