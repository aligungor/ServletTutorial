package s07_PageRedirect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Redirect Servlet", urlPatterns = "/redirect")
public class RedirectServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//resp.setContentType("text/html");
		String site = new String("https://github.com/aligungor");
		resp.setStatus(resp.SC_MOVED_TEMPORARILY);
		resp.setHeader("Location", site);    
	}
	
}
