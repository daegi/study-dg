package com.test0421;

public class Test1 {

	public static void main(String[] args) {
		int data;

		try {
			// read() : �ѹ��ڸ� �Է¹޾� �Է� ���� ������ ASCII�ڵ� �� ����
			
			// ctrl+z : -1
			// 13�ϰ� 10�� ���� �ǹ� 
			System.out.println("�Է�? ");
			while ((data = System.in.read()) != -1) {
				System.out.print("\n" + data + "->"+(char)data+":");
				System.out.write((char) data);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
