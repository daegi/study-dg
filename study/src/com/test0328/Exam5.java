package com.test0328;

public class Exam5 {

	public static void main(String[] args) {
		
/*		int i=0;
		int j=0;
		
		for(i; i<=10; i++){
			for(j=0; i<=i; j++)
				System.out.println("*");
				System.out.println();
		}	
	}
}
*/

		// for (초기값 ; 조건문; 증가값)

		int i = 0;
		
		while (i <= 10) { //1. 조건문 줄바꿈에 대한 while문  
			
			int j = 0;   //조건에 맞을 때가지 j값을 초기화
			while (j <= i) { //2. j가 i보다 작거나 같을 때 * 찍음  
				             //i 값이 1일때(첫번째줄) j값 (별갯수 1)
						   	//조건 만족시 1번 while문 실행
				 
				System.out.print("*");
				j++;
			}
			System.out.println(); // 다음줄
			i++; 
		}
	}
}
	
	

