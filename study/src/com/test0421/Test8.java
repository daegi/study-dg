package com.test0421;

//������ ����? test.txt
//������ ���纻? ex.txt
//
//�Է¹��� �U���� �ƽ�Ű�ڵ尪�� ������ ������ ����
//	��ĳ�� ��ü
//try{
//	�������ϸ�� ���纻 ���ϸ����Է� �޴´�.
//	���� �Է°�ü�� ���� ��� ��ü ����
//	���� �Է� ��ü���� �о ���� ��� ��ü�� ����-�ݺ�
//�����Է� ��ü�� ��������°�ü ���
//}catch(....)

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Test8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int data;
		String s1, s2;

		try {
			System.out.println("���� �Է�?");
			s1 = sc.next();
			System.out.println("���纻 �Է�?");
			s2 = sc.next();
			FileInputStream fis = new FileInputStream(s1);
			FileOutputStream fos = new FileOutputStream(s2);

			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			fos.close();
			fis.close();
			System.out.println("���� �Ϸ�");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
