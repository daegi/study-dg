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

		// for (�ʱⰪ ; ���ǹ�; ������)

		int i = 0;
		
		while (i <= 10) { //1. ���ǹ� �ٹٲ޿� ���� while��  
			
			int j = 0;   //���ǿ� ���� ������ j���� �ʱ�ȭ
			while (j <= i) { //2. j�� i���� �۰ų� ���� �� * ����  
				             //i ���� 1�϶�(ù��°��) j�� (������ 1)
						   	//���� ������ 1�� while�� ����
				 
				System.out.print("*");
				j++;
			}
			System.out.println(); // ������
			i++; 
		}
	}
}
	
	

