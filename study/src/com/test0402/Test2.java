package com.test0402;

public class Test2 {
	int num = 0;

	// �ձ��ϱ�
	public int sum(int n) { // n:���μ�(���� �Ű�����).sum() �޼ҵ带 ���������� �Ҹ�

		int s = 0;// ��������, �ʱ�ȭ �ʿ�
		for (int i = 1; i <= n; i++)
			s += 1;
		return s;
	}

	public void sub(int i) { // ���ĸŰ������� �ǸŰ������� �������� �������� ����
		i = 200;
		System.out.println("sub����" + num);
	}

	public void test() {
		num = 300;
	}
	
	public void sub1(int[] n) { //���μ��� �迭
		n[1] = 200;
	}
	
	public void sub2(Test2 tt) { //���μ��� ��ü 
		tt.num = 700;
	}
	
	

	// static: Ŭ������ �ε��Ǵ� ���� �޸� �Ҵ� ����
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 100;

		int s;
		// s=sum(i);
		Test2 t = new Test2();
		s = t.sum(i); // i: ���μ� (�ǸŰ�����)
		System.out.println("���: " + s);

		t.test();
		
		//�⺻ �ڷ����� ���ĸŰ������� �ǸŰ������� �����Ҹ� �������� ����
		//call by value

		t.sub(i);
		System.out.println(i);
		
		
		//������(�迭, åü��)�� ���� �Ű������� �ǸŰ������� �������� ����
		//call by reference
		int []nn= new int[5];
		t.sub1(nn);
		System.out.println(nn[0]);
		System.out.println(nn[1]);
		
		t.sub2(t);
		System.out.println(t.num);
		
		
		
		

	}

}
