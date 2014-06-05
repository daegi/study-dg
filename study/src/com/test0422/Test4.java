package com.test0422;

import java.io.File;
import java.util.Scanner;

public class Test4 {
	public static void dirList(String pathname) {
		File f = new File(pathname);
		File[] list = f.listFiles();

		try {
			for (int i = 0; i < list.length; i++) {
				File ff = list[i];
				if (ff.isFile()) {
					System.out.println("���ϸ�:" + ff.getName());
				} else if (ff.isDirectory()) {
					System.out.println("������:" + ff.getName());

					// �ٽ� �ش� ������ ������ Ž��
					dirList(ff.getCanonicalPath());
				}
			}

		} catch (Exception e) {
			System.out.println(e.toString());

		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String pathname;

		System.out.println("���� �Ǵ� ������(��:c:\\windows)?");
		pathname = sc.next();
		dirList(pathname);

	}

}
