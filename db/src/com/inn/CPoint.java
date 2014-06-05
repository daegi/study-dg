package com.inn;

public class CPoint {

	private int x, y;

	

	public CPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}


	public void show() {
		System.out.println("x=" + x + ", y=" + y + ", " + other());

	}

	protected String other() {
		return "";
	}

	public String toString() {

		return "x=" + x + ", y=" + y + "¿‘¥œ¥Ÿ.";

	}

}
