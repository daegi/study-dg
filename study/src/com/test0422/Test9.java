package com.test0422;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test9 {

	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("ex.txt");
			int data;

			System.out.println("���ڿ�(����:ctrl+z)?");
			while ((data = System.in.read()) != -1) {
				fos.write(data);
			}
			fos.close();

			String s;
			FileInputStream fis = new FileInputStream("ex.txt");

			// ������ ������ ���پ� �Է� �ޱ� ���� ���
			// �ؽ�Ʈ ������ �ƴѰ�� ��� �ϸ� �ȵ�
			// -- ����Ʈ��Ʈ���� ���ڽ�Ʈ������ ��ȯ�ϹǷ�
			// ��������(gif, exe ��)������ ������ �ٲ�� ����
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			System.out.println("\n���ϳ���...");
			while ((s = br.readLine()) != null) {
				System.out.println(s);
			}
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
