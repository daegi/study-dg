
//�����带 ��ӹ޾Ƽ� �������� 

package com.thread;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThreadTimerTest extends JFrame{

	//������ �ۼ� ��
	public ThreadTimerTest(){
		this.setTitle("Ÿ�̸�"); //Ÿ��Ʋ(â�� ����) 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Ŭ�ο��� �ȴ�. 
		Container c = getContentPane(); 
		c.setLayout(new FlowLayout());//��� ��ġ�� �Ұų�
		
		JLabel timerLabel = new JLabel(); 
		timerLabel.setFont(new Font("Gothic",Font.ITALIC,80));//�۾�
		
		TimerThread th=new TimerThread(timerLabel);//�Ǵٸ� ������
		
		c.add(timerLabel); //�信 ��������. 
		this.setSize(300, 150);//������ ����(â)
		this.setVisible(true);
		
		th.start();	//����
		
	}
	
	public static void main(String[]args){
		new ThreadTimerTest(); //��ü���� 
		
	}
}
