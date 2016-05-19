import java.util.*;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Node;
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
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GameUI extends Stage
{
	// Constants for the map elements setup
	public static final int[] TREE_X = { 5, 1228, 580 };
	public static final int[] TREE_Y = { 465, 450, 850 };

	public static final int[] ROCK_X = { 675, 600, 1247, 1287, 1260, 501 };
	public static final int[] ROCK_Y = { 63, 70, 359, 365, 400, 844 };

	public static double FIELD_SCALE = .8;
	public static final double SMALL_ROCK_SIZE = 40 * FIELD_SCALE;
	public static final double MEDIUM_ROCK_SIZE = 50 * FIELD_SCALE;
	public static final double LARGE_ROCK_SIZE = 60 * FIELD_SCALE;
	public static final double SUPER_LARGE_ROCK_SIZE = 85 * FIELD_SCALE;
	public static final double MEDIUM_TREE_SIZE = 120 * FIELD_SCALE;
	public static final double HOUSE_TWO_Y = 350;
	public static final double HOUSE_TWO_X = 791;
	public static final double HOUSE_TWO_HEIGHT = 313 * FIELD_SCALE;
	public static final double HOUSE_TWO_WIDTH = 286 * FIELD_SCALE;

	public static final double HOUSE_ONE_Y = 368;
	public static final double HOUSE_ONE_X = 270;
	public static final double HOUSE_ONE_HEIGHT = 261 * FIELD_SCALE;
	public static final double HOUSE_ONE_WIDTH = 400 * FIELD_SCALE;

	public static final double WINNER_SIZE = 72;
	public static final double WINNER_Y = 176;
	public static final double WINNER_X = 215;
	public static final double EXIT_PANEL_Y = 352;
	public static final double EXIT_PANEL_X = 151;
	public static final double EXIT_PANEL_HEIGHT = 77;
	public static final double EXIT_PANEL_WIDTH = 407;
	public static final double END_SCREEN_HEIGHT = 500;
	public static final double END_SCREEN_WIDTH = 720;

	public static final int MIN_MONEY_SPAWN = 100;
	public static final int MIN_MONEY = 50;
	public static final double TWO_MONEY_CHANCE = .05;
	public static final double ONE_MONEY_CHANCE = .15;

	public static final int BULLET_SPEED = 400;
	public static final int BULLET_WIDTH = 20;
	public static final int BULLET_HEIGHT = 10;
	public static final int DAMAGE_Y = 575;
	public static final int DAMAGE_X = 180;
	public static final int MOVE_RANGE_Y = 530;
	public static final int MOVE_RANGE_X = 305;
	public static final int STAT_SIZE = 30;
	public static final int ATTACK_RANGE_Y = 480;
	public static final int ATTACK_RANGE_X = 270;
	public static final int HEALTH_TEXT_SIZE = 25;
	public static final int HEALTH_TEXT_Y = 441;
	public static final int HEALTH_TEXT_X = 200;
	public static final int HEALTH_Y = 441;
	public static final int HEALTH_X = 30;
	public static final int HEALTH_MAX_HEIGHT = 30;
	public static final int HEALTH_MAX_WIDTH = 405;
	public static final int TYPE_SIZE = 40;
	public static final int TYPE_Y = 350;
	public static final int TYPE_X = 215;
	public static final int ICON_Y = 352;
	public static final int ICON_X = 29;
	public static final int ICON_SIZE = 76;
	public static final int TEXT_SIZE = 40;
	public static final double TEXT_Y = 660.96;

	public static final double ATTACK_TEXT_X = 63.52;
	public static final int ATTACK_BUTTON_X = 44;
	public static final int ATTACK_BUTTON_WIDTH = 123;

	public static final int MOVE_BUTTON_X = 182;
	public static final double MOVE_TEXT_X = 200.18;
	public static final double MOVE_BUTTON_WIDTH = 110;

	public static final int SKIP_BUTTON_X = 306;
	public static final double SKIP_TEXT_X = 336.33;
	public static final double SKIP_BUTTON_WIDTH = 116;

	public static final int BUTTON_Y = 661;
	public static final int BUTTON_HEIGHT = 51;

	public static final double BASE_WIDTH = 262.5;
	public static final double BASE_HEIGHT = 127.5;

	public static final int END_Y = 155;
	public static final int END_X = 301;
	public static final int END_HEIGHT = 50;
	public static final int END_WIDTH = 136;

	public static final int PANE_Y = 42;
	public static final int PANE_X = 476;

	public static final Image GRASSY_GROUND_IMAGE = Tools
			.createImage("GameGrassyBack.png");
	public static final Image GRASSY_GROUND_CLICKED_IMAGE = Tools
			.createImage("GameGrassyBackClicked.png");
	public static final Image NAME_SET_IMAGE = Tools
			.createImage("NameSelect.png");
	public static final Image NAME_SET_CLICKED_IMAGE = Tools
			.createImage("NameSelectClicked.png");
	public static final Image END_SCREEN_IMAGE = Tools
			.createImage("EndScreen.png");
	public static final Image END_SCREEN_CLICKED_IMAGE = Tools
			.createImage("EndScreenClicked.png");

	public static final double GAME_WIDTH = 1920;
	public static final double GAME_HEIGHT = 1080;
	public static final int GAME_CONTROL_SIZE = 30;

	public static final double GAME_PANE_WIDTH = 1401;
	public static final double GAME_PANE_HEIGHT = 997;
	public static final int NAME_SET_WIDTH = 600;

	public static final int NAME_SET_HEIGHT = 400;
	public static final double CLOSE_X = 1880;

	public static final double CLOSE_Y = 2;
	public static final int NAME_CLOSE_SIZE = 25;

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
	// Gradient for attack button
	public static final Stop[] SKIP_STOP = { new Stop(0, Color.web("#eeeeee")),
			new Stop(0.25, Color.web("#999999")),
			new Stop(.55, Color.web("#cdcdcd")),
			new Stop(.8, Color.web("#979797")),
			new Stop(1.0, Color.web("#e5e5e5")) };

	public static final LinearGradient GRADIENT_SKIP = new LinearGradient(0, 0,
			0, 1, true, CycleMethod.NO_CYCLE, SKIP_STOP);
	public static final Stop[] MOVE_STOP = {
			new Stop(0.0, Color.web("#eefde7")),
			new Stop(0.1, Color.web("#86e74b")),
			new Stop(.25, Color.web("#55be30")),
			new Stop(.55, Color.web("#88ea4c")),
			new Stop(.8, Color.web("#479211")),
			new Stop(1.0, Color.web("#95dc87")) };

	public static final LinearGradient GRADIENT_MOVE = new LinearGradient(0, 0,
			0, 1, true, CycleMethod.NO_CYCLE, MOVE_STOP);
	public static final Stop[] ATTACK_STOP = {
			new Stop(0.0, Color.web("#fde0d8")),
			new Stop(0.1, Color.web("#e65b48")),
			new Stop(.25, Color.web("#c22905")),
			new Stop(.55, Color.web("#dc5a4d")),
			new Stop(.8, Color.web("#ad0707")),
			new Stop(1.0, Color.web("#e6a89c")) };

	public static final LinearGradient GRADIENT_ATTACK = new LinearGradient(0,
			0, 0, 1, true, CycleMethod.NO_CYCLE, ATTACK_STOP);
	public static final Stop[] HEALTH_STOP = {
			new Stop(0.0, Color.web("#dfb5aa")),
			new Stop(0.1, Color.web("#e65b48")),
			new Stop(.25, Color.web("#e53030")),
			new Stop(.55, Color.web("#f0786f")),
			new Stop(.8, Color.web("#de3434")),
			new Stop(1.0, Color.web("#f49886")) };

	public static final LinearGradient GRADIENT_HEALTH = new LinearGradient(0,
			0, 0, 1, true, CycleMethod.NO_CYCLE, HEALTH_STOP);
	public static final Stop[] ATTACK_CIRCLE_STOP = {
			new Stop(0.0, Color.web("#ffffff00")),
			new Stop(1.0, Color.web("#ffffff55")) };

	public static final RadialGradient GRADIENT_CIRCLE = new RadialGradient(0,
			0, .5, .5, .5, true, CycleMethod.NO_CYCLE, ATTACK_CIRCLE_STOP);
	public static final DropShadow[] TEAM_EFFECTS = { Tools.RED_OUT_SHADE,
			Tools.CYAN_OUT_SHADE, Tools.GREEN_OUT_SHADE, Tools.PINK_OUT_SHADE };

	public static final int MAX_LENGTH = 12;
	public static final double PLAYER_NAME_X = 175;
	public static final double PLAYER_NAME_Y = 23;
	public static final double PLAYER_MONEY_X = 125;

	public static final double PLAYER_MONEY_Y = 95;
	public static final int NAME_SIZE = 50;
	public static final int MONEY_SIZE = 35;
	public static final double UNIT_ICON_SIZE = 55;
	public static final double[] UNIT_X = { 30, 101, 170, 239, 309, 380 };
	public static final double UNIT_LIST_Y = 226;

	public static final double[] BASE_X = { 0, 1138.5, 0, 1138.5 };
	public static final double[] BASE_Y = { 0, 0, 869.5, 869.5 };
	public static final double[] BASE_UNIT_X = { 10, 1148.5, 10, 1148.5 };

	public static final double[] BASE_UNIT_Y = { 10, 10, 879.5, 879.5 };
	public static final double SCALE = .6;
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

	public final BackgroundImage ground;
	public final BackgroundImage groundClicked;
	public final BackgroundImage nameSetBack;
	public final BackgroundImage nameSetClicked;
	public final BackgroundImage endScreenBack;
	public final BackgroundImage endScreenClicked;

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

	// Display unit list
	private ImageView[] pUnit = new ImageView[MAX_UNIT_LIST];

	private ImageView selectIcon;
	private Text selectType;
	private Rectangle selectHealthBar;
	private Text selectHealthText;
	private Text selectAttRange;
	private Text selectMoveRange;
	private Text selectDamage;

	private Rectangle attackButton;
	private Text attackText;
	private Rectangle moveButton;
	private Text moveText;
	private Rectangle skipButton;
	private Text skipText;
	// check for if player has no units or if game is over after
	// a bullet is fired

	private int currentPlayer;
	private Unit currentUnit;
	private AnchorPane gamePane;
	private AnchorPane root;

	private AnchorPane endRoot;
	// Used to deselect the unit if the player clicks outside of the unit range
	private AnchorPane coverPane;
	private Rectangle clipAttack;
	private Rectangle clipMove;
	private Ellipse attackEllipse;
	private boolean attacking;
	// Rotates around the z- axis (birds eye view)
	private final Rotate direction = new Rotate(0, Rotate.Z_AXIS);
	private double prevTime;

	private Ellipse moveEllipse;

	private Stage nameSet;
	private Stage endScreen;

	public GameUI(int numPlayers, double widthRatio, double heightRatio,
			double smallestRatio)
	{
		this.widthRatio = widthRatio;
		this.heightRatio = heightRatio;
		this.smallestRatio = smallestRatio;
		this.numPlayers = numPlayers;
		ground = new BackgroundImage(GRASSY_GROUND_IMAGE,
				BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
				BackgroundPosition.DEFAULT,
				new BackgroundSize(GRASSY_GROUND_IMAGE.getWidth() * widthRatio,
						GRASSY_GROUND_IMAGE.getHeight() * heightRatio, false,
						false, false, false));
		groundClicked = new BackgroundImage(GRASSY_GROUND_CLICKED_IMAGE,
				BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
				BackgroundPosition.DEFAULT,
				new BackgroundSize(
						GRASSY_GROUND_CLICKED_IMAGE.getWidth() * widthRatio,
						GRASSY_GROUND_CLICKED_IMAGE.getHeight() * heightRatio,
						false, false, false, false));
		nameSetBack = new BackgroundImage(NAME_SET_IMAGE,
				BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
				BackgroundPosition.DEFAULT,
				new BackgroundSize(NAME_SET_IMAGE.getWidth() * widthRatio,
						NAME_SET_IMAGE.getHeight() * heightRatio, false, false,
						false, false));
		nameSetClicked = new BackgroundImage(NAME_SET_CLICKED_IMAGE,
				BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
				BackgroundPosition.DEFAULT,
				new BackgroundSize(
						NAME_SET_CLICKED_IMAGE.getWidth() * widthRatio,
						NAME_SET_CLICKED_IMAGE.getHeight() * heightRatio, false,
						false, false, false));
		endScreenBack = new BackgroundImage(END_SCREEN_IMAGE,
				BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
				BackgroundPosition.DEFAULT,
				new BackgroundSize(END_SCREEN_IMAGE.getWidth() * widthRatio,
						END_SCREEN_IMAGE.getHeight() * heightRatio, false,
						false, false, false));
		endScreenClicked = new BackgroundImage(END_SCREEN_CLICKED_IMAGE,
				BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
				BackgroundPosition.DEFAULT,
				new BackgroundSize(
						END_SCREEN_CLICKED_IMAGE.getWidth() * widthRatio,
						END_SCREEN_CLICKED_IMAGE.getHeight() * heightRatio,
						false, false, false, false));
		createNameSet(numPlayers);
	}

	public void addBases(AnchorPane root)
	{
		for (int k = 0; k < numPlayers; k++)
		{
			Obstacle base = Tools.createBase(BASE_HEIGHT, BASE_WIDTH, BASE_X[k],
					BASE_Y[k], widthRatio, heightRatio, smallestRatio,
					TEAM_EFFECTS[k]);
			moveElement(base, base.getLayoutX(), base.getLayoutY(), 0);
			root.getChildren().add(base.getCollShape());
			root.getChildren().add(base);
		}
	}

	public void addPlayerUnit(Unit unit)
	{
		gamePane.getChildren().add(unit);
	}

	public void addUnitIcons()
	{
		for (int index = 0; index < players.get(currentPlayer).getUnitList()
				.size(); index++)
		{
			if (players.get(currentPlayer).getUnitList().size() > index)
			{
				pUnit[index] = Tools.createImageView(
						players.get(currentPlayer).getUnitList().get(index)
								.getIcon(),
						UNIT_ICON_SIZE, UNIT_ICON_SIZE, UNIT_X[index],
						UNIT_LIST_Y, widthRatio, heightRatio, smallestRatio,
						Tools.SMALL_SHADE);

				final int F_INDEX = index;
				pUnit[index].setOnMousePressed(new EventHandler<MouseEvent>()
				{
					@Override
					public void handle(MouseEvent arg0)
					{
						refreshSelect();
						selectUnit(players.get(currentPlayer).getUnitList()
								.get(F_INDEX));
					}
				});

				root.getChildren().add(pUnit[index]);
			}
		}
	}

	public void attackClick(double mouseX, double mouseY)
	{
		currentUnit.attack();
		attackEllipse.setVisible(false);

		double unitX = currentUnit.getLayoutX() + currentUnit.getFitWidth() / 2;
		double unitY = currentUnit.getLayoutY()
				+ currentUnit.getFitHeight() / 2;
		double bulletDirection = Math
				.toDegrees(Math.atan2(mouseY - unitY, mouseX - unitX));

		// Generate offset in x and y direction
		double xDist = unitX - mouseX;
		double yDist = unitY - mouseY;
		double totalDist = Math.sqrt(xDist * xDist + yDist * yDist);

		Projectile bullet = Tools.createProjectile(currentUnit.getDamage(),
				BULLET_HEIGHT, BULLET_WIDTH, bulletDirection,
				unitX / widthRatio - 75 * xDist / totalDist,
				unitY / heightRatio - 75 * yDist / totalDist, widthRatio,
				heightRatio, smallestRatio, TEAM_EFFECTS[currentPlayer]);
		gamePane.getChildren().add(bullet);
		gamePane.getChildren().add(bullet.getCollShape());
		fireBullet(bullet, mouseX, mouseY, bulletDirection);

	}

	public void chanceAddMoney()
	{
		double chance = Math.random();
		if (chance <= ONE_MONEY_CHANCE)
		{
			genMoney();
		}
		if (chance <= TWO_MONEY_CHANCE)
		{
			genMoney();
		}
	}

	public void checkEndGame()
	{
		createEnd(1);
		int winnerIndex = -1;
		int nonNull = 0;
		for (int k = 0; k < players.size(); k++)
		{
			if (players.get(k) != null)
			{
				nonNull++;
				winnerIndex = k;
			}
		}

		if (nonNull == 1)
		{
			createEnd(winnerIndex);
		}
	}

	public void checkPlayer()
	{
		for (int k = 0; k < players.size(); k++)
		{
			Player person = players.get(k);
			if (person != null)
			{
				if (person.getUnitList().size() == 0
						&& person.getAmountOfMoney() < 100)
				{
					players.set(k, null);
				}
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
		checker = firstName.getText().length() <= MAX_LENGTH
				&& firstName.getText().length() > 0;
		checker = checker && (secondName.getText().length() <= MAX_LENGTH
				&& secondName.getText().length() > 0);
		checker = checker && ((thirdName == null) ? true
				: thirdName.getText().length() <= MAX_LENGTH
						&& thirdName.getText().length() > 0);
		checker = checker && ((fourthName == null) ? true
				: fourthName.getText().length() <= MAX_LENGTH
						&& fourthName.getText().length() > 0);

		HashSet<String> tempCheck = new HashSet<String>();
		tempCheck.add(firstName.getText());
		tempCheck.add(secondName.getText());
		if (thirdName != null)
			tempCheck.add(thirdName.getText());
		if (fourthName != null)
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

	public void createAttackButton()
	{
		EventHandler<MouseEvent> in = new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				attackButton.setEffect(Tools.LARGE_SHADE);
			}
		};

		EventHandler<MouseEvent> out = new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				attackButton.setEffect(Tools.MEDIUM_OUT_SHADE);
				startAttack();
			}
		};

		attackButton = Tools.createRoundedRectangle(ATTACK_BUTTON_WIDTH,
				BUTTON_HEIGHT, RECT_ARC_SIZE, RECT_ARC_SIZE, ATTACK_BUTTON_X,
				BUTTON_Y, widthRatio, heightRatio, smallestRatio, Color.WHITE,
				Tools.MEDIUM_OUT_SHADE);
		attackButton.setFill(GRADIENT_ATTACK);

		attackButton.setOnMousePressed(in);
		attackButton.setOnMouseReleased(out);

		attackText = Tools.createText(ATTACK_TEXT_X, TEXT_Y, widthRatio,
				heightRatio, "attack", Color.DARKGRAY.darker(),
				Tools.SMALL_SHADE,
				Tools.createFont("Agency FB", null, TEXT_SIZE, smallestRatio));

		attackText.setOnMousePressed(in);
		attackText.setOnMouseReleased(out);

		root.getChildren().addAll(attackButton, attackText);
	}

	public void createButtons()
	{
		if (!currentUnit.hasAttacked())
		{
			createAttackButton();
		}
		if (!currentUnit.hasMoved())
		{
			createMoveButton();
		}
		if (!currentUnit.hasMoved() || !currentUnit.hasAttacked())
		{
			createSkipButton();
		}
	}

	public void createBuyCorporalPanel()
	{
		Rectangle corpPanel = Tools.createRoundedRectangle(BUY_SIZE, BUY_SIZE,
				RECT_ARC_SIZE, RECT_ARC_SIZE, BUY_CORP_X, BUY_CORP_Y,
				widthRatio, heightRatio, smallestRatio, Tools.TRANSPARENT,
				null);

		corpPanel.setOnMouseClicked(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				if (checkPurchase(CORP_COST))
				{
					final Unit corp = Tools.createCorporal(currentPlayer,
							CORP_HEIGHT, CORP_WIDTH, 0,
							BASE_UNIT_X[currentPlayer],
							BASE_UNIT_Y[currentPlayer], widthRatio, heightRatio,
							smallestRatio, TEAM_EFFECTS[currentPlayer]);
					// add the CollisionShape
					moveElement(corp, corp.getLayoutX(), corp.getLayoutY(), 0);
					players.get(currentPlayer).deductMoney(CORP_COST);
					players.get(currentPlayer).getUnitList().add(corp);

					corp.setOnMouseClicked(new EventHandler<MouseEvent>()
					{
						@Override
						public void handle(MouseEvent arg0)
						{
							refreshSelect();
							selectUnit(corp);
						}
					});
					gamePane.getChildren().add(corp.getCollShape());
					gamePane.getChildren().add(corp);
					updateInfo();
				}
			}
		});
		root.getChildren().add(corpPanel);
	}

	public void createBuyPanels()
	{
		createBuyPrivatePanel();
		createBuyCorporalPanel();
		createBuySergPanel();
		createBuySniperPanel();
		createBuyTankPanel();
		createBuyScoutPanel();
		createEndPanel();
	}

	public void createBuyPrivatePanel()
	{
		Rectangle privatePanel = Tools.createRoundedRectangle(BUY_SIZE,
				BUY_SIZE, RECT_ARC_SIZE, RECT_ARC_SIZE, BUY_PRIV_X, BUY_PRIV_Y,
				widthRatio, heightRatio, smallestRatio, Tools.TRANSPARENT,
				null);

		privatePanel.setOnMouseClicked(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				if (checkPurchase(PRIV_COST))
				{
					final Unit priv = Tools.createPrivate(currentPlayer,
							PRIV_HEIGHT, PRIV_WIDTH, 0,
							BASE_UNIT_X[currentPlayer],
							BASE_UNIT_Y[currentPlayer], widthRatio, heightRatio,
							smallestRatio, TEAM_EFFECTS[currentPlayer]);
					// add the CollisionShape
					moveElement(priv, priv.getLayoutX(), priv.getLayoutY(), 0);
					players.get(currentPlayer).deductMoney(PRIV_COST);
					players.get(currentPlayer).getUnitList().add(priv);

					priv.setOnMouseClicked(new EventHandler<MouseEvent>()
					{
						@Override
						public void handle(MouseEvent arg0)
						{
							refreshSelect();
							selectUnit(priv);
						}
					});
					gamePane.getChildren().add(priv.getCollShape());
					gamePane.getChildren().add(priv);
					updateInfo();
				}
			}
		});
		root.getChildren().add(privatePanel);
	}

	public void createBuyScoutPanel()
	{
		Rectangle scoutPanel = Tools.createRoundedRectangle(BUY_SIZE, BUY_SIZE,
				RECT_ARC_SIZE, RECT_ARC_SIZE, BUY_SCOUT_X, BUY_SCOUT_Y,
				widthRatio, heightRatio, smallestRatio, Tools.TRANSPARENT,
				null);

		scoutPanel.setOnMouseClicked(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				if (checkPurchase(SCOUT_COST))
				{
					final Unit scout = Tools.createScout(currentPlayer,
							SCOUT_HEIGHT, SCOUT_WIDTH, 0,
							BASE_UNIT_X[currentPlayer],
							BASE_UNIT_Y[currentPlayer], widthRatio, heightRatio,
							smallestRatio, TEAM_EFFECTS[currentPlayer]);
					// add the CollisionShape
					moveElement(scout, scout.getLayoutX(), scout.getLayoutY(),
							0);
					players.get(currentPlayer).deductMoney(SCOUT_COST);
					players.get(currentPlayer).getUnitList().add(scout);

					scout.setOnMouseClicked(new EventHandler<MouseEvent>()
					{
						@Override
						public void handle(MouseEvent arg0)
						{
							refreshSelect();
							selectUnit(scout);
						}
					});
					gamePane.getChildren().add(scout.getCollShape());
					gamePane.getChildren().add(scout);

					updateInfo();
				}
			}
		});
		root.getChildren().add(scoutPanel);
	}

	public void createBuySergPanel()
	{
		Rectangle sergPanel = Tools.createRoundedRectangle(BUY_SIZE, BUY_SIZE,
				RECT_ARC_SIZE, RECT_ARC_SIZE, BUY_SERG_X, BUY_SERG_Y,
				widthRatio, heightRatio, smallestRatio, Tools.TRANSPARENT,
				null);

		sergPanel.setOnMouseClicked(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				if (checkPurchase(SERG_COST))
				{
					final Unit serg = Tools.createSergeant(currentPlayer,
							SERG_HEIGHT, SERG_WIDTH, 0,
							BASE_UNIT_X[currentPlayer],
							BASE_UNIT_Y[currentPlayer], widthRatio, heightRatio,
							smallestRatio, TEAM_EFFECTS[currentPlayer]);
					// add the CollisionShape
					moveElement(serg, serg.getLayoutX(), serg.getLayoutY(), 0);
					players.get(currentPlayer).deductMoney(SERG_COST);
					players.get(currentPlayer).getUnitList().add(serg);

					serg.setOnMouseClicked(new EventHandler<MouseEvent>()
					{
						@Override
						public void handle(MouseEvent arg0)
						{
							refreshSelect();
							selectUnit(serg);
						}
					});
					gamePane.getChildren().add(serg.getCollShape());
					gamePane.getChildren().add(serg);
					updateInfo();
				}
			}
		});
		root.getChildren().add(sergPanel);
	}

	public void createBuySniperPanel()
	{
		Rectangle snipPanel = Tools.createRoundedRectangle(BUY_SIZE, BUY_SIZE,
				RECT_ARC_SIZE, RECT_ARC_SIZE, BUY_SNIPER_X, BUY_SNIPER_Y,
				widthRatio, heightRatio, smallestRatio, Tools.TRANSPARENT,
				null);

		snipPanel.setOnMouseClicked(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				if (checkPurchase(SNIP_COST))
				{
					final Unit snip = Tools.createSniper(currentPlayer,
							SNIP_HEIGHT, SNIP_WIDTH, 0,
							BASE_UNIT_X[currentPlayer],
							BASE_UNIT_Y[currentPlayer], widthRatio, heightRatio,
							smallestRatio, TEAM_EFFECTS[currentPlayer]);
					// add the CollisionShape
					moveElement(snip, snip.getLayoutX(), snip.getLayoutY(), 0);
					players.get(currentPlayer).deductMoney(SNIP_COST);
					players.get(currentPlayer).getUnitList().add(snip);

					snip.setOnMouseClicked(new EventHandler<MouseEvent>()
					{
						@Override
						public void handle(MouseEvent arg0)
						{
							refreshSelect();
							selectUnit(snip);
						}
					});
					gamePane.getChildren().add(snip.getCollShape());
					gamePane.getChildren().add(snip);
					updateInfo();
				}
			}
		});
		root.getChildren().add(snipPanel);
	}

	public void createBuyTankPanel()
	{
		Rectangle tankPanel = Tools.createRoundedRectangle(BUY_SIZE, BUY_SIZE,
				RECT_ARC_SIZE, RECT_ARC_SIZE, BUY_TANK_X, BUY_TANK_Y,
				widthRatio, heightRatio, smallestRatio, Tools.TRANSPARENT,
				null);

		tankPanel.setOnMouseClicked(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				if (checkPurchase(TANK_COST))
				{
					final Unit tank = Tools.createTank(currentPlayer,
							TANK_HEIGHT, TANK_WIDTH, 0,
							BASE_UNIT_X[currentPlayer],
							BASE_UNIT_Y[currentPlayer], widthRatio, heightRatio,
							smallestRatio, TEAM_EFFECTS[currentPlayer]);
					// add the CollisionShape
					moveElement(tank, tank.getLayoutX(), tank.getLayoutY(), 0);
					players.get(currentPlayer).deductMoney(TANK_COST);
					players.get(currentPlayer).getUnitList().add(tank);

					tank.setOnMouseClicked(new EventHandler<MouseEvent>()
					{
						@Override
						public void handle(MouseEvent arg0)
						{
							refreshSelect();
							selectUnit(tank);
						}
					});
					gamePane.getChildren().add(tank.getCollShape());
					gamePane.getChildren().add(tank);
					updateInfo();
				}
			}
		});
		root.getChildren().add(tankPanel);
	}

	public void createEnd(int winnerIndex)
	{
		endScreen = new Stage();
		endScreen.initStyle(StageStyle.TRANSPARENT);
		endScreen.initOwner(this);

		endRoot = new AnchorPane();
		Scene scene = new Scene(endRoot, END_SCREEN_WIDTH * widthRatio,
				END_SCREEN_HEIGHT * heightRatio);

		Text winner = Tools.createText(WINNER_X, WINNER_Y, widthRatio,
				heightRatio, players.get(winnerIndex).getName(),
				Color.DARKRED.darker(), Tools.SMALL_SHADE, Tools.createFont(
						"Bookman Old Style", null, WINNER_SIZE, smallestRatio));

		Rectangle endExit = createEndExit();

		endRoot.getChildren().addAll(winner, endExit);

		endRoot.setBackground(new Background(endScreenBack));

		endScreen.setScene(scene);
		endScreen.show();

	}

	public Rectangle createEndExit()
	{
		Rectangle exitPanel = Tools.createRoundedRectangle(EXIT_PANEL_WIDTH,
				EXIT_PANEL_HEIGHT, RECT_ARC_SIZE, RECT_ARC_SIZE, EXIT_PANEL_X,
				EXIT_PANEL_Y, widthRatio, heightRatio, smallestRatio,
				Color.TRANSPARENT, null);

		exitPanel.setOnMousePressed(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				endRoot.setBackground(new Background(endScreenClicked));
			}
		});
		exitPanel.setOnMouseReleased(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				endRoot.setBackground(new Background(endScreenBack));
				closeGameScreen();
			}
		});
		return exitPanel;
	}

	public void createEndPanel()
	{
		Rectangle endPanel = Tools.createRoundedRectangle(END_WIDTH, END_HEIGHT,
				RECT_ARC_SIZE, RECT_ARC_SIZE, END_X, END_Y, widthRatio,
				heightRatio, smallestRatio, Tools.TRANSPARENT, null);

		endPanel.setOnMousePressed(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				root.setBackground(new Background(groundClicked));
			}
		});

		endPanel.setOnMouseReleased(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				root.setBackground(new Background(ground));
				refreshSelect();
				// while the next player is one that has been removed, keep
				// adding to the index
				do
				{
					currentPlayer = (currentPlayer + 1) % players.size();
				} while (players.get(currentPlayer) == null);
				chanceAddMoney();
				refreshPlayers();
				updateInfo();
			}
		});
		root.getChildren().add(endPanel);
	}

	public Text createGameCloseButton()
	{
		Text close = Tools.createText(CLOSE_X, CLOSE_Y, widthRatio, heightRatio,
				"X", Color.LIGHTGRAY, Tools.SMALL_SHADE,
				Tools.createFont("Bookman Old Style", null, GAME_CONTROL_SIZE,
						smallestRatio));

		close.setOnMouseClicked(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				closeGameScreen();
			}
		});

		return close;
	}

	public Text createGameMinButton()
	{
		Text minimize = Tools.createText(MIN_X, MIN_Y, widthRatio, heightRatio,
				"-", Color.LIGHTGRAY, Tools.SMALL_SHADE,
				Tools.createFont("Bookman Old Style", null,
						GAME_CONTROL_SIZE + 10, smallestRatio));

		minimize.setOnMouseClicked(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				minimizeGameScreen();
			}
		});

		return minimize;
	}

	public void createGameUI()
	{
		this.initStyle(StageStyle.TRANSPARENT);
		this.setFullScreen(true);
		// prevents the user from pressing escape to exit full screen
		this.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

		root = new AnchorPane();
		Scene scene = new Scene(root, GAME_WIDTH * widthRatio,
				GAME_HEIGHT * heightRatio);

		Text close = createGameCloseButton();
		Text minimize = createGameMinButton();

		gamePane = new AnchorPane();
		gamePane.setPrefSize(GAME_PANE_WIDTH * widthRatio,
				GAME_PANE_HEIGHT * heightRatio);
		AnchorPane.setLeftAnchor(gamePane, PANE_X * widthRatio);
		AnchorPane.setTopAnchor(gamePane, PANE_Y * heightRatio);
		clipAttack = new Rectangle(0, 0, GAME_PANE_WIDTH * widthRatio,
				GAME_PANE_HEIGHT * heightRatio);
		clipMove = new Rectangle(0, 0, GAME_PANE_WIDTH * widthRatio,
				GAME_PANE_HEIGHT * heightRatio);
		updateInfo();
		attackEllipse = new Ellipse();
		setAttackEllipse();
		moveEllipse = new Ellipse();
		setMoveEllipse();
		coverPane = new AnchorPane();
		setCoverPane();

		createBuyPanels();
		addBases(gamePane);

		root.getChildren().addAll(close, minimize, gamePane, coverPane,
				moveEllipse, attackEllipse);
		root.setBackground(new Background(ground));

		createField();

		this.setScene(scene);
		this.show();
	}

	public void createIcon()
	{
		selectIcon = Tools.createImageView(currentUnit.getIcon(), ICON_SIZE,
				ICON_SIZE, ICON_X, ICON_Y, widthRatio, heightRatio,
				smallestRatio, Tools.SMALL_SHADE);
		root.getChildren().add(selectIcon);
	}

	public void createMoveButton()
	{
		EventHandler<MouseEvent> in = new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				moveButton.setEffect(Tools.LARGE_SHADE);
			}
		};

		EventHandler<MouseEvent> out = new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				moveButton.setEffect(Tools.MEDIUM_OUT_SHADE);
				startMove();
			}
		};

		moveButton = Tools.createRoundedRectangle(MOVE_BUTTON_WIDTH,
				BUTTON_HEIGHT, RECT_ARC_SIZE, RECT_ARC_SIZE, MOVE_BUTTON_X,
				BUTTON_Y, widthRatio, heightRatio, smallestRatio, Color.WHITE,
				Tools.MEDIUM_OUT_SHADE);
		moveButton.setFill(GRADIENT_MOVE);
		moveButton.setOnMousePressed(in);
		moveButton.setOnMouseReleased(out);
		moveText = Tools.createText(MOVE_TEXT_X, TEXT_Y, widthRatio,
				heightRatio, "move", Color.DARKGRAY.darker(), Tools.SMALL_SHADE,
				Tools.createFont("Agency FB", null, TEXT_SIZE, smallestRatio));
		moveText.setOnMousePressed(in);
		moveText.setOnMouseReleased(out);
		root.getChildren().addAll(moveButton, moveText);
	}

	public Text createNameCloseButton()
	{
		Text close = Tools.createText(NAME_CLOSE_X, NAME_CLOSE_Y, widthRatio,
				heightRatio, "X", Tools.DARK_GREEN, Tools.SMALL_SHADE,
				Tools.createFont("Bookman Old Style", null, NAME_CLOSE_SIZE,
						smallestRatio));

		close.setOnMouseClicked(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				Stage back = new IntroUI(widthRatio, heightRatio,
						smallestRatio);
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
		Scene scene = new Scene(root, NAME_SET_WIDTH * widthRatio,
				NAME_SET_HEIGHT * heightRatio);

		Rectangle ok = createNameSetOK(root);
		Text close = createNameCloseButton();
		root.setEffect(Tools.LARGE_SHADE);

		createNameTextFields(root, players);

		root.getChildren().addAll(ok, close);
		root.setBackground(new Background(nameSetBack));

		nameSet.setScene(scene);
		nameSet.show();
	}

	public Rectangle createNameSetOK(final AnchorPane root)
	{
		Rectangle okPanel = Tools.createRoundedRectangle(NAME_OK_WIDTH,
				NAME_OK_HEIGHT, NAME_OK_ARC_SIZE, NAME_OK_ARC_SIZE, NAME_OK_X,
				NAME_OK_Y, widthRatio, heightRatio, smallestRatio,
				Tools.TRANSPARENT, null);

		okPanel.setOnMousePressed(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				root.setBackground(new Background(nameSetClicked));
			}
		});
		okPanel.setOnMouseReleased(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				root.setBackground(new Background(nameSetBack));
				if (checkTextfields())
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
		firstName = Tools.createTextField(FIELD_WIDTH, FIELD_HEIGHT, TEXT_X,
				FIRST_Y, widthRatio, heightRatio, FIRST_TEXT,
				Tools.LARGE_OUT_SHADE);
		secondName = Tools.createTextField(FIELD_WIDTH, FIELD_HEIGHT, TEXT_X,
				SECOND_Y, widthRatio, heightRatio, SECOND_TEXT,
				Tools.LARGE_OUT_SHADE);

		// these will always be added
		root.getChildren().addAll(firstName, secondName);

		if (numPlayers >= 3)
		{
			thirdName = Tools.createTextField(FIELD_WIDTH, FIELD_HEIGHT, TEXT_X,
					THIRD_Y, widthRatio, heightRatio, THIRD_TEXT,
					Tools.LARGE_OUT_SHADE);
			root.getChildren().add(thirdName);
		}
		if (numPlayers == 4)
		{
			fourthName = Tools.createTextField(FIELD_WIDTH, FIELD_HEIGHT,
					TEXT_X, FOURTH_Y, widthRatio, heightRatio, FOURTH_TEXT,
					Tools.LARGE_OUT_SHADE);
			root.getChildren().add(fourthName);
		}
	}

	public void createPlayers()
	{
		players = new ArrayList<Player>();

		players.add(new Player(firstName.getText()));
		players.add(new Player(secondName.getText()));
		if (thirdName != null)
			players.add(new Player(thirdName.getText()));
		if (fourthName != null)
			players.add(new Player(fourthName.getText()));

		currentPlayer = 0;
	}

	public void createSkipButton()
	{
		EventHandler<MouseEvent> in = new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				skipButton.setEffect(Tools.LARGE_SHADE);
			}
		};

		EventHandler<MouseEvent> out = new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				skipButton.setEffect(Tools.MEDIUM_OUT_SHADE);
				currentUnit.skip();
				refreshSelect();
			}
		};

		skipButton = Tools.createRoundedRectangle(SKIP_BUTTON_WIDTH,
				BUTTON_HEIGHT, RECT_ARC_SIZE, RECT_ARC_SIZE, SKIP_BUTTON_X,
				BUTTON_Y, widthRatio, heightRatio, smallestRatio, Color.WHITE,
				Tools.MEDIUM_OUT_SHADE);
		skipButton.setFill(GRADIENT_SKIP);
		skipButton.setOnMousePressed(in);
		skipButton.setOnMouseReleased(out);

		skipText = Tools.createText(SKIP_TEXT_X, TEXT_Y, widthRatio,
				heightRatio, "skip", Color.DARKGRAY.darker(), Tools.SMALL_SHADE,
				Tools.createFont("Agency FB", null, TEXT_SIZE, smallestRatio));
		skipText.setOnMousePressed(in);
		skipText.setOnMouseReleased(out);
		root.getChildren().addAll(skipButton, skipText);
	}

	public void createUnitStats()
	{
		selectType = Tools.createText(TYPE_X, TYPE_Y, widthRatio, heightRatio,
				currentUnit.getType(), Color.GRAY, Tools.SMALL_SHADE,
				Tools.createFont("Agency FB", null, TYPE_SIZE, smallestRatio));
		selectHealthBar = Tools.createRoundedRectangle(
				HEALTH_MAX_WIDTH * currentUnit.getHealth()
						/ currentUnit.getMaxHealth(),
				HEALTH_MAX_HEIGHT, RECT_ARC_SIZE, RECT_ARC_SIZE, HEALTH_X,
				HEALTH_Y, widthRatio, heightRatio, smallestRatio, Color.RED,
				Tools.MEDIUM_SHADE);
		selectHealthBar.setFill(GRADIENT_HEALTH);
		selectHealthText = Tools.createText(HEALTH_TEXT_X, HEALTH_TEXT_Y,
				widthRatio, heightRatio,
				currentUnit.getHealth() + "/" + currentUnit.getMaxHealth(),
				Color.BLACK, Tools.SMALL_OUT_SHADE, Tools.createFont(
						"Agency FB", null, HEALTH_TEXT_SIZE, smallestRatio));

		selectAttRange = Tools.createText(ATTACK_RANGE_X, ATTACK_RANGE_Y,
				widthRatio, heightRatio,
				currentUnit.getAttackRange() + " units", Color.GRAY,
				Tools.SMALL_SHADE,
				Tools.createFont("Agency FB", null, STAT_SIZE, smallestRatio));
		selectMoveRange = Tools.createText(MOVE_RANGE_X, MOVE_RANGE_Y,
				widthRatio, heightRatio,
				currentUnit.getMovementRange() + " units", Color.GRAY,
				Tools.SMALL_SHADE,
				Tools.createFont("Agency FB", null, STAT_SIZE, smallestRatio));
		selectDamage = Tools.createText(DAMAGE_X, DAMAGE_Y, widthRatio,
				heightRatio, currentUnit.getDamage() + " damage", Color.RED,
				Tools.SMALL_SHADE,
				Tools.createFont("Agency FB", null, STAT_SIZE, smallestRatio));

		root.getChildren().addAll(selectType, selectHealthBar, selectHealthText,
				selectAttRange, selectMoveRange, selectDamage);
	}

	public void fireBullet(final Projectile bullet, final double endpointX,
			final double endpointY, final double angle)
	{
		prevTime = -1;
		attacking = true;
		final double distX = endpointX - bullet.getLayoutX();
		final double distY = endpointY - bullet.getLayoutY();
		final double dist = Math.sqrt(distX * distX + distY * distY);

		AnimationTimer anim = new AnimationTimer()
		{
			@Override
			public void handle(long now)
			{
				double nowSec = now * 1e-9;
				if (prevTime == -1)
				{
					prevTime = nowSec;
				} else
				{
					// Move bullet by dy and dx or to endX
					double distance = (nowSec - prevTime) * BULLET_SPEED;

					double dx1 = endpointX - bullet.getLayoutX();
					double dx2 = distance * distX / dist;
					double dx = (Math.abs(dx1) > Math.abs(dx2)) ? dx2 : dx1;

					double dy1 = endpointY - bullet.getLayoutY();
					double dy2 = distance * distY / dist;
					double dy = (Math.abs(dy1) > Math.abs(dy2)) ? dy2 : dy1;

					moveElement(bullet, bullet.getLayoutX() + dx,
							bullet.getLayoutY() + dy, angle);

					// Check each unit for collision
					for (Node child : gamePane.getChildren())
					{
						if (child instanceof Unit)
						{
							Unit check = (Unit) child;
							if (check.checkCollision(bullet)
									&& currentUnit != check)
							{
								check.setHealth(check.getHealth()
										- currentUnit.getDamage());
								if (check.getHealth() <= 0)
								{
									removeUnit(check);
								}
								hit(bullet);
								stop();
								return;
							}
						} else if (child instanceof Obstacle)
						{
							Obstacle check = (Obstacle) child;
							if (check.checkCollision(bullet)
									&& !check.isShootable())
							{
								hit(bullet);
								stop();
								return;
							}
						}
					}
					if (bullet.getLayoutX() == endpointX
							|| bullet.getLayoutY() == endpointY
							|| bullet.getLayoutX() < 0
							|| bullet.getLayoutY() < 0
							|| bullet.getLayoutX() > GAME_WIDTH * widthRatio
							|| bullet.getLayoutY() > GAME_HEIGHT * heightRatio)
					{
						hit(bullet);
						stop();
						return;
					}
				}
				prevTime = nowSec;
			}
		};
		anim.start();
	}

	public void genMoney()
	{
		Rectangle moneySpace = new Rectangle();
		gamePane.getChildren().add(moneySpace);
		int randomValue;
		double randomX;
		double randomY;
		do
		{
			randomValue = (int) (Math.random()
					* (Tools.MAX_MONEY_BAG - MIN_MONEY_SPAWN + 1))
					+ MIN_MONEY_SPAWN;
			randomX = Math.random()
					* (GAME_PANE_WIDTH - Tools.MAX_MONEY_BAG / 2);
			randomY = Math.random() * (GAME_PANE_HEIGHT - BASE_HEIGHT * 2
					- Tools.MAX_MONEY_BAG / 2) + BASE_HEIGHT;

			moneySpace.setLayoutX(randomX * widthRatio);
			moneySpace.setLayoutY(randomY * heightRatio);
			moneySpace.setWidth(
					Tools.MONEY_SIZE * randomValue / Tools.MAX_MONEY_BAG);
			moneySpace.setHeight(
					Tools.MONEY_SIZE * randomValue / Tools.MAX_MONEY_BAG);
		} while (!checkObstacles(moneySpace));

		MoneyBag spawn = Tools.createMoneyBag(randomValue, 0, 0, widthRatio,
				heightRatio, smallestRatio, Tools.MEDIUM_OUT_SHADE);
		spawn.setLayoutX(randomX * widthRatio);
		spawn.setLayoutY(randomY * heightRatio);
		moveElement(spawn, spawn.getLayoutX(), spawn.getLayoutY(), 0);

		gamePane.getChildren().remove(moneySpace);
		gamePane.getChildren().addAll(spawn.getCollShape(), spawn);
	}

	public boolean checkObstacles(Rectangle moneySpace)
	{
		for (Node child : gamePane.getChildren())
		{
			if (child instanceof Obstacle)
			{
				Obstacle check = (Obstacle) child;
				if (((Path) Shape.intersect(check.getCollShape(), moneySpace))
						.getElements().size() > 0)
				{
					return false;
				}
			}
		}
		return true;
	}

	public void hit(Projectile bullet)
	{
		attacking = false;
		// Snap back to 0 degrees after attack
		if (currentUnit != null)
			currentUnit.getTransforms().remove(direction);

		gamePane.getChildren().removeAll(bullet.getCollShape(), bullet);

		// Removes attack ellipse after attack, but prevents action until
		// bullet is gone
		coverPane.setVisible(false);
		// Deselects the unit after attack
		refreshSelect();

		checkPlayer();
		checkEndGame();
	}

	public void minimizeGameScreen()
	{
		this.setIconified(true);
	}

	public void moveClick(double endpointX, double endpointY)
	{
		boolean valid = true;
		// Holds all money at that location
		ArrayList<MoneyBag> bags = new ArrayList<MoneyBag>();
		final Rectangle destination = new Rectangle(
				endpointX - currentUnit.getFitWidth() / 2,
				endpointY - currentUnit.getFitHeight() / 2,
				currentUnit.getFitWidth(), currentUnit.getFitHeight());
		gamePane.getChildren().add(destination);

		for (Node child : gamePane.getChildren())
		{
			if (child instanceof UIElement)
			{
				UIElement check = (UIElement) child;
				if (((Path) Shape.intersect(check.getCollShape(), destination))
						.getElements().size() > 0)
				{
					if (check instanceof Obstacle
							&& !((Obstacle) check).isWalkable())
					{
						valid = false;
						break;
					} else if (check instanceof MoneyBag)
					{
						bags.add((MoneyBag) check);
					}
				}
			}
		}
		if (endpointX - currentUnit.getFitWidth() / 2 < 0
				|| endpointX + currentUnit.getFitWidth() / 2 > GAME_WIDTH
						* widthRatio
				|| endpointY - currentUnit.getFitHeight() / 2 < 0
				|| endpointY + currentUnit.getFitHeight() / 2 > GAME_HEIGHT
						* heightRatio)
		{
			valid = false;
		}

		if (valid)
		{
			for (MoneyBag money : bags)
			{
				players.get(currentPlayer).addMoney(money.getMoneyValue());
				gamePane.getChildren().removeAll(money.getCollShape(), money);
			}
			updateInfo();
			moveElement(currentUnit, endpointX - currentUnit.getFitWidth() / 2,
					endpointY - currentUnit.getFitHeight() / 2, 0);
			currentUnit.move();
			refreshSelect();
		}
		gamePane.getChildren().remove(destination);
		moveEllipse.setVisible(false);
		coverPane.setVisible(false);
	}

	public void moveElement(UIElement ele, double endpointX, double endpointY,
			double angle)
	{
		ele.setLayoutX(endpointX);
		ele.setLayoutY(endpointY);

		ele.updateCollShape(ele.getFitHeight(), ele.getFitWidth(), angle,
				ele.getLayoutX() + ele.getFitWidth() / 2,
				ele.getLayoutY() + ele.getFitHeight() / 2, 1, 1, 1);
	}

	public void refreshPlayers()
	{
		for (int k = 0; k < players.size(); k++)
		{
			Player person = players.get(k);
			if (person != null)
			{
				for (Unit unit : person.getUnitList())
				{
					unit.refreshAction();
				}
			}
		}
	}

	public void refreshSelect()
	{
		if (currentUnit != null)
			currentUnit.setEffect(TEAM_EFFECTS[currentUnit.getTeam()]);
		root.getChildren().removeAll(selectIcon, selectType, selectHealthBar,
				selectHealthText, selectAttRange, selectMoveRange, selectDamage,
				attackButton, attackText, moveButton, moveText, skipButton,
				skipText);
		currentUnit = null;
	}

	public void removeUnit(Unit removed)
	{
		double deathX = removed.getLayoutX() + removed.getFitWidth() / 2;
		double deathY = removed.getLayoutY() + removed.getFitHeight() / 2;
		players.get(removed.getTeam()).getUnitList().remove(removed);
		gamePane.getChildren().removeAll(removed.getCollShape(), removed);

		int randomValue = (int) (Math.random()
				* (removed.getCost() - MIN_MONEY + 1)) + MIN_MONEY;
		MoneyBag loot = Tools.createMoneyBag(randomValue, 0, 0, widthRatio,
				heightRatio, smallestRatio, Tools.MEDIUM_OUT_SHADE);
		loot.setLayoutX(deathX - loot.getFitWidth() / 2);
		loot.setLayoutY(deathY - loot.getFitHeight() / 2);
		moveElement(loot, loot.getLayoutX(), loot.getLayoutY(), 0);

		gamePane.getChildren().addAll(loot.getCollShape(), loot);

	}

	public void selectUnit(Unit unit)
	{
		currentUnit = unit;
		createIcon();

		if (players.get(currentPlayer).getUnitList().contains(currentUnit))
		{
			createButtons();
		}
		createUnitStats();
		currentUnit.setEffect(Tools.LARGE_WHITE_OUT);

	}

	public void setAttackEllipse()
	{
		attackEllipse.setVisible(false);
		attackEllipse.setOnMouseMoved(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				if (currentUnit != null)
				{
					double mouseX = arg0.getX();
					double mouseY = arg0.getY();

					double unitX = currentUnit.getLayoutX()
							+ currentUnit.getFitWidth() / 2;
					double unitY = currentUnit.getLayoutY()
							+ currentUnit.getFitHeight() / 2;
					// uses degrees, must convert
					direction.setAngle(Math.toDegrees(
							Math.atan2(mouseY - unitY, mouseX - unitX)));
				}
			}
		});
		attackEllipse.setOnMousePressed(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				if (currentUnit != null)
				{
					attackClick(arg0.getX(), arg0.getY());
				}
			}
		});
		// Sets the ellipse location relative to game pane
		attackEllipse.setTranslateX(PANE_X * widthRatio);
		attackEllipse.setTranslateY(PANE_Y * heightRatio);
		attackEllipse.setFill(GRADIENT_CIRCLE);
		attackEllipse.setClip(clipAttack);
	}

	public void setCoverPane()
	{
		coverPane.setOnMousePressed(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent event)
			{
				if (!attacking)
				{
					// If clicking outside range, deselect the unit
					coverPane.setVisible(false);
					moveEllipse.setVisible(false);
					attackEllipse.setVisible(false);
					if (currentUnit != null)
					{
						currentUnit.getTransforms().remove(direction);
					}
				}
			}
		});

		coverPane.setVisible(false);
		coverPane.setPrefSize(GAME_WIDTH * widthRatio, GAME_WIDTH * widthRatio);
	}

	public void setMoveEllipse()
	{
		moveEllipse.setVisible(false);
		moveEllipse.setOnMousePressed(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				if (currentUnit != null)
					moveClick(arg0.getX(), arg0.getY());
			}
		});
		moveEllipse.setTranslateX(PANE_X * widthRatio);
		moveEllipse.setTranslateY(PANE_Y * heightRatio);
		moveEllipse.setFill(GRADIENT_CIRCLE);
		moveEllipse.setClip(clipMove);
	}

	public void startAttack()
	{
		coverPane.setVisible(true);
		coverPane.toFront();
		attackEllipse.setVisible(true);
		attackEllipse.toFront();

		double attackRange = currentUnit.getAttackRange() * smallestRatio;
		attackEllipse.setRadiusX(attackRange);
		attackEllipse.setRadiusY(attackRange);
		attackEllipse.setCenterX(
				currentUnit.getLayoutX() + currentUnit.getFitWidth() / 2);
		attackEllipse.setCenterY(
				currentUnit.getLayoutY() + currentUnit.getFitHeight() / 2);

		direction.setPivotX(currentUnit.getFitWidth() / 2);
		direction.setPivotY(currentUnit.getFitHeight() / 2);
		currentUnit.getTransforms().add(direction);
	}

	public void startMove()
	{
		coverPane.setVisible(true);
		coverPane.toFront();
		moveEllipse.setVisible(true);
		moveEllipse.toFront();

		double moveRange = currentUnit.getMovementRange() * smallestRatio;
		moveEllipse.setRadiusX(moveRange);
		moveEllipse.setRadiusY(moveRange);
		moveEllipse.setCenterX(
				currentUnit.getLayoutX() + currentUnit.getFitWidth() / 2);
		moveEllipse.setCenterY(
				currentUnit.getLayoutY() + currentUnit.getFitHeight() / 2);
	}

	public void updateInfo()
	{
		root.getChildren().removeAll(pUnit);
		root.getChildren().removeAll(playerName, playerMoney);
		playerName = Tools.createText(PLAYER_NAME_X, PLAYER_NAME_Y, widthRatio,
				heightRatio, players.get(currentPlayer).getName(), PLAYER_NAME,
				Tools.SMALL_SHADE,
				Tools.createFont("Agency FB", null, NAME_SIZE, smallestRatio));

		playerMoney = Tools.createText(PLAYER_MONEY_X, PLAYER_MONEY_Y,
				widthRatio, heightRatio,
				"$" + players.get(currentPlayer).getAmountOfMoney(),
				PLAYER_MONEY, Tools.SMALL_SHADE,
				Tools.createFont("Agency FB", null, MONEY_SIZE, smallestRatio));

		addUnitIcons();

		root.getChildren().addAll(playerName, playerMoney);
	}

	public void createField()
	{
		createHouseOne(HOUSE_ONE_HEIGHT, HOUSE_ONE_WIDTH, HOUSE_ONE_X,
				HOUSE_ONE_Y);
		createHouseTwo(HOUSE_TWO_HEIGHT, HOUSE_TWO_WIDTH, HOUSE_TWO_X,
				HOUSE_TWO_Y);
		createTrees(MEDIUM_TREE_SIZE, MEDIUM_TREE_SIZE, TREE_X[0], TREE_Y[0]);
		createTrees(MEDIUM_TREE_SIZE, MEDIUM_TREE_SIZE, TREE_X[1], TREE_Y[1]);
		createTrees(MEDIUM_TREE_SIZE, MEDIUM_TREE_SIZE, TREE_X[2], TREE_Y[2]);

		createRock(LARGE_ROCK_SIZE, LARGE_ROCK_SIZE, ROCK_X[0], ROCK_Y[0]);
		createRock(SUPER_LARGE_ROCK_SIZE, SUPER_LARGE_ROCK_SIZE, ROCK_X[1],
				ROCK_Y[1]);

		createRock(LARGE_ROCK_SIZE, LARGE_ROCK_SIZE, ROCK_X[2], ROCK_Y[2]);
		createRock(MEDIUM_ROCK_SIZE, MEDIUM_ROCK_SIZE, ROCK_X[3], ROCK_Y[3]);
		createRock(SMALL_ROCK_SIZE, SMALL_ROCK_SIZE, ROCK_X[4], ROCK_Y[4]);
		createRock(MEDIUM_ROCK_SIZE, MEDIUM_ROCK_SIZE, ROCK_X[5], ROCK_Y[5]);

	}

	public void createHouseOne(double height, double width, double xLoc,
			double yLoc)
	{
		Obstacle houseOne = Tools.createSolid(Tools.HOUSE_ONE, height, width,
				xLoc, yLoc, widthRatio, heightRatio, smallestRatio,
				Tools.LARGE_OUT_SHADE);
		houseOne.updateCollShape(houseOne.getFitHeight(),
				houseOne.getFitWidth(), 0,
				houseOne.getLayoutX() + houseOne.getFitWidth() / 2,
				houseOne.getLayoutY() + houseOne.getFitHeight() / 2, 1, 1, 1);
		gamePane.getChildren().addAll(houseOne.getCollShape(), houseOne);
	}

	public void createHouseTwo(double height, double width, double xLoc,
			double yLoc)
	{
		Obstacle houseTwo = Tools.createSolid(Tools.HOUSE_TWO, height, width,
				xLoc, yLoc, widthRatio, heightRatio, smallestRatio,
				Tools.LARGE_OUT_SHADE);
		houseTwo.updateCollShape(houseTwo.getFitHeight(),
				houseTwo.getFitWidth(), 0,
				houseTwo.getLayoutX() + houseTwo.getFitWidth() / 2,
				houseTwo.getLayoutY() + houseTwo.getFitHeight() / 2, 1, 1, 1);
		gamePane.getChildren().addAll(houseTwo.getCollShape(), houseTwo);
	}

	public void createTrees(double height, double width, double xLoc,
			double yLoc)
	{
		Obstacle trees = Tools.createSolid(Tools.TREE, height, width, xLoc,
				yLoc, widthRatio, heightRatio, smallestRatio,
				Tools.LARGE_OUT_SHADE);
		trees.updateCollShape(trees.getFitHeight(), trees.getFitWidth(), 0,
				trees.getLayoutX() + trees.getFitWidth() / 2,
				trees.getLayoutY() + trees.getFitHeight() / 2, 1, 1, 1);
		gamePane.getChildren().addAll(trees.getCollShape(), trees);
	}

	public void createRock(double height, double width, double xLoc,
			double yLoc)
	{
		Obstacle rock = Tools.createSolid(Tools.ROCK, height, width, xLoc, yLoc,
				widthRatio, heightRatio, smallestRatio, Tools.LARGE_OUT_SHADE);
		rock.updateCollShape(rock.getFitHeight(), rock.getFitWidth(), 0,
				rock.getLayoutX() + rock.getFitWidth() / 2,
				rock.getLayoutY() + rock.getFitHeight() / 2, 1, 1, 1);
		gamePane.getChildren().addAll(rock.getCollShape(), rock);
	}

}
