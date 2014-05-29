package com.test0331;

public class Test4 {

	public static void main(String[] args) {

		int num[] = { 45, 85, 78, 50, 35 };

		int t;

		// 선택정렬

		for (int i = 0; i < num.length - 1; i++) {
			for (int j = i + 1; j < num.length; j++) {
				if (num[i] > num[j]) {
					t = num[i];
					num[i] = num[j];
					num[j] = t;
				}
			}
		}
		System.out.println("정렬 결과");
		for (int i = 0; i < num.length; i++)
			System.out.print(num + "   ");
		System.out.println();
	}

}
