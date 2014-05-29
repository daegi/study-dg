package com.test0404;

public class Test5 {
	public static void stringTime() {
		// Runtime : �ڹ� ���� ȯ��� ���õ� ����
		Runtime rt = Runtime.getRuntime();

		System.out.println("String...");
		System.out.println("������ �޸� : " + rt.freeMemory() + "/"
				+ rt.totalMemory());

		long start = System.currentTimeMillis();

		String s = "a";
		for (int i = 1; i < 300000; i++) {
			s += "a";
		}
		System.out.println("���ڿ�����: " + s.length());

		long end = System.currentTimeMillis();

		System.out.println("����ð� : " + (end - start));
		System.out.println("������ �޸� : " + rt.freeMemory() + "/"
				+ rt.totalMemory());
	}

	// StringBuilder: ����ȭ ��������(StringBuffer ���� ����)
	// StringBuffer: ����ȭ ����
	public static void stringBuffer() {
		// Runtime : �ڹ� ���� ȯ��� ���õ� ����
		Runtime rt = Runtime.getRuntime();

		System.out.println("stringBuffer...");
		System.out.println("������ �޸� : " + rt.freeMemory() + "/"
				+ rt.totalMemory());

		long start = System.currentTimeMillis();

		StringBuffer sb = new StringBuffer("a");
		for (int i = 1; i < 300000; i++)
			sb.append("a");
		System.out.println("���ڿ�����: " + sb.length());

		long end = System.currentTimeMillis();

		System.out.println("����ð� : " + (end - start));
		System.out.println("������ �޸� : " + rt.freeMemory() + "/"
				+ rt.totalMemory());
	}

	public static void main(String[] args) {

		stringTime();

		System.out.println();

		stringBuffer();

	}
}
