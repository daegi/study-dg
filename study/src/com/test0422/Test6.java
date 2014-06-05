package com.test0422;

import java.io.File;

public class Test6 {

	public static void removeDir(String pathname) {
		File f = new File(pathname);

		if (!f.exists()) {
			System.out.println("폴더 또는 파일이 존재하지 않음...");
			return;
		}
		try {
			if (f.isDirectory())
				removeSubDir(pathname);

			f.delete();
		} catch (Exception e) {
			System.out.println("삭제 실패...");
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
			System.out.println("삭제 실패....");
		}

	}

	public static void main(String[] args) {
		removeDir("d:\\ex");

	}

}
