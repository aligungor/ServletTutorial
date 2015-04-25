package s03_Request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author AliGungor
 * FormRequest1.html tarafından kullanılır.
 *
 */
@WebServlet(name = "Request Servlet 1", urlPatterns = "/request1")
public class RequestServlet1 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//Türkçe karakter problemleri için
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter printWriter = resp.getWriter();
		printWriter.print("İlgili servlet: " + getServletName() + "<br>");
		printWriter.print("Adınız: " + req.getParameter("Ad") + "<br>");
		printWriter.print("Soyadınız: " + req.getParameter("Soyad") + "<br>");
	}
	
}
