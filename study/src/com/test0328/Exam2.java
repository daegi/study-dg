package com.test0328;

public class Exam2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int sum = 0;
		for (int i = 0; i < 10; i++) {

			if (i % 2 == 0)
				continue;// 짝수이면 다시 처음 for문으로 이동
			sum += i;
			System.out.print(i + "\t");
		}
		System.out.println("홀수의합:" + sum);
	}
}