

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;

/**
 * Servlet Filter implementation class Fil2
 */
public class Fil2 extends HttpFilter {
       
  
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
response.getWriter().println("filtoor2 pre processing");
		
		chain.doFilter(request, response); //checks if there's another filter, if it's there then req resp gets send to that and if not then req resp gets send to servlet
		response.getWriter().println("\nfiltoor2 post processing");
	}



}
