package com.test0428;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements ActionListener, Runnable {
	private static final long serialVersionUID = 1L;

	private JTextArea ta = new JTextArea();
	private JTextField tf = new JTextField();

	private Socket sc;
	private String host = "127.0.0.1";
	private int port = 7777;
	private String user = "스프링]";

	public ChatClient() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(new JScrollPane(ta), BorderLayout.CENTER);
		add(tf, BorderLayout.SOUTH);

		// JTextField에 ActionEvent등록(엔터 치면 발생)
		tf.addActionListener(this);

		setTitle("채팅 클라이언트");
		setSize(500, 500);
		setVisible(true);

	}

	public static void main(String[] args) {
		new ChatClient().connect();

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
				if (sc == null)
					return;

				// 서버에게 정보를 전송
				PrintWriter pw = new PrintWriter(sc.getOutputStream(), true);
				pw.println(user + s);

				ta.append("보냄]" + s + "\n");
				tf.setText("");
				tf.requestFocus();

			} catch (Exception e) {
				// 서버가 죽은 경우
				ta.append("서버가 죽었음...\n");
				sc = null;
			}
		}

	}

	@Override
	public void run() {
		// 서버가 전송한 채팅 문자열을 받는다.

		try {
			String s;
			if (sc == null)
				return;

			// 서버의 정보를 받기 위한 입력 스트림
			BufferedReader br = new BufferedReader(new InputStreamReader(
					sc.getInputStream()));

			while ((s = br.readLine()) != null) {
				ta.append(s + "\n");
			}

		} catch (Exception e) {
			// 서버가 죽으면 예외가 발생
			ta.append("서버가 황천길로...\n");
			sc = null;
		}
	}

	public void connect() {
		try {
			// 서버에 연결
			sc = new Socket(host, port);
			ta.setText("서버에 접속...\n");

			Thread th = new Thread(this);
			th.start();

		} catch (Exception e) {
			sc = null;
			ta.append("서버가 돌아가셨습니다. \n");
		}
	}

}
