package com.mouse0516;

public class RFMouse extends Mouse implements IRF {
	
		
	public void move() {
		System.out.println("������");		
	}

	public void scroll() {
		System.out.println("��ũ�� ����");
		
	}

	public void wconnect() {
		System.out.println("��������");
		
	}

	public void wdisconnect() {
		System.out.println("�������� ����");
		
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
