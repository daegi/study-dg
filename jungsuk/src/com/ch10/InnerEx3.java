package com.ch10;

public class InnerEx3 {

	private int outerIv = 0;
	static int outerCv = 0;

	class InstanceInner {
		int iiv = outerIv;
		int iiv2 = outerCv;
	}

	static class StaticInner3 {
		static int scv = outerCv;
	}
	
	void myMethod(){
		final int iv = 0;
		final int LV=0;
		
		class LocalInner{
			int liv = outerIv;
			int liv2 = outerCv;
			
			int liv3 = iv;
			int liv4 = LV;
		}
	}
	
	
	

}
