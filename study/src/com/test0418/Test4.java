package com.test0418;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test4 extends Frame{
	public Test4(){
		//������ �̺�Ʈ ���
		addWindowListener(new WindowHandler());
		
		setTitle("����");
		setSize(400,400);
		setVisible(true);
	}
	
	//��øŬ����
	//WindowAdapater : WindowListener Ŭ������ ������ Ŭ����
	//�ʿ��� �̺�Ʈ(�޼ҵ�)�� ������ �Ѵ�.
	class WindowHandler extends WindowAdapter{

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
				
	}
	//main�� ���α׷��� ���������� �������� �ƴϴ�.
	//���α׷��� ����Ǳ� ���ؼ��� ��� �����尡 ����Ǿ���Ѵ�.
	public static void main(String[] args) {
		new Test4();
	}
}
