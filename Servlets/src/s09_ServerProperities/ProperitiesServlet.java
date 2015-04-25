package s09_ServerProperities;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Properities Servlet", urlPatterns = "/getServerInfo")
public class ProperitiesServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("System properities:");
		Properties properties = System.getProperties();
        Set<Object>  sysPropertiesKeys = properties.keySet();
        for (Object key : sysPropertiesKeys) {
        	printWriter.println(key + " : " + properties.getProperty((String)key));
        }
	}
	
}
