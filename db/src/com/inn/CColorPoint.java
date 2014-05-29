package com.inn;

public class CColorPoint extends CPoint {

	private String color;

	public CColorPoint(int x, int y, String color) {
		super(x, y);
		this.color = color;

	}

	public String other() {
		return color;
	}

	public static void main(String[] args) {
		CPoint a, b;

		a = new CPoint(2, 3);
		b = new CColorPoint(3, 4, "color");

		a.show();
		b.show();
		System.out.println(a);
		System.out.println(b);
	}
}
