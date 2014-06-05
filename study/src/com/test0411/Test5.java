package com.test0411;

//알아둬라
//스태틱중첩클래스
//익명의 중첩클래스

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
		
		setTitle("윈도우 프로그램...");
		setSize(500,500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Test5();

	}

}
