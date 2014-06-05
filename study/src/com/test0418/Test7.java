package com.test0418;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Test7 extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private JButton btn[]=new JButton[16];

	public Test7() {
		// BorderLayout를 GridLayout로 변경
		setLayout(new GridLayout(4,4));
		
		for(int i=0; i<btn.length; i++) {
			btn[i]=new JButton("눌러 : "+i);
			btn[i].addActionListener(this);
			add(btn[i]);
		}
		
		setTitle("테스트");
		setSize(500, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Test7();
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource()==btn[0]) {
			JOptionPane.showMessageDialog(null, "확인...");
			
		} else if(evt.getSource()==btn[1]) {
			JOptionPane.showMessageDialog(this, "음 확인...",
					"알림", JOptionPane.INFORMATION_MESSAGE);
			
		} else if (evt.getSource()==btn[2]) {
			int n=JOptionPane.showConfirmDialog(this,
					"할래?", "물어봄", JOptionPane.YES_NO_OPTION);
			
			if(n==JOptionPane.OK_OPTION) {
				JOptionPane.showMessageDialog(this, "예...");
			} else {
				JOptionPane.showMessageDialog(this, "아니오...");
			}
		}else if(evt.getSource()==btn[3]) {
			String s;
			s=JOptionPane.showInputDialog("입력");
			JOptionPane.showMessageDialog(this, s);
		}
		
		
	}
}
