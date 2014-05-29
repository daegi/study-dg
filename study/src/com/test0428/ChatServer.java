package com.test0428;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatServer extends JFrame implements ActionListener, Runnable {
	private static final long serialVersionUID = 1L;

	private JTextArea ta = new JTextArea();
	private JTextField tf = new JTextField();

	private ServerSocket ss;
	private Socket sc;
	private int port = 7777;
	private String user = "서버]";

	public ChatServer() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(new JScrollPane(ta), BorderLayout.CENTER);
		add(tf, BorderLayout.SOUTH);

		// JTextField에 ActionEvent등록(엔터 치면 발생)
		tf.addActionListener(this);

		setTitle("채팅 서버");
		setSize(500, 500);
		setVisible(true);

	}

	public static void main(String[] args) {
		new ChatServer().serverStart();

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == tf) {
			try {
				String s = tf.getText().trim();

				if (s.length() == 0) {
					tf.requestFocus();
					return;
				}

				// 채팅 문자열 전송
				if (sc == null) // 클라이언트 접속이 없는 경우
					return;

				// 클라이언트에게 보낼 출력 스트림
				PrintWriter pw = new PrintWriter(sc.getOutputStream(), true);
				// 버퍼내용을 바로전송

				// 클라이언트에게 문자열 보냄
				pw.println(user + s);

				ta.append("보냄]" + s + "\n");
				tf.setText("");
				tf.requestFocus();

			} catch (Exception e) {
				ta.append("클라이언트가 나갔음. \n");
				sc = null;
			}
		}

	}

	@Override
	public void run() {
		String ip = null;

		try {
			if (sc == null) // 클라이언트가 연결되지 않은 경우
				return;

			// 접속한 클라이언트의 ip주소 구하기
			ip = sc.getInetAddress().getHostAddress();
			ta.append(ip + "에서 접속... \n");

			// 접속한 클라이언트의 정보를 받기 위한 입력 스트림

			BufferedReader br = new BufferedReader(new InputStreamReader(
					sc.getInputStream()));

			String s;
			while ((s = br.readLine()) != null) {
				ta.append(s + "\n");
			}

		} catch (Exception e) {
			// 클라이언트가 접속을 해제하면 IOException이 발생
			String s = ip + "에서 연결해제";
			ta.append(s + "\n");
			sc = null;
		}

	}

	public void serverStart() {
		try {
			// 클라이언트와의 접속을 위한 서버 소켓을 객체생성(포트)
			ss = new ServerSocket(port);

			ta.setText("서버 시작... \n");

			// 클라이언트의 접속을 기다린다(blocking 상태)
			sc = ss.accept(); // 접속된 클라이언트와 통신할 소켓 리턴

			// 클라이언트가 접속 된 경우 클라이언트 정보를 받기 위한 스레드실행
			Thread t = new Thread(this);
			t.start();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
