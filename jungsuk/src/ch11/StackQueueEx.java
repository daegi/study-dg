package ch11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueEx {

	public static void main(String[] args) {
		Stack st = new Stack();
		Queue q = new LinkedList();

		st.push("0");
		st.push("1");
		st.push("2");

		q.offer("0");
		q.offer("1");
		q.offer("2");
		
		System.out.println("=Stack=");
		while(!st.empty()){
			System.out.println(st.pop()); //스택 선두의 값을 삭제하고 그 객체의 값을 가저옴??????
		}
		
		System.out.println("=Queue=");
		while(!q.isEmpty()){ //isEmpty 요소가 없으면 true 값 을 돌려준다.
			System.out.println(q.poll()); //큐의 맨앞부분 값을 가저오고 삭제 널이면 널값 가저옴
		}

	}

}
