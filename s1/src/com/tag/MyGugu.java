package com.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyGugu extends TagSupport {

	private static final long serialVersionUID = 1L;

	private String dan;

	public void setDan(String dan) {
		this.dan = dan;
	}

	@Override
	public int doEndTag() throws JspException {
		// 사용자 태그 처리후 jsp 다음 계속 처리
		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			int n = 0;
			if (dan != null) {
				n = Integer.parseInt(dan);
			}

			int s = 0;
			for (int i = 1; i <= 9; i++) {
				s = n * i;
				out.print(dan + "*" + i + "=" + s + "<br/>");
			}

		} catch (Exception e) {
		}

		// 바디가 없는 태그 (<br/>)
		return SKIP_BODY;
	}

}
