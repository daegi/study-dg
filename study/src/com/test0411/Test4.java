package com.test0411;

public class Test4 {
	public static void main(String[] args) {
		Ex4 ee=new Ex4();
		ee.fun();
		
		ee.write();
		
	}
}

interface Inter4 {
	public void print();
}

class Ex4 {
	public void fun() {
		// Inter4 ob=new Inter4(); // ����(�������̽��°�ü�����Ұ�)
		
		// �������̽��� �̿��� �͸� Ŭ���� ����
		Inter4 ob=new Inter4() {
			@Override
			public void print() {
				System.out.println("�͸�(����) Ŭ���� ���� �Դϴ�.");
			}
		};
		
		ob.print();
	}
	
	public void write() {
		//  �͸��� Ŭ���� �ۼ� ���
		/*
		 ����Ŭ�����̸� ��ü��=new ����Ŭ����() {
		      // �ش�޼ҵ� ������
		 };
		 */
		Object ob=new Object() {
			@Override
			public String toString() {
				return "����................";
			}
		};
		
		System.out.println(ob.toString());
		
		
	}
}


