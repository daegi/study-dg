package com.test0328;

public class Test6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n, s;
		
		n=s=0;
/*		
		//continue : while, do~ while, for
		while(n<=100){
			n++;
			if(n%2 ==1)
				continue; // �Ʒ� �κ��� ���� ���� �ʰ� �ٽ� ��������
			s+=n;
		}
		System.out.println(s);
*/
		while(true){
			n++;
			s+=n;
			if(n>=10)break; // �ݺ���, switch���� ��������
		}
		System.out.println(s);
	}

}
