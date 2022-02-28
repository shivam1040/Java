import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/*j2ee servelet technology standards

1. component tech
2. container tech
3. server tech
4. directory structure tech
5. communication tech
6. service tech
instanceOf methods check if object is instance of given class
marker interfaces are one with no attribute/methods
serializable are marker interfaces used to mark an object in java, or check a given condition and then run the operations accordingly
*/

public class Serv implements Servlet{
    //init, service, destroy are lifecycle methods of servelet
    
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public ServletConfig getServletConfig() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getServletInfo() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void init(ServletConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
        // TODO Auto-generated method stub
        
    }

}