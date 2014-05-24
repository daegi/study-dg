package com.ch10;

public class InnerEx2 {

	class InstanceInner2 {
	}

	static class StaticInner2 {
	}

	// 인스턴스 멤버 간에는 서로 직접 접근이 가능하다.
	InstanceInner2 iv = new InstanceInner2();
	// static 멤버 간에는 서로 직접 접근이 가능
	static StaticInner2 cv = new StaticInner2();

	static void staticMethod2() {
		// static 멤버는 인스턴스 멤버에 직접 접근 불가
		// InstanceInner2 obj1 = new InstanceInner2();
		StaticInner2 obj2 = new StaticInner2();

		// 굳이 하려면 객체를 생성 하고 해야함
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
