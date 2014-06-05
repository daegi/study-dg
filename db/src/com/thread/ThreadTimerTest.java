
//쓰레드를 상속받아서 스윙실현 

package com.thread;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThreadTimerTest extends JFrame{

	//생성자 작성 중
	public ThreadTimerTest(){
		this.setTitle("타이머"); //타이틀(창의 제목) 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //클로우즈 된다. 
		Container c = getContentPane(); 
		c.setLayout(new FlowLayout());//어떻게 배치를 할거냐
		
		JLabel timerLabel = new JLabel(); 
		timerLabel.setFont(new Font("Gothic",Font.ITALIC,80));//글씨
		
		TimerThread th=new TimerThread(timerLabel);//또다른 생성장
		
		c.add(timerLabel); //뷰에 보여진다. 
		this.setSize(300, 150);//사이즈 지정(창)
		this.setVisible(true);
		
		th.start();	//구동
		
	}
	
	public static void main(String[]args){
		new ThreadTimerTest(); //객체생성 
		
	}
}
