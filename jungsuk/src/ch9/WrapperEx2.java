package ch9;

public class WrapperEx2 {

	public static void main(String[] args) {
		
		int i = new Integer("100").intValue();
		int i2 = Integer.parseInt("100");
		Integer i3 = Integer.valueOf("100");
		
		int i4= Integer.parseInt("100");
		int i5= Integer.parseInt("100",8);
		int i6= Integer.parseInt("100",16);
		int i7= Integer.parseInt("FF",16);
		//int i8= Integer.parseInt("FF");  //³ÑÆ÷ÀÍ¼Á
		
		int i9= Integer.valueOf("100",2);
		int i10= Integer.valueOf("100",8);
		int i11= Integer.valueOf("100",16);
		int i12= Integer.valueOf("FF",16);
		//int i13= Integer.valueOf("ff");
		
		
		System.out.println(i);
		System.out.println(i2);
		System.out.println(i3);
		System.out.println(i4);
		System.out.println(i5);
		System.out.println(i6);
		System.out.println(i7);
		//System.out.println(i8);
		System.out.println(i9);
		System.out.println(i10);
		System.out.println(i11);
		System.out.println(i12);
		//System.out.println(i13);
		
		
		

	}

}
