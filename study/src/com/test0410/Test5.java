package com.test0410;

public class Test5 {

	public static void main(String[] args) {

	}

}

class Ex5{
	int a=10;
	static int b=20;
	
	public void print(){
		System.out.println(a+":"+b);
	}
	
	//static ��ø Ŭ����(��ø Ŭ������ ��츸 Ŭ�����տ� static����)
	static class Demo5{
		int c=30;
		public void write(){
			//static ��øŬ������ �ν��Ͻ� ���� ���� �Ұ�
			//static ��øŬ������ �ܵ����� ��ü ������ ���� �ϹǷ�]
			// System.out.println(a);<--����  
			System.out.println(b+":"+c);
		}
	}
}
