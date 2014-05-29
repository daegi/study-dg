package com.test0411;

import java.lang.reflect.Method;

public class Test7 {

	public static void main(String[] args) throws Exception {
		//class 클래스 : 클래스에 대한 정보
		
		Class<?> cls=Class.forName("java.lang.String");
		
		//메소드 확인
		Method [] m=cls.getMethods();
		for(Method mm:m)
			System.out.println(mm);

	}
}
