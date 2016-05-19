
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
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
import java.util.*;

public class IntroUI extends Stage
{

	// Dimensions of the main screen
	public static final int SCENE_WIDTH = 1200;
	public static final int SCENE_HEIGHT = 675;
	public static final int BORDER_WIDTH = 1220;
	public static final int BORDER_HEIGHT = 695;

	public static final int NUM_SELECT_WIDTH = 600;
	public static final int NUM_SELECT_HEIGHT = 220;

	// Help button dimensions
	public static final double HELP_WIDTH = 287.25;
	public static final double HELP_HEIGHT = 153;
	public static final double HELP_X = 699.75;
	public static final double HELP_Y = 420.75;

	// Play button dimensions
	public static final double PLAY_WIDTH = 482.25;
	public static final double PLAY_HEIGHT = 153;
	public static final double PLAY_X = 182.25;
	public static final double PLAY_Y = 420.75;

	// Close button dimensions
	public static final double CLOSE_X = 1150;
	public static final double MIN_X = 1110;
	public static final double CLOSE_Y = 5;
	public static final double MIN_Y = 0;

	// Dropdown box dimensions
	public static final double COMBO_X = 30;
	public static final double COMBO_Y = 125;
	public static final double COMBO_WIDTH = 400;
	public static final double COMBO_HEIGHT = 45;

	// OK button dimensions
	public static final double OK_WIDTH = 90;
	public static final double OK_HEIGHT = 55;
	public static final double OK_ARC_SIZE = 10;
	public static final double OK_X = 472;
	public static final double OK_Y = 122;

	public static final double NUM_CLOSE_X = 565;
	public static final double NUM_CLOSE_Y = 5;

	public static final double RECT_ARC_SIZE = 22.5;

	public static final int OFFSET = 10;

	// Homepage Images
	public static final Image INTRO_BORDER_IMAGE = Tools
			.createImage("background.jpg");
	public static final Image INTRO_BACK_IMAGE = Tools
			.createImage("IntroBack.png");
	public static final Image INTRO_HELP_CLICK_IMAGE = Tools
			.createImage("IntroHelpClick.png");
	public static final Image INTRO_HELP_HOVER_IMAGE = Tools
			.createImage("IntroHelpHover.png");
	public static final Image INTRO_PLAY_CLICK_IMAGE = Tools
			.createImage("IntroPlayClick.png");
	public static final Image INTRO_PLAY_HOVER_IMAGE = Tools
			.createImage("IntroPlayHover.png");
	public static final Image NUM_PLAY_IMAGE = Tools
			.createImage("NumPlayers.png");
	public static final Image NUM_PLAY_CLICKED_IMAGE = Tools
			.createImage("NumPlayersClicked.png");

	// "Selecting Units" page images
	public static final Image SELECTING_UNITS_IMAGE = Tools
			.createImage("Selecting Units.png");
	public static final Image SELECTING_UNITS_BACK_HOVER_IMAGE = Tools
			.createImage("Selecting Units (Back Option Hover).png");
	public static final Image SELECTING_UNITS_BACK_CLICKED_IMAGE = Tools
			.createImage("Selecting Units (Back Option Clicked).png");
	public static final Image SELECTING_UNITS_NEXT_HOVER_IMAGE = Tools
			.createImage("Selecting Units (Next Hover).png");
	public static final Image SELECTING_UNITS_NEXT_CLICKED_IMAGE = Tools
			.createImage("Selecting Units (Next Clicked).png");

	// "Game Elements" page images
	public static final Image GAME_ELEMENTS_IMAGE = Tools
			.createImage("Game Elements.png");
	public static final Image GAME_ELEMENTS_PREVIOUS_HOVER_IMAGE = Tools
			.createImage("Game Elements (Previous Hover).png");
	public static final Image GAME_ELEMENTS_PREVIOUS_CLICKED_IMAGE = Tools
			.createImage("Game Elements (Previous Clicked).png");
	public static final Image GAME_ELEMENTS_NEXT_HOVER_IMAGE = Tools
			.createImage("Game Elements (Next Hover).png");
	public static final Image GAME_ELEMENTS_NEXT_CLICKED_IMAGE = Tools
			.createImage("Game Elements (Next Clicked).png");

	// "Game Setup" page images
	public static final Image GAME_SETUP_IMAGE = Tools
			.createImage("Game Setup.PNG");
	public static final Image GAME_SETUP_HOMEPAGE_HOVER_IMAGE = Tools
			.createImage("Game Setup (Homepage Hover).png");
	public static final Image GAME_SETUP_HOMEPAGE_CLICKED_IMAGE = Tools
			.createImage("Game Setup (Homepage Clicked).png");
	public static final Image GAME_SETUP_NEXT_HOVER_IMAGE = Tools
			.createImage("Game Setup (Next Hover).png");
	public static final Image GAME_SETUP_NEXT_CLICKED_IMAGE = Tools
			.createImage("Game Setup (Next Clicked).png");

	// "Gameplay" page images
	public static final Image GAMEPLAY_IMAGE = Tools
			.createImage("Gameplay.PNG");
	public static final Image GAMEPLAY_PREVIOUS_HOVER_IMAGE = Tools
			.createImage("Gameplay (Previous Hover).PNG");
	public static final Image GAMEPLAY_PREVIOUS_CLICKED_IMAGE = Tools
			.createImage("Gameplay (Previous Clicked).PNG");

	private BackgroundImage introBorder = new BackgroundImage(
			INTRO_BORDER_IMAGE, BackgroundRepeat.REPEAT,
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(INTRO_BORDER_IMAGE.getWidth(),
					INTRO_BORDER_IMAGE.getHeight(), false, false, false,
					false));
	private BackgroundImage introBack = new BackgroundImage(INTRO_BACK_IMAGE,
			BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
			BackgroundPosition.DEFAULT,
			new BackgroundSize(INTRO_BACK_IMAGE.getWidth(),
					INTRO_BACK_IMAGE.getHeight(), false, false, true, false));
	private BackgroundImage intoHelpClick = new BackgroundImage(
			INTRO_HELP_CLICK_IMAGE, BackgroundRepeat.REPEAT,
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(INTRO_HELP_CLICK_IMAGE.getWidth(),
					INTRO_HELP_CLICK_IMAGE.getHeight(), false, false, true,
					false));
	private BackgroundImage introHelpHover = new BackgroundImage(
			INTRO_HELP_HOVER_IMAGE, BackgroundRepeat.REPEAT,
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(INTRO_HELP_HOVER_IMAGE.getWidth(),
					INTRO_HELP_HOVER_IMAGE.getHeight(), false, false, true,
					false));
	private BackgroundImage introPlayClick = new BackgroundImage(
			INTRO_PLAY_CLICK_IMAGE, BackgroundRepeat.REPEAT,
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(INTRO_PLAY_CLICK_IMAGE.getWidth(),
					INTRO_PLAY_CLICK_IMAGE.getHeight(), false, false, true,
					false));
	private BackgroundImage introPlayHover = new BackgroundImage(
			INTRO_PLAY_HOVER_IMAGE, BackgroundRepeat.REPEAT,
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(INTRO_PLAY_HOVER_IMAGE.getWidth(),
					INTRO_PLAY_HOVER_IMAGE.getHeight(), false, false, true,
					false));
	private BackgroundImage numPlay = new BackgroundImage(NUM_PLAY_IMAGE,
			BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
			BackgroundPosition.DEFAULT,
			new BackgroundSize(NUM_PLAY_IMAGE.getWidth(),
					NUM_PLAY_IMAGE.getHeight(), false, false, true, false));
	private BackgroundImage numPlayClicked = new BackgroundImage(
			NUM_PLAY_CLICKED_IMAGE, BackgroundRepeat.REPEAT,
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(NUM_PLAY_CLICKED_IMAGE.getWidth(),
					NUM_PLAY_CLICKED_IMAGE.getHeight(), false, false, true,
					false));

	private BackgroundImage selectingUnits = new BackgroundImage(
			SELECTING_UNITS_IMAGE, BackgroundRepeat.REPEAT,
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(NUM_PLAY_CLICKED_IMAGE.getWidth(),
					NUM_PLAY_CLICKED_IMAGE.getHeight(), false, false, true,
					false));
	private BackgroundImage selectingUnitsBackHover = new BackgroundImage(
			SELECTING_UNITS_BACK_HOVER_IMAGE, BackgroundRepeat.REPEAT,
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(NUM_PLAY_CLICKED_IMAGE.getWidth(),
					NUM_PLAY_CLICKED_IMAGE.getHeight(), false, false, true,
					false));
	private BackgroundImage selectingUnitsBackClicked = new BackgroundImage(
			SELECTING_UNITS_BACK_CLICKED_IMAGE, BackgroundRepeat.REPEAT,
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(NUM_PLAY_CLICKED_IMAGE.getWidth(),
					NUM_PLAY_CLICKED_IMAGE.getHeight(), false, false, true,
					false));
	private BackgroundImage selectingUnitsNextHover = new BackgroundImage(
			SELECTING_UNITS_NEXT_HOVER_IMAGE, BackgroundRepeat.REPEAT,
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(NUM_PLAY_CLICKED_IMAGE.getWidth(),
					NUM_PLAY_CLICKED_IMAGE.getHeight(), false, false, true,
					false));
	private BackgroundImage selectingUnitsNextClicked = new BackgroundImage(
			SELECTING_UNITS_NEXT_CLICKED_IMAGE, BackgroundRepeat.REPEAT,
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(NUM_PLAY_CLICKED_IMAGE.getWidth(),
					NUM_PLAY_CLICKED_IMAGE.getHeight(), false, false, true,
					false));

	private BackgroundImage gameElements = new BackgroundImage(
			GAME_ELEMENTS_IMAGE, BackgroundRepeat.REPEAT,
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(NUM_PLAY_CLICKED_IMAGE.getWidth(),
					NUM_PLAY_CLICKED_IMAGE.getHeight(), false, false, true,
					false));
	private BackgroundImage gameElementsPreviousHover = new BackgroundImage(
			GAME_ELEMENTS_PREVIOUS_HOVER_IMAGE, BackgroundRepeat.REPEAT,
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(NUM_PLAY_CLICKED_IMAGE.getWidth(),
					NUM_PLAY_CLICKED_IMAGE.getHeight(), false, false, true,
					false));
	private BackgroundImage gameElementsPreviousClicked = new BackgroundImage(
			GAME_ELEMENTS_PREVIOUS_CLICKED_IMAGE, BackgroundRepeat.REPEAT,
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(NUM_PLAY_CLICKED_IMAGE.getWidth(),
					NUM_PLAY_CLICKED_IMAGE.getHeight(), false, false, true,
					false));
	private BackgroundImage gameElementsNextHover = new BackgroundImage(
			GAME_ELEMENTS_NEXT_HOVER_IMAGE, BackgroundRepeat.REPEAT,
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(NUM_PLAY_CLICKED_IMAGE.getWidth(),
					NUM_PLAY_CLICKED_IMAGE.getHeight(), false, false, true,
					false));
	private BackgroundImage gameElementsNextClicked = new BackgroundImage(
			GAME_ELEMENTS_NEXT_CLICKED_IMAGE, BackgroundRepeat.REPEAT,
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(NUM_PLAY_CLICKED_IMAGE.getWidth(),
					NUM_PLAY_CLICKED_IMAGE.getHeight(), false, false, true,
					false));

	private BackgroundImage gameSetup = new BackgroundImage(GAME_SETUP_IMAGE,
			BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
			BackgroundPosition.DEFAULT,
			new BackgroundSize(INTRO_BORDER_IMAGE.getWidth(),
					INTRO_BORDER_IMAGE.getHeight(), false, false, true, false));
	private BackgroundImage GAME_SETUP_HOMEPAGE_HOVER = new BackgroundImage(
			GAME_SETUP_HOMEPAGE_HOVER_IMAGE, BackgroundRepeat.REPEAT,
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(INTRO_BORDER_IMAGE.getWidth(),
					INTRO_BORDER_IMAGE.getHeight(), false, false, true, false));
	private BackgroundImage GAME_SETUP_HOMEPAGE_CLICKED = new BackgroundImage(
			GAME_SETUP_HOMEPAGE_CLICKED_IMAGE, BackgroundRepeat.REPEAT,
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(INTRO_BORDER_IMAGE.getWidth(),
					INTRO_BORDER_IMAGE.getHeight(), false, false, true, false));
	private BackgroundImage GAME_SETUP_NEXT_HOVER = new BackgroundImage(
			GAME_SETUP_NEXT_HOVER_IMAGE, BackgroundRepeat.REPEAT,
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(INTRO_BORDER_IMAGE.getWidth(),
					INTRO_BORDER_IMAGE.getHeight(), false, false, true, false));
	private BackgroundImage GAME_SETUP_NEXT_CLICKED = new BackgroundImage(
			GAME_SETUP_NEXT_CLICKED_IMAGE, BackgroundRepeat.REPEAT,
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(INTRO_BORDER_IMAGE.getWidth(),
					INTRO_BORDER_IMAGE.getHeight(), false, false, true, false));

	private BackgroundImage GAMEPLAY = new BackgroundImage(GAMEPLAY_IMAGE,
			BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
			BackgroundPosition.DEFAULT,
			new BackgroundSize(INTRO_BORDER_IMAGE.getWidth(),
					INTRO_BORDER_IMAGE.getHeight(), false, false, true, false));
	private BackgroundImage GAMEPLAY_PREVIOUS_HOVER = new BackgroundImage(
			GAMEPLAY_PREVIOUS_HOVER_IMAGE, BackgroundRepeat.REPEAT,
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(INTRO_BORDER_IMAGE.getWidth(),
					INTRO_BORDER_IMAGE.getHeight(), false, false, true, false));
	private BackgroundImage GAMEPLAY_PREVIOUS_CLICKED = new BackgroundImage(
			GAMEPLAY_PREVIOUS_CLICKED_IMAGE, BackgroundRepeat.REPEAT,
			BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(INTRO_BORDER_IMAGE.getWidth(),
					INTRO_BORDER_IMAGE.getHeight(), false, false, true, false));

	private double widthRatio;
	private double heightRatio;
	private double smallestRatio;

	private Stage border, numSelect, help, setup, select, elements, gameplay;
	private ComboBox<String> comboBox;

	/**
	 * Creates the Stage for the main IntroUI
	 * @param widthRatio the ratio of the UI's width to the user's screen
	 * @param heightRatio the ratio of the UI's height to the user's screen
	 * @param smallestRatio the smallest of the two ratios
	 */
	public IntroUI(double widthRatio, double heightRatio, double smallestRatio)
	{
		this.widthRatio = widthRatio;
		this.heightRatio = heightRatio;
		this.smallestRatio = smallestRatio;

		// Creates the border
		createIntroBorder();
		createIntroUI();
	}

	/**
	 * Closes the intro screen and its border
	 */
	public void closeIntroScreen()
	{
		this.close();
		border.close();
	}

	/**
	 * Closes the Intro screen only
	 */
	public void closeIntroOnly()
	{
		this.close();
	}

	/**
	 * Closes the numSelect screen and its border
	 */
	public void closeNumScreen()
	{
		numSelect.close();
	}

	public void loadBackgrounds()
	{

	}

	/**
	 * Creates an invisible rectangle shape around the Help button which can be
	 * used to create clicking effects for the button
	 * @param root the AnchorPane layout on which the button is placed
	 * @return the invisible rectangle
	 */
	public Rectangle createHelpPanel(final AnchorPane root)
	{
		Rectangle helpPanel = Tools.createRoundedRectangle(HELP_WIDTH,
				HELP_HEIGHT, RECT_ARC_SIZE, RECT_ARC_SIZE, HELP_X, HELP_Y,
				widthRatio, heightRatio, smallestRatio, Tools.TRANSPARENT,
				null);

		helpPanel = createRectangle(root, helpPanel, introHelpHover, introBack,
				intoHelpClick);

		helpPanel.setOnMouseReleased(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				root.setBackground(new Background(introHelpHover));
				createHelpStage();
				closeIntroOnly();
			}
		});

		return helpPanel;
	}

	/**
	 * Creates a metallic-textured border to appear around the IntroUI
	 */
	private void createIntroBorder()
	{
		border = new Stage();
		border.initStyle(StageStyle.TRANSPARENT);

		AnchorPane root = new AnchorPane();
		Scene scene = new Scene(root, BORDER_WIDTH * widthRatio,
				BORDER_HEIGHT * heightRatio);

		root.setBackground(new Background(introBorder));
		root.setEffect(Tools.LARGE_SHADE);
		border.setScene(scene);
		border.show();
		border.centerOnScreen();
	}

	/**
	 * Creates a close button on the homepage
	 * @param root the AnchorPane layout on which the button is placed
	 * @return the Text of the close button
	 */
	public Text createIntroCloseButton(AnchorPane root)
	{
		Text close = Tools.createText(CLOSE_X, CLOSE_Y, widthRatio, heightRatio,
				"x", Color.LIGHTGRAY, Tools.SMALL_SHADE,
				Tools.createFont("Bookman Old Style", null, 50, smallestRatio));

		close.setOnMouseClicked(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				closeIntroScreen();
			}
		});

		return close;
	}

	/**
	 * Creates a minimize button on the homepage
	 * @param root the AnchorPane layout on which the button is placed
	 * @return the Text of the minimize button
	 */
	public Text createIntroMinButton(AnchorPane root)
	{
		Text minimize = Tools.createText(MIN_X, MIN_Y, widthRatio, heightRatio,
				"-", Color.LIGHTGRAY, Tools.SMALL_SHADE,
				Tools.createFont("Bookman Old Style", null, 60, smallestRatio));

		minimize.setOnMouseClicked(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				minimizeIntroScreen();
			}
		});

		return minimize;
	}

	/**
	 * Initializes the Stage for the homepage
	 */
	public void createIntroUI()
	{
		this.initStyle(StageStyle.TRANSPARENT);
		AnchorPane root = new AnchorPane();
		Scene scene = new Scene(root, SCENE_WIDTH * widthRatio,
				SCENE_HEIGHT * heightRatio);

		// Connects the intro screen with its border
		this.initOwner(border);
		this.setX(border.getX() + OFFSET * widthRatio);
		this.setY(border.getY() + OFFSET * heightRatio);

		// Editing the root, which is what elements display on
		root.setBackground(new Background(introBack));

		Rectangle helpPanel = createHelpPanel(root);
		Rectangle playPanel = createPlayPanel(root);

		Text close = createIntroCloseButton(root);
		Text minimize = createIntroMinButton(root);

		root.getChildren().addAll(helpPanel, playPanel, close, minimize);
		root.setEffect(Tools.XLARGE_SHADE);
		this.setScene(scene);
	}

	/**
	 * Creates a close button on the homepage
	 * @param root the AnchorPane layout on which the button is placed
	 * @return the Text of the close button
	 */
	public Text createNumCloseButton(AnchorPane root)
	{
		Text close = Tools.createText(NUM_CLOSE_X, NUM_CLOSE_Y, widthRatio,
				heightRatio, "X", Tools.DARK_GREEN, Tools.SMALL_SHADE,
				Tools.createFont("Bookman Old Style", null, 30, smallestRatio));

		close.setOnMouseClicked(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				closeNumScreen();
				openIntroScreen();
			}
		});

		return close;
	}

	/**
	 * Creates the NumSelect Stage, where the number of players can be selected
	 */
	private void createNumSelect()
	{
		numSelect = new Stage();
		numSelect.initStyle(StageStyle.TRANSPARENT);

		AnchorPane root = new AnchorPane();
		Scene scene = new Scene(root, NUM_SELECT_WIDTH * widthRatio,
				NUM_SELECT_HEIGHT * heightRatio);

		// Setting up the combo box within the panel
		ObservableList<String> options = FXCollections
				.observableArrayList("2 Players", "3 Players", "4 Players");
		comboBox = new ComboBox<String>(options);

		comboBox.setLayoutX(COMBO_X * widthRatio);
		comboBox.setLayoutY(COMBO_Y * heightRatio);
		comboBox.setPrefWidth(COMBO_WIDTH * smallestRatio);
		comboBox.setPrefHeight(COMBO_HEIGHT * smallestRatio);
		comboBox.setStyle("-fx-font: 20px \"Bookman Old Style\";");
		comboBox.setEffect(Tools.LARGE_OUT_SHADE);

		// adds coloring to the list cells, unchangeable otherwise
		scene.getStylesheets()
				.add(IntroUI.class.getResource("edits.css").toExternalForm());

		Rectangle ok = createNumSelectOK(root);
		Text close = createNumCloseButton(root);
		root.setEffect(Tools.LARGE_SHADE);

		root.getChildren().addAll(comboBox, ok, close);

		root.setBackground(new Background(numPlay));
		numSelect.setScene(scene);
		numSelect.show();
	}

	/**
	 * Creates the Help Stage, where the initial Game Setup screen is displayed
	 */
	private void createHelpStage()
	{
		AnchorPane root = new AnchorPane();
		help = createStandardStage(root);

		root.setBackground(new Background(gameSetup));
		Rectangle p = setupHomepage(root);
		Rectangle next = setupNext(root);

		root.getChildren().addAll(p, next);
		help.show();
	}

	/**
	 * Creates a standard Stage, with code that is used every time a Stage is
	 * created
	 * @param root the AnchorPane layout on which the button is placed
	 * @return the created Stage
	 */
	private Stage createStandardStage(AnchorPane root)
	{
		Stage standard = new Stage();
		standard.initStyle(StageStyle.TRANSPARENT);

		border.show();
		standard.initOwner(border);
		standard.setX(border.getX() + OFFSET * widthRatio);
		standard.setY(border.getY() + OFFSET * heightRatio);

		Scene scene = new Scene(root, SCENE_WIDTH * widthRatio,
				SCENE_HEIGHT * heightRatio);
		standard.setScene(scene);

		return standard;
	}

	/**
	 * Creates the stage on which the Selecting Units screen is displayed
	 */
	private void createSelectingUnits()
	{
		AnchorPane root = new AnchorPane();
		select = createStandardStage(root);

		root.setBackground(new Background(selectingUnits));
		Rectangle back = createBackSelectingUnits(root);
		Rectangle next = createNextSelectingUnits(root);
		root.getChildren().addAll(back, next);
		select.show();
	}

	/**
	 * Creates the stage on which the Game Setup screen is displayed
	 */
	private void createGameSetup()
	{
		AnchorPane root = new AnchorPane();
		setup = createStandardStage(root);
		Rectangle homepage = setupHomepage(root);
		Rectangle next = setupNext(root);

		root.getChildren().addAll(next, homepage);
		root.setBackground(new Background(selectingUnits));
	}

	/**
	 * Creates an invisible rectangle shape around the OK button on the
	 * numSelect screen, which can be used to create clicking effects for the
	 * button
	 * @param root the AnchorPane layout on which the button is placed
	 * @return the invisible rectangle
	 */
	public Rectangle createNumSelectOK(final AnchorPane root)
	{
		Rectangle okPanel = Tools.createRoundedRectangle(OK_WIDTH, OK_HEIGHT,
				OK_ARC_SIZE, OK_ARC_SIZE, OK_X, OK_Y, widthRatio, heightRatio,
				smallestRatio, Tools.TRANSPARENT, null);

		okPanel.setOnMousePressed(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				root.setBackground(new Background(numPlayClicked));
			}
		});
		okPanel.setOnMouseReleased(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				root.setBackground(new Background(numPlay));
				String players = (String) comboBox.getValue();
				int numPlay = 0;
				if (players != null)
				{
					switch (players) {
					case "2 Players":
						numPlay = 2;
						break;
					case "3 Players":
						numPlay = 3;
						break;
					case "4 Players":
						numPlay = 4;
						break;
					}
				}
				if (numPlay != 0)
				{
					// Edit to add name setting
					Stage game = new GameUI(numPlay, widthRatio, heightRatio,
							smallestRatio);
					numSelect.close();
				}
			}
		});
		return okPanel;
	}

	/**
	 * Creates an invisible rectangle shape around the Back button on the
	 * Selecting Units screen, which can be used to create clicking effects for
	 * the button
	 * @param root the AnchorPane layout on which the button is placed
	 * @return the invisible rectangle
	 */
	public Rectangle createBackSelectingUnits(final AnchorPane root)
	{
		Rectangle back = setupHomepage(root);
		back.setWidth(310);

		back.setOnMouseEntered(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				root.setBackground(new Background(selectingUnitsBackHover));
			}
		});

		back.setOnMouseExited(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				root.setBackground(new Background(selectingUnits));
			}
		});

		back.setOnMousePressed(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				root.setBackground(new Background(selectingUnitsBackClicked));
			}
		});

		back.setOnMouseReleased(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				root.setBackground(new Background(selectingUnitsBackHover));
				createHelpStage();
			}
		});

		return back;
	}

	/**
	 * Creates an invisible rectangle shape around the Next button on the
	 * Selecting Units screen, which can be used to create clicking effects for
	 * the button
	 * @param root the AnchorPane layout on which the button is placed
	 * @return the invisible rectangle
	 */
	public Rectangle createNextSelectingUnits(final AnchorPane root)
	{
		Rectangle next = setupNext(root);

		next.setOnMouseEntered(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				root.setBackground(new Background(selectingUnitsNextHover));
			}
		});

		next.setOnMouseExited(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				root.setBackground(new Background(selectingUnits));
			}
		});
		next.setOnMousePressed(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				root.setBackground(new Background(selectingUnitsNextClicked));
			}
		});
		next.setOnMouseReleased(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				root.setBackground(new Background(selectingUnitsNextHover));
				createElementsStage();
			}
		});

		return next;
	}

	/**
	 * Creates an invisible rectangle shape around the Back button on the Game
	 * Setup screen, which can be used to create clicking effects for the button
	 * @param root the AnchorPane layout on which the button is placed
	 * @return the invisible rectangle
	 */
	public Rectangle backToIntro(final AnchorPane root)
	{
		Rectangle back = Tools.createRoundedRectangle(450, 70, RECT_ARC_SIZE,
				RECT_ARC_SIZE, 11, 600, widthRatio, heightRatio, smallestRatio,
				Tools.TRANSPARENT, null);

		back = createRectangle(root, back, selectingUnitsBackHover,
				selectingUnits, selectingUnitsBackClicked);

		back.setOnMouseReleased(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				root.setBackground(new Background(selectingUnitsBackHover));
				// createIntroUI();
			}
		});
		return back;
	}

	/**
	 * Creates an invisible rectangle shape around the Homepage button on the
	 * Game Setup screen, which can be used to create clicking effects for the
	 * button
	 * @param root the AnchorPane layout on which the button is placed
	 * @return the invisible rectangle
	 */
	public Rectangle setupHomepage(final AnchorPane root)
	{
		Rectangle home = Tools.createRoundedRectangle(280, 53, RECT_ARC_SIZE,
				RECT_ARC_SIZE, 10, 610, widthRatio, heightRatio, smallestRatio,
				Tools.TRANSPARENT, null);

		home = createRectangle(root, home, GAME_SETUP_HOMEPAGE_HOVER, gameSetup,
				GAME_SETUP_HOMEPAGE_CLICKED);

		home.setOnMouseReleased(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				root.setBackground(new Background(GAME_SETUP_HOMEPAGE_HOVER));
				openIntroScreen();
			}
		});

		return home;
	}

	/**
	 * Creates an invisible rectangle shape around the Next button on the Game
	 * Setup screen, which can be used to create clicking effects for the button
	 * @param root the AnchorPane layout on which the button is placed
	 * @return the invisible rectangle
	 */
	public Rectangle setupNext(final AnchorPane root)
	{
		Rectangle next = Tools.createRoundedRectangle(190, 66, RECT_ARC_SIZE,
				RECT_ARC_SIZE, SCENE_WIDTH - 250, 600, widthRatio, heightRatio,
				smallestRatio, Tools.TRANSPARENT, null);

		next = createRectangle(root, next, GAME_SETUP_NEXT_HOVER, gameSetup,
				GAME_SETUP_NEXT_CLICKED);

		next.setOnMouseReleased(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				root.setBackground(new Background(GAME_SETUP_NEXT_HOVER));
				createSelectingUnits();
			}
		});

		return next;
	}

	/**
	 * Creates an invisible rectangle shape around the Play button on the Intro
	 * screen, which can be used to create clicking effects for the button
	 * @param root the AnchorPane layout on which the button is placed
	 * @return the invisible rectangle
	 */
	public Rectangle createPlayPanel(final AnchorPane root)
	{
		Rectangle playPanel = Tools.createRoundedRectangle(PLAY_WIDTH,
				PLAY_HEIGHT, RECT_ARC_SIZE, RECT_ARC_SIZE, PLAY_X, PLAY_Y,
				widthRatio, heightRatio, smallestRatio, Tools.TRANSPARENT,
				null);

		playPanel = createRectangle(root, playPanel, introPlayHover, introBack,
				introPlayClick);

		playPanel.setOnMouseReleased(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				root.setBackground(new Background(introPlayHover));
				createNumSelect();
				closeIntroScreen();
			}
		});

		return playPanel;
	}

	/**
	 * Creates the Stage on which the Game Elements screen is displayed
	 */
	private void createElementsStage()
	{
		AnchorPane root = new AnchorPane();
		elements = createStandardStage(root);
		root.setBackground(new Background(gameElements));
		Rectangle back = createElementsPrevious(root);
		Rectangle next = createElementsNext(root);
		root.getChildren().addAll(back, next);
		elements.show();
	}

	/**
	 * Creates an invisible rectangle shape around the Previous button on the
	 * Game Elements screen, which can be used to create clicking effects for
	 * the button
	 * @param root the AnchorPane layout on which the button is placed
	 * @return the invisible rectangle
	 */
	public Rectangle createElementsPrevious(final AnchorPane root)
	{
		Rectangle back = Tools.createRoundedRectangle(280, 53, RECT_ARC_SIZE,
				RECT_ARC_SIZE, 10, 610, widthRatio, heightRatio, smallestRatio,
				Tools.TRANSPARENT, null);

		Rectangle result = createRectangle(root, back,
				gameElementsPreviousHover, gameElements,
				gameElementsPreviousClicked);

		result.setOnMouseReleased(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				root.setBackground(new Background(gameElementsPreviousHover));
				createSelectingUnits();
			}
		});

		return result;
	}

	/**
	 * Creates an invisible rectangle shape around the Next button on the Game
	 * Elements screen, which can be used to create clicking effects for the
	 * button
	 * @param root the AnchorPane layout on which the button is placed
	 * @return the invisible rectangle
	 */
	public Rectangle createElementsNext(final AnchorPane root)
	{
		Rectangle base = Tools.createRoundedRectangle(190, 66, RECT_ARC_SIZE,
				RECT_ARC_SIZE, SCENE_WIDTH - 250, 600, widthRatio, heightRatio,
				smallestRatio, Tools.TRANSPARENT, null);
		Rectangle result = createRectangle(root, base, gameElementsNextHover,
				gameElements, gameElementsNextClicked);

		result.setOnMouseReleased(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				root.setBackground(new Background(gameElementsNextHover));
				createGameplayStage();
			}
		});

		return result;
	}

	/**
	 * Creates the Stage on which the Gameplay screen is displayed
	 */
	public void createGameplayStage()
	{
		AnchorPane root = new AnchorPane();
		gameplay = createStandardStage(root);
		root.setBackground(new Background(GAMEPLAY));
		Rectangle back = createGameplayPrevious(root);
		root.getChildren().addAll(back);
		gameplay.show();
	}

	/**
	 * Creates an invisible rectangle shape around the Previous button on the
	 * Gameplay screen, which can be used to create clicking effects for the
	 * button
	 * @param root the AnchorPane layout on which the button is placed
	 * @return the invisible rectangle
	 */
	public Rectangle createGameplayPrevious(final AnchorPane root)
	{
		Rectangle back = Tools.createRoundedRectangle(265, 53, RECT_ARC_SIZE,
				RECT_ARC_SIZE, 10, 610, widthRatio, heightRatio, smallestRatio,
				Tools.TRANSPARENT, null);

		Rectangle result = createRectangle(root, back, GAMEPLAY_PREVIOUS_HOVER,
				GAMEPLAY, GAMEPLAY_PREVIOUS_CLICKED);

		result.setOnMouseReleased(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				root.setBackground(new Background(GAMEPLAY_PREVIOUS_HOVER));
				createElementsStage();
			}
		});

		return result;
	}

	/**
	 * Creates a standard transparent rectangle, which changes the background of
	 * the layout based on actions taken with the rectangle
	 * @param root the layout which will experience a change in background
	 * @param base the basic shape of the rectangle
	 * @param mouseEnter the background the layout will change to when the mouse
	 * hovers over it
	 * @param mouseExit the background the layout will change to when the mouse
	 * stops hovering over it
	 * @param mousePressed the background the layout will change to when the
	 * mouse presses (but does not release) it
	 * @return the Rectangle with all these configurations
	 */
	private Rectangle createRectangle(final AnchorPane root, Rectangle base,
			final BackgroundImage mouseEnter, final BackgroundImage mouseExit,
			final BackgroundImage mousePressed)
	{
		base.setOnMouseEntered(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				root.setBackground(new Background(mouseEnter));
			}
		});

		base.setOnMouseExited(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				root.setBackground(new Background(mouseExit));
			}
		});

		base.setOnMousePressed(new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent arg0)
			{
				root.setBackground(new Background(mousePressed));
			}
		});

		return base;
	}

	/**
	 * Minimizes the intro screen
	 */
	public void minimizeIntroScreen()
	{
		this.setIconified(true);
		border.setIconified(true);
	}

	/**
	 * Opens the intro screen
	 */
	public void openIntroScreen()
	{
		border.show();
		this.show();
	}
}
