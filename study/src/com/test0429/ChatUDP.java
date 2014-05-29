package com.test0429;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 UDP : �񿬰�(TCP ���� ����. ��Ȯ�� ������ ������ ���� ���� ����)
 DatagramSocket: UDP���� ��Ŷ�� �����ϰų� ����
 DatagramPacket:UDP�� ���۵Ǵ� ������
 MulticastSocket:�ټ��� Ŭ���̾�Ʈ�� ������ �׷��� ����

 �׷�����: D class(224.0.0.0~239.255.255.255)

 */

public class ChatUDP extends JFrame implements ActionListener, Runnable {
	private static final long serialVersionUID = 1L;

	private JTextArea ta = new JTextArea();
	private JTextField tf = new JTextField();

	private MulticastSocket ms;
	private InetAddress group;
	private String host = "230.0.0.1";
	private int port = 5555;
	private String userName = "�Ƹ���";

	public ChatUDP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(new JScrollPane(ta), BorderLayout.CENTER);
		add(tf, BorderLayout.SOUTH);

		// JTextField�� ActionEvent ���(���� ġ�� �߻�)
		tf.addActionListener(this);

		setTitle("ä��");
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ChatUDP().setup();
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
				byte[] b = (userName + "] " + s).getBytes();
				DatagramPacket p = new DatagramPacket(b, b.length, group, port);
				// ����
				ms.send(p);

				// ta.append("����]"+s+"\n");
				tf.setText("");
				tf.requestFocus();
			} catch (Exception e) {
			}
		}
	}

	@Override
	public void run() {
		if (ms == null)
			return;

		try {
			while (true) {
				byte b[] = new byte[256];

				// ���۹��� ��Ŷ
				DatagramPacket p = new DatagramPacket(b, b.length);
				// ���� ����
				ms.receive(p);

				String s = new String(p.getData()).trim();
				ta.append(s + "\n");

				ta.setCaretPosition(ta.getDocument().getLength());
			}
		} catch (Exception e) {
			disConn();
		}

	}

	public void setup() {
		try {
			group = InetAddress.getByName(host);
			ms = new MulticastSocket(port);
			// Ư�� �׷쿡 ����
			ms.joinGroup(group);

			Thread th = new Thread(this);
			th.start();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void disConn() {
		try {
			ms.leaveGroup(group); // �׷쿡�� ���� ����
			ms.close();
			ms = null;
		} catch (Exception e) {
		}
	}

}
