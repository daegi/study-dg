package com.test0414;


public class Test11 {

	public static void main(String[] args) {

		Ex11 ob = new Ex11();
		
		try{
			ob.fun(-10);
			System.out.println(ob.get());
			
		}catch(Exception e){
			System.out.println(e.toString());
		}
		System.out.println("��,,,");

	}

}

class Ex11 {
	private int a = 10;
	
	
	// ���ܸ� �������(throw)��� �޼ҵ忡�� �ݵ��
	// �ش� ���ܸ� throws �ؾ��Ѵ�.
	// �̷���� checked exception �� ���� ����̴�.
	public void fun(int a) throws Exception {
		if (a < 0) // ���ܸ� ����(������ ���ܸ� �߻���Ŵ)
			throw new Exception("���� 0���� ������ ����.");

		this.a += a;
	}

	public int get() {
		return a;

	}

}
