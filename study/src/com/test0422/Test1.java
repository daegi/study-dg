package com.test0422;

import java.io.File;

public class Test1 {

	public static void main(String[] args) {

		// \\��� �ǹ������� +File.separator+�� ����ؾ���
		String s1 = "c:"+File.separator+"data\\test\\a.txt";
		String s2 = s1.substring(0, s1.lastIndexOf("\\"));
/*
		// ������ �������� ������ ������ ����
		File f1 = new File(s1);
		if (!f1.getParentFile().exists()) {  //!�������� ������
			f1.getParentFile().mkdirs();
		}
*/
		File f1 = new File(s2);
		//������ �ִ� ���
		if (!f1.exists()) {
			f1.mkdirs();	//���� s�� ��� ������ ����
			System.out.println("������ �������....");
		}else{
			System.out.println("�̹� ������ ������...");
		}
		
		String s3 = System.getProperty("user.dir");
		System.out.println("���۾����:"+s3);
				

	}

}
