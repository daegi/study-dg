package com.test0328;

public class Test7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a, b;
		
		
		
		a=0;
		b=0;
		
		label:
			
		while(a<10){
			a++;
			System.out.println("a:"+a);
			b= 0;
			while(b<5){
				b++;
				System.out.println("b:"+b);
				
				if(a+b >=7)
					//break;
					break label;
			}
			System.out.println("a:"+a+",b:"+b);
		}

	}

}
