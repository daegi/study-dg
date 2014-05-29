package com.test0428;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatMultiServer {
	// 클라이언트의 소캣을 저장하기 위한 List 객체
	private ArrayList<Socket> list = new ArrayList<>();
	private ServerSocket ss;
	private int port = 7777;

	// 내부 스레드 클래스
	class WorkerThread extends Thread {
		private Socket sc = null;

		public WorkerThread(Socket sc) {
			this.sc = sc;
		}

		public void run() {
			String ip = null;

			try {
				// 접속한 클라이언트의 ip
				ip = sc.getInetAddress().getHostAddress();

				// 접속한 클라이언트 정보를 얻기위한 입력스트림(수신)
				BufferedReader br = new BufferedReader(new InputStreamReader(
						sc.getInputStream()));

				// 클라이언트(소켓)를 ArrayList에 저장
				list.add(sc);

				// 클라이언트의 접속 사실을 다른 클라이언트에게 알림
				String ss = ip + " 입장.........";
				for (Socket s : list) {
					if (s == sc)
						continue; // 자기 지신에게는 전송 할 필요가 없으므로

					PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
					pw.println(ss);
				}
				System.out.println(ss);

				// 클라이언트가 보낸 정보를 다른 클라이언트에게 전송
				while ((ss = br.readLine()) != null) {
					ss = ss + "(" + ip + ")";

					// 다른 클라이언트에게 전송
					for (Socket s : list) {
						if (s == sc)
							continue;

						PrintWriter pw = new PrintWriter(s.getOutputStream(),
								true);
						pw.println(ss);
					}
				}

			} catch (Exception e) {
				// 클라이언트가 접속 해제한 경우
				String ss = ip + "가 접속을 해제 했습니다.";

				// 다른 클라이언트에게 접속 해제 사실을 알림
				try {
					for (Socket s : list) {
						if (s == sc)
							continue;

						PrintWriter pw = new PrintWriter(s.getOutputStream(),
								true);
						pw.println(ss);
					}
				} catch (Exception e2) {
				}

				// ArrayList에서 해당 소켓 제거
				list.remove(sc);

				sc = null;
				System.out.println(ss);
			}
		}
	}

	public void serverStart() {
		try {
			ss = new ServerSocket(port);
			System.out.println("서버 시작...");

			while (true) { // 1:다 채팅이므로 while(true)
				Socket sc = ss.accept(); // 클라이언트 접속을 기다림

				// 클라이언트가 접속할 때마다 스레드 생성
				// 1명의 클라이어언트->하나의 스레드가 처리
				WorkerThread th = new WorkerThread(sc);
				th.start();
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public static void main(String[] args) {
		new ChatMultiServer().serverStart();
	}
}
