package ch9;

public class StringEx8 {

	public static void main(String[] args) {
		String[] numbers = { "1", "2", "3", "4", "5" };
		String result1 = "";
		int result2 = 0;
		
		
		for(int i=0; i <numbers.length; i++){
			result1 += numbers[i];
			result2 += Integer.parseInt(numbers[i]);//문자열을 정수로 변환
		}
		
		System.out.println(result1);
		System.out.println(result2);
		

	}

}
