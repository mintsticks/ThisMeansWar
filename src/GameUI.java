import java.util.*;

import javafx.stage.Stage;

public class GameUI extends Stage {
	private List<Player> players;
	
	public GameUI(int numPlayers)
	{
		players = new ArrayList<Player>(numPlayers);
	}
}
