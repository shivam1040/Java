package serv;

import jakarta.servlet.GenericServlet;
import java.io.IOException;


/**
 * Servlet implementation class ServByGeneric
 */
public class ServByGeneric extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public ServByGeneric() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void service(jakarta.servlet.ServletRequest arg0, jakarta.servlet.ServletResponse arg1)
			throws jakarta.servlet.ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Generic");
		
	}

}
