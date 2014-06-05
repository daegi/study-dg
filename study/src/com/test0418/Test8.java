package com.test0418;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class Test8 extends JFrame implements ActionListener {
	private JTextField tf;
	private JPasswordField pf;
	private JFormattedTextField ftf;
	private JTextArea ta=new JTextArea();
	private JButton btn=new JButton("확인");
	
	public Test8() {
		btn.addActionListener(this);
		add(btn, BorderLayout.SOUTH);
		
		add(ta, BorderLayout.CENTER);
		
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(3,2));
		
		tf=new JTextField(30);
		p.add(new JLabel("아이디:"));
		p.add(tf);
		
		pf=new JPasswordField(30);
		pf.setEchoChar('#');
		p.add(new JLabel("패스워드:"));
		p.add(pf);
		
		try {
			MaskFormatter mf=new MaskFormatter("####-##-##");
			mf.setPlaceholderCharacter('_');
			ftf=new JFormattedTextField(mf);
			p.add(new JLabel("생년월일:"));
			p.add(ftf);
		} catch(Exception  e) {
		}
		
		add(p, BorderLayout.NORTH);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("예제");
		setSize(500, 500);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Test8();
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource()==btn) {
			String i=tf.getText().trim();
			String p=new String(pf.getPassword());
			String n=ftf.getText().trim();
			
			ta.setText("아이디:"+i);  // 기존내용 지우고 설정
			ta.append("\n패스워드:"+p); // 기존내용에 추가
			ta.append("\n생년월일:"+n);
		}
		
	}

}
