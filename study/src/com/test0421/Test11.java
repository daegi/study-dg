package com.test0421;

import java.io.FileOutputStream;

public class Test11 {

	public static void main(String[] args) {
		int data;

		try {

			// �⺻ : false ->������ ������ ����� �ٽ� ����
			// true : ������ ������ ������ �ʰ� �߰���
			FileOutputStream fos = new FileOutputStream("test.txt", true);

			System.out.println("���ڿ� �Է�...(ctrl+z: ����)");

			while ((data = System.in.read()) != -1) {
				fos.write(data);
			}
			fos.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
