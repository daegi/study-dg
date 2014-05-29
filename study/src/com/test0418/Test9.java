package com.test0418;

// 정수
// 문자열
// 실수

public class Test9 {

	public static void main(String[] args) {
		Box<Integer> aa = new Box();
		Box<Double> bb = new Box();

		aa.set(50);
		bb.set(100.0);

		int a = aa.get();
		double b = bb.get();

		System.out.println(a + ":" + b);

	}
}

class Box<T> {

	private T t;

	public void set(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}
}