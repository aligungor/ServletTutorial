package s11_JDBC;

import java.util.List;

public interface PlayerDAO {

	List<Player> getAll();
    List<Player> findByName(String name);
    boolean insertPlayer(Player player);
    boolean updatePlayer(int playerID, Player player);
    boolean deletePlayer(int playerID);
    
}
