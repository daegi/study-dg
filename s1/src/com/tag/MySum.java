package com.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MySum extends TagSupport {
	private static final long serialVersionUID = 1L;

	private String num;

	public void setNum(String num) {
		this.num = num;

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
			if (num != null) {
				n = Integer.parseInt(num);
			}

			int s = 0;
			for (int i = 1; i <= n; i++) {
				s += i;
			}

			out.print("1부터" + num + "까지합 :" + s);

		} catch (Exception e) {
		}

		// 바디가 없는 태그 (<br/>)
		return SKIP_BODY;
	}

}
