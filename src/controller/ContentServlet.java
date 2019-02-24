package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ContentServlet", urlPatterns = { "/contentServlet" })
public class ContentServlet extends HttpServlet {

	String record = "";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String content = req.getParameter("content");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String datetime = sdf.format(date);
		String user = (String) req.getSession().getAttribute("nameSession");
		record += user + "  " + content + "  " + datetime + "\n";
		req.setAttribute("content", record);
		req.getRequestDispatcher("/WEB-INF/welcome.jsp").forward(req, resp);
	}

}
