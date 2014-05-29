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
 UDP : 비연결(TCP 보다 빠름. 정확한 데이터 전송을 보장 받지 못함)
 DatagramSocket: UDP에서 패킷을 전송하거나 수신
 DatagramPacket:UDP로 전송되는 데이터
 MulticastSocket:다수의 클라이언트에 데이터 그램을 전송

 그룹지정: D class(224.0.0.0~239.255.255.255)

 */

public class ChatUDP extends JFrame implements ActionListener, Runnable {
	private static final long serialVersionUID = 1L;

	private JTextArea ta = new JTextArea();
	private JTextField tf = new JTextField();

	private MulticastSocket ms;
	private InetAddress group;
	private String host = "230.0.0.1";
	private int port = 5555;
	private String userName = "아몰라";

	public ChatUDP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(new JScrollPane(ta), BorderLayout.CENTER);
		add(tf, BorderLayout.SOUTH);

		// JTextField에 ActionEvent 등록(엔터 치면 발생)
		tf.addActionListener(this);

		setTitle("채팅");
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

				// 채팅 문자열 전송
				byte[] b = (userName + "] " + s).getBytes();
				DatagramPacket p = new DatagramPacket(b, b.length, group, port);
				// 전송
				ms.send(p);

				// ta.append("보냄]"+s+"\n");
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

				// 전송받을 패킷
				DatagramPacket p = new DatagramPacket(b, b.length);
				// 전송 받음
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
			// 특정 그룹에 포함
			ms.joinGroup(group);

			Thread th = new Thread(this);
			th.start();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void disConn() {
		try {
			ms.leaveGroup(group); // 그룹에서 빠져 나옴
			ms.close();
			ms = null;
		} catch (Exception e) {
		}
	}

}
