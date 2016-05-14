import java.util.*;

import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GameUI extends Stage {
	private List<Player> players;
	
	public GameUI(int numPlayers)
	{
		players = new ArrayList<Player>(numPlayers);
		this.initStyle(StageStyle.TRANSPARENT);
		this.setFullScreen(true);
	}
}
