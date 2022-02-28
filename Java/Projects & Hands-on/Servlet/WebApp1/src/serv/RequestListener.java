package serv;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;

/**
 * Application Lifecycle Listener implementation class RequestListener
 *
 */
public class RequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		ServletRequestListener.super.requestDestroyed(sre);
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		System.out.println("this listener will get executed everytime a request is made to any of the servlet or webpage");
	}

	//there's one more listener that is used for sessions created between servlet and client known as httpsessionlistener interface and gets instantiated whenever an object is created for HttpSession interface
}
