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
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
	
public class IntroUI extends Stage{
	
	public static final int SCENE_WIDTH = 1200;
	public static final int SCENE_HEIGHT = 675;
	public static final int BORDER_WIDTH = 1220;
	public static final int BORDER_HEIGHT = 695;
	
	public static final int NUM_SELECT_WIDTH = 600;
	public static final int NUM_SELECT_HEIGHT = 300;
	
	public static final double HELP_WIDTH = 287.25;
	public static final double HELP_HEIGHT = 153;
	public static final double HELP_X = 699.75;
	public static final double HELP_Y = 420.75;
	
	public static final double PLAY_WIDTH = 482.25;
	public static final double PLAY_HEIGHT = 153;
	public static final double PLAY_X = 182.25;
	public static final double PLAY_Y = 420.75;
	
	public static final double CLOSE_X = 1150;
	public static final double MIN_X = 1110;
	public static final double CLOSE_Y = 5;
	public static final double MIN_Y = 0;
	
	public static final double COMBO_X = 50;
	public static final double COMBO_Y = 180;
	public static final double COMBO_WIDTH = 360;
	public static final double COMBO_HEIGHT = 50;
	
	public static final double OK_WIDTH = 100;
	public static final double OK_HEIGHT = 60.42;
	public static final double OK_ARC_SIZE = 10;
	public static final double OK_X = 447;
	public static final double OK_Y = 175;
	
	private static final double NUM_CLOSE_X = 575;
	private static final double NUM_CLOSE_Y = 5;
	
	public static final double RECT_ARC_SIZE = 22.5;
	public static final Color TRANSPARENT =  Color.rgb(100, 100, 100, 0);
	
	public static final int OFFSET = 10;
	
	
	public static final Image INTRO_BORDER_IMAGE = Tools.createImage("background.jpg");
	public static final Image INTRO_BACK_IMAGE = Tools.createImage("IntroBack.png");
	public static final Image INTRO_HELP_CLICK_IMAGE = Tools.createImage("IntroHelpClick.png");
	public static final Image INTRO_HELP_HOVER_IMAGE = Tools.createImage("IntroHelpHover.png");
	public static final Image INTRO_PLAY_CLICK_IMAGE = Tools.createImage("IntroPlayClick.png");
	public static final Image INTRO_PLAY_HOVER_IMAGE = Tools.createImage("IntroPlayHover.png");
	public static final Image NUM_PLAY_IMAGE = Tools.createImage("NumPlayers.png");
	public static final Image NUM_PLAY_CLICKED_IMAGE = Tools.createImage("NumPlayersClicked.png");
	
	public static final BackgroundImage INTRO_BORDER = new BackgroundImage(INTRO_BORDER_IMAGE, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(INTRO_BORDER_IMAGE.getWidth(), INTRO_BORDER_IMAGE.getHeight(), false, false, false, false));
	public static final BackgroundImage INTRO_BACK = new BackgroundImage(INTRO_BACK_IMAGE, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(INTRO_BACK_IMAGE.getWidth(), INTRO_BACK_IMAGE.getHeight(), false, false, true, false));
	public static final BackgroundImage INTRO_HELP_CLICK = new BackgroundImage(INTRO_HELP_CLICK_IMAGE, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(INTRO_HELP_CLICK_IMAGE.getWidth(), INTRO_HELP_CLICK_IMAGE.getHeight(), false, false, true, false));
	public static final BackgroundImage INTRO_HELP_HOVER = new BackgroundImage(INTRO_HELP_HOVER_IMAGE, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(INTRO_HELP_HOVER_IMAGE.getWidth(), INTRO_HELP_HOVER_IMAGE.getHeight(), false, false, true, false));
	public static final BackgroundImage INTRO_PLAY_CLICK = new BackgroundImage(INTRO_PLAY_CLICK_IMAGE, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(INTRO_PLAY_CLICK_IMAGE.getWidth(), INTRO_PLAY_CLICK_IMAGE.getHeight(), false, false, true, false));
	public static final BackgroundImage INTRO_PLAY_HOVER = new BackgroundImage(INTRO_PLAY_HOVER_IMAGE, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(INTRO_PLAY_HOVER_IMAGE.getWidth(), INTRO_PLAY_HOVER_IMAGE.getHeight(), false, false, true, false));
	public static final BackgroundImage NUM_PLAY = new BackgroundImage(NUM_PLAY_IMAGE, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(NUM_PLAY_IMAGE.getWidth(), NUM_PLAY_IMAGE.getHeight(), false, false, true, false));
	public static final BackgroundImage NUM_PLAY_CLICKED = new BackgroundImage(NUM_PLAY_CLICKED_IMAGE, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
			new BackgroundSize(NUM_PLAY_CLICKED_IMAGE.getWidth(), NUM_PLAY_CLICKED_IMAGE.getHeight(), false, false, true, false));
	
	private double widthRatio;
	private double heightRatio;
	private double smallestRatio;
	
	private AnchorPane root;
	private Scene scene;
	private Stage border;
	private Stage numSelect;
	private ComboBox comboBox;
	
	public IntroUI(double widthRatio, double heightRatio, double smallestRatio)
	{
		this.widthRatio = widthRatio;
		this.heightRatio = heightRatio;
		this.smallestRatio = smallestRatio;
		
		//Creates the border
		createIntroBorder();
		createIntroUI();
	}
	public void createIntroUI()
	{
		this.initStyle(StageStyle.TRANSPARENT);
		AnchorPane root = new AnchorPane();
		Scene scene = new Scene(root, SCENE_WIDTH * widthRatio, SCENE_HEIGHT * heightRatio);
		
		//Connects the intro screen with its border
		this.initOwner(border);
		this.setX(border.getX() + OFFSET * widthRatio);
		this.setY(border.getY() + OFFSET * heightRatio);
		
		//Editing the root, which is what elements display on
		root.setBackground(new Background(INTRO_BACK));
		
		Rectangle helpPanel = createHelpPanel(root);
		Rectangle playPanel = createPlayPanel(root);
		
		Text close = createCloseButton(root);
		Text minimize = createMinButton(root);
		
		root.getChildren().addAll(helpPanel, playPanel, close, minimize);
		root.setEffect(Tools.XLARGE_SHADE);
		this.setScene(scene);
	}
	public Text createCloseButton(AnchorPane root)
	{
		Text close = Tools.createText(CLOSE_X, CLOSE_Y, widthRatio, heightRatio, "x", Color.LIGHTGRAY, Tools.SMALL_SHADE, Tools.createFont("Bookman Old Style", null, 50, smallestRatio));

		close.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				closeScreen();
			}
        });
		
		return close;
	}
	
	public Text createMinButton(AnchorPane root)
	{
		Text minimize = Tools.createText(MIN_X, MIN_Y, widthRatio, heightRatio, "-", Color.LIGHTGRAY, Tools.SMALL_SHADE, Tools.createFont("Bookman Old Style", null, 60, smallestRatio));
		
		minimize.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				minimizeScreen();
			}
        });
		
		return minimize;
	}
	public void closeScreen()
	{
		this.close();
		border.close();
	}
	
	public void minimizeScreen()
	{
		this.setIconified(true);
		border.setIconified(true);
	}
	
	public void openScreen()
	{
		border.show();
		this.show();
	}
	public Rectangle createHelpPanel(AnchorPane root)
	{
		Rectangle helpPanel = Tools.createRoundedRectangle(HELP_WIDTH, HELP_HEIGHT, RECT_ARC_SIZE, RECT_ARC_SIZE, HELP_X, HELP_Y, 
				widthRatio, heightRatio, smallestRatio, TRANSPARENT, null);
		
		helpPanel.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				root.setBackground(new Background(INTRO_HELP_HOVER));
			}
        });
		helpPanel.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				root.setBackground(new Background(INTRO_BACK));
			}
        });
		helpPanel.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				root.setBackground(new Background(INTRO_HELP_CLICK));
			}
        });
		helpPanel.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				root.setBackground(new Background(INTRO_HELP_HOVER));
			}
        });
		
		return helpPanel;
	}
	public Rectangle createPlayPanel(AnchorPane root)
	{
		Rectangle playPanel = Tools.createRoundedRectangle(PLAY_WIDTH, PLAY_HEIGHT, RECT_ARC_SIZE, RECT_ARC_SIZE, PLAY_X, PLAY_Y, 
				widthRatio, heightRatio, smallestRatio, TRANSPARENT, null);
		
		playPanel.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				root.setBackground(new Background(INTRO_PLAY_HOVER));
			}
        });
		playPanel.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				root.setBackground(new Background(INTRO_BACK));
			}
        });
		playPanel.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				root.setBackground(new Background(INTRO_PLAY_CLICK));
			}
        });
		playPanel.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				root.setBackground(new Background(INTRO_PLAY_HOVER));
				createNumSelect();
				closeScreen();
			}
        });
		
		return playPanel;
	}
	private void createIntroBorder() 
	{
		border = new Stage();
		border.initStyle(StageStyle.TRANSPARENT);

		AnchorPane root = new AnchorPane();
		Scene scene = new Scene(root, BORDER_WIDTH * widthRatio, BORDER_HEIGHT * heightRatio);

		root.setBackground(new Background(INTRO_BORDER));
		root.setEffect(Tools.LARGE_SHADE);
		border.setScene(scene);
		border.show();
		border.centerOnScreen();
	}
	
	public Rectangle createOK(AnchorPane root)
	{
		Rectangle okPanel = Tools.createRoundedRectangle(OK_WIDTH, OK_HEIGHT, OK_ARC_SIZE, OK_ARC_SIZE, OK_X, OK_Y, 
				widthRatio, heightRatio, smallestRatio, TRANSPARENT, null);
		
		okPanel.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				root.setBackground(new Background(NUM_PLAY_CLICKED));
			}
        });
		okPanel.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				root.setBackground(new Background(NUM_PLAY));
				String players = (String)comboBox.getValue();
				int numPlay = 0;
				if(players != null)
				{
					switch(players)
					{
						case "2 Players": numPlay = 2;
							break;
						case "3 Players": numPlay = 3;
							break;
						case "4 Players": numPlay = 4;
							break;
					}
				}
				if(numPlay != 0)
				{
					GameUI game = new GameUI(numPlay);
					game.show();
					numSelect.close();
				}	
			}
        });
		return okPanel;
	}
	
	public Text createNumCloseButton(AnchorPane root)
	{
		Text close = Tools.createText(NUM_CLOSE_X, NUM_CLOSE_Y, widthRatio, heightRatio, "X", Color.LIGHTGRAY, 
				Tools.SMALL_SHADE, Tools.createFont("Bookman Old Style", null, 30, smallestRatio));

		close.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				closeNumScreen();
				openScreen();
			}
        });
		
		return close;
	}
	private void createNumSelect()
	{
		numSelect = new Stage();
		numSelect.initStyle(StageStyle.TRANSPARENT);
		
		AnchorPane root = new AnchorPane();
		Scene scene = new Scene(root, NUM_SELECT_WIDTH * widthRatio, NUM_SELECT_HEIGHT * heightRatio);
		ObservableList<String> options = FXCollections.observableArrayList("2 Players", "3 Players", "4 Players");
		comboBox = new ComboBox(options);
		
		comboBox.setLayoutX(COMBO_X * widthRatio);
		comboBox.setLayoutY(COMBO_Y * heightRatio);
		comboBox.setPrefWidth(COMBO_WIDTH * smallestRatio);
		comboBox.setPrefHeight(COMBO_HEIGHT * smallestRatio);
		comboBox.setStyle("-fx-font: 20px \"Agency FB\";");
		comboBox.setEffect(Tools.LARGE_SHADE);
		
		Rectangle ok = createOK(root);
		Text close = createNumCloseButton(root);
		root.setEffect(Tools.LARGE_SHADE);
		
		root.getChildren().addAll(comboBox, ok, close);
		
		root.setBackground(new Background(NUM_PLAY));
		numSelect.setScene(scene);
		numSelect.show();
	}
	public void closeNumScreen()
	{
		numSelect.close();
	}
	private void showHelpScreen()
	{
		AnchorPane root = new AnchorPane();
		Scene helpScene = new Scene (root, SCENE_WIDTH * widthRatio, SCENE_HEIGHT * heightRatio);
		root.setBackground(new Background(INTRO_BACK));
		this.setScene(helpScene);	
	}
	

}
