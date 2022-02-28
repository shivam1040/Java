package custom;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.BodyTag;
import jakarta.servlet.jsp.tagext.BodyTagSupport;
import jakarta.servlet.jsp.tagext.Tag;

public class BodyTagSupportDem extends BodyTagSupport {

	@Override
	public int doEndTag() throws JspException {
		String body=bodyContent.getString(); //storing body in string form
		ServletRequest obj=pageContext.getRequest();
		obj.setAttribute("bod", body);
		return Tag.EVAL_PAGE; //continues evaluating body
	}

	@Override
	public int doStartTag() throws JspException {
		return BodyTag.EVAL_BODY_BUFFERED; //stores body of tag in buffer
	}
	
}
