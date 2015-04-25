package s04_Response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Response Servlet 2", urlPatterns = "/response2")
public class ResponseServlet2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Cookie userNameCookie = new Cookie("userName", "aligungor");
		Cookie passwordCookie = new Cookie("password", "1234");

		resp.addHeader("Set-Cookie","testName=testValue");

		resp.addCookie(userNameCookie);
		resp.addCookie(passwordCookie);

		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				System.out.println(c.getName() + " " + c.getValue());
			}
		}
	}
	
}
