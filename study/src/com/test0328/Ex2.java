package com.test0328;

import java.util.Scanner;

/*-컴퓨터와 가위바위보 게임 프로그램 작성

random 또는 math.random()이용

선택(1.가위, 2. 바위, 3. 보)? 1
당신이 이겼습니다.
*/

public class Ex2 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int com, n;
		
		com=(int)Math.random()*3; //rnd.nextInt(3)+1;
		
		System.out.println("선택(1.가위, 2. 바위, 3. 보)?");
		n=sc.nextInt();
		
		
		if(com == n){
			System.out.println("당신이 비겼습니다.");
		}else if(com > 1 && n== 3){
			
		}
	

	}

}
