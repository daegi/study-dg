package ch11;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListEx1 {

	public static void main(String[] args) {
		ArrayList list1 = new ArrayList();

		list1.add(new Integer(5));
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));
		
		// sublist list1의 지정 범위(인덱스1~3)의 값을 인스턴스변수 list2 에 가져감
		ArrayList list2 = new ArrayList(list1.subList(1, 4));

		print(list1, list2);
		
		
		
		Collections.sort(list1);
		Collections.sort(list2);
		print(list1, list2);
		
		// list1 과 list2 와 값을 비교하여 list2에 요소가 한개라도 있으면 true 값 반환
		System.out.println("list1.containsAll(list2):" + list1.containsAll(list2));

		list2.add("b");
		list2.add("c");
		list2.add(3, "a");
		print(list1, list2);

		list2.set(3, "aa");
		print(list1, list2);
		
		// list1 에서 list2와 겹치는 부분만 남기고 삭제
		System.out.println("list1.retainAll(list2)" + list1.retainAll(list2));
		print(list1, list2);
		
		
		//  for(초기값=4; 초기값이 0보다 작거나 같을때까지; 초기값 감소) 총5번 반복수행
		for (int i = list2.size() - 1; i >= 0; i--) {
			// 만약 list1에 있는 값이 list2에 있으면 인덱스에 들어있는 값 삭제
			if (list1.contains(list2.get(i)))
				list2.remove(i);
		}
		print(list1, list2);
	}

	static void print(ArrayList list1, ArrayList list2) {
		System.out.println("list1:" + list1);
		System.out.println("list2:" + list2);
		System.out.println();
	}

}
