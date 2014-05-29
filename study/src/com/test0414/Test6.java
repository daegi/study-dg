package com.test0414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test6 {

	public static void main(String[] args) throws IOException {
		//�ڹٴ� �⺻ �Է��� byte ��Ʈ���� InputStream �̴�.
		//System.in ; ����Ʈ ��Ʈ��
		//byte ��Ʈ���� ���ڷ� ��ȯ�ϴ� ��Ʈ�� : InputStreamReader
		//BufferedReader : ���۸� �̿��Ͽ� �Է��ϴ� ���� ��Ʈ��
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String s;
		int[] num = new int[2];
		
		
		System.out.print("����");
		// readLine() �޼ҵ�� checked exception �� IOExcepiton
		// �� �ݵ�� ó���ؾ� ��
		// ���1) �޼ҵ忡�� throws IOException 
		// ���2) try~ catch
		s=br.readLine(); //���پ� �Է�
		num[0]=Integer.parseInt(s);
		
		System.out.print("����");
		s=br.readLine();
		
		//���� a11�̶� �Է� �ϸ� NumberFormatException ��
		//�߻��ϸ� ���α׷� ����(a11�� ������ ��ȯ �Ұ�)
		//NumberFormatException�� unchecked exception
		num[1]=Integer.parseInt(s);
		
		//�迭�� 2�� �ε� num[2]�� ����Ͽ� ���α׷� ������
		//ArrayIndexOutOfBoundsExcepiton ���ܰ� �߻��Ͽ�
		//���α׷��� �����Ѵ�.
		// ArrayIndexOutOfBoundsException�� ��Ÿ���� �߻���
		//���ܷ� �̷� ���ܸ� �ݵ�� catch �� �ʿ� ������
		// unchecked exception�̶� �Ѵ�.
		
		num[2]=num[0]+num[1]; //����
		System.out.println("���:"+num[2]);
		
		System.out.println("���α׷� ����..");

	}

}
