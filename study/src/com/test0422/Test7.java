package com.test0422;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test7 {

	public static void fileCopy1(String source, String target) {
		try {
			FileInputStream fis = new FileInputStream(source);
			FileOutputStream fos = new FileOutputStream(target);
			byte b[] = new byte[1024];
			int len;

			System.out.println("복사시작...");
			long start = System.currentTimeMillis();

			while ((len = fis.read(b, 0, 1024)) != -1) {
				fos.write(b, 0, len);
			}
			fos.close();
			fis.close();

			long end = System.currentTimeMillis();
			System.out.println("걸린시간 :" + (end - start) + "ms");

		} catch (Exception e) {
		}
	}

	public static void fileCopy2(String source, String target) {
		try {
			int BUFFER_SIZE = 1024;

			FileInputStream fis = new FileInputStream(source);
			FileOutputStream fos = new FileOutputStream(target);

			// 버퍼스트림
			BufferedInputStream bis = new BufferedInputStream(fis);
			BufferedOutputStream bos = new BufferedOutputStream(fos,BUFFER_SIZE);

			byte b[] = new byte[BUFFER_SIZE];
			int len;

			System.out.println("복사시작...");
			long start = System.currentTimeMillis();

			while ((len = bis.read(b, 0, BUFFER_SIZE)) != -1) {
				bos.write(b, 0, len);
			}
			bos.flush();
			bos.close();
			bis.close();

			long end = System.currentTimeMillis();
			System.out.println("걸린시간 :" + (end - start) + "ms");

		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		String source = "d:\\ex\\12.zip";
		String target = "d:\\ex\\123.zip";
		
		//fileCopy1(source, target);
		fileCopy2(source, target);
		
	}

}
