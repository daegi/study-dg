package com.test0428;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatMultiServer {
	// Ŭ���̾�Ʈ�� ��Ĺ�� �����ϱ� ���� List ��ü
	private ArrayList<Socket> list = new ArrayList<>();
	private ServerSocket ss;
	private int port = 7777;

	// ���� ������ Ŭ����
	class WorkerThread extends Thread {
		private Socket sc = null;

		public WorkerThread(Socket sc) {
			this.sc = sc;
		}

		public void run() {
			String ip = null;

			try {
				// ������ Ŭ���̾�Ʈ�� ip
				ip = sc.getInetAddress().getHostAddress();

				// ������ Ŭ���̾�Ʈ ������ ������� �Է½�Ʈ��(����)
				BufferedReader br = new BufferedReader(new InputStreamReader(
						sc.getInputStream()));

				// Ŭ���̾�Ʈ(����)�� ArrayList�� ����
				list.add(sc);

				// Ŭ���̾�Ʈ�� ���� ����� �ٸ� Ŭ���̾�Ʈ���� �˸�
				String ss = ip + " ����.........";
				for (Socket s : list) {
					if (s == sc)
						continue; // �ڱ� ���ſ��Դ� ���� �� �ʿ䰡 �����Ƿ�

					PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
					pw.println(ss);
				}
				System.out.println(ss);

				// Ŭ���̾�Ʈ�� ���� ������ �ٸ� Ŭ���̾�Ʈ���� ����
				while ((ss = br.readLine()) != null) {
					ss = ss + "(" + ip + ")";

					// �ٸ� Ŭ���̾�Ʈ���� ����
					for (Socket s : list) {
						if (s == sc)
							continue;

						PrintWriter pw = new PrintWriter(s.getOutputStream(),
								true);
						pw.println(ss);
					}
				}

			} catch (Exception e) {
				// Ŭ���̾�Ʈ�� ���� ������ ���
				String ss = ip + "�� ������ ���� �߽��ϴ�.";

				// �ٸ� Ŭ���̾�Ʈ���� ���� ���� ����� �˸�
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

				// ArrayList���� �ش� ���� ����
				list.remove(sc);

				sc = null;
				System.out.println(ss);
			}
		}
	}

	public void serverStart() {
		try {
			ss = new ServerSocket(port);
			System.out.println("���� ����...");

			while (true) { // 1:�� ä���̹Ƿ� while(true)
				Socket sc = ss.accept(); // Ŭ���̾�Ʈ ������ ��ٸ�

				// Ŭ���̾�Ʈ�� ������ ������ ������ ����
				// 1���� Ŭ���̾��Ʈ->�ϳ��� �����尡 ó��
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
