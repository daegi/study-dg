package com.test0410;

public class Test1 {
	public static void main(String[] args) {
		Ex1 ob=new Ex1();
		
		int s;
		char c;
		
		c=ob.upper('x');
		System.out.println(c);
		
		s=ob.sum(1, 20);
		System.out.println(s);
		ob.trangle(7);

		ob.gugudan(7);
		
		int []nn={2,4,6,8,10};
		s=ob.sum(nn);
		System.out.println(s);
		
	}
}

class Ex1 {
	
	// 1~n���� �� ���ϱ�(sum)
	public int sum(int n) {
		int s=0;
		for(int i=1; i<=n; i++)
			s+=i;
		return s;
	}
	
	// n�� ¦���̸� true Ȧ�� �̸� false(isEven)
	public boolean isUpisEven(int n) {
		return n%2==0;
	}
	
	// ���ڰ� �ҹ����̸� �빮�ڷ� ��ȯ(upper)
	public char upper(char c) {
		return c>='a'&&c<='z'?(char)(c-32):c;
	}
	// c�� �빮���̸� true �׷��� ������ false(isUpper)
	public boolean isUpper(char c) {
		return c>='A'&&c<='Z';
	}
	// �μ�(a, b) �� ���������� ū��������(sum(int a, int b))
	public int sum(int a, int b) {
		int t;
		if(a>b) {
			t=a;a=b;b=t;
		}
		int s=0;
		for(int i=a;i<=b;i++) 
			s+=i;
		return s;
	}
	
	// ������ ���ڷ� �޾� �ﰢ�� �����(trangle)
	public void trangle(int n) {
		for(int i=1; i<=n; i++) {
			// ����
			for(int j=1; j<=n-i; j++)
				System.out.print(" ");
			
			for(int j=1; j<=i*2-1; j++)
				System.out.print("*");
			System.out.println();
		}
	}
	
	// ������ ���� ����(95~100:4.5, 90~94:4.0.... 0.0) : grade(int n)
	public double grade(int n) {
		double s;
		if(n>=95) s=4.5;
		else if(n>=90) s=4.0;
		else if(n>=85) s=3.5;
		else if(n>=80) s=3.0;
		else if(n>=75) s=2.5;
		else if(n>=70) s=2.0;
		else if(n>=65) s=1.5;
		else if(n>=60) s=1.0;
		else s=0.0;
		return s;
	}
	
	// ������ ���� ����(����̾簡) : hak(int n)(switch~case)
	public String hak(int n) {
		String s;
		switch(n/10) {
		case 10:
		case 9:s="��";break;
		case 8:s="��";break;
		case 7:s="��";break;
		case 6:s="��";break;
		default:s="��";break;
		}
		return s;
	}
	
	// n���� �������� ���: void gugudan(int n)
	// �� n�� 1~9�� �ƴϸ� �ƹ��͵� ������� �ʴ´�.
	public void gugudan(int n) {
		if(n<1 || n>9)
			return;
		
		for(int i=1; i<=9; i++)
			System.out.println(n+"*"+i+"="+(n*i));
	}
	
	// �⵵�� �������� ������� �Ǻ� : boolean isLeap(int y)
	// �⵵�� 4�� ����̰� 100�� ����� �ƴϰų� 400�� ����̸�
	public boolean isLeap(int y) {
		return y%4==0&&y%100!=0||y%400==0;
	}
	
	// ���ڷ� �Ѿ�� ������ �迭�� �� ���ϱ�
	public int sum(int[] num) {
		int s=0;
		
/*		for(int n : num)
			s+=n;
*/
		for(int i=0; i<num.length; i++)
			s+=num[i];
		
		return s;
	}

}
