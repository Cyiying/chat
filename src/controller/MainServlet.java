package controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Main", urlPatterns = { "/main" })
public class MainServlet extends HttpServlet {

	Map<String, String> users = new HashMap<>();

	{
		users.put("��001", "001");
		users.put("��002", "002");
		users.put("��003", "003");
		users.put("��004", "004");
		users.put("��005", "005");
	}

	private static final long serialVersionUID = 735434484141465992L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// �����������
//		req.setCharacterEncoding("utf-8");

		// ��ȡ��¼��Ϣ
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String rememberMe = req.getParameter("remember-me");
//		System.out.println("username=" + username + "\n" + "password=" + password + "\n" + "rememberMe=" + rememberMe);
//		System.out.println(users);
		req.getSession().setAttribute("nameSession", username);
		// У���˻�
		if (users.containsKey(username) && password.equals(users.get(username))) {
			// ��ס��
			if ("remember-me".equals(rememberMe)) {
				Cookie nameCookie = new Cookie("username", URLEncoder.encode(username, "UTF-8"));
				Cookie pwdCookie = new Cookie("password", URLEncoder.encode(password, "UTF-8"));
				nameCookie.setMaxAge(60 * 60 * 24 * 3);
				nameCookie.setMaxAge(60 * 60 * 24 * 3);
				resp.addCookie(pwdCookie);
				resp.addCookie(nameCookie);
			}
			req.getRequestDispatcher("/WEB-INF/welcome.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("loginFail.jsp");
		}
	}

}
