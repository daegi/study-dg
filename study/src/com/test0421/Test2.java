package com.test0421;

public class Test2 {

	public static void main(String[] args) {
		int data;

		try {
			//abc : while�� 3��(��������)
			//���ѹα� : while�� 8��(��������) -->byte ��Ʈ��
			System.out.print("�Է�?");
			while ((data = System.in.read()) != -1) {
				char ch = (char) data;
				//System.out.print(ch); // �ѱ۱���
				System.out.write(ch);
			}

		} catch (Exception e) {
		}

	}

}
