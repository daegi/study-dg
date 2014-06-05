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
		// BorderLayout�� GridLayout�� ����
		setLayout(new GridLayout(4,4));
		
		for(int i=0; i<btn.length; i++) {
			btn[i]=new JButton("���� : "+i);
			btn[i].addActionListener(this);
			add(btn[i]);
		}
		
		setTitle("�׽�Ʈ");
		setSize(500, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Test7();
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource()==btn[0]) {
			JOptionPane.showMessageDialog(null, "Ȯ��...");
			
		} else if(evt.getSource()==btn[1]) {
			JOptionPane.showMessageDialog(this, "�� Ȯ��...",
					"�˸�", JOptionPane.INFORMATION_MESSAGE);
			
		} else if (evt.getSource()==btn[2]) {
			int n=JOptionPane.showConfirmDialog(this,
					"�ҷ�?", "���", JOptionPane.YES_NO_OPTION);
			
			if(n==JOptionPane.OK_OPTION) {
				JOptionPane.showMessageDialog(this, "��...");
			} else {
				JOptionPane.showMessageDialog(this, "�ƴϿ�...");
			}
		}else if(evt.getSource()==btn[3]) {
			String s;
			s=JOptionPane.showInputDialog("�Է�");
			JOptionPane.showMessageDialog(this, s);
		}
		
		
	}
}
