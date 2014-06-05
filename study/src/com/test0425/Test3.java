package com.test0425;

import java.awt.BorderLayout;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Test3 extends JFrame implements Runnable{
	private JLabel lbl= new JLabel("",JLabel.CENTER);

	public Test3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(lbl, BorderLayout.CENTER);
		
		Calendar cal = Calendar.getInstance();
		String s= String.format("%tF%tT", cal, cal);
		lbl.setText(s);

		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Thread(new Test3()).start();

	}

	@Override
	public void run() {
		while(true){	
		try {
			Calendar cal = Calendar.getInstance();
			String s= String.format("%tF%tT", cal, cal);
			lbl.setText(s);
			Thread.sleep(1000);
			
		} catch (Exception e) {
		}
		}
	}
}
