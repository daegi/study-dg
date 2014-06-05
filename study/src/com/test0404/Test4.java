package com.test0404;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1="서울";
		String s2="서울";
		
		String s3=new String("서울");
		
		
		//String 에서 == 값을 비교하지 않고 주소를 비교
		System.out.println(s1==s2); //true(동일주소)
		System.out.println(s1==s3); //false
		
		//문자열을 비교할때 때는 equals 사용
		//String 의 equals()의 값을 비교
		System.out.println(s1.equals(s3));
		
		//문자열+기본자료형=>문자열
		//문자열+문자열=>문자열결합
		//string는 불변의 원칙
		
		s1+="부산";
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1==s2);
		
		//문자열 처리 두번째 클래스
		//가변적인 문자열을 처리할때 StringBuffer는 String
		//과는 다르게 문자열을 추가 하므로
		//속도가 더 빠르다.
		StringBuffer sb1=new StringBuffer();
		StringBuffer sb2=new StringBuffer();
		
		sb1.append("서울");
		sb2.append("서울");
		
		System.out.println(sb1);
		System.out.println(sb2);
		System.out.println(sb1==sb2);  //false
		//StringBuffer의 equals는 Object의 equals이며 주소를 비교함
		System.out.println(sb1.equals(sb2));  //false
		System.out.println(sb1.toString().equals(sb2.toString()));
		
		
		
		
		
		

	}

}
