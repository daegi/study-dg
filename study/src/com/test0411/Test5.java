package com.test0411;

//�˾Ƶֶ�
//����ƽ��øŬ����
//�͸��� ��øŬ����

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test5 extends Frame{
	public Test5(){
		
		setBackground(Color.YELLOW);
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
		setTitle("������ ���α׷�...");
		setSize(500,500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Test5();

	}

}
