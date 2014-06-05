package com.test0428;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JTextArea ta = new JTextArea();
	private JTextField tf = new JTextField();

	public ChatFrame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(new JScrollPane(ta), BorderLayout.CENTER);
		add(tf, BorderLayout.SOUTH);
		
		//JTextField에 ActionEvent등록(엔터 치면 발생)
		tf.addActionListener(this);

		setTitle("채팅");
		setSize(500, 500);
		setVisible(true);

	}

	public static void main(String[] args) {
		new ChatFrame();

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == tf) {
			try {
				String s = tf.getText().trim();
				
				if(s.length()==0){
					tf.requestFocus();
					return;
				}
									
				//채팅 문자열 전송
				
				
				
				ta.append("보냄]"+s+"\n");
				tf.setText("");
				tf.requestFocus();

			} catch (Exception e) {
			}
		}

	}

}
