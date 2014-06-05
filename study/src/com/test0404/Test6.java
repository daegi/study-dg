package com.test0404;
// string
public class Test6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1="seoul korea";
		
		System.out.println("문자열 길이 :"+s1.length());
		
		//7번째 문자만 추출 (인덱스가 0부터 시작)
		System.out.println(s1.charAt(6));
		
		//7번째 문자에서 3개만 추출
		System.out.println(s1.substring(6,9));
		
		//6번째 위치부터 끝까지 추출
		System.out.println(s1.substring(6));
		
		//kor 문자열의 위치는?
		System.out.println(s1.indexOf("kor"));
		
		//o문자열의 위치는
		System.out.println(s1.indexOf("o"));
		System.out.println(s1.lastIndexOf("1: o"));
		
		//ss문자열의 위치는?(없으면 -1)
		System.out.println(s1.indexOf("ss"));
		//앞부분만 비교
		System.out.println(s1.startsWith("seoul"));
		//뒷부분만 비교
		System.out.println(s1.endsWith("korea"));
		
		System.out.println(s1.equals("seoul korea"));
		System.out.println(s1.equals("Seoul Korea"));
		
		//대소문자를 비교하지 않음
		System.out.println(s1.equalsIgnoreCase("Seoul Korea"));
		
		//문자열을 사전식으로 비교('k'-'c'=8)
		System.out.println(s1.compareTo("seoul corea"));
		//System.out.println(s1 < ("seoul corea")); 에러 문자열은 부등호로 비교 불가.
		
		
		String s2= s1.toUpperCase();
		System.out.println(s2);
		
		s1="서울 대한민국 대한독립 우리 대한";
		s2=s1.replaceAll("대한","大韓");
		System.out.println(s2);
		
		s1="   우 리 나 라    ";
		System.out.println(":"+s1+":");
		s2=s1.trim(); // 앞과 뒤의 공백 제거
		System.out.println(":"+s2+":");
		
		s2=s1.replace(" ", ""); // \\s 공백
		s2=s1.replaceAll("\\s", "");
		System.out.println(":"+s2+":");
		
		s1="aa,bb,cc";
		String[] ss=s1.split(","); //문자열을 분리
		System.out.println(ss.length);
		
		for(String s:ss)
			System.out.println(s);
		
		int n=10;
		// s1=n; 에러
		s1= ""+n;// 문자열 + 기본자료형 =>문자열
				 // 없어보임
		
		System.out.println(s1);
		
		
		//정수를 문자열(Integer:정수를 처리하는 클래스)
		s1=Integer.toString(n);
		System.out.println(s1);
		
		n=1234567;
		// String.format()은 System.out.prinf()와 형식이 유사
		s1=String.format("%,d", n); 
		System.out.println(s1);
		
		s1=String.format("%.1f %.2f %f", 12.5869,12.5869,12.5869);
		System.out.println(s1);
		
		
		System.out.printf("%.1f %.2f %f\n", 12.5869,12.5869,12.5869);
				
		}
}
