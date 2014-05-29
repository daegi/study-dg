package com.test0410;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2 ob = new Ex2();
		ob.print(10);
		ob.write();
		
		
		Inter1 ii=ob; //��ĳ����
		ii.write();

	}
}
/*
 * interface�� ���� �ְ� ���ǰ� ���� �߻�Ŭ������ �����̴�.
 * -�ʵ�� final ������ �����ϸ� final�� ������ �ʾƵ� final
 * -���������ڸ� ������ �ʾƵ� public 
 * -�޼ҵ�� ���� ����.(abstract �޼ҵ���)
 * -�������̽��� ���� ����� �����ϴ�.
 * -�������̽��� ������ Ŭ������ �ݵ�� �������̽��� ���
 * �޼ҵ带 ������ �ؾ� �Ѵ�.(��, �߻� Ŭ������ ����)
 * -�ڹ��� ���� ����� �������� �ʴ� ���� �������̽���
 * �ذ��� �� �ִ�.
*/

interface Inter1{
	int a=10;

	// public int c;  <����(flnal ������ �����ϸ� �ݵ�� �ʱ�ȭ)
	public int b=20;
	
	public void print(int n);
	public abstract void write(); //abstract �����ص� abstract 	
}

// �������̽� ����(2���̻� ���� ����)
// �߻�Ŭ������ �ƴѰ�� �������̽��� ��� �޼ҵ带 ������ �ؾ���
class Ex2 implements Inter1{

	@Override
	public void print(int n) {
		// TODO Auto-generated method stub
		System.out.println(n);
		
	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		System.out.println("���...");
		
	}
}
		