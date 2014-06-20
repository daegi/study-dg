package ch9;

public class StringEx3 {

	public static void main(String[] args) {
		
		String s1 = "AAA";
		String s2 = new String("AAA");
		
		if(s1 == s2){
			System.out.println("s1 s2 같냐? 엉");
		}else{
			System.out.println("s1 s2 같냐? 아니");
		}
		
		s2 = s2.intern();
		System.out.println("s2에 인턴() 호출후");
		
		if(s1 == s2){
			System.out.println("s1 s2 같냐? 엉");
		}else{
			System.out.println("s1 s2 같냐? 아니");
		}

	}

}
