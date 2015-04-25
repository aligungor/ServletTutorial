package s05_Attribute;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Session Attribute", urlPatterns = {"/sessionAttribute"})
public class SessionAttribute extends HttpServlet{
	/**
	 * Session'da tanımlı Attribute değerler sadece Session'la ilişkili Client
	 * tarafında geçerlidir yani Client bazlıdır.
	 * 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter printWriter = resp.getWriter();
		
		HttpSession session = req.getSession();

		synchronized (session) {
			session.setAttribute(AttributeConstants.NAME_ATTR, "Ali");
			session.setAttribute(AttributeConstants.SURNAME_ATTR, "Güngör");
			session.setAttribute(AttributeConstants.AGE_ATTR, 24);

			printWriter.println(session.getAttribute(AttributeConstants.NAME_ATTR));
			printWriter.println(session.getAttribute(AttributeConstants.SURNAME_ATTR));
			printWriter.println(session.getAttribute(AttributeConstants.AGE_ATTR));
		}
	}
	
}
