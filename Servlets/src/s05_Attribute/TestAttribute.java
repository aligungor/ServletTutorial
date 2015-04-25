package s05_Attribute;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Test Attribute", urlPatterns = {"/testAttribute"})
public class TestAttribute extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("Start");
		
		printWriter.println("Servlet Context");
		printWriter.println(getServletContext().getAttribute(AttributeConstants.NAME_ATTR));

		printWriter.println("HTTP Session");
		printWriter.println(req.getSession().getAttribute(AttributeConstants.NAME_ATTR));

		printWriter.println("HTTP Request");
		printWriter.println(req.getAttribute(AttributeConstants.NAME_ATTR));
		
		printWriter.println("End");
	}
	
}
