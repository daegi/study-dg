/*���� ���θ� �Է� �޾� �簢�� ���̿� �ѷ��� ����ϴ�
 * ���α׷��� ����� �̿��Ͽ� �ۼ�
 *
 * �߻�ȭ
 * �ʵ� :���� ����
 * ��� : �Է�, ����(��*��), �ѷ�((��+��)*2), ���
 * 
 * 
 * ���� : ����, ����
 * ��� : ����, �ѷ�
 * 
 * ���� : Scanner
 * ���: �Է�, ���
 * 
 */

package com.test0408;

import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Demo6 ob = new Demo6();
		ob.input();
		int s = ob.calc();
		ob.print(s);

	}

}

class Ex6 {
	protected int num1, num2;
	protected String oper;

	public int calc() {
		if (oper == null)
			return 0;

		int result = 0;
		if (oper.equals("����"))
			result = num1 * num2;
		else if (oper.equals("�ѷ�"))
			result = (num1 * num2) / 2;

		return result;
	}
}

class Demo6 extends Ex6 {

	private Scanner sc = new Scanner(System.in);

	public void input() {
		System.out.print("����?");
		num1 = sc.nextInt();
		System.out.print("����?");
		num2 = sc.nextInt();

		do {
			System.out.print("����? �ѷ�?");
			oper = sc.next();
		} while (!oper.equals("����") && !oper.equals("�ѷ�"));
	}

	public void print(int result) {
		System.out.println(result);

	}

}


















