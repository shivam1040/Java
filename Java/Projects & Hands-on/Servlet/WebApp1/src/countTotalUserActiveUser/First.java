package countTotalUserActiveUser;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class First
 */
public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();//this is necessaary to trigger httpsession listener
		//session.invalidate(); //this will trigger sessiondestroyed of countuserlistener
		response.setContentType("text/html");
		ServletContext ctx=this.getServletContext();
		int t=(int) ctx.getAttribute("totalusers");
		int c=(int) ctx.getAttribute("currentusers");
		response.getWriter().print(t);
		response.getWriter().print(c);
		response.getWriter().print("<a href='Logout'>logout</a>");
	}

}
