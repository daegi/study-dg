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
	private String user = "������]";

	public ChatClient() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(new JScrollPane(ta), BorderLayout.CENTER);
		add(tf, BorderLayout.SOUTH);

		// JTextField�� ActionEvent���(���� ġ�� �߻�)
		tf.addActionListener(this);

		setTitle("ä�� Ŭ���̾�Ʈ");
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

				// ä�� ���ڿ� ����
				if (sc == null)
					return;

				// �������� ������ ����
				PrintWriter pw = new PrintWriter(sc.getOutputStream(), true);
				pw.println(user + s);

				ta.append("����]" + s + "\n");
				tf.setText("");
				tf.requestFocus();

			} catch (Exception e) {
				// ������ ���� ���
				ta.append("������ �׾���...\n");
				sc = null;
			}
		}

	}

	@Override
	public void run() {
		// ������ ������ ä�� ���ڿ��� �޴´�.

		try {
			String s;
			if (sc == null)
				return;

			// ������ ������ �ޱ� ���� �Է� ��Ʈ��
			BufferedReader br = new BufferedReader(new InputStreamReader(
					sc.getInputStream()));

			while ((s = br.readLine()) != null) {
				ta.append(s + "\n");
			}

		} catch (Exception e) {
			// ������ ������ ���ܰ� �߻�
			ta.append("������ Ȳõ���...\n");
			sc = null;
		}
	}

	public void connect() {
		try {
			// ������ ����
			sc = new Socket(host, port);
			ta.setText("������ ����...\n");

			Thread th = new Thread(this);
			th.start();

		} catch (Exception e) {
			sc = null;
			ta.append("������ ���ư��̽��ϴ�. \n");
		}
	}

}
