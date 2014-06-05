package com.test0331;

public class BubbleSort1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = { 21, 23, 40, 45, 55, 78, 85, 80, 90, 95 };
		int t;
		boolean flag;
		int pass = 1;

		do {
			flag = false;
			for (int i = 0; i < num.length - pass; i++) {
				if (num[i] > num[i + 1]) {

					t = num[i];
					num[i] = num[i + 1];
					num[i + 1] = t;
					flag = true;
				}
			}
			System.out.println(pass + "회전 결과");
			for (int n : num)
				System.out.print(n + "  ");
			System.out.println();

			pass++;
		} while (flag);

		System.out.println("정렬 결과");
		for (int n : num)
			System.out.print(n + "  ");
		System.out.println();

	}

}