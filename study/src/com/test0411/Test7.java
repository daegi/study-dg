package com.test0411;

import java.lang.reflect.Method;

public class Test7 {

	public static void main(String[] args) throws Exception {
		//class Ŭ���� : Ŭ������ ���� ����
		
		Class<?> cls=Class.forName("java.lang.String");
		
		//�޼ҵ� Ȯ��
		Method [] m=cls.getMethods();
		for(Method mm:m)
			System.out.println(mm);

	}
}
