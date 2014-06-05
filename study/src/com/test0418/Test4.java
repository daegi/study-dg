package com.test0418;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test4 extends Frame{
	public Test4(){
		//윈도우 이벤트 등록
		addWindowListener(new WindowHandler());
		
		setTitle("예제");
		setSize(400,400);
		setVisible(true);
	}
	
	//중첩클래스
	//WindowAdapater : WindowListener 클래스를 구현한 클래스
	//필요한 이벤트(메소드)만 재정의 한다.
	class WindowHandler extends WindowAdapter{

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
				
	}
	//main는 프로그램의 시작점이지 종료점은 아니다.
	//프로그램이 종료되기 위해서는 모든 스레드가 종료되어야한다.
	public static void main(String[] args) {
		new Test4();
	}
}
