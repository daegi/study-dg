package com.test0401;

public class Test3 {

	public static void main(String[] args) {
		
	// 3. ��ü ����	
		Sum ss=new Sum();
		
	ss.num=100;
	System.out.println("�� : "+ss.hap());
	System.out.println("¦���� : "+ss.even());

	}

}

// ��, ¦����, Ȧ�� �� ���ϴ� Ŭ���� �����

/*
 * 
 * 1. �߻�ȭ -������ : ����(��������) -���: ��,¦����,Ȧ����
 * 
 * 
 */




// 2. Ŭ���� �����
class Sum {
	int num;
	
	
	//�ڿ��� ��
	public int hap() {
		int s = 0;
		for (int i = 0; i <= num; i++)
			s += i;
		return s;
	}
	
	//¦����
	public int even() {
		int s = 0;
		for (int i = 2; i <= num; i += 2)
			s += i;
		return s;
	}
	
	//Ȧ����
	public int odd() {
		int s = 0;
		for (int i = 1; i <= num; i += 2)
			s += i;
		return s;
	}
}
