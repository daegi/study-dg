package com.test0418;

public class Test10 {

	public static void main(String[] args) {
		Ex10<Integer> oo = new Ex10<Integer>();
		oo.set(new Integer(100));
		oo.print("���");

		// w���ʸ��� ���� �����ؼ� �ڽŸ� ����(������ �ȵ�)
		// Ex10<Number> ee=new Ex10<Integer>(); <-->����

		// ? ��� ����
		Ex10<?> ee = new Ex10<Integer>();
		// ee.set(new Integer(100)); <->����

		((Ex10<Integer>) ee).set(new Integer(100));
		ee.print("�׽�Ʈ");

		// Number
		Ex10<? extends Number> mm = new Ex10<Integer>();
		((Ex10<Integer>) mm).set(new Integer(100));
		mm.print("�׽�Ʈ");

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
