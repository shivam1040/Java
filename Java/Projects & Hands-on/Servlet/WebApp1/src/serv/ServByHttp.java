package serv;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ServByHttp
 */

//@WebServlet("/ServByHttp")//way to use annotation based servlet, and the name of servlet is servbyhttp
public class ServByHttp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServByHttp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	} //this method is run on get request, similar for dopost

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// httpserveletreq/resp is made by extending  serveletrequest interface
		String name=request.getParameter("name"); //using the reuqest obj to get parameter having html tag descriptor as name
		response.getWriter().append(name); //sending the response back to client and printing var name on display
		PrintWriter obj=response.getWriter();//this represents output stream of browser, since getwritere represents the streamtype of browser
		//above method can be used to send html tags or page and this will get processed by browser, multiple tags can be written in multiple getwriter methods, response.getWriter().println("<body></body>");
		
		//response.sendRedirect("index.html"); //gets taken to index.html after above statement is executed this makes a new response and request and response is from index.html and never write a code right above/below sendredirect it won't get executed, url will change to index.html
		//response.setContentType("text/html"); response can be send in several types, application/excel powerpoint etc.
		
		RequestDispatcher obj1=request.getRequestDispatcher("index.html"); //creating obj for reqdispatcher using factory method since reqdispatch is interface
		obj1.forward(request, response); //takes to index.html, //this is same as above but no new request/response s created and it works on the same reuqest and response, moreover codes below or above can be executed too, this is generally used for sending to other servlet/website, the request remains the same and response is from called entity i.e index.html in this case
		
		//response.setContentType("text/html"); //this is necessary to send html response not text which is by default ehile using the below include method to send response
		//response.getWriter().append("invalid");
		//obj1.include(request, response); //this is generally used for redirecting to same website/servlet including som tag changes as above, ensure to not use multiple responses at once, in this method the response is combination of calling entity and called entity i.e instructions given in dopost+response from index.html
		//url will not change in reqdisp way
		
		ServletContext obj2=this.getServletContext();
		obj2.setAttribute("attr", name); //this has value of name in attr and this can can be used in other servlets by using getattribute method and first arguement name(because we know that context is only one for entire project)
		String b=(String)obj2.getAttribute("attr");
			
		/*Session tracking method by hidden url, in this case request is carried to next servlet by means of hidden fields, downsides are need to click submit button, create form everytime and not secure since data on client side, data managed(state) but identity not managed
		obj.println("<html><body><form action='Serv1' method='post'>");
		obj.println("<input type='hidden' name='any' value='any'>");
		obj.println("input type='submit'>");
		obj.println("</form></body></html>");
		*/
		
		/*Session tracking by urlrewriting, in this cases identity isn't maintained but state is, for instance on flipkart page one servlet is used to get content for catatlog by using query html statement containing id which is passed to called servlet for further instructions
		obj.println("<a href='NextServ?name="+name+">Nextpage"); //this html statememnt is used to query and get the value correspondent to the name parameter from the request and use it on the called servlet
		*/
		
		/*session tracking by cookie, no identity tracking
		Cookie cookie=new Cookie("a", name);//creates a cookie with key a have value from var name; only string type
		response.addCookie(cookie);// necessary to send cookie alongwith response
		//in cookies method entire functionality is broken if cookie disabled
		 obj.println("<a href='NextServ?name="+name+">Nextpage");
		 */
		
		Cookie cookie[]=request.getCookies();
		
		/*session tracking by httpsession, identity tracking available
		HttpSession session=request.getSession();//returns new session obj for new req and same session obj for old req
		//HttpSession session=request.getSession(false); this always gives old session
		//in httpsession ref/obj, an id is created for the ref/obj id known as jsession id which is stored in cookie and send to client after adding this cookie to response
		//a new session obj is created only when there's a diff in received jsession id, using the isNew() method of httpsession
		session.setAttribute("name", name); //this attribute can be used in called servlet/page
		obj.println("<a href='NextServ>Nextpage");
		session.invalidate()//forcefully expires the session equivalent to logout
		session.setMaxInactiveInterval(30); // deletes the session incase the inactivity is beyond 30sec.
		*/
	}

}