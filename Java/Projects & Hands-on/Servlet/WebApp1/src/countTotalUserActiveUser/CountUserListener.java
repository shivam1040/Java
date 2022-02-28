package countTotalUserActiveUser;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class CountUserListener
 *
 */
public class CountUserListener implements HttpSessionListener {//this event will be fired when object of httpsession is created 
	static int total=0, current=0;
	ServletContext ctx=null;
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		total++;
		current++;
		ctx=se.getSession().getServletContext();
		ctx.setAttribute("totalusers", total);
		ctx.setAttribute("currentusers", current);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		current--;
		ctx.setAttribute("currentusers", current);
	}
	
}
