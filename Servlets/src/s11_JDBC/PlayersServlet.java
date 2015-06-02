package s11_JDBC;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Players Servlet", urlPatterns = "/players/*")
public class PlayersServlet extends HttpServlet {
	private static final String ADD = "add";
	private static final String DELETE = "delete";
	private static final String FIND = "find";
	private static final String GET_ALL = "getAll";
	private static final String UPDATE = "update";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String path = req.getPathInfo() == null ? "" : req.getPathInfo()
				.replace("/", "");
		if (path.isEmpty())
			path = GET_ALL;

		PrintWriter printWriter = resp.getWriter();
		PlayerDB playerDB = new PlayerDB();

		if (path.equals(ADD)) {
			printWriter
					.println(playerDB
							.insertPlayer(createPlayerFromRequest(req)) ? "player added"
							: "error");
		} else if (path.equals(DELETE)) {
			printWriter.println(playerDB.deletePlayer(Integer.parseInt(req
					.getParameter("playerID"))) ? "player deleted" : "error");
		} else if (path.equals(FIND)) {
			List<Player> playersFound = playerDB.findByName(req
					.getParameter("name"));
			printWriter.println(playersFound.isEmpty() ? "player not found"
					: convertPlayerListToHtmlTable(playersFound));
		} else if (path.equals(UPDATE)) {
			printWriter.println(playerDB.updatePlayer(
					Integer.parseInt(req.getParameter("playerID")),
					createPlayerFromRequest(req)) ? "player updated"
					: "update unsuccessful");
		} else if (path.equals(GET_ALL)) {
			List<Player> players = playerDB.getAll();
			printWriter.println(players.isEmpty() ? "empty"
					: convertPlayerListToHtmlTable(players));
		}

	}

	private Player createPlayerFromRequest(HttpServletRequest req) {
		Player p = new Player();
		p.setName(req.getParameter("name"));
		p.setSurname(req.getParameter("surname"));
		p.setTeam(req.getParameter("team"));
		p.setAge(Integer.parseInt(req.getParameter("age")));
		return p;
	}
	
	private String convertPlayerListToHtmlTable(List<Player> players) {
		String html = "<table>";
		for (Player p : players) {
			html += "<tr>";
			html += "<td>" + p.getPlayerID() + "</td>";
			html += "<td>" + p.getName() + "</td>";
			html += "<td>" + p.getSurname() + "</td>";
			html += "<td>" + p.getTeam() + "</td>";
			html += "<td>" + p.getAge() + "</td>";
			html += "</tr>";
		}
		html += "</table>";
		return html;
	}

}
