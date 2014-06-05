package com.test0409;

public class Test6 {

	public static void main(String[] args) {
		SelectionSort ss = new SelectionSort();

		int[] n = { 50, 42, 62, 75, 44 };

		ss.sort(n);
		for (int nn : n)
			System.out.print(nn + "  ");
		System.out.println();

	}

}

/*
 * abstract Ŭ���� -�̿ϼ� Ŭ���� 
 * -�̿ϼ� Ŭ�����̹Ƿ� ��ü ���� �Ұ� (��:java.util.Calendar) 
 * -abstract �޼ҵ尡 ����(���� �ְ� ���ǰ� ���� �޼ҵ�) 
 * -�޸� ������� ȣ���ȹ�� ����� ���� ��� 
 * -�ϳ� �̻��� abstract �޼ҵ尡 �����ϴ°�� �ݵ�� abstract Ŭ������ 
 * �ۼ��ؾ���(abstract)�޼ҵ尡 ��� ���� 
 * -�ݵ�� ���� Ŭ������ �����ϸ� abstract Ŭ������ ��� ���� ���� Ŭ������
 *  ��� abstract �޼ҵ带 ������ �ؾ��� ��, ���� Ŭ������ abstract Ŭ����
 * �̸� ������ ���� �ʾƵ���
 */

abstract class SortInt {
	protected int[] num;

	public abstract void sorting();

	public void sort(int[] num) {
		this.num = num;
		sorting();
	}

	public int length() { // �迭 ����� ����
		if (num == null)
			return 0;
		return num.length;
	}

	public void swap(int i, int j) {
		int t = num[i];
		num[i] = num[j];
		num[j] = t;

	}

	public int compare(int i, int j) {
		return num[i] - num[j];
	}
}

class SelectionSort extends SortInt {

	// @Override: ������̼�, �ΰ����� ����
	// �ּ��� �������Ҷ� ���������� ������̼��� ������������
	// @Override�� �޼ҵ� �����ǵ� ����� �˷��ִ� ������
	// ������ ��߳��� ���� ǥ����

	@Override
	public void sorting() {
		if (length() == 0)
			return;

		for (int i = 0; i < length() - 1; i++) {
			for (int j = i + 1; j < length(); j++) {
				if (compare(i, j) > 0)
					swap(i, j);
			}
		}

	}
}

class BubbleSort extends SortInt{

	@Override
	public void sorting() {
		// TODO Auto-generated method stub
		int pass=1;
		boolean flag;
		
		do{
			flag=false;
			for(int i=0; i<length()-pass;i++){
				if(compare(i, i+1)>0){
					swap(i,i+1);
					flag=true;
				}
			}
			pass++;
		}while(flag);
		
	}
	
}
