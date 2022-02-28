

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
/**
 * Servlet Filter implementation class Filt
 */
public class Filt extends HttpFilter {
       
	FilterConfig fConfig;
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		response.getWriter().println("filtoor pre processing");
		response.getWriter().println(fConfig.getInitParameter("name"));//displaying init param for this filter
		chain.doFilter(request, response); //checks if there's another filter, if it's there then req resp gets send to that and if not then req resp gets send to servlet
		response.getWriter().println("\nfiltoor post processing");
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.fConfig=fConfig;
	}

}
