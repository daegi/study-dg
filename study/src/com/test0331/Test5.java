package com.test0331;

public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n;
		int[][] arr = new int[4][5];

		n = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				n++;
				if (i % 2 == 1)
					arr[i][4 - j] = n;
				else
					arr[i][j] = n;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {

				System.out.printf("%4d", arr[i][j]);

			}
			System.out.println();
		}

	}

}
