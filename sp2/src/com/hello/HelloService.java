package com.hello;

import java.util.Calendar;

public class HelloService {
	public String getMessage() {
		String s;

		int h = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if (h >= 6 && h <= 8)
			s = "�Ͼ�� �����Ϸ� ���½ð�....";

		else if (h >= 9 && h <= 13)
			s = "���� ���νð�...";
		else if (h >= 13 && h <= 14)
			s = "��Դ½ð�...";
		else if (h >= 14 && h <= 18)
			s = "���� ���νð�...";
		else
			s = "�����ð�....";
		
		return s;
	}
}
