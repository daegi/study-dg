package com.test0331;

public class Test2 {

	public static void main(String[] args) {
		// �迭 �ʱ�ȭ
		
		int n[] = new int []{1,3,5,7,9};
		//int n[] = {1,3,5,7,9};
		
		
		//�迭�� ��� ���� ��� ��� 1
		
		for(int i=0; i<n.length; i++)
			System.out.println(n[i]);
		System.out.println();
		
		
		
		//�迭�� ��� ���� ��� ��� 2
				
		for(int a:n)		//���� for��(jdk 5.0 ���� ����) for(����:arr)
			System.out.println(a);
	}
}
