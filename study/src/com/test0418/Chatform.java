package com.test0418;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// ActionEvent : ��ư, �޴�������, �ؽ�Ʈ�ʵ忡�� ����
// ����Ʈ���� �׸����Ŭ���ϸ� �߻�
// ActionListener : ActionEvent�� ó���ϴ� �̺�Ʈ

public class Chatform extends JFrame implements ActionListener{
	private JTextArea ta = new JTextArea();
	private JButton btn = new JButton("������");
	private JTextField tf = new JTextField(50);

	public Chatform() {
		// x��ư���� ���α׷� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// JFrame�� �⺻������ ���������߾�
		// 5���� ������Ʈ�� ���� ����(BorderLayout)
		add(new JScrollPane(ta), BorderLayout.CENTER);
		
		//��ư �� �ؽ�Ʈ �ʵ忡 actionEvent ���
		btn.addActionListener(this);
		tf.addActionListener(this);
		

		JPanel p = new JPanel(); // �ϳ��̻��� ������Ʈ�� ����
		p.setLayout(new FlowLayout()); //���������� ����
		p.add(tf);
		p.add(btn);
		add(p, BorderLayout.SOUTH);

		setTitle("ä��");
		setSize(700, 500);
		setVisible(true);

	}

	public static void main(String[] args) {
		new Chatform();
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		//getSource():�̺�Ʈ�� �߻� ��Ų ������Ʈ
		if(evt.getSource()== btn || evt.getSource()==tf){
			String s= tf.getText().trim();
			if(s.length()==0)
				return;
			
			ta.append(s+"\n");
			tf.setText("");
			tf.requestFocus();
			
		}
		
	}

}
