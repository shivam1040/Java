package custom;
import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.Tag;
import jakarta.servlet.jsp.tagext.TagSupport;

public class HandlerTagSupport extends TagSupport{
	int a;
	
	public void setvar1(String var1) {
		this.a=Integer.parseInt(var1);
	}
	
	@Override
	public int doStartTag() throws JspException {
		
		JspWriter obj=pageContext.getOut();
		try {
			obj.println(a*2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return Tag.SKIP_BODY, skips the below mentioned content
		return Tag.EVAL_BODY_INCLUDE;//this will also give the content inside custom tag as result
	}
	
}
