package com.util;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

// HttpSessionListener : 세션이 생성되거나 소멸되는
// 이벤트 를 처리하는 인터페이스
// 세션 이벤트를 처리하기 위해서는 web.xml 에
// listener를 등록 해야함(또는 어노테이션 사용)
public class CountManager implements HttpSessionListener {
	private static int count = 0;

	public static int getCount() {
		return count;
	}

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		// 세션이 생성될때 호출

		HttpSession session = event.getSession();

		count++;

		String s = session.getId() + ":세션이 생성, 인원수:" + count;
		session.getServletContext().log(s);

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		// 세션이 소멸될때 호출

		HttpSession session = event.getSession();

		count--;
		if (count < 0)
			count = 0;

		String s = session.getId() + ":세션이 소멸, 인원수:" + count;
		session.getServletContext().log(s);

	}

}
