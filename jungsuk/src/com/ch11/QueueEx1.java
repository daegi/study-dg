package com.ch11;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;

public class QueueEx1 {
	static Queue q = new LinkedList();
	static final int MAX_SIZE = 5; //

	public static void main(String[] args) {
		System.out.println("help�� �Է��ϸ� ������ ���� �ֽ��ϴ�.");
		
		//���ѷ���
		while (true) {
			System.out.print(">>");
			try {
				Scanner sc = new Scanner(System.in);
				String input = sc.nextLine().trim();

				if ("".equals(input))
					continue;

				if (input.equalsIgnoreCase("q")) {// equalsIgnoreCase ��ҹ��� �������
													// ��
					System.exit(0);
				} else if (input.equalsIgnoreCase("help")) {
					System.out.println("help - ������ ������");
					System.out.println("q �Ǵ� Q - ���α׷��� ������");
					System.out.println("history - �ֱٿ� �Է��� ��ɾ�� " + MAX_SIZE
							+ "�� ������");
				} else if (input.equalsIgnoreCase("history")) {
					int i = 0;

					save(input);

					LinkedList tmp = (LinkedList) q;
					ListIterator it = tmp.listIterator();

					while (it.hasNext()) {
						System.out.println(++i + "." + it.next());
					}
				} else {
					save(input);
					System.out.println(input);
				}

			} catch (Exception e) {
				System.out.println("�Է¿����Դϴ�.");
			}
		}
	}

	public static void save(String input) {
		if (!"".equals(input))
			q.offer(input);

		if (((LinkedList) q).size() > MAX_SIZE)
			q.remove();

	}

}
