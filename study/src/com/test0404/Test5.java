package com.test0404;

public class Test5 {
	public static void stringTime() {
		// Runtime : 자바 실행 환경과 관련된 정보
		Runtime rt = Runtime.getRuntime();

		System.out.println("String...");
		System.out.println("실행전 메모리 : " + rt.freeMemory() + "/"
				+ rt.totalMemory());

		long start = System.currentTimeMillis();

		String s = "a";
		for (int i = 1; i < 300000; i++) {
			s += "a";
		}
		System.out.println("문자열길이: " + s.length());

		long end = System.currentTimeMillis();

		System.out.println("실행시간 : " + (end - start));
		System.out.println("실행후 메모리 : " + rt.freeMemory() + "/"
				+ rt.totalMemory());
	}

	// StringBuilder: 동기화 지원안함(StringBuffer 보다 빠름)
	// StringBuffer: 동기화 지원
	public static void stringBuffer() {
		// Runtime : 자바 실행 환경과 관련된 정보
		Runtime rt = Runtime.getRuntime();

		System.out.println("stringBuffer...");
		System.out.println("실행전 메모리 : " + rt.freeMemory() + "/"
				+ rt.totalMemory());

		long start = System.currentTimeMillis();

		StringBuffer sb = new StringBuffer("a");
		for (int i = 1; i < 300000; i++)
			sb.append("a");
		System.out.println("문자열길이: " + sb.length());

		long end = System.currentTimeMillis();

		System.out.println("실행시간 : " + (end - start));
		System.out.println("실행후 메모리 : " + rt.freeMemory() + "/"
				+ rt.totalMemory());
	}

	public static void main(String[] args) {

		stringTime();

		System.out.println();

		stringBuffer();

	}
}
