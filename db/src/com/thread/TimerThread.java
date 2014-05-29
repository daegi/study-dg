//쓰레드 정의 
package com.thread;

import javax.swing.JLabel; //스윙 

public class TimerThread extends Thread{ //Thread 상속받음 
    
	JLabel timerLabel; 
	
	public TimerThread(JLabel timerLabel){//생성자
		this.timerLabel = timerLabel; 
	}
	
	public void run(){//실행
		int n=0; //초 
		
		while(true){
			timerLabel.setText(Integer.toString(n));//문자열로 받겠다
			n++; //증감연산자 
			 
			try {
				Thread.sleep(1000);//예외처리 해주어야 함//1초씩 쉬겠다. //static은 그냥 호출 가능
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				return; //리턴값 반환
			} 
		}
	}
}



