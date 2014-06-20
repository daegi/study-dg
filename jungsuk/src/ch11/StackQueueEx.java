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
			System.out.println(st.pop()); //���� ������ ���� �����ϰ� �� ��ü�� ���� ������??????
		}
		
		System.out.println("=Queue=");
		while(!q.isEmpty()){ //isEmpty ��Ұ� ������ true �� �� �����ش�.
			System.out.println(q.poll()); //ť�� �Ǿպκ� ���� �������� ���� ���̸� �ΰ� ������
		}

	}

}
