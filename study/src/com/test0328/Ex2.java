package com.test0328;

import java.util.Scanner;

/*-��ǻ�Ϳ� ���������� ���� ���α׷� �ۼ�

random �Ǵ� math.random()�̿�

����(1.����, 2. ����, 3. ��)? 1
����� �̰���ϴ�.
*/

public class Ex2 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int com, n;
		
		com=(int)Math.random()*3; //rnd.nextInt(3)+1;
		
		System.out.println("����(1.����, 2. ����, 3. ��)?");
		n=sc.nextInt();
		
		
		if(com == n){
			System.out.println("����� �����ϴ�.");
		}else if(com > 1 && n== 3){
			
		}
	

	}

}
