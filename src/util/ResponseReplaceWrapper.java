package util;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class ResponseReplaceWrapper extends HttpServletResponseWrapper {

	private CharArrayWriter charArrayWriter = new CharArrayWriter();

	@Override
	public PrintWriter getWriter() throws IOException {
		return new PrintWriter(charArrayWriter);
	}

	public ResponseReplaceWrapper(HttpServletResponse response) {
		super(response);
	}

	public CharArrayWriter getCharWriter() {
		return charArrayWriter;
	}

}
