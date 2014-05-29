package com.ex0403;

public class Make369 {

	public static void main(String[] args) {

		int len, temp;
		boolean flag;
		for (int n = 1; n <= 100; n++) {

			temp = n;
			len = 1;
			while (temp >= 10) {
				temp = temp / 10;
				len++;
			}
			
			flag=false;
			temp=n;
			
			for(int i=1; i<=len; i++){
				if(temp%10!=0 &&(temp%10)%3==0){
					System.out.print("   *");
					flag=true;
					break;
				}
				temp=temp/10;
			}
			if(! flag)
				System.out.printf("%5d", n); //참이면 n값
			if(n%10==0)
				System.out.println();  // 10단위 다음줄
			
			
		}

	}

}
