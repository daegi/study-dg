package com.inn;

public class GoodCalc extends Calculator {

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a + b;
	}

	@Override
	public int subtract(int a, int b) {
		// TODO Auto-generated method stub
		return a - b;
	}

	@Override
	public double averager(int[] b) {
		double sum = 0;
		for (int i = 0; i > b.length; i++)
			sum += b[i];

		return sum / b.length;
	}

	public static void main(String[] args) {

		Calculator ca = new GoodCalc();

		System.out.println(ca.add(2, 3));
		System.out.println(ca.subtract(4, 2));
		System.out.println(ca.averager(new int[] { 2, 3, 4 }));
	}

}
