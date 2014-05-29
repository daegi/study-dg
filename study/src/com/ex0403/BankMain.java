package com.ex0403;

class Bank {
	
	private int money= 1000;
	
	String name;
	
	public int getMoney(){
		return money;
	}
	public int draw(int m){
		
		if(m>money)
			return -1;
		money -=m;
		
		return m;
	}
	public void saving(int m){
		money+=m;
	}

}

public class BankMain{
	public static void main(String[] args){
		Bank ob1 =new Bank();
		
		ob1.name="홍길동";
		
		ob1.saving(1000);
		int m = ob1.draw(1500);
		if(m==-1){
			System.out.println("인출실패!!");
		}else{
			System.out.println(m+"인출성공");
		}
			System.out.println("남은금액 :"+ob1.getMoney());
		Bank ob2 =new Bank();
		System.out.println("이름 :"+ob2.name);
		System.out.println("남은금액 :"+ob2.getMoney());
		
	}
}
