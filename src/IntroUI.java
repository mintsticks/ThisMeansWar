import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
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
	
	public static final double RECT_ARC_SIZE = 22.5;
	public static final Color TRANSPARENT =  Color.rgb(100, 100, 100, 0);
	
	public static final int OFFSET = 10;
	
	public static final Image INTRO_BORDER_IMAGE = Tools.createImage("background.jpg");
	public static final Image INTRO_BACK_IMAGE = Tools.createImage("IntroBack.png");
	public static final Image INTRO_HELP_CLICK_IMAGE = Tools.createImage("IntroHelpClick.png");
	public static final Image INTRO_HELP_HOVER_IMAGE = Tools.createImage("IntroHelpHover.png");
	public static final Image INTRO_PLAY_CLICK_IMAGE = Tools.createImage("IntroPlayClick.png");
	public static final Image INTRO_PLAY_HOVER_IMAGE = Tools.createImage("IntroPlayHover.png");

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
	
	private double widthRatio;
	private double heightRatio;
	private double smallestRatio;
	
	private AnchorPane root;
	private Scene scene;
	private Stage border;
	
	public IntroUI(double widthRatio, double heightRatio, double smallestRatio)
	{
		this.widthRatio = widthRatio;
		this.heightRatio = heightRatio;
		this.smallestRatio = smallestRatio;
		
		this.initStyle(StageStyle.TRANSPARENT);
		AnchorPane root = new AnchorPane();
		Scene scene = new Scene(root, SCENE_WIDTH * widthRatio, SCENE_HEIGHT * heightRatio);
		//Creates the border
		createIntroBorder();
				
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
			}
        });
		
		return playPanel;
	}
	private void createIntroBorder() {
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
	
	private void showHelpScreen()
	{
		AnchorPane root = new AnchorPane();
		Scene helpScene = new Scene (root, SCENE_WIDTH * widthRatio, SCENE_HEIGHT * heightRatio);
		root.setBackground(new Background(INTRO_BACK));
		this.setScene(helpScene);	
	}
	

}
