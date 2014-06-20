package ch11;

import java.util.EmptyStackException;
import java.util.Vector;

public class MyStack extends Vector {

	public Object push(Object item) {
		addElement(item); // add �޼ҵ�� ���ϰ��� �ְ�, addElement �޼ҵ�� return ���� ����.
		return item;
	}

	public Object pop() {
		Object obj = peek(); // ���ÿ� ����� ������ ��Ҹ� �о�´�.
		removeElementAt(size() - 1); // ������ ��Ҹ� �����Ѵ�
		return obj;
	}

	public Object peek() {
		int len = size();

		if (len == 0) // ���� ������ ��������� peek()�޼��尡 ���� ó���� �߻���Ų��.
			throw new EmptyStackException();
		return elementAt(len - 1); // ������ ��Ҹ� ��ȯ�Ѵ�.
	}

	public boolean empty() {
		return size() == 0;
	}

	public int search(Object o) {
		int i = lastIndexOf(o);	//���������� ��ü�� ã�´�.
		//��ȯ���� ����� ��ġ (�迭�� index)�̴�.
		if (i >= 0) {	//��ü�� ã�� ���
			return size() - 1;	
		}
		return -1; 
	}

}
