package s03_Request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Request Servlet 2",urlPatterns="/request2")
public class RequestServlet2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String maritalStatus = req.getParameter("marital status");
		String[] language = req.getParameterValues("lang");

		PrintWriter pw = resp.getWriter();
		
		pw.print("<html><body>");
		pw.print(name + " " + gender + "<br>");
		pw.print(maritalStatus + "<br>");
		if (language != null) {
			for (String str : language) {
				pw.print(str + "<br>");
			}
		}
		pw.print("</body></html>");
	}
	
}
