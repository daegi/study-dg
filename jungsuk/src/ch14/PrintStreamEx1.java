package ch14;

import java.util.Date;

public class PrintStreamEx1 {

	public static void main(String[] args) {
		int i = 65;
		float f= 1234.56789f;
		
		Date d = new Date();
		
		System.out.printf("���� %c�� �ڵ�� %d\n", i, i);
		System.out.printf("int i: %d %10f\n",i,f);
		
		System.out.printf("%tY�� %tm�� %td��",d,d,d);
		System.out.printf("");
		System.out.printf("");
		
		System.out.printf("������ %tY�� %tm�� %td�� �Դϴ�.\n", d,d,d );
		System.out.printf("������ %tH�� %tM�� %tS�� �Դϴ�.\n", d,d,d );
		System.out.printf("������ %1$tH�� %1$tM�� %1$tS�� �Դϴ�.\n", d );

	}

}
