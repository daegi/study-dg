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
		
		//JTextField�� ActionEvent���(���� ġ�� �߻�)
		tf.addActionListener(this);

		setTitle("ä��");
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
									
				//ä�� ���ڿ� ����
				
				
				
				ta.append("����]"+s+"\n");
				tf.setText("");
				tf.requestFocus();

			} catch (Exception e) {
			}
		}

	}

}
