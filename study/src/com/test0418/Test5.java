package com.test0418;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test5 extends Frame{
	public Test5(){
		//������ �̺�Ʈ ���(�͸� Ŭ����)
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
		setBackground(Color.GREEN);
		setTitle("����");
		setSize(400,400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Test5();

	}

}
