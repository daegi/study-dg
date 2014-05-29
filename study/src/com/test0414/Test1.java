package com.test0414;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {

	public static void main(String[] args) {

		String[] data = { "bat", "baby", "bonus", "c", "cA", "ca", "co", "c",
				"c0", "c#", "car", "combat", "count", "date", "disc" };

		String[] p = { "c[a-z]", "c[a-z]*","c[a-z].*" };  //c�� ������ a~z����

		for (int i = 0; i < p.length; i++) {
			Pattern pt = Pattern.compile(p[i]);
			System.out.println(p[i] + "���ϰ��...");
			
			for (int x = 0; x < data.length; x++) {
				Matcher m = pt.matcher(data[x]);
				if (m.matches())
					System.out.println(data[x]);
			}
			System.out.println();

		}

	}
}


/*
 * c[a-z] : c�� �����ϴ� 2������ ����ܾ�(�ҹ���)
 * c[a-z]* : c�� �����ϴ� ����ܾ�(�ҹ���)
 * c[a-z].* : c�� �����ϴ� 2���� �̻��� ����ܾ�(�ҹ���)
 * 
 * c[a-zA-Z]* : c�� �����ϴ� ����ܾ�(��ҹ��ڸ� �������� ����)
 * .* : ��� ����
 * c.*t : c�� �����ϰ� t�� ������ ���ڿ�
 * [b|c].*: b�� c�� �����ϴ� ���ڿ�
 * [^b|c].*: b�� c�� �������� �ʴ� ���ڿ�  
 * .*a.* : a�� �����ϴ� 
 * * : 0�����̻�
 * + : 1�����̻�
 * . : �ѹ��� 
 * 
 *  [b|c].{2} : b�Ǵ� c�� �����ϴ� ���ڸ� ���ڿ�
 *  
 *  
*/
