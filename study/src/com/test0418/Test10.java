package com.test0418;

public class Test10 {

	public static void main(String[] args) {
		Ex10<Integer> oo = new Ex10<Integer>();
		oo.set(new Integer(100));
		oo.print("결과");

		// w제너릭은 형이 엄격해서 자신만 가능(상위도 안됨)
		// Ex10<Number> ee=new Ex10<Integer>(); <-->오류

		// ? 모두 가능
		Ex10<?> ee = new Ex10<Integer>();
		// ee.set(new Integer(100)); <->오류

		((Ex10<Integer>) ee).set(new Integer(100));
		ee.print("테스트");

		// Number
		Ex10<? extends Number> mm = new Ex10<Integer>();
		((Ex10<Integer>) mm).set(new Integer(100));
		mm.print("테스트");

	}
}

class Ex10<T> {
	private T t;

	public void set(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}

	public <U> void print(U u) {
		System.out.println(u);
		System.out.println("T" + t.getClass().getName());
		System.out.println("U" + u.getClass().getName());
	}
}
