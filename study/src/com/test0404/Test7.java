package com.test0404;

import java.util.Scanner;

public class Test7 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);

		String ss;

		System.out.println("입력 : ");
		ss = sc.nextLine();
		ss = ss.replaceAll("\\s", ""); // 모든 공백 제거

		int n1, n2;
		//String[] oo=new String[] { "+", "-", "*", "/" }
		for (String s : new String[] { "+", "-", "*", "/" }) {
			int pos = ss.indexOf(s);
			if (pos > 0) {
				n1 = Integer.parseInt(ss.substring(0, pos));
				n2 = Integer.parseInt(ss.substring(pos + 1));

				if (s.equals("+"))
					System.out.println(ss + "=" + (n1 + n2));
				else if (s.equals("-"))
					System.out.println(ss + "=" + (n1 - n2));
				else if (s.equals("*"))
					System.out.println(ss + "=" + (n1 * n2));
				else if (s.equals("/"))
					System.out.println(ss + "=" + (n1 / n2));
				break;

			}
		}

	}

}
