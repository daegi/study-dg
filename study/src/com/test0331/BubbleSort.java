package com.test0331;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] num = { 21, 23, 40, 45, 55, 78, 85, 80, 90 };
		int t;
		
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num.length-1; j++) {
				if (num[i] > num[j]) {
					t = num[i];
					num[j] = num[i];
					num[i+1] = t;
				}
			}
			System.out.println(i+"회전 결과");
			for(int n:num)
				System.out.print(n+"  ");
				System.out.println();
			}
			System.out.println("정렬 결과");
			for(int n:num)
				System.out.print(n+"  ");
				System.out.println();
			
		

	}

}
