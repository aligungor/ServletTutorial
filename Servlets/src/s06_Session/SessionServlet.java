package s06_Session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Session Servlet", urlPatterns = "/sessionServlet")
public class SessionServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter printWriter = resp.getWriter();
		HttpSession httpSession = req.getSession();

		if (httpSession.isNew()) {
			printWriter.println("Session doesn't exist");
		} else {
			printWriter.println("Session exists");
		}
		
		printSessionInfo(httpSession, printWriter);
	}
	
	private void printSessionInfo(HttpSession session, PrintWriter printWriter) {
		String id = session.getId();
		Date creationTime = new Date(session.getCreationTime());
		Date lastAccessedTime = new Date(session.getLastAccessedTime());
		Integer maxInactiveInternal = session.getMaxInactiveInterval();
		
		printWriter.println("Session id : " + id);
		printWriter.println("Creation time : " + lastAccessedTime);
		printWriter.println("Last access time : " + lastAccessedTime);
	}
}
