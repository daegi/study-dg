package com.test0422;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String pathname;

		List<String> listFile = new ArrayList<String>();
		List<String> listDir = new ArrayList<String>();

		System.out.println("���� �Ǵ� ����(��:c\\windows)?");
		pathname = sc.next();

		try {
			File f = new File(pathname);
			if (!f.exists()) {
				System.out.println("�������� ����");
				System.exit(0);
			}

			File[] list = f.listFiles();
			for (int i = 0; i < list.length; i++) {
				File ff = list[i];

				if (ff.isFile())
					listFile.add(ff.getName());
				else if (ff.isDirectory())
					listDir.add(ff.getName());
			}
			// ����
			Collections.sort(listFile);
			Collections.sort(listDir);

			if (f.isDirectory()) {
				System.out.println(pathname + "������ ����");
				System.out.println("\n����");
				for (String s : listDir)
					System.out.println(s);

				System.out.println("\n����");
				for (String s : listFile)
					System.out.println(s);
			}

		} catch (Exception e) {
			System.out.println("������");
		}

	}

}
