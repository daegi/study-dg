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
					System.out.println("파일명:" + ff.getName());
				} else if (ff.isDirectory()) {
					System.out.println("폴더명:" + ff.getName());

					// 다시 해당 폴더의 내용을 탐색
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

		System.out.println("파일 또는 폴더명(예:c:\\windows)?");
		pathname = sc.next();
		dirList(pathname);

	}

}
