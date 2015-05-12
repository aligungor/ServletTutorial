package s10_WebFilter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class Filter
 */
@WebFilter(filterName = "filter", urlPatterns = { "/filter/*" })
public class Filter implements javax.servlet.Filter {

	/**
	 * Default constructor.
	 */
	public Filter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("destroy()");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter()");
		HttpServletResponse res = (HttpServletResponse) response;
		// HttpServletRequest req = (HttpServletRequest) request;
		String ip = request.getRemoteAddr();
		
		System.out.println(ip);
		if (ip.startsWith("192.168.2.")) {
			chain.doFilter(request, response);
			System.out.println("success");
		} else {
			res.sendError(HttpServletResponse.SC_FORBIDDEN,
					"Only local network users can reach me.");
			System.out.println("access denied");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init()");
	}

}
