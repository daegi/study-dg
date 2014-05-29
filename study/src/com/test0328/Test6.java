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
				continue; // 아래 부분을 실행 하지 않고 다시 조건으로
			s+=n;
		}
		System.out.println(s);
*/
		while(true){
			n++;
			s+=n;
			if(n>=10)break; // 반복문, switch문을 빠져나감
		}
		System.out.println(s);
	}

}
