import java.util.*;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GameUI extends Stage {
	
	public static final Image GRASSY_GROUND_IMAGE = Tools.createImage("GameGrassyBack.png");
	
	public static final BackgroundImage GRASSY_GROUND = new BackgroundImage(GRASSY_GROUND_IMAGE, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(GRASSY_GROUND_IMAGE.getWidth(), GRASSY_GROUND_IMAGE.getHeight(), false, false, false, false));
	
	public static final double GAME_WIDTH = 1920;
	public static final double GAME_HEIGHT = 1080;

	private static final double CLOSE_X = 1870;
	private static final double CLOSE_Y = 3;
	
	private double widthRatio;
	private double heightRatio;
	private double smallestRatio;
	
	private List<Player> players;
	
	public GameUI(int numPlayers, double widthRatio, double heightRatio, double smallestRatio)
	{
		this.widthRatio = widthRatio;
		this.heightRatio = heightRatio;
		this.smallestRatio = smallestRatio;
		
		createGameUI(numPlayers);
	}
	
	public void createGameUI(int numPlayers)
	{
		players = new ArrayList<Player>(numPlayers);
		this.initStyle(StageStyle.TRANSPARENT);
		this.setFullScreen(true);
		//prevents the user from pressing escape to exit full screen
		this.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
		
		AnchorPane root = new AnchorPane();
		Scene scene = new Scene(root, GAME_WIDTH * widthRatio, GAME_HEIGHT * heightRatio);
		
		Text close = createGameCloseButton(root);
		root.getChildren().addAll(close);
		root.setBackground(new Background(GRASSY_GROUND));
		
		this.setScene(scene);
	}
	
	public Text createGameCloseButton(AnchorPane root)
	{
		Text close = Tools.createText(CLOSE_X, CLOSE_Y, widthRatio, heightRatio, "X", Color.LIGHTGRAY, Tools.SMALL_SHADE, Tools.createFont("Bookman Old Style", null, 50, smallestRatio));

		close.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				closeGameScreen();
			}
        });
		
		return close;
	}
	
	public void closeGameScreen()
	{
		Stage back = new IntroUI(widthRatio, heightRatio, smallestRatio);
		back.show();
		this.close();
	}
}
