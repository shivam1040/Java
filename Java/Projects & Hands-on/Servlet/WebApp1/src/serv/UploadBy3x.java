package serv;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.Part;

//@WebServlet("/UploadBy3x")
//@MultipartConfig(maxFileSize=1024)
public class UploadBy3x extends HttpServlet { //3x+ servlet version
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		for(jakarta.servlet.http.Part part:request.getParts()) {
			String filename=getFileName(part); //refer to Servlet tutorial directory for getfilename method
			part.write("get directory path"+File.separator+filename); //file.separator is necessary to identify the type of slash
		}
	}

}
