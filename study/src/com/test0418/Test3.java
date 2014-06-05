package com.test0418;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

//WindowListener : 윈도우 이벤트를 처리하는 인터페이스
public class Test3 extends Frame implements WindowListener{
	private static final long serialVersionUID = 1L;
	public Test3(){
		//프레임에 윈도우 이벤트 등록
		addWindowListener(this);
		
		setTitle("예제");
		setSize(400,400);
		setVisible(true);

	}
	public static void main(String[] args){
		new Test3();
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		JOptionPane.showMessageDialog(this, "잘가");
		System.exit(0);
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
