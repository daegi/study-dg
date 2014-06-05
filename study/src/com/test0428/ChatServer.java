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
	private String user = "����]";

	public ChatServer() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(new JScrollPane(ta), BorderLayout.CENTER);
		add(tf, BorderLayout.SOUTH);

		// JTextField�� ActionEvent���(���� ġ�� �߻�)
		tf.addActionListener(this);

		setTitle("ä�� ����");
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

				// ä�� ���ڿ� ����
				if (sc == null) // Ŭ���̾�Ʈ ������ ���� ���
					return;

				// Ŭ���̾�Ʈ���� ���� ��� ��Ʈ��
				PrintWriter pw = new PrintWriter(sc.getOutputStream(), true);
				// ���۳����� �ٷ�����

				// Ŭ���̾�Ʈ���� ���ڿ� ����
				pw.println(user + s);

				ta.append("����]" + s + "\n");
				tf.setText("");
				tf.requestFocus();

			} catch (Exception e) {
				ta.append("Ŭ���̾�Ʈ�� ������. \n");
				sc = null;
			}
		}

	}

	@Override
	public void run() {
		String ip = null;

		try {
			if (sc == null) // Ŭ���̾�Ʈ�� ������� ���� ���
				return;

			// ������ Ŭ���̾�Ʈ�� ip�ּ� ���ϱ�
			ip = sc.getInetAddress().getHostAddress();
			ta.append(ip + "���� ����... \n");

			// ������ Ŭ���̾�Ʈ�� ������ �ޱ� ���� �Է� ��Ʈ��

			BufferedReader br = new BufferedReader(new InputStreamReader(
					sc.getInputStream()));

			String s;
			while ((s = br.readLine()) != null) {
				ta.append(s + "\n");
			}

		} catch (Exception e) {
			// Ŭ���̾�Ʈ�� ������ �����ϸ� IOException�� �߻�
			String s = ip + "���� ��������";
			ta.append(s + "\n");
			sc = null;
		}

	}

	public void serverStart() {
		try {
			// Ŭ���̾�Ʈ���� ������ ���� ���� ������ ��ü����(��Ʈ)
			ss = new ServerSocket(port);

			ta.setText("���� ����... \n");

			// Ŭ���̾�Ʈ�� ������ ��ٸ���(blocking ����)
			sc = ss.accept(); // ���ӵ� Ŭ���̾�Ʈ�� ����� ���� ����

			// Ŭ���̾�Ʈ�� ���� �� ��� Ŭ���̾�Ʈ ������ �ޱ� ���� ���������
			Thread t = new Thread(this);
			t.start();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
