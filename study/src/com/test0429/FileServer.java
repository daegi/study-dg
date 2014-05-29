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
		String path = "test.txt"; // 보낼 파일명
		int port = 8000;

		try {
			File f = new File(path);
			if (!f.exists()) {
				System.out.println("파일이 존재하지 않습니다.");
				return;
			}

			ServerSocket ss = new ServerSocket(port);
			System.out.println("서버 시작 !!!");
			
			//클라이언트 접속을 기다림
			Socket sc = ss.accept();

			InetSocketAddress isaClient = (InetSocketAddress) sc
					.getRemoteSocketAddress();
			String clientAddress = isaClient.getAddress().getHostAddress();
			int clientPort = isaClient.getPort();

			System.out.println("클라이언트 접속. (" + clientAddress + ":" + clientPort
					+ ")");

			long fileSize = f.length();
			System.out.println("File size: " + (fileSize) + " Byte(s)");

			FileInputStream fis = new FileInputStream(f);
			OutputStream os = sc.getOutputStream();

			long totalReadBytes = 0;

			byte[] b = new byte[512];
			int len;

			System.out.println("파일 전송 시작...");
			while ((len = fis.read(b)) > 0) {
				os.write(b, 0, len);

				totalReadBytes += len;
				System.out.println("In progress: " + totalReadBytes + "/"
						+ fileSize + " Byte(s) ("
						+ (totalReadBytes * 100 / fileSize) + " %)");
			}
			System.out.println("파일 전송 끝 !!!");

			fis.close();
			sc.close();
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
