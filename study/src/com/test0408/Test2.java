package com.test0408;

public class Test2 {
	public static void main(String[] args) {
		// upcasting(����Ŭ������ü�� ����Ŭ������ü�� ����Ŵ)
		// ��ĳ������ ������ ������
		Ex2 ob1=new Demo2();
		// ob1�� ����Ŭ������ �����ѵ� ob1��ü�� ����Ŭ����
		//    ��ü�̸� �ʵ�� ������ �ڱ��ڽ� �ʵ带 ��Ÿ����.
		//    ������ �޼ҵ�� ������Ŭ������ �޼ҵ带 ȣ���Ѵ�.
		System.out.println(ob1.a); // 20
		System.out.println(ob1.b); // 20
		ob1.print();  // sub
		// ob1.write(); // �������Ҷ��˻��ϸ� Ex2�� ��������
		                    // �����Ƿ� ������ ������ �߻��Ѵ�.
		
		// downcasting
		// �ٿ�ĳ������ ��ĳ�����Ѱ͸� �ٿ�ĳ������ �����ϴ�.
		// Demo2 ob2=ob1; // ����. �ݵ�� ĳ�����ؾ���
		if(ob1 instanceof Demo2) {
			System.out.println("Demo2 ��ü��...");
		}
		
		Demo2 ob2=(Demo2)ob1;
		ob2.print();
		ob2.write();
		
/*		Ex2 e1=new Ex2();
		Demo2 e2=(Demo2)e1; // �ٿ�ĳ����. ��Ÿ�ӿ���
		e2.print();*/
		
		Ex2 e1=new Ex2();
		//  instanceof : �ش� Ŭ������ ��ü�̸� true
		if(e1 instanceof Demo2) { // ��Ÿ�ӿ�������
			Demo2 e2=(Demo2)e1;
			e2.print();
		}
		
		// Object�� ��� Ŭ������ superŬ����(�ֻ���)�̹Ƿ�
		Object o1=new Ex2();
		//o1.print(); // �����Ͽ���
		((Ex2)o1).print(); // �ٿ�ĳ����
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
