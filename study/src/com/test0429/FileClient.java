package com.test0429;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class FileClient {
	public static void main(String[] args) {
		String path="sam.txt"; // ���� ���ϸ�
		String host = "127.0.0.1";
		int port = 8000;

		try {
			Socket sc = new Socket(host, port);
			System.out.println("���� ����...");
			
			FileOutputStream fos = new FileOutputStream(path);
			InputStream is = sc.getInputStream();
			
			byte[] b = new byte[512];
			int len;
			
			System.out.println("���� �ٿ�ε� ����...");
			long startTime = System.currentTimeMillis();
			
			while ((len = is.read(b)) != -1) {
				fos.write(b, 0, len);
			}
			
			long endTime = System.currentTimeMillis();
			System.out.println("���� �ٿ�ε� ��.");
			System.out.println("�ð�:"+(endTime-startTime)+"ms");

			is.close();
			fos.close();

			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
