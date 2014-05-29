package com.test0422;

import java.io.File;

public class Test6 {

	public static void removeDir(String pathname) {
		File f = new File(pathname);

		if (!f.exists()) {
			System.out.println("���� �Ǵ� ������ �������� ����...");
			return;
		}
		try {
			if (f.isDirectory())
				removeSubDir(pathname);

			f.delete();
		} catch (Exception e) {
			System.out.println("���� ����...");
		}
	}

	private static void removeSubDir(String pathname) {
		File[] list = new File(pathname).listFiles();

		try {
			for (int i = 0; i < list.length; i++) {
				if (list[i].isDirectory())
					removeSubDir(list[i].getPath());

				list[i].delete();
			}

		} catch (Exception e) {
			System.out.println("���� ����....");
		}

	}

	public static void main(String[] args) {
		removeDir("d:\\ex");

	}

}
