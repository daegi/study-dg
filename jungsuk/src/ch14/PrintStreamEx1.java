package ch14;

import java.util.Date;

public class PrintStreamEx1 {

	public static void main(String[] args) {
		int i = 65;
		float f= 1234.56789f;
		
		Date d = new Date();
		
		System.out.printf("문자 %c의 코드는 %d\n", i, i);
		System.out.printf("int i: %d %10f\n",i,f);
		
		System.out.printf("%tY년 %tm월 %td일",d,d,d);
		System.out.printf("");
		System.out.printf("");
		
		System.out.printf("오늘은 %tY년 %tm월 %td일 입니다.\n", d,d,d );
		System.out.printf("지금은 %tH시 %tM분 %tS초 입니다.\n", d,d,d );
		System.out.printf("지금은 %1$tH시 %1$tM분 %1$tS초 입니다.\n", d );

	}

}
