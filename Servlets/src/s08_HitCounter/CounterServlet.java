package s08_HitCounter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Hit Counter Servlet", urlPatterns = {"/counter"})
public class CounterServlet extends HttpServlet{
	
	private int hitCount;
	
	@Override
	public void init() throws ServletException {
		hitCount = 0;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		hitCount++;
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("Hits : " + hitCount);
	}
	
}
