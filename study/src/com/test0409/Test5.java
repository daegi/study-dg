package com.test0409;

public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

// final �ʵ�: ���� �ѹ��� �ʱ�ȭ �Ҽ� �մ�.
// �Ϲ������� final �ʵ�� static�� ���� ����ϸ�
// �ʵ� ���� �빮�ڷ� �����.
// final �޼ҵ� : �޼ҵ带 ������(Override)�� �� ����.
// final Ŭ���� : ���� Ŭ����(���� Ŭ����)�� ���� �� ����.
// ��ǥ���� final Ŭ���� : String 
class Ex5{
	final int a=10, b; 
	public Ex5(){
		b=20;  //final ���� �ʱ�ȭ�� ������ �Ǵ� �ʱ�ȭ ������
	}
	public final void print(){
		System.out.println(a+":"+b);
	}
	public void fun(){
		// a=30; -> ����
		
	}
}