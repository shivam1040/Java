package serv;

import jakarta.servlet.Servlet;
import java.io.IOException;

public class Serv1 implements Servlet {
	
	public Serv1() {
		System.out.println("const");
	}
	
	@Override
	public void destroy() {
		System.out.println("destr");
	}

	@Override
	public jakarta.servlet.ServletConfig getServletConfig() {
		System.out.println("getservconf");
		return null;
	}

	@Override
	public String getServletInfo() {
		System.out.println("getservinf");
		return null;
	}

	@Override
	public void init(jakarta.servlet.ServletConfig config) throws jakarta.servlet.ServletException {
		System.out.println("init");
		
	}

	@Override
	public void service(jakarta.servlet.ServletRequest arg0, jakarta.servlet.ServletResponse arg1)
			throws jakarta.servlet.ServletException, IOException {
		System.out.println("service");
		arg1.getWriter().println("meth. inside service"); //same as PrintWriter obj=arg1.getWr...this output gets displayed in browser when called
		
	}

	

}
