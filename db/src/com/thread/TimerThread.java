//������ ���� 
package com.thread;

import javax.swing.JLabel; //���� 

public class TimerThread extends Thread{ //Thread ��ӹ��� 
    
	JLabel timerLabel; 
	
	public TimerThread(JLabel timerLabel){//������
		this.timerLabel = timerLabel; 
	}
	
	public void run(){//����
		int n=0; //�� 
		
		while(true){
			timerLabel.setText(Integer.toString(n));//���ڿ��� �ްڴ�
			n++; //���������� 
			 
			try {
				Thread.sleep(1000);//����ó�� ���־�� ��//1�ʾ� ���ڴ�. //static�� �׳� ȣ�� ����
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				return; //���ϰ� ��ȯ
			} 
		}
	}
}



