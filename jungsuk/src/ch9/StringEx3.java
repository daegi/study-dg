package ch9;

public class StringEx3 {

	public static void main(String[] args) {
		
		String s1 = "AAA";
		String s2 = new String("AAA");
		
		if(s1 == s2){
			System.out.println("s1 s2 ����? ��");
		}else{
			System.out.println("s1 s2 ����? �ƴ�");
		}
		
		s2 = s2.intern();
		System.out.println("s2�� ����() ȣ����");
		
		if(s1 == s2){
			System.out.println("s1 s2 ����? ��");
		}else{
			System.out.println("s1 s2 ����? �ƴ�");
		}

	}

}
