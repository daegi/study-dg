package com.test0418;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

//WindowListener : ������ �̺�Ʈ�� ó���ϴ� �������̽�
public class Test3 extends Frame implements WindowListener{
	private static final long serialVersionUID = 1L;
	public Test3(){
		//�����ӿ� ������ �̺�Ʈ ���
		addWindowListener(this);
		
		setTitle("����");
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
		JOptionPane.showMessageDialog(this, "�߰�");
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
