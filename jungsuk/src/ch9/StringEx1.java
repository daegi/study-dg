package ch9;

public class StringEx1 {

	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = new String("abc");
		
		System.out.println("String str1 = \"abc\";");
		System.out.println("String str2 = \"abc\";");
		
		
		
		str2 = str2.intern();
		if(str1 == str2){
			System.out.println("str1 == str2 ? true");
			
		}else{
			System.out.println("str1 == str2 ? false");
		}
	}

}
