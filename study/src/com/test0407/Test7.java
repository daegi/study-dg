package com.test0407;

public class Test7 {
	public static void main(String[] args) {
		boolean flag;
		for (int n = 1; n <= 100; n++) {
			flag = false;
			for (String s : new String[] { "3", "6", "9" }) {  
				//��) for(int i : arr) arr�迭�� ��� �ִ� ���� ���ʴ�� ������ ���鼭 i�� ���� 
				if (Integer.toString(n).indexOf(s) != -1) {
					System.out.print("    *");
					flag = true;
					break;
				}
			}

			if (!flag)
				System.out.printf("%5d", n);

			if (n % 10 == 0)
				System.out.println();
		}

	}

}
