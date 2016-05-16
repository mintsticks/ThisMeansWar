import java.util.*;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
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
	
	public static final int END_Y = 155;
	public static final int END_X = 301;
	public static final int END_HEIGHT = 50;
	public static final int END_WIDTH = 136;
	
	public static final int PANE_Y = 42;
	public static final int PANE_X = 476;
	
	public static final Image GRASSY_GROUND_IMAGE = Tools.createImage("GameGrassyBack.png");
	public static final Image GRASSY_GROUND_CLICKED_IMAGE = Tools.createImage("GameGrassyBackClicked.png");
	public static final Image NAME_SET_IMAGE = Tools.createImage("NameSelect.png");
	public static final Image NAME_SET_CLICKED_IMAGE = Tools.createImage("NameSelectClicked.png");
	
	public static final BackgroundImage GRASSY_GROUND = new BackgroundImage(GRASSY_GROUND_IMAGE, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(GRASSY_GROUND_IMAGE.getWidth(), GRASSY_GROUND_IMAGE.getHeight(), false, false, false, false));
	public static final BackgroundImage GRASSY_GROUND_CLICKED = new BackgroundImage(GRASSY_GROUND_CLICKED_IMAGE, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(GRASSY_GROUND_CLICKED_IMAGE.getWidth(), GRASSY_GROUND_CLICKED_IMAGE.getHeight(), false, false, false, false));
	public static final BackgroundImage NAME_SET = new BackgroundImage(NAME_SET_IMAGE, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(NAME_SET_IMAGE.getWidth(), NAME_SET_IMAGE.getHeight(), false, false, true, false));
	public static final BackgroundImage NAME_SET_CLICKED = new BackgroundImage(NAME_SET_CLICKED_IMAGE, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(NAME_SET_CLICKED_IMAGE.getWidth(), NAME_SET_CLICKED_IMAGE.getHeight(), false, false, true, false));
	
	public static final double GAME_WIDTH = 1920;
	public static final double GAME_HEIGHT = 1080;
	
	public static final double GAME_PANE_WIDTH = 1401;
	public static final double GAME_PANE_HEIGHT = 997;
	
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
	
	
	public static final DropShadow[] TEAM_EFFECTS = {Tools.RED_OUT_SHADE, Tools.CYAN_OUT_SHADE, Tools.GREEN_OUT_SHADE, Tools.PINK_OUT_SHADE};
	public static final int MAX_LENGTH = 12;
	
	public static final double PLAYER_NAME_X = 175;
	public static final double PLAYER_NAME_Y = 23;
	public static final double PLAYER_MONEY_X = 125;
	public static final double PLAYER_MONEY_Y = 95;
	public static final int NAME_SIZE = 50;
	public static final int MONEY_SIZE = 35;
	
	public static final double UNIT_ICON_SIZE = 55;
	public static final double[] UNIT_X = {30, 101, 170, 239, 309, 380};
	public static final double UNIT_LIST_Y = 226;
	
	public static final double[] BASE_X = {0, 1138.5, 0, 1138.5};
	public static final double[] BASE_Y = {0, 0, 869.5, 869.5};
	public static final double[] BASE_UNIT_X = {10, 1148.5, 10, 1148.5};
	public static final double[] BASE_UNIT_Y = {10, 10, 879.5, 879.5};
	
	public static final double SCALE = .75;
	public static final double CORP_WIDTH = 200 * SCALE;
	public static final double CORP_HEIGHT = 86 * SCALE;
	public static final double PRIV_WIDTH = 180 * SCALE;
	public static final double PRIV_HEIGHT = 78.4 * SCALE;
	public static final double SCOUT_WIDTH = 211 * SCALE;
	public static final double SCOUT_HEIGHT = 89 * SCALE;
	public static final double SERG_WIDTH = 220 * SCALE;
	public static final double SERG_HEIGHT = 100 * SCALE;
	public static final double SNIP_WIDTH = 308.7 * SCALE;
	public static final double SNIP_HEIGHT = 140.4 * SCALE;
	public static final double TANK_WIDTH = 320 * SCALE;
	public static final double TANK_HEIGHT = 148 * SCALE;
	
	public static final double BUY_SIZE = 75;
	public static final double RECT_ARC_SIZE = 10;
	public static final double BUY_PRIV_X = 30;
	public static final double BUY_PRIV_Y = 860;
	public static final double BUY_CORP_X = 170;
	public static final double BUY_CORP_Y = 860;
	public static final double BUY_SERG_X = 309;
	public static final double BUY_SERG_Y = 860;
	public static final double BUY_TANK_X = 30;
	public static final double BUY_TANK_Y = 960;
	public static final double BUY_SNIPER_X = 170;
	public static final double BUY_SNIPER_Y = 960;
	public static final double BUY_SCOUT_X = 309;
	public static final double BUY_SCOUT_Y = 960;
	
	public static final int PRIV_COST = 100;
	public static final int CORP_COST = 200;
	public static final int SERG_COST = 300;
	public static final int SCOUT_COST = 200;
	public static final int SNIP_COST = 200;
	public static final int TANK_COST = 400;
	
	public static final int MAX_UNIT_LIST = 6;
	
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
	private ImageView[] pUnit = new ImageView[MAX_UNIT_LIST];
	
	//check for if player has no units or if game is over after a bullet is fired
	
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
	
	public void addBases(AnchorPane root)
	{
		for(int k = 0; k < numPlayers; k++)
		{
			Obstacle base = Tools.createBase(127.5, 262.5, BASE_X[k], BASE_Y[k], widthRatio, heightRatio, smallestRatio, TEAM_EFFECTS[k]);
			root.getChildren().add(base);
		}
	}
	
	public void addUnitIcons(final AnchorPane root)
	{
		for(int index = 0; index < players.get(currentPlayer).getUnitList().size(); index++)
		{
			if(players.get(currentPlayer).getUnitList().size() > index)
			{
				pUnit[index] = Tools.createImageView(players.get(currentPlayer).getUnitList().get(index).getIcon(), UNIT_ICON_SIZE, UNIT_ICON_SIZE, UNIT_X[index], UNIT_LIST_Y, 
						widthRatio, heightRatio, smallestRatio, Tools.SMALL_SHADE);
				
				final int F_INDEX = index;
				pUnit[index].setOnMousePressed(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent arg0) {
						currentUnit = players.get(currentPlayer).getUnitList().get(F_INDEX);
						selectUnit();
					}
		        });
				
				root.getChildren().add(pUnit[index]);
			}
		}
	}
	
	public boolean checkPurchase(int cost)
	{
		boolean checker = true;
		
		checker = players.get(currentPlayer).getAmountOfMoney() >= cost;
		checker = checker & players.get(currentPlayer).getUnitList().size() < 6;
		
		return checker;
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
	
	public void closeGameScreen()
	{
		Stage back = new IntroUI(widthRatio, heightRatio, smallestRatio);
		back.show();
		this.close();
	}
	
	public void closeNameSet()
	{
		nameSet.close();
	}
	
	public void createBuyCorporalPanel(final AnchorPane root)
	{
		Rectangle corpPanel = Tools.createRoundedRectangle(BUY_SIZE, BUY_SIZE, RECT_ARC_SIZE, RECT_ARC_SIZE, BUY_CORP_X, BUY_CORP_Y, 
				widthRatio, heightRatio, smallestRatio, Tools.TRANSPARENT, null);
		
		corpPanel.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				if(checkPurchase(CORP_COST))
				{	
					Unit corp = Tools.createCorporal(CORP_HEIGHT, CORP_WIDTH, 0, BASE_UNIT_X[currentPlayer], BASE_UNIT_Y[currentPlayer], widthRatio, heightRatio, smallestRatio, TEAM_EFFECTS[currentPlayer]);
					players.get(currentPlayer).deductMoney(CORP_COST);
					players.get(currentPlayer).getUnitList().add(corp);
					gamePane.getChildren().add(corp);
					updateInfo(root);
				}
			}
        });
		root.getChildren().add(corpPanel);
	}
	
	public void createBuyPrivatePanel(final AnchorPane root)
	{
		Rectangle privatePanel = Tools.createRoundedRectangle(BUY_SIZE, BUY_SIZE, RECT_ARC_SIZE, RECT_ARC_SIZE, BUY_PRIV_X, BUY_PRIV_Y, 
				widthRatio, heightRatio, smallestRatio, Tools.TRANSPARENT, null);
		
		privatePanel.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				if(checkPurchase(PRIV_COST))
				{	
					Unit priv = Tools.createPrivate(PRIV_HEIGHT, PRIV_WIDTH, 0, BASE_UNIT_X[currentPlayer], BASE_UNIT_Y[currentPlayer], widthRatio, heightRatio, smallestRatio, TEAM_EFFECTS[currentPlayer]);
					players.get(currentPlayer).deductMoney(PRIV_COST);
					players.get(currentPlayer).getUnitList().add(priv);
					gamePane.getChildren().add(priv);
					updateInfo(root);
				}
			}
        });
		root.getChildren().add(privatePanel);
	}
	
	public void createBuyScoutPanel(final AnchorPane root)
	{
		Rectangle scoutPanel = Tools.createRoundedRectangle(BUY_SIZE, BUY_SIZE, RECT_ARC_SIZE, RECT_ARC_SIZE, BUY_SCOUT_X, BUY_SCOUT_Y, 
				widthRatio, heightRatio, smallestRatio, Tools.TRANSPARENT, null);
		
		scoutPanel.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				if(checkPurchase(SCOUT_COST))
				{
					Unit scout = Tools.createScout(SCOUT_HEIGHT, SCOUT_WIDTH, 0, BASE_UNIT_X[currentPlayer], BASE_UNIT_Y[currentPlayer], widthRatio, heightRatio, smallestRatio, TEAM_EFFECTS[currentPlayer]);
					players.get(currentPlayer).deductMoney(SCOUT_COST);
					players.get(currentPlayer).getUnitList().add(scout);
					gamePane.getChildren().add(scout);
					updateInfo(root);
				}
			}
        });
		root.getChildren().add(scoutPanel);
	}
	
	public void addPlayerUnit(Unit unit)
	{
		//unit.setLayoutX(value);
		gamePane.getChildren().add(unit);
	}
	public void createBuySergPanel(final AnchorPane root)
	{
		Rectangle sergPanel = Tools.createRoundedRectangle(BUY_SIZE, BUY_SIZE, RECT_ARC_SIZE, RECT_ARC_SIZE, BUY_SERG_X, BUY_SERG_Y, 
				widthRatio, heightRatio, smallestRatio, Tools.TRANSPARENT, null);
		
		sergPanel.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				if(checkPurchase(SERG_COST))
				{
					Unit serg = Tools.createSergeant(SERG_HEIGHT, SERG_WIDTH, 0, BASE_UNIT_X[currentPlayer], BASE_UNIT_Y[currentPlayer], widthRatio, heightRatio, smallestRatio, TEAM_EFFECTS[currentPlayer]);
					players.get(currentPlayer).deductMoney(SERG_COST);
					players.get(currentPlayer).getUnitList().add(serg);
					gamePane.getChildren().add(serg);
					updateInfo(root);
				}
			}
        });
		root.getChildren().add(sergPanel);
	}
	
	public void createBuySniperPanel(final AnchorPane root)
	{
		Rectangle snipPanel = Tools.createRoundedRectangle(BUY_SIZE, BUY_SIZE, RECT_ARC_SIZE, RECT_ARC_SIZE, BUY_SNIPER_X, BUY_SNIPER_Y, 
				widthRatio, heightRatio, smallestRatio, Tools.TRANSPARENT, null);
		
		snipPanel.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				if(checkPurchase(SNIP_COST))
				{
					Unit snip = Tools.createSniper(SNIP_HEIGHT, SNIP_WIDTH, 0, BASE_UNIT_X[currentPlayer], BASE_UNIT_Y[currentPlayer], widthRatio, heightRatio, smallestRatio, TEAM_EFFECTS[currentPlayer]);
					players.get(currentPlayer).deductMoney(SNIP_COST);
					players.get(currentPlayer).getUnitList().add(snip);
					gamePane.getChildren().add(snip);
					updateInfo(root);
				}
			}
        });
		root.getChildren().add(snipPanel);
	}
	
	public void createBuyTankPanel(final AnchorPane root)
	{
		Rectangle tankPanel = Tools.createRoundedRectangle(BUY_SIZE, BUY_SIZE, RECT_ARC_SIZE, RECT_ARC_SIZE, BUY_TANK_X, BUY_TANK_Y, 
				widthRatio, heightRatio, smallestRatio, Tools.TRANSPARENT, null);
		
		tankPanel.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				if(checkPurchase(TANK_COST))
				{
					Unit tank = Tools.createTank(TANK_HEIGHT, TANK_WIDTH, 0, BASE_UNIT_X[currentPlayer], BASE_UNIT_Y[currentPlayer], widthRatio, heightRatio, smallestRatio, TEAM_EFFECTS[currentPlayer]);
					players.get(currentPlayer).deductMoney(TANK_COST);
					players.get(currentPlayer).getUnitList().add(tank);
					gamePane.getChildren().add(tank);
					updateInfo(root);
				}
			}
        });
		root.getChildren().add(tankPanel);
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
	
	public void createEndPanel(final AnchorPane root)
	{
		Rectangle endPanel = Tools.createRoundedRectangle(END_WIDTH, END_HEIGHT, RECT_ARC_SIZE, RECT_ARC_SIZE, END_X, END_Y, 
				widthRatio, heightRatio, smallestRatio, Tools.TRANSPARENT, null);
		
		endPanel.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				root.setBackground(new Background(GRASSY_GROUND_CLICKED));
			}
        });
		
		endPanel.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				root.setBackground(new Background(GRASSY_GROUND));
				currentPlayer = (currentPlayer + 1) % players.size();
				updateInfo(root);
			}
        });
		root.getChildren().add(endPanel);
	}
	public void selectUnit()
	{
		
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
		
		createBuyPrivatePanel(root);
		createBuyCorporalPanel(root);
		createBuySergPanel(root);
		createBuySniperPanel(root);
		createBuyTankPanel(root);
		createBuyScoutPanel(root);
		createEndPanel(root);
		
		gamePane = new AnchorPane();
		gamePane.setPrefSize(GAME_PANE_WIDTH * widthRatio, GAME_PANE_HEIGHT * heightRatio);
		
		AnchorPane.setLeftAnchor(gamePane, PANE_X * widthRatio);
		AnchorPane.setTopAnchor(gamePane, PANE_Y * heightRatio);
		
		addBases(gamePane);
		root.getChildren().addAll(close, minimize, gamePane);
		root.setBackground(new Background(GRASSY_GROUND));
		updateInfo(root);
		this.setScene(scene);
		this.show();
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
	
	public Rectangle createNameSetOK(final AnchorPane root)
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
	
	public void minimizeGameScreen()
	{
		this.setIconified(true);
	}
	
	public void updateInfo(AnchorPane root)
	{
		root.getChildren().removeAll(pUnit);
		root.getChildren().removeAll(playerName, playerMoney);
		playerName = Tools.createText(PLAYER_NAME_X, PLAYER_NAME_Y, widthRatio, heightRatio, players.get(currentPlayer).getName(), PLAYER_NAME,
				Tools.SMALL_SHADE, Tools.createFont("Agency FB", null, NAME_SIZE, smallestRatio));
		
		playerMoney = Tools.createText(PLAYER_MONEY_X, PLAYER_MONEY_Y, widthRatio, heightRatio, "$" + players.get(currentPlayer).getAmountOfMoney(), 
				PLAYER_MONEY, Tools.SMALL_SHADE,Tools.createFont("Agency FB", null, MONEY_SIZE, smallestRatio));
		
		
		addUnitIcons(root);
		
		root.getChildren().addAll(playerName, playerMoney);
	}
}
