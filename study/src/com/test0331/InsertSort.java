package com.test0331;

public class InsertSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] num = { 65, 45, 66, 99, 43, 54, 12 };
		int tmp = 0; // �ӽ�����
		int a = 0;

		for (int i = 1; i < num.length; i++) {
			tmp = num[i]; // ���ذ� �迭 1��(23)�� tmp�� ����
			a = i - 1; // 0 ���� ����
			while ((a >= 0) && num[a] > tmp) { // a�� ���� ũ�� num[a]���� tmp���� ������ �Ʒ�
												// ���� ����
				
				num[a + 1] = num[a]; // ���󤿤����η��Τ���;����;�Ӹ���;�̤�����;�Ӥ�����;�̤���
				a--;

				for (int k = 0; k < num.length; k++) {
					System.out.printf("%4d", num[k]);
				}
				System.out.println();
			}
			num[a + 1] = tmp;
			for (int k = 0; k < num.length; k++) {
				System.out.printf("%4d", num[k]);
			}
			System.out.println("num");
		}

	}
}
