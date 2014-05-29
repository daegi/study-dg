package com.ch11;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;

public class QueueEx1 {
	static Queue q = new LinkedList();
	static final int MAX_SIZE = 5; //

	public static void main(String[] args) {
		System.out.println("help를 입력하면 도움말을 볼수 있습니다.");
		
		//무한루프
		while (true) {
			System.out.print(">>");
			try {
				Scanner sc = new Scanner(System.in);
				String input = sc.nextLine().trim();

				if ("".equals(input))
					continue;

				if (input.equalsIgnoreCase("q")) {// equalsIgnoreCase 대소문자 상관없이
													// 비교
					System.exit(0);
				} else if (input.equalsIgnoreCase("help")) {
					System.out.println("help - 도움말을 보여줌");
					System.out.println("q 또는 Q - 프로그램을 종료함");
					System.out.println("history - 최근에 입력한 명령어들 " + MAX_SIZE
							+ "개 보여줌");
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
				System.out.println("입력오류입니다.");
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
