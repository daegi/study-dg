package com.test0414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test7 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s;
		int[] num = new int[2];

		// ����ó�� ��� 2 : try ~catch
		try {// ���ܰ� �߻��� ���ɼ��� �ִ� �ڵ带 ���
			System.out.print("����?");
			s = br.readLine();
			num[0] = Integer.parseInt(s);
			
			System.out.print("����?");
			s = br.readLine();
			num[1] = Integer.parseInt(s);
			
			num[2] = num[1] + num[2];
			System.out.println("���" + num[2]);
		} catch (IOException e) { // checked exception ó��
			// ���ܰ� �߻��� ��� ������ ���߰� catch ���� ����
			System.out.println(e.toString());

		}
		System.out.println("���α׷� ��");

	}

}
