package serv;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;


public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String file=request.getParameter("down"); //gets name of file, for further processing, concatenate the absolute path here
		File f=new File(file);
		System.out.println(f.getAbsolutePath());
		response.setHeader("content-disposition", "attachment;filename="+f);
		response.setContentType("application/octet-stream"); //setting appropriate headers for downloading
		OutputStream out=response.getOutputStream();
		FileInputStream fin=new FileInputStream(file);
		byte[] b=new byte[fin.available()];
		fin.read(b);
		out.write(b);
	}
}
