package com.test0414;

import java.util.Scanner;

//�μ� ? 10 5
//������ ? +
//10=5=15

//-�μ� �Է��� �߸��� ��� ���� ó���� �̿��Ͽ�
// ���ڸ� ��Ȯ�� �Է� �ϼ��� �޽����� ����ϰ� ���α׷�
// ����

//-�����ڰ� +,-,*,/�� �ƴѰ�� ���� �����Դϴ�.
//��� ���ܰ� ��� �ǵ��� ���ܸ� ������

//- ���������� ������ ���� 0�ΰ�� 0���� ������ �����ϴ�.
// �޽����� �������� ���ܸ� ������

public class Test12 {

	public static void main(String[] args) {
		
		Calculate cc= new Calculate();
		
		cc.input();

	}

}

class Calculate {
	private int num1, num2;
	private char oper;
	private Scanner sc = new Scanner(System.in);

	public void input() {
		try {

			System.out.print("�μ� : ");
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			System.out.println("������ :");
			oper = sc.next().charAt(0);

			int s = calc();
			System.out.printf("%d %c %d% = %d %n", num1, oper, num2, s);

		} catch (Exception e) {
			System.out.println(e.toString());

		}

	}

	public int calc()throws Exception{
		int s=0;
		
		
		if(oper=='+')
			s=num1+num2;
		else if(oper=='-')
			s=num1-num2;
		else if(oper=='*')
			s=num1*num2;
		else if(oper=='/'){
			s=num1/num2;
				if(num2==0)
					throw new Exception("0���� ������ ����");
				s=num1/num2;
		}else{
				throw new Exception("������ ���� �Դϴ�.");
			}
		
		return s;
	}
}
