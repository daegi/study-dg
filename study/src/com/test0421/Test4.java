package com.test0421;

import java.io.InputStreamReader;
import java.io.Reader;

public class Test4 {

	public static void main(String[] args) {
		
		

		int data;
		// Stystem.in: ����Ʈ ��Ʈ��(InputStream)
		// Reader : ���� ��Ʈ��(�߻� Ŭ����)
		// InputStreamReader : ����Ʈ ��Ʈ���� ���� ��Ʈ��
		// ���� ��ȯ�ϴ� bridge ��Ʈ��

		Reader rd = new InputStreamReader(System.in);

		try {
			System.out.print("���ڿ�?");
			// ���ѹα��� �Է��� ���
			// InputStream:while 8�� ����
			// Reader : while���� 4�� ����

			while ((data = rd.read()) != -1) {
				char ch=(char) data;
				System.out.print(ch);  //��´����� �����̹Ƿ� �ѱ��� ������ ����
				//System.out.write(ch);  <---��´����� ����Ʈ�̹Ƿ� �ѱ� ����

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
