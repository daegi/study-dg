package ch6;

import java.util.Scanner;

public class Test7 {

	public static void main(String[] args) {
		
		Ex7 x= new Ex7();
		
		try{
		x.input();
		int n=x.getValue();
		System.out.println(n);
		}catch(Exception e){
			System.out.println(e.toString());
		}

	}

}
class Ex7{
	private int value;
	private Scanner sc=new Scanner(System.in); 
	
	public void setValue(int value) throws Exception{
		if(value<0)
			throw new Exception("값 0 보다 적을수 없어");
		this.value=value;
	}
	public int getValue(){
		return value;
	}
	public void input() throws Exception{
		int n;
		try{
			System.out.print("정수?");
			n=sc.nextInt();
			setValue(n);
		}catch(Exception e){
			throw e;
		}
	}
}
