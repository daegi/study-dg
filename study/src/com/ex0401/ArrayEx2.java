package com.ex0401;

public class ArrayEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] score = { 79, 88, 90, 33, 10, 55, 95 }; // 7

		int max = score[0];
		int min = score[0];

		for (int i = 1; i < score.length; i++) {
			if (score[i] > max) {
				max = score[i];
			}
			if (score[i] < min) {
				min = score[i];
			}
		}
		System.out.println("�ִ밪 :" + max);
		System.out.println("�ּҰ� :" + min);

	}

}