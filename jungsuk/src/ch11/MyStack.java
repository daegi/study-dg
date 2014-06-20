package ch11;

import java.util.EmptyStackException;
import java.util.Vector;

public class MyStack extends Vector {

	public Object push(Object item) {
		addElement(item); // add 메소드는 리턴값이 있고, addElement 메소드는 return 값이 없다.
		return item;
	}

	public Object pop() {
		Object obj = peek(); // 스택에 저장된 마지막 요소를 읽어온다.
		removeElementAt(size() - 1); // 마지막 요소를 삭제한다
		return obj;
	}

	public Object peek() {
		int len = size();

		if (len == 0) // 만일 스택이 비어있으면 peek()메서드가 예외 처리를 발생시킨다.
			throw new EmptyStackException();
		return elementAt(len - 1); // 마지막 요소를 반환한다.
	}

	public boolean empty() {
		return size() == 0;
	}

	public int search(Object o) {
		int i = lastIndexOf(o);	//끝에서부터 객체를 찾는다.
		//반환값은 저장딘 위치 (배열의 index)이다.
		if (i >= 0) {	//객체를 찾은 경우
			return size() - 1;	
		}
		return -1; 
	}

}
