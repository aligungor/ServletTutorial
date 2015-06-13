package s11_JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerDB implements PlayerDAO {
	/*
	 * CREATE TABLE Players ( PlayerID int NOT NULL AUTO_INCREMENT, Name
	 * varchar(255) NOT NULL, Surname varchar(255) NOT NULL, Team varchar(255)
	 * NOT NULL, Age int NOT NULL, PRIMARY KEY(PlayerID) );
	 */

	private static String TABLE_PLAYERS = "Football.Players";

	private static String PLAYER_ID = "PlayerID";
	private static String PLAYER_NAME = "Name";
	private static String PLAYER_SURNAME = "Surname";
	private static String PLAYER_TEAM = "Team";
	private static String PLAYER_AGE = "Age";

	private static DBMySQL dbManager;

	public PlayerDB() {
		dbManager = DBMySQL.getDBMySQL();
	}

	@Override
	public List<Player> getAll() {
		List<Player> players = new ArrayList<Player>();
		String sql = "SELECT * FROM " + TABLE_PLAYERS;
		try {
			PreparedStatement st = dbManager.getConnectionFromPool().prepareStatement(
					sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Player p = new Player();
				p.setPlayerID(rs.getInt(PLAYER_ID));
				p.setName(rs.getString(PLAYER_NAME));
				p.setSurname(rs.getString(PLAYER_SURNAME));
				p.setTeam(rs.getString(PLAYER_TEAM));
				p.setAge(rs.getInt(PLAYER_AGE));
				players.add(p);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbManager.closeConnectionFromPool();
		}
		return players;
	}

	@Override
	public List<Player> findByName(String name) {
		List<Player> players = new ArrayList<Player>();
		String sql = "SELECT * FROM " + TABLE_PLAYERS + " WHERE " + PLAYER_NAME
				+ " LIKE ?";
		try {
			PreparedStatement st = dbManager.getConnection().prepareStatement(
					sql);
			st.setString(1, "%" + name + "%");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Player p = new Player();
				p.setPlayerID(rs.getInt("PlayerID"));
				p.setName(rs.getString("Name"));
				p.setSurname(rs.getString("Surname"));
				p.setTeam(rs.getString("Team"));
				p.setAge(rs.getInt("Age"));
				players.add(p);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbManager.closeConnection();
		}
		return players;
	}

	@Override
	public boolean insertPlayer(Player player) {
		boolean success = false;
		String sql = "INSERT INTO " + TABLE_PLAYERS + " (" + PLAYER_ID + ", "
				+ PLAYER_NAME + ", " + PLAYER_SURNAME + ", " + PLAYER_TEAM
				+ ", " + PLAYER_AGE + ") VALUES (NULL, ?, ?, ?, ?)";
		try {
			PreparedStatement st = dbManager.getConnection().prepareStatement(
					sql);
			st.setString(1, player.getName());
			st.setString(2, player.getSurname());
			st.setString(3, player.getTeam());
			st.setInt(4, player.getAge());
			st.executeUpdate();
			st.close();
			success = true;
		} catch (SQLException e) {
			success = false;
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbManager.closeConnection();
		}
		return success;
	}

	@Override
	public boolean updatePlayer(int playerID, Player player) {
		boolean success = false;
		String sql = "UPDATE " + TABLE_PLAYERS + " SET " + PLAYER_NAME
				+ " = ?, " + PLAYER_SURNAME + " = ?, " + PLAYER_TEAM + " = ?, "
				+ PLAYER_AGE + " = ? WHERE " + PLAYER_ID + " = ?";
		try {
			PreparedStatement st = dbManager.getConnection().prepareStatement(
					sql);
			st.setString(1, player.getName());
			st.setString(2, player.getSurname());
			st.setString(3, player.getTeam());
			st.setInt(4, player.getAge());
			st.setInt(5, playerID);
			st.executeUpdate();
			st.close();
			success = true;
		} catch (SQLException e) {
			success = false;
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbManager.closeConnection();
		}
		return success;
	}

	@Override
	public boolean deletePlayer(int playerID) {
		boolean success = false;
		String sql = "DELETE FROM " + TABLE_PLAYERS + " WHERE " + PLAYER_ID
				+ " = ?";
		try {
			PreparedStatement st = dbManager.getConnection().prepareStatement(
					sql);
			st.setInt(1, playerID);
			st.executeUpdate();
			st.close();
			success = true;
		} catch (SQLException e) {
			success = false;
			e.printStackTrace();
		} finally {
			dbManager.closeConnection();
		}
		return success;
	}

}
