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

// ActionEvent : 버튼, 메뉴아이템, 텍스트필드에서 엔터
// 리스트에서 항목더블클릭하면 발생
// ActionListener : ActionEvent를 처리하는 이벤트

public class Chatform extends JFrame implements ActionListener{
	private JTextArea ta = new JTextArea();
	private JButton btn = new JButton("보내기");
	private JTextField tf = new JTextField(50);

	public Chatform() {
		// x버튼으로 프로그램 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// JFrame는 기본적으로 동서남북중앙
		// 5개의 컴포넌트만 부착 가능(BorderLayout)
		add(new JScrollPane(ta), BorderLayout.CENTER);
		
		//버튼 및 텍스트 필드에 actionEvent 등록
		btn.addActionListener(this);
		tf.addActionListener(this);
		

		JPanel p = new JPanel(); // 하나이상의 컴포넌트를 결합
		p.setLayout(new FlowLayout()); //일직선으로 부착
		p.add(tf);
		p.add(btn);
		add(p, BorderLayout.SOUTH);

		setTitle("채팅");
		setSize(700, 500);
		setVisible(true);

	}

	public static void main(String[] args) {
		new Chatform();
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		//getSource():이벤트를 발생 시킨 컴포넌트
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
