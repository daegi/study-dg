package com.test0429;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
	public static void main(String[] args) {
		String path = "test.txt"; // ���� ���ϸ�
		int port = 8000;

		try {
			File f = new File(path);
			if (!f.exists()) {
				System.out.println("������ �������� �ʽ��ϴ�.");
				return;
			}

			ServerSocket ss = new ServerSocket(port);
			System.out.println("���� ���� !!!");
			
			//Ŭ���̾�Ʈ ������ ��ٸ�
			Socket sc = ss.accept();

			InetSocketAddress isaClient = (InetSocketAddress) sc
					.getRemoteSocketAddress();
			String clientAddress = isaClient.getAddress().getHostAddress();
			int clientPort = isaClient.getPort();

			System.out.println("Ŭ���̾�Ʈ ����. (" + clientAddress + ":" + clientPort
					+ ")");

			long fileSize = f.length();
			System.out.println("File size: " + (fileSize) + " Byte(s)");

			FileInputStream fis = new FileInputStream(f);
			OutputStream os = sc.getOutputStream();

			long totalReadBytes = 0;

			byte[] b = new byte[512];
			int len;

			System.out.println("���� ���� ����...");
			while ((len = fis.read(b)) > 0) {
				os.write(b, 0, len);

				totalReadBytes += len;
				System.out.println("In progress: " + totalReadBytes + "/"
						+ fileSize + " Byte(s) ("
						+ (totalReadBytes * 100 / fileSize) + " %)");
			}
			System.out.println("���� ���� �� !!!");

			fis.close();
			sc.close();
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
