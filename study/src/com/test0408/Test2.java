package com.test0408;

public class Test2 {
	public static void main(String[] args) {
		// upcasting(상위클래스객체가 하위클래스객체를 가르킴)
		// 업캐스팅은 언제나 가능함
		Ex2 ob1=new Demo2();
		// ob1이 서브클래스를 가르켜도 ob1자체가 슈퍼클래스
		//    객체이며 필드는 무조건 자기자신 필드를 나타낸다.
		//    하지만 메소드는 생성된클래스의 메소드를 호출한다.
		System.out.println(ob1.a); // 20
		System.out.println(ob1.b); // 20
		ob1.print();  // sub
		// ob1.write(); // 컴파일할때검사하며 Ex2에 존재하지
		                    // 않으므로 컴파일 오류가 발생한다.
		
		// downcasting
		// 다운캐스팅은 업캐스팅한것만 다운캐스팅이 가능하다.
		// Demo2 ob2=ob1; // 에러. 반드시 캐스팅해야함
		if(ob1 instanceof Demo2) {
			System.out.println("Demo2 객체임...");
		}
		
		Demo2 ob2=(Demo2)ob1;
		ob2.print();
		ob2.write();
		
/*		Ex2 e1=new Ex2();
		Demo2 e2=(Demo2)e1; // 다운캐스팅. 런타임오류
		e2.print();*/
		
		Ex2 e1=new Ex2();
		//  instanceof : 해당 클래스의 객체이면 true
		if(e1 instanceof Demo2) { // 런타임오류방지
			Demo2 e2=(Demo2)e1;
			e2.print();
		}
		
		// Object는 모든 클래스의 super클래스(최상위)이므로
		Object o1=new Ex2();
		//o1.print(); // 컴파일오류
		((Ex2)o1).print(); // 다운캐스팅
	}
}

class Ex2 {
	int a=10, b=20;
	public void print() {
		System.out.println("super:"+a+":"+b);
	}
}

class Demo2 extends Ex2 {
	int b=200, c=300;
	public void print() {
		System.out.println("sub:"+a+":"+b+":"+c);
	}
	public void write() {
		System.out.println(a+":"+b+":"+c);
	}
}
