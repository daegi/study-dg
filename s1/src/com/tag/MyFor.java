package com.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class MyFor extends TagSupport {
	private static final long serialVersionUID = 1L;

	private Integer begin, end;
	private String var;

	public void setBegin(Integer begin) {
		this.begin = begin;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public void setVar(String var) {
		this.var = var;
	}

	@Override
	public int doStartTag() throws JspException {
		if (begin > end)
			return SKIP_BODY;

		pageContext.setAttribute(var, begin);
		return EVAL_BODY_AGAIN;
	}

	@Override
	public int doAfterBody() throws JspException {

		if (end > begin) {
			begin++;
			pageContext.setAttribute(var, begin);
			return EVAL_BODY_AGAIN;
		}
		return SKIP_BODY;
	}
}