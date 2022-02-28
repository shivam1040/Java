

import java.io.IOException;

import com.oreilly.servlet.MultipartRequest;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class Uploading extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String s=System.getProperty("user.dir"); //current working directory
		s=this.getServletConfig().getServletContext().getRealPath("a");//gets absolute path of directory a in project
		MultipartRequest mpr=new MultipartRequest(request, "WEB-INF", 20*1024); //webinf is folder name, 20*1024 is size, operations can be done accordingly using multipartreq ethods
		
		
	}

}
