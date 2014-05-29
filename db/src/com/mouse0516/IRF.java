package com.mouse0516;

public interface IRF {
	
	String RF_Type_BT = "블루투스";
	String RF_Type_IR = "적외선";
	
	public void wconnect();
	public void wdisconnect();

}
