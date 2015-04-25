package s05_Attribute;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Context Attribute", urlPatterns = "/contextAttribute")
public class ContextAttribute extends HttpServlet{
	/**
	 * Servlet Context'teki Attribute değişikliği sadece ilgili servleti değil
	 * tüm uygulamayı etkiler. Test Attribute bu servlet çalıştıktan sonra 
	 * Test Attribute servleti de çalıştırılırsa servletin tanımlı değerlere
	 * erişebileceği görülür. Uygulama bazlıdır.
	 * 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter printWriter = resp.getWriter();
		
		//getServletContext() fonk. Thread Safe olabilmesi için
		synchronized (getServletContext()) {
			getServletContext().setAttribute(AttributeConstants.NAME_ATTR, "Ali");
			getServletContext().setAttribute(AttributeConstants.SURNAME_ATTR, "Güngör");
			getServletContext().setAttribute(AttributeConstants.AGE_ATTR, 24);

			printWriter.println(getServletContext().getAttribute(AttributeConstants.NAME_ATTR));
			printWriter.println(getServletContext().getAttribute(AttributeConstants.SURNAME_ATTR));
			printWriter.println(getServletContext().getAttribute(AttributeConstants.AGE_ATTR));
		}
	}
	
}
