import java.util.*;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GameUI extends Stage {
	
	public static final Image GRASSY_GROUND_IMAGE = Tools.createImage("GameGrassyBack.png");
	public static final Image NAME_SET_IMAGE = Tools.createImage("NameSelect.png");
	public static final Image NAME_SET_CLICKED_IMAGE = Tools.createImage("NameSelectClicked.png");
	
	public static final BackgroundImage GRASSY_GROUND = new BackgroundImage(GRASSY_GROUND_IMAGE, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(GRASSY_GROUND_IMAGE.getWidth(), GRASSY_GROUND_IMAGE.getHeight(), false, false, false, false));
	public static final BackgroundImage NAME_SET = new BackgroundImage(NAME_SET_IMAGE, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(NAME_SET_IMAGE.getWidth(), NAME_SET_IMAGE.getHeight(), false, false, true, false));
	public static final BackgroundImage NAME_SET_CLICKED = new BackgroundImage(NAME_SET_CLICKED_IMAGE, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(NAME_SET_CLICKED_IMAGE.getWidth(), NAME_SET_CLICKED_IMAGE.getHeight(), false, false, true, false));
	
	public static final double GAME_WIDTH = 1920;
	public static final double GAME_HEIGHT = 1080;
	
	public static final int NAME_SET_WIDTH = 600;
	public static final int NAME_SET_HEIGHT = 400;
	
	public static final double CLOSE_X = 1880;
	public static final double CLOSE_Y = 2;

	public static final double MIN_X = 1850;
	public static final double MIN_Y = 0;
	
	public static final double NAME_CLOSE_X = 570;
	public static final double NAME_CLOSE_Y = 2;
	
	public static final double NAME_OK_WIDTH = 90;
	public static final double NAME_OK_HEIGHT = 55;
	public static final double NAME_OK_ARC_SIZE = 15;
	public static final double NAME_OK_X = 490;
	public static final double NAME_OK_Y = 197;
	
	public static final double TEXT_X = 50;
	public static final double FIRST_Y = 140;
	public static final double SECOND_Y = 200;
	public static final double THIRD_Y = 260;
	public static final double FOURTH_Y = 320;
	
	public static final String FIRST_TEXT = "Player 1";
	public static final String SECOND_TEXT = "Player 2";
	public static final String THIRD_TEXT = "Player 3";
	public static final String FOURTH_TEXT = "Player 4";
	public static final double FIELD_WIDTH = 390;
	public static final double FIELD_HEIGHT = 40;
	
	public static final Color PLAYER_NAME = Color.web("#636363");
	public static final Color PLAYER_MONEY = Color.web("477628");
	public static final int MAX_LENGTH = 12;
	
	public static final double PLAYER_NAME_X = 175;
	public static final double PLAYER_NAME_Y = 23;
	public static final double PLAYER_MONEY_X = 125;
	public static final double PLAYER_MONEY_Y = 95;
	public static final int NAME_SIZE = 50;
	public static final int MONEY_SIZE = 35;
	
	public static final double UNIT_ICON_SIZE = 55;
	public static final double[] UNIT_X = {30, 101, 170, 239, 309, 380};
	public static final double UNIT_LIST_Y = 206;
	
	private double widthRatio;
	private double heightRatio;
	private double smallestRatio;
	
	private int numPlayers;
	private List<Player> players;
	private TextField firstName;
	private TextField secondName;
	private TextField thirdName;
	private TextField fourthName;
	
	private Text playerName;
	private Text playerMoney;
	
	//Display unit list
	private ImageView pUnit1;
	private ImageView pUnit2;
	private ImageView pUnit3;
	private ImageView pUnit4;
	private ImageView pUnit5;
	private ImageView pUnit6;
	
	
	
	private int currentPlayer; // player index who is currently making the moves.
	private Unit currentUnit;  //- unit that is currently selected.
	private AnchorPane gamePane; //that contains all the actual units and good stuff.
	private AnchorPane selectionPane; //AnchorPane that completely overlaps the game pane. This will
		//   usually be disabled to mouse clicks by using the Pane.setMouseTransparent(false) clause.
		//   This has a Mouse.PRESSED event handler that automatically cancels any attack/move when clicked.
	private Ellipse attackEllipse; //Ellipse that contains the range of an attack. This will be added as a 
		//   child of the selectionPane and will be positioned and sized property to the unit. This has
		//   a Mouse.PRESSED event handler that will finalize an attack with the currentActor. Usually will
		//   be invisible.
	private Ellipse moveEllipse; //- Ellipse that contains the range of a move. This will be added as a 
		//   child of the selectionPane and will be positioned and sized property to the unit. This has
		//   a Mouse.PRESSED event handler that will finalize an movement with the currentActor. Usually
		//   will be invisible.
	private List<Obstacle> playerBases;	//* playerBases- arraylist of bases corresponding to the players by index
	
	private Stage nameSet;
	
	public GameUI(int numPlayers, double widthRatio, double heightRatio, double smallestRatio)
	{
		this.widthRatio = widthRatio;
		this.heightRatio = heightRatio;
		this.smallestRatio = smallestRatio;
		this.numPlayers = numPlayers;
		createNameSet(numPlayers);
	}
	
	public void createGameUI()
	{
		this.initStyle(StageStyle.TRANSPARENT);
		this.setFullScreen(true);
		//prevents the user from pressing escape to exit full screen
		this.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
		
		AnchorPane root = new AnchorPane();
		Scene scene = new Scene(root, GAME_WIDTH * widthRatio, GAME_HEIGHT * heightRatio);
		
		Text close = createGameCloseButton(root);
		Text minimize = createGameMinButton(root);
		players.get(0).addUnit(Tools.createPrivate(0, 0, 0, 0, 0, widthRatio, heightRatio, smallestRatio, null));
		players.get(0).addUnit(Tools.createSergeant(0, 0, 0, 0, 0, widthRatio, heightRatio, smallestRatio, null));
		players.get(0).addUnit(Tools.createScout(0, 0, 0, 0, 0, widthRatio, heightRatio, smallestRatio, null));
		players.get(0).addUnit(Tools.createSniper(0, 0, 0, 0, 0, widthRatio, heightRatio, smallestRatio, null));
		players.get(0).addUnit(Tools.createCorporal(0, 0, 0, 0, 0, widthRatio, heightRatio, smallestRatio, null));
		players.get(0).addUnit(Tools.createTank(0, 0, 0, 0, 0, widthRatio, heightRatio, smallestRatio, null));
		updateInfo(root);
		
		root.getChildren().addAll(close, minimize);
		root.setBackground(new Background(GRASSY_GROUND));
		
		this.setScene(scene);
		this.show();
	}
	
	public void updateInfo(AnchorPane root)
	{
		playerName = Tools.createText(PLAYER_NAME_X, PLAYER_NAME_Y, widthRatio, heightRatio, players.get(currentPlayer).getName(), PLAYER_NAME,
				Tools.SMALL_SHADE, Tools.createFont("Agency FB", null, NAME_SIZE, smallestRatio));
		
		playerMoney = Tools.createText(PLAYER_MONEY_X, PLAYER_MONEY_Y, widthRatio, heightRatio, "$" + players.get(currentPlayer).getAmountOfMoney(), 
				PLAYER_MONEY, Tools.SMALL_SHADE,Tools.createFont("Agency FB", null, MONEY_SIZE, smallestRatio));
		
		root.getChildren().remove(pUnit1);
		root.getChildren().remove(pUnit2);
		root.getChildren().remove(pUnit3);
		root.getChildren().remove(pUnit4);
		root.getChildren().remove(pUnit5);
		root.getChildren().remove(pUnit6);
		addUnitIcons(root);
		
		root.getChildren().addAll(playerName, playerMoney);
	}
	
	public void addUnitIcons(AnchorPane root)
	{
		if(players.get(currentPlayer).getUnitList().size() >= 1)
		{
			pUnit1 = Tools.createImageView(players.get(currentPlayer).getUnitList().get(0).getIcon(), UNIT_ICON_SIZE, UNIT_ICON_SIZE, UNIT_X[0], UNIT_LIST_Y, 
				widthRatio, heightRatio, smallestRatio, Tools.SMALL_SHADE);
			root.getChildren().add(pUnit1);
		}
		if(players.get(currentPlayer).getUnitList().size() >= 2)
		{
			pUnit2 = Tools.createImageView(players.get(currentPlayer).getUnitList().get(1).getIcon(), UNIT_ICON_SIZE, UNIT_ICON_SIZE, UNIT_X[1], UNIT_LIST_Y, 
					widthRatio, heightRatio, smallestRatio, Tools.SMALL_SHADE);
			root.getChildren().add(pUnit2);
		}
		if(players.get(currentPlayer).getUnitList().size() >= 3)
		{
			pUnit3 = Tools.createImageView(players.get(currentPlayer).getUnitList().get(2).getIcon(), UNIT_ICON_SIZE, UNIT_ICON_SIZE, UNIT_X[2], UNIT_LIST_Y, 
					widthRatio, heightRatio, smallestRatio, Tools.SMALL_SHADE);
			root.getChildren().add(pUnit3);
		}
		if(players.get(currentPlayer).getUnitList().size() >= 4)
		{
			pUnit4 = Tools.createImageView(players.get(currentPlayer).getUnitList().get(3).getIcon(), UNIT_ICON_SIZE, UNIT_ICON_SIZE, UNIT_X[3], UNIT_LIST_Y, 
					widthRatio, heightRatio, smallestRatio, Tools.SMALL_SHADE);
			root.getChildren().add(pUnit4);
		}
		if(players.get(currentPlayer).getUnitList().size() >= 5)
		{
			pUnit5 = Tools.createImageView(players.get(currentPlayer).getUnitList().get(4).getIcon(), UNIT_ICON_SIZE, UNIT_ICON_SIZE, UNIT_X[4], UNIT_LIST_Y, 
					widthRatio, heightRatio, smallestRatio, Tools.SMALL_SHADE);
			root.getChildren().add(pUnit5);
		}
		if(players.get(currentPlayer).getUnitList().size() == 6)
		{
			pUnit6 = Tools.createImageView(players.get(currentPlayer).getUnitList().get(5).getIcon(), UNIT_ICON_SIZE, UNIT_ICON_SIZE, UNIT_X[5], UNIT_LIST_Y, 
					widthRatio, heightRatio, smallestRatio, Tools.SMALL_SHADE);
			root.getChildren().add(pUnit6);
		}
	}
	
	public Text createGameCloseButton(AnchorPane root)
	{
		Text close = Tools.createText(CLOSE_X, CLOSE_Y, widthRatio, heightRatio, "X", Color.LIGHTGRAY, Tools.SMALL_SHADE, Tools.createFont("Bookman Old Style", null, 30, smallestRatio));

		close.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				closeGameScreen();
			}
        });
		
		return close;
	}
	
	public Text createGameMinButton(AnchorPane root)
	{
		Text minimize = Tools.createText(MIN_X, MIN_Y, widthRatio, heightRatio, "-", Color.LIGHTGRAY, Tools.SMALL_SHADE, Tools.createFont("Bookman Old Style", null, 30, smallestRatio));
		
		minimize.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				minimizeGameScreen();
			}
        });
		
		return minimize;
	}
	
	public void createNameSet(int players)
	{
		nameSet = new Stage();
		nameSet.initStyle(StageStyle.TRANSPARENT);
		
		AnchorPane root = new AnchorPane();
		Scene scene = new Scene(root, NAME_SET_WIDTH * widthRatio, NAME_SET_HEIGHT * heightRatio);
		
		Rectangle ok = createNameSetOK(root);
		Text close = createNameCloseButton();
		root.setEffect(Tools.LARGE_SHADE);
		
		createNameTextFields(root, players);
		
		root.getChildren().addAll(ok, close);
		
		root.setBackground(new Background(NAME_SET));
		nameSet.setScene(scene);
		nameSet.show();
	}
	
	public void createNameTextFields(AnchorPane root, int numPlayers)
	{
		firstName = Tools.createTextField(FIELD_WIDTH, FIELD_HEIGHT, TEXT_X, FIRST_Y, widthRatio, heightRatio, FIRST_TEXT, Tools.LARGE_OUT_SHADE);
		secondName = Tools.createTextField(FIELD_WIDTH, FIELD_HEIGHT, TEXT_X, SECOND_Y, widthRatio, heightRatio, SECOND_TEXT, Tools.LARGE_OUT_SHADE);
		
		//these will always be added
		root.getChildren().addAll(firstName,secondName);
		
		if(numPlayers >= 3)
		{
			thirdName = Tools.createTextField(FIELD_WIDTH, FIELD_HEIGHT, TEXT_X, THIRD_Y, widthRatio, heightRatio, THIRD_TEXT, Tools.LARGE_OUT_SHADE);
			root.getChildren().add(thirdName);
		}
		if(numPlayers == 4)
		{
			fourthName = Tools.createTextField(FIELD_WIDTH, FIELD_HEIGHT, TEXT_X, FOURTH_Y, widthRatio, heightRatio, FOURTH_TEXT, Tools.LARGE_OUT_SHADE);
			root.getChildren().add(fourthName);
		}
	}
	
	public Text createNameCloseButton()
	{
		Text close = Tools.createText(NAME_CLOSE_X, NAME_CLOSE_Y, widthRatio, heightRatio, "X", Tools.DARK_GREEN, 
				Tools.SMALL_SHADE, Tools.createFont("Bookman Old Style", null, 25, smallestRatio));

		close.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				Stage back = new IntroUI(widthRatio, heightRatio, smallestRatio);
				back.show();
				closeNameSet();
			}
        });
		return close;
	}
	
	public Rectangle createNameSetOK(AnchorPane root)
	{
		Rectangle okPanel = Tools.createRoundedRectangle(NAME_OK_WIDTH, NAME_OK_HEIGHT, NAME_OK_ARC_SIZE, NAME_OK_ARC_SIZE, NAME_OK_X, NAME_OK_Y, 
				widthRatio, heightRatio, smallestRatio, Tools.TRANSPARENT, null);
		
		okPanel.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				root.setBackground(new Background(NAME_SET_CLICKED));
			}
        });
		okPanel.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				root.setBackground(new Background(NAME_SET));
				if(checkTextfields())
				{
					createPlayers();
					createGameUI();
					closeNameSet();
				}
			}
        });
		return okPanel;
	}
	
	public boolean checkTextfields()
	{
		boolean checker = true;
		checker = firstName.getText().length() <= MAX_LENGTH && firstName.getText().length() > 0;
		checker = checker && (secondName.getText().length() <= MAX_LENGTH && secondName.getText().length() > 0);
		checker = checker && ((thirdName == null ) ? true : thirdName.getText().length() <= MAX_LENGTH && thirdName.getText().length() > 0);
		checker = checker && ((fourthName == null) ? true : fourthName.getText().length() <= MAX_LENGTH && fourthName.getText().length() > 0);
		
		HashSet<String> tempCheck = new HashSet<String>();
		tempCheck.add(firstName.getText());
		tempCheck.add(secondName.getText());
		if(thirdName != null)
			tempCheck.add(thirdName.getText());
		if(fourthName != null)
			tempCheck.add(fourthName.getText());
		
		checker = checker && tempCheck.size() == numPlayers;
		
		return checker;
	}
	
	public void createPlayers()
	{
		players = new ArrayList<Player>();
		
		players.add(new Player(firstName.getText()));
		players.add(new Player(secondName.getText()));
		if(thirdName != null)
			players.add(new Player(thirdName.getText()));
		if(fourthName != null)
			players.add(new Player(fourthName.getText()));
		
		currentPlayer = 0;
	}
	
	public void closeGameScreen()
	{
		Stage back = new IntroUI(widthRatio, heightRatio, smallestRatio);
		back.show();
		this.close();
	}
	
	public void minimizeGameScreen()
	{
		this.setIconified(true);
	}
	
	public void closeNameSet()
	{
		nameSet.close();
	}
}
