package com.ex0403;

class Rect {
	
	int width, height;
	
	public void setData(int w, int h){
		width =w;
		height =h;
	}
	
	public int area(){
		return width *height;
	}
	
	public int length(){
		return (width +height)*2;
	}
}


public class Test1{
	public static void main(String[] args){
		Rect ob1 = new Rect();
		Rect ob2 = new Rect();
		
		int a, b;
		
		ob1.setData(10,5);
		ob2.setData(50, 60);
		
		a=ob1.area(); // 10*5
		b=ob1.length(); // 10+5*2
		System.out.printf("가로 : %d, 세로 : %d, 넓이 : %d, 둘레 : %d\n",
				ob1.width, ob1.height, a, b);
		
		
		a=ob2.area();
		b=ob2.length();
		System.out.printf("가로 : %d, 세로 : %d, 넓이 : %d, 둘레 : %d\n",
				ob2.width, ob2.height, a, b);
		
		
	}

}