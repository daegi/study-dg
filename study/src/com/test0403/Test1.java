package com.test0403;

public class Test1 {
	//�ν��Ͻ� �޼ҵ�( ��ü�� �����ؾ� ȣ�� ����
	public int pow(int a, int b){
		return b>=1? a*pow(a,b-1):1;
	}
	//Ŭ���� �޼ҵ� (�ٷ� ȣ�� ����)
	public int spow(int a, int b){
		return b>=1? a*pow(a,b-1):1;
	}
	
	public int gcm(int a, int b){
		return b==0? a:gcm(b,a%b);
	}
	
	public static void main(String[] args){
		Test1 ob =new Test1();
		
		//�ν��Ͻ� �޼ҵ� ȣ��(��ü�� �����ؾ� ȣ�� ����)
		int n=ob.pow(2,10); //��ü��.�޼ҵ�
		System.out.println(n);
		
		//Ŭ���� �޼ҵ� ȣ��(static �޼ҵ� ȣ��)
		//n=spow(2,3); ���� Ŭ�����̹Ƿ�
		//n=.spow(2,3); //Ŭ���� �̸�.�޼ҵ�(�μ�);
		System.out.println(n);
		
		
		n= ob.gcm(12, 8);
				System.out.println(n);
	}

}
