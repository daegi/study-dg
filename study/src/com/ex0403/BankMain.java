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
		
		ob1.name="ȫ�浿";
		
		ob1.saving(1000);
		int m = ob1.draw(1500);
		if(m==-1){
			System.out.println("�������!!");
		}else{
			System.out.println(m+"���⼺��");
		}
			System.out.println("�����ݾ� :"+ob1.getMoney());
		Bank ob2 =new Bank();
		System.out.println("�̸� :"+ob2.name);
		System.out.println("�����ݾ� :"+ob2.getMoney());
		
	}
}
