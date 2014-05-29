package com.test0429;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class FileClient {
	public static void main(String[] args) {
		String path="sam.txt"; // 받은 파일명
		String host = "127.0.0.1";
		int port = 8000;

		try {
			Socket sc = new Socket(host, port);
			System.out.println("서버 접속...");
			
			FileOutputStream fos = new FileOutputStream(path);
			InputStream is = sc.getInputStream();
			
			byte[] b = new byte[512];
			int len;
			
			System.out.println("파일 다운로드 시작...");
			long startTime = System.currentTimeMillis();
			
			while ((len = is.read(b)) != -1) {
				fos.write(b, 0, len);
			}
			
			long endTime = System.currentTimeMillis();
			System.out.println("파일 다운로드 끝.");
			System.out.println("시간:"+(endTime-startTime)+"ms");

			is.close();
			fos.close();

			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
