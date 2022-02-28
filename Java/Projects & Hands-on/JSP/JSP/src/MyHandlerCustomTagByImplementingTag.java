import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.PageContext;
import jakarta.servlet.jsp.tagext.Tag;

public class MyHandlerCustomTagByImplementingTag implements Tag{

	@Override
	public int doEndTag() throws JspException { //bussiness logic when tag ends </prefix:name>
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doStartTag() throws JspException { //bussiness logic when tag starts <prefix:name>
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Tag getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void release() { //do somethin at the ending of tag after business logic
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPageContext(PageContext arg0) { //does the job of passing pagecontext obj to tag handler class
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setParent(Tag arg0) { //does the job of making a tag parent, used for nested tags
		// TODO Auto-generated method stub
		
	}

}
