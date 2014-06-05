package com.ex0403;

public class Test2 {
	private int w, h;

	public int area() {
		return w * h;
	}

	public void write(int a) {
		System.out.println("°á°ú : " + a);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Test2 ob1 = new Test2();

		ob1.w = 10;
		ob1.h = 20;
		int a = ob1.area();
		ob1.write(a);

	}

}
