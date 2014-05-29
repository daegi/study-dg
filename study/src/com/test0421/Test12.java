package com.test0421;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test12 {

	public static void main(String[] args) {

		try {
			// ���Ͽ� ���� ������ ���ϰų�, ����(����)����Ʈ,
			// ���� ���� ���� �� ���� ����, ���϶Ǵ� ������ ����

			String s = "test.txt"; // ����
			// ������ ������ ������ :File separator
			// String s = "c:" + File.separator + "windows"; // ����
			File f = new File(s);

			if (f.exists()) // ���� �Ǵ� ������ �����ϴ��� Ȯ��
				System.out.println(s + "�� �����մϴ�.");
			else
				System.out.println(s + "�� �������� �ʽ��ϴ�.");

			System.out.println("���ϸ�:" + f.getName());
			System.out.println("������:" + f.getAbsolutePath());
			// System.out.println("���:"+f.getPath());
			System.out.println("����:" + f.length()); // long��

			Date dd = new Date(f.lastModified());
			System.out.println("���糯¥:" + dd);

			SimpleDateFormat ff = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

			String ss = ff.format(dd);
			System.out.println("���糯¥" + dd);
			System.out.println("���鳯¥" + ss);

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
