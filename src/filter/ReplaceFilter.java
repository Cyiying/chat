package filter;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import util.ResponseReplaceWrapper;

@WebFilter(urlPatterns = "/contentServlet")
public class ReplaceFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse resp = (HttpServletResponse) response;
		ResponseReplaceWrapper wrapper = new ResponseReplaceWrapper(resp);
		chain.doFilter(request, wrapper);
		String out = wrapper.getCharWriter().toString();
		PrintWriter writer = resp.getWriter();
		InputStream resourceAsStream = request.getServletContext().getResourceAsStream("replace.properties");
		Properties properties = new Properties();
		properties.load(resourceAsStream);
		String property = properties.getProperty("pinyin");
		String[] split = property.split(",");
		for (String s : split) {
			out = out.replace(s, "√»√»");
		}
		writer.write(out);
	}

}
