package com.ch10;

public class InnerEx2 {

	class InstanceInner2 {
	}

	static class StaticInner2 {
	}

	// �ν��Ͻ� ��� ������ ���� ���� ������ �����ϴ�.
	InstanceInner2 iv = new InstanceInner2();
	// static ��� ������ ���� ���� ������ ����
	static StaticInner2 cv = new StaticInner2();

	static void staticMethod2() {
		// static ����� �ν��Ͻ� ����� ���� ���� �Ұ�
		// InstanceInner2 obj1 = new InstanceInner2();
		StaticInner2 obj2 = new StaticInner2();

		// ���� �Ϸ��� ��ü�� ���� �ϰ� �ؾ���
		InnerEx2 outer = new InnerEx2();
		InstanceInner2 obj1 = outer.new InstanceInner2();
	}

	void instanceMethod() {
		InstanceInner2 obj1 = new InstanceInner2();
		StaticInner2 obj2 = new StaticInner2();
	}

	void myMethod() {
		class LocalInner {
		}
		LocalInner iv = new LocalInner();
	}

}
