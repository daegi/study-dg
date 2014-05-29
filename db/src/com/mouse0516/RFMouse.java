package com.mouse0516;

public class RFMouse extends Mouse implements IRF {
	
		
	public void move() {
		System.out.println("움직임");		
	}

	public void scroll() {
		System.out.println("스크롤 동작");
		
	}

	public void wconnect() {
		System.out.println("무선연결");
		
	}

	public void wdisconnect() {
		System.out.println("무선연결 끊김");
		
	}
	
	public static void main(String[] args) {
		
		RFMouse rfm = new RFMouse();
		
		System.out.println(RF_Type_BT);
		rfm.move();
		rfm.scroll();
		rfm.wconnect();
		rfm.wdisconnect();
	}

}
