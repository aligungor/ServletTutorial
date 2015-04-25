package s04_Response;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Response Servlet 1", urlPatterns = "/response")
public class ResponseServlet1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setHeader("firstName", "Header-firstName");
		String firstName = resp.getHeader("firstName");
		System.out.println("firstName:" + firstName);

		resp.addHeader("firstName", "levent");
		firstName = resp.getHeader("firstName");
		System.out.println("firstName:" + firstName);

		Collection<String> firstNamesHeader = resp.getHeaders("firstName");
		for (String str : firstNamesHeader) {
			System.out.println("firstName:" + str);
		}

		resp.setHeader("firstName", "ali");
		resp.setHeader("lastname", "gungor");
		resp.setIntHeader("birthday", 1990);

		Collection<String> headerNames = resp.getHeaderNames();
		for (String str : headerNames) {
			System.out.println("Header Name:" + str + " HeaderValue:" + resp.getHeader(str));
		}
	}
	
}
