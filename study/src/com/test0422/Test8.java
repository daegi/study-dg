package com.test0422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test8 {

	// System.in : byte ��Ʈ��
	// InputStreamReader: ����Ʈ ��Ʈ���� ���ڽ�Ʈ�����κ�ȯ
	// BufferedReader: ���ͽ�Ʈ��

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		
		System.out.println("���ڿ�?");
		try {
			s=br.readLine();
			System.out.println(s);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
