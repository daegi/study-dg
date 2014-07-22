package com.hello;

import java.util.Calendar;

public class HelloService {
	public String getMessage() {
		String s;

		int h = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if (h >= 6 && h <= 8)
			s = "일어나서 공부하러 오는시간....";

		else if (h >= 9 && h <= 13)
			s = "오전 공부시간...";
		else if (h >= 13 && h <= 14)
			s = "밥먹는시간...";
		else if (h >= 14 && h <= 18)
			s = "오후 공부시간...";
		else
			s = "자유시간....";
		
		return s;
	}
}
