package com.test0401;

public class Test4 {

	public static void main(String[] args) {
		Ex4 oo1 = new Ex4();
		Ex4 oo2 = new Ex4();
		
		//System.out.println(oo1.a);// ���� private�� �ܺ� Ŭ�������� ���� �Ұ�
		
		oo1.b=5;
		System.out.println(oo1.b+":"+oo1.c+":"+oo1.d);
		oo1.write();
		
		oo2.b=5;
		//�ʵ带 �ʱ�ȭ ���� ������ int�� ��� 0
		System.out.println(oo2.b+":"+oo2.c+":"+oo2.d);
		oo2.write();
		

		Ex4 o=oo1;
		o.b=400;
		System.out.println(oo1.b+":"+oo1.c+":"+oo1.d);
		oo2.write();

	}

}

class Ex4{
	
	//�ʵ�(�ν��ͽ� ����)
	private int a; 	//�ٸ� Ŭ�������� ���� �Ұ�(ĸ��ȭ)
	int b;	  			//���� ��Ű��(����)���� �� ���ٰ���
	protected int c;  //���� ��Ű�� �� ����Ŭ������ ���ٰ���
	public int d= 10; 	//��𼭳� ���ٰ���
	public void write(){
		System.out.println(a+":"+b+":"+c+":"+d);
	}
}
