package s02_LifeCycle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Life Cycle",urlPatterns={"/lifeCycle"})
public class LifeCycle extends HttpServlet{

	/**
	 * init() fonksiyonu Servlet çalıştırıldığında bir kere çalıştırılır
	 * İlgili Servlet'in sunucuda oluşturulup başarıyla başladığına
	 * işaret eder.
	 */
	@Override
	public void init() throws ServletException {
		System.out.println("init() fonksiyonu çalıştı");
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.getWriter().print("Life Cycle Servlet");
	}
	
	/**
	 * Destroy komutu Servlet sonlandırılır. Artık sunucuda servletin
	 * çalıştırılmasına ihtiyaç kalmamıştır.
	 */
	@Override
	public void destroy() {
		System.out.println("destroy() fonsiyonu çalıştı");
	}
}
