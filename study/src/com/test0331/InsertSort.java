package com.test0331;

public class InsertSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] num = { 65, 45, 66, 99, 43, 54, 12 };
		int tmp = 0; // 임시저장
		int a = 0;

		for (int i = 1; i < num.length; i++) {
			tmp = num[i]; // 기준값 배열 1번(23)을 tmp에 대입
			a = i - 1; // 0 부터 시작
			while ((a >= 0) && num[a] > tmp) { // a가 보다 크고 num[a]값이 tmp보다 작을때 아래
												// 문장 수행
				
				num[a + 1] = num[a]; // 몰라ㅏㄹ암인러민ㅇ러;망널;ㅣ만얼;미ㅏㄴ얼;ㅣㅁ나얼;미ㅏ너
				a--;

				for (int k = 0; k < num.length; k++) {
					System.out.printf("%4d", num[k]);
				}
				System.out.println();
			}
			num[a + 1] = tmp;
			for (int k = 0; k < num.length; k++) {
				System.out.printf("%4d", num[k]);
			}
			System.out.println("num");
		}

	}
}
