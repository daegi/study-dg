package com.test0331;

public class Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a;
		int[] num = new int[45];

		for (int i = 0; i < num.length; i++) {
			num[i] = i + 1;
			
			for(int j=0;j<100;j++)
				j=(int)Math.random()*45;
			
			
			

		}

	}

}
