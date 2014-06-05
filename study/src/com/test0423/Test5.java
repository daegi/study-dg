package com.test0423;

import java.io.RandomAccessFile;

public class Test5 {

	public static void main(String[] args) {
		try {
			byte b;
			RandomAccessFile rad = new RandomAccessFile("ex.txt", "rw");
			for (int i = 65; i <= 90; i++) {
				rad.write(i);
			}

			// 파일의 내용을 읽어 들일 위치로 이동
			rad.seek(5);
			b = rad.readByte();
			System.out.write(b);

			rad.seek(10);
			b = rad.readByte();
			System.out.write(b);
			System.out.flush();
			System.out.println();

			for (int i = 0; i < (int) rad.length(); i += 2) {
				rad.seek(i);
				System.out.print((char) rad.readByte());
			}
			System.out.println();
			rad.close();

		} catch (Exception e) {
		}

	}

}
