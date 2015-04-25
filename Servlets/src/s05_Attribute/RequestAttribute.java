package s05_Attribute;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Request Attribute", urlPatterns = {"/requestAttribute"})
public class RequestAttribute extends HttpServlet{
	/**
	 * Request'te tanımlanan Attribute değerlerine sadece o Request
	 * nesnesiyle ulaşılabilir, dolayısı ile Attribute değerlerinin
	 * ömrü Request nesnesinin ömrüyle sınırlıdır.İstek bazlıdır.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter printWriter = resp.getWriter();
		
		req.setAttribute(AttributeConstants.NAME_ATTR, "Ali");
		req.setAttribute(AttributeConstants.SURNAME_ATTR, "Güngör");
		req.setAttribute(AttributeConstants.AGE_ATTR, 24);

		printWriter.println(req.getAttribute(AttributeConstants.NAME_ATTR));
		printWriter.println(req.getAttribute(AttributeConstants.SURNAME_ATTR));
		printWriter.println(req.getAttribute(AttributeConstants.AGE_ATTR));
	}
	
}
