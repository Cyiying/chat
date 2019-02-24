package listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class OnlineListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		ServletContext servletContext = se.getSession().getServletContext();
		Integer count = (Integer) servletContext.getAttribute("online");
		if (count == null) {
			count = 1;
		} else {
			count++;
		}
		servletContext.setAttribute("online", count);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		ServletContext servletContext = se.getSession().getServletContext();
		Integer count = (Integer) servletContext.getAttribute("online");
		count--;
		servletContext.setAttribute("online", count);
	}

}
